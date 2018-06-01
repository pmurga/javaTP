package javaTP;

import java.util.ArrayList;

public abstract class Hub extends Dispositivo{

	protected ArrayList<Dispositivo> dispositivos;
	
	public void enviar(Paquete p) 
	{
		//harcodeado re cabeza --> revisar/mejorar luego (falla la extensibilidad)
		for(Dispositivo dispositivo : dispositivos) 
		{
			
			if (dispositivo instanceof Terminal)
			{
				((Terminal) dispositivo).recibir(p);
			} else if (dispositivo instanceof Hub) 
				{
					((Hub) dispositivo).recibir(p);
				} /*else if (dispositivo instance of Router)
					{
						((Router) dispositivo).recibir(p);
					}*/	
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
	
}
