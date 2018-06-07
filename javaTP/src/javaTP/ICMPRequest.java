package javaTP;

import java.util.Optional;

public class ICMPRequest extends PaqueteDeServicio {

	public ICMPRequest(IP orig, IP dest, Integer t) {
		super(orig, dest, t);
	}

	@Override
	public Optional<Paquete> procesar(Dispositivo d, SistemaOperativo so) {
		// Envía al equipo que originó el paquete un nuevo paquete de tipo ICMPResponse.
		ICMPResponse sm = new ICMPResponse(getIpOrigen());
		sm.setIpOrigen(getIpDestino());
		sm.setIpDestino(getIpOrigen());
		sm.setTtl(so.default_ttl);
		Optional<Paquete> pack = Optional.of(sm);
		return pack;
	}

}