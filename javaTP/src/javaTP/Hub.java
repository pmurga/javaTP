package javaTP;

public abstract class Hub extends Dispositivo{
	
	public void enviar(Paquete p) 
	{
		for(Conectable dispositivo : conectados) 
		{
			dispositivo.recibir(p);
		}
	}
	public void recibir(Paquete p) 
	{
		
		this.enviar(p);
		
	}
	@Override
	public boolean conectar(Conectable d2)
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
						this.conectados[p1] = d2;
						int p2 = ((Dispositivo) d2).getPuertoLibre();
						((Dispositivo) d2).conectados[p2] = this;	
						return true;
				}	
			}
		}
		return false;
	}
	
	public Hub(int puertos)
	{
		puertos = puertosValidar(puertos);
		this.nroPuertos = puertos;
		this.conectados = new Conectable[nroPuertos];
	}
	
	protected int puertosValidar(int p)
	{
		if( p != 4 || p != 8 || p !=16 || p != 32)
		{
			return 4;
		}else
		{
			return p;
		}
		
	}
	
	
}
