package javaTP;

public class PaqueteDeServicio extends Paquete{
	enum TipoDeServicio {b, a, otros}
	private TipoDeServicio servicio;
	
	public PaqueteDeServicio() {
		super();
		servicio = TipoDeServicio.otros;
	}
	
	public void procesar() {
		//...
	}
	
	public boolean esMismaRed(IP p) {
		
		boolean es = ipDestino.esMismaRed(p);
		return es;
		
	}
	
	/*
	public boolean esMismaRed(IP dest) {
		boolean es = false;
		if (this.ipDestino.getOct1()==dest.getOct1()) {
			if(this.ipDestino.getOct2()==dest.getOct2()) {
				if(this.ipDestino.getOct3()==dest.getOct3()) {
					es = true;
				}
			}
			
		}
		return es;
	}
	*/
	
}
