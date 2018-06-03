package javaTP;

public class PaqueteDeServicio extends Paquete{
	public TipoDeServicio tipo;	 
	
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
	public PaqueteDeServicio(IP orig, IP dest, Integer t) {
		super(orig,dest,t);
		
	}
	
}
