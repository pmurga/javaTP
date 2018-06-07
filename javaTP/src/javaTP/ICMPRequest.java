package javaTP;


import java.util.Optional;

public class ICMPRequest extends PaqueteDeServicio{

	/*@Override
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
*/
	@Override
	public Optional<Paquete> procesar(Dispositivo d, SistemaOperativo so) {
		//Envía al equipo que originó el paquete un nuevo paquete de tipo ICMPResponse.
				ICMPResponse sm = new ICMPResponse(getIpOrigen());
				sm.setIpOrigen(getIpDestino());
				sm.setIpDestino(getIpOrigen());
				sm.setTtl(so.default_ttl);
				Optional<Paquete> pack = Optional.of(sm);
				return pack;
	}

	
}