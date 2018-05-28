package javaTP;

public class PaqueteDeServicio extends Paquete{
	enum TipoDeServicio {b, a, otros}
	private TipoDeServicio servicio;
	
	public PaqueteDeServicio() {
		super();
		servicio = TipoDeServicio.otros;
	}
	
}
