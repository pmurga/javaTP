package javaTP;

import java.util.Optional;

public abstract class PaqueteDeServicio extends Paquete {


	public PaqueteDeServicio() {
		super();

	}

	public boolean esMismaRed(IP p) {
		return ipDestino.esMismaRed(p);
	}

	public PaqueteDeServicio(IP orig, IP dest, Integer t) {
		super(orig, dest, t);

	}

	
	public abstract Optional<Paquete> procesar(Dispositivo d, SistemaOperativo so);

}
