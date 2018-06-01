package javaTP;

import java.util.ArrayList;

public abstract class Hub extends Dispositivo implements iConexion{

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
	public void conectar(Dispositivo d) 
	{
		//llenar el arreglo de puertos
		if (!(dispositivos.contains(d))) /* si el dispositivo no esta conectado ya */
		{
			dispositivos.add(d);
		//	d.conectar(this); HAY QUE HACER UPCASTING DE ESTO 
		}
	}
	
}
