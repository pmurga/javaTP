package javaTP;

public class PaqueteDeServicio extends Paquete{
	private TipoDeServicio tipo;	 
	
	public PaqueteDeServicio() {
		super();
		
	}
	
	public void procesar() {
		//...
	}
	
	public boolean esMismaRed(IP p) {
		
		boolean es = ipDestino.esMismaRed(p);
		return es;
		
	}
	
	
}
