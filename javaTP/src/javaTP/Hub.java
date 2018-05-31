package javaTP;

public abstract class Hub extends Dispositivo implements iConexion{
	private Dispositivo[] puertos;
	
	public void enviar(Paquete p) {
		Dipositivo x = new Dispositivo();
		for(Dispositivo : x) {
			x.recibir(p);
		}
	}
	public void recibir() {
		
	}
	public void conectar() {
		//llenar el arreglo de puertos
	}
	
	
}
