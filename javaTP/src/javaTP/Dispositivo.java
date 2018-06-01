package javaTP;

import java.util.ArrayList;

public abstract class Dispositivo implements Conectable
{
	// cantidad de puertos que va a tener el Dispositivo
	public Integer nroPuertos;	
	// lista de dispositivos conectados al dispositivo
	protected ArrayList<Conectable> conectados;
	
	public abstract void enviar(Paquete p);
	public abstract void recibir(Paquete p);
	public abstract boolean conectar(Conectable d);
	
	public ArrayList<Conectable> getConectados() {
		return conectados;
	}
	
	public boolean tienePuertosLibres()
	{
		if (this.conectados.size() < this.nroPuertos)
		{
			return true;
		}
		return false;
	}
	
	
}
