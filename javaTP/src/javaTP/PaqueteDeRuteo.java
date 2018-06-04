package javaTP;

import java.util.Optional;

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
	public Optional<Paquete> procesar(Dispositivo d, SistemaOperativo so) {
		//Valido que el paquete de ruteo este en un Router. Caso contrario, descarto, devolviendo un Empty.
		if (d instanceof Router) {
			
			//Aqui hacer lo que tenga que hacer
			//Una vez que termino, construyo pack
			//devuelvo pack
			Optional<Paquete> pack = Optional.of(this);
		}else {
			//Se descarta el paquete, ya que terminales no procesan paquetes de ruteo. 
			return Optional.empty();
		}
	}
	
	
	
}
