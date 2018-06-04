package javaTP;

public class PaqueteDeServicio extends Paquete{
	public TipoDeServicio tipo;	 
	
	public PaqueteDeServicio() {
		super();
		
	}
	
	
	public boolean esMismaRed(IP p) {return ipDestino.esMismaRed(p);}
	
	public PaqueteDeServicio(IP orig, IP dest, Integer t) {
		super(orig,dest,t);
		
	}
	
}
