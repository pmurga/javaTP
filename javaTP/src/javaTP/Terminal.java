package javaTP;

public abstract class Terminal extends Dispositivo
{
	
	protected SistemaOperativoTerminal sistema_operativo; 
	
	
	//permitir al usuario instalar un SO de su preferencia - por defecto los dispositivos no tendran un SO instalado (?)
	public abstract void instalar(SistemaOperativo SO);
	public abstract SistemaOperativoTerminal getSO();
	
	public Terminal()
	{	
		//terminal solo puede conectarse a 1 dispositivo
		this.nroPuertos = 1;
		this.conectados = new Conectable[nroPuertos];
	}

	@Override
	public boolean conectar (Conectable d2)
	{
		
		// validar que this no es mismo dispositivo que d2 (para que no se conecte a si mismo)
		if (!(this.equals(d2)))
		{
			// validar que this tenga puerto libre para conectar
			if (this.tienePuertosLibres())
			{
				// validar que d2 tenga puerto libre para conectar	
				if (((Dispositivo) d2).tienePuertosLibres())
				{
						int p1 = this.getPuertoLibre();
						
						// getPuertoLibre retorna -1 si no encuentra un puerto libre
						if (p1 != -1) {
							
							this.conectados[p1] = d2;
							System.out.println(this + " conectado exitosamente a " + d2);

							int p2 = ((Dispositivo) d2).getPuertoLibre();
							if (p2 != -1) {
								
								((Dispositivo) d2).conectados[p2] = this;
								System.out.println(d2 + " conectado exitosamente a " + this);
								return true;
							}
						}
					
				}	
			}
		}
		System.out.println("No se pudo conectar a " + d2);
		return false;
	}
	
	public void enviar(Paquete p)
	{
		this.sistema_operativo.enviarPaquete(p, this);	
	}
	
	public void recibir(Paquete p)
	{
		this.sistema_operativo.validarPaquete(p, this);
	}
	public void instalar(SistemaOperativoTerminal so, String name,String ver) {
		sistema_operativo = so;
		sistema_operativo.instalar(name, ver, this);
		
	}
}
