package javaTP;

import java.util.Optional;

public interface TipoDeServicio {
	
	public Optional<Paquete> procesarServicio(Dispositivo d, SistemaOperativo so, Paquete p);
		
}
