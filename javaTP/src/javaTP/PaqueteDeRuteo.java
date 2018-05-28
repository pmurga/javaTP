package javaTP;

public class PaqueteDeRuteo extends Paquete{
	private Paquete cont;
	public PaqueteDeRuteo() {
		super();
		
	}
	public PaqueteDeRuteo(Paquete c) {
		super();
		cont = c;
	}
	
	@Override
	public boolean esMismaRed(IP dest) {
		// TODO Auto-generated method stub
		return false;
	}
	public void procesar() {
		//...
	}
	
}
