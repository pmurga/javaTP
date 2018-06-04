package javaTP;


import java.util.Optional;

public class ICMPRequest implements TipoDeServicio{

	@Override
	public Optional<Paquete> procesarServicio(Dispositivo d, SistemaOperativo so, Paquete p) {
		//Envía al equipo que originó el paquete un nuevo paquete de tipo ICMPResponse.
		ICMPResponse sm_tipo = new ICMPResponse(p.getIpOrigen());
		PaqueteDeServicio sm = new PaqueteDeServicio();
		sm.setIpOrigen(p.getIpDestino());
		sm.setIpDestino(p.getIpOrigen());
		sm.setTtl(so.default_ttl);
		sm.setTipo(sm_tipo);
		Optional<Paquete> pack = Optional.of(sm);
		return pack;
	}

	
}