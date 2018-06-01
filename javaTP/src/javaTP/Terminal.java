package javaTP;

public abstract class Terminal extends Dispositivo
{
	protected IP ip_Host;
	protected IP default_Gateway;
	protected SistemaOperativo sistema_Operativo; 
	
	
	//permitir al usuario instalar un SO de su preferencia - por defecto los dispositivos no tendran un SO instalado (?)
	public abstract void instalar(SistemaOperativo SO);
	public abstract String getSO();
	public abstract void setIpHost(IP ip);
	
	public Terminal()
	{	
		//terminal solo puede conectarse a 1 dispositivo
		this.nroPuertos = 1;
		Conectable[] conectados = new Conectable[nroPuertos];
	}
	
	@Override
	public boolean conectar(Conectable d2)
	{
		// validar que this no es mismo dispositivo que d2 (para que no se conecte a si mismo)
		
		// validar que this tenga puerto libre para conectar
		if (this.tienePuertosLibres())
		{
			// validar que d2 tenga puerto libre para conectar	
			if (((Dispositivo) d2).tienePuertosLibres())
			{
				// validar que d2 no esta conectado ya a this
				if (!(this.conectados.contains(d2))) 
				{	
					this.conectados.add(d2);
					boolean x = d2.conectar(this);
					if (x == true) {return true;}
				}
			}	
		}
		return false;
	}
	
	public void enviar(Paquete p)
	{
		// la la
	}
	public void recibir(Paquete p)
	{
		//la la
	}
	
}
