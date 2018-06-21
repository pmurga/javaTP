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
	
	public Dispositivo getDispositivo(){	
		return this;	
	}
	public boolean tienePuertosLibres()
	{
		for(int x=0; x < this.conectados.length ; x++) {
			if(this.conectados[x] == null) {
				return true;
			}
		}
		return false;
	}
	public int getPuertoLibre()
	{
		for(int x=0; x < this.conectados.length ; x++) {
			if(this.conectados[x] == null) {
				return x;
			}
		}
		System.out.println("Error - No hay ningun puerto libre en el dispositivo");
		return -1;
	
	}
	
}
