package javaTP;


public abstract class Dispositivo implements Conectable
{
	// cantidad de puertos que va a tener el Dispositivo
	public Integer nroPuertos;	
	// lista de dispositivos conectados al dispositivo
	protected Conectable[] conectados;
	
	public abstract void enviar(Paquete p);
	public abstract void recibir(Paquete p);
	public abstract boolean conectar(Conectable d);
	
	public Conectable[] getConectados() {
		return conectados;
	}
	
	public boolean tienePuertosLibres()
	{
		if (this.conectados.length < this.nroPuertos)
		{
			return true;
		}
		return false;
	}
	public int getPuertoLibre()
	{
		return this.conectados.length;
	}
	
}
