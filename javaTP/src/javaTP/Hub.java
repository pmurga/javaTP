package javaTP;

import java.util.ArrayList;

public abstract class Hub extends Dispositivo{

	protected ArrayList<Dispositivo> dispositivos;
	
	public void enviar(Paquete p) 
	{
		for(Dispositivo dispositivo : dispositivos) 
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
						this.conectados.add(d2);
						((Dispositivo) d2).conectados.add(this);	
				}	
			}
		}
		return false;
	}
	
}
