package javaTP;

import java.util.Optional;

public class Who extends PaqueteDeServicio {
	
	
	public Who(IP orig, IP dest, Integer t) {
		super(orig, dest, t);
	}

	@Override
	public Optional<Paquete> procesar(Dispositivo d, SistemaOperativo so) {
		//Env�a al equipo que origin� el paquete un nuevo paquete de tipo SendMessage que
				//contenga informaci�n del Sistema Operativo local (nombre, versi�n, IP, etc) y
				//SendMessage sm_tipo = new SendMessage(so_local);
				SendMessage sm = new SendMessage();
				sm.setIpDestino(getIpOrigen());
				sm.setIpOrigen(getIpDestino());
				sm.setTtl(so.default_ttl);
				sm.setMsg(so.toString());
				
				if (d instanceof Router) {
					sm.agregarMsg(((Router)d).getSistema_operativo().toStringTablaRuteo());
				}
				Optional<Paquete> pack = Optional.of(sm);
				return pack;
	}
	
	
	
	
	

}
