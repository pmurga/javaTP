package javaTP;

import java.util.Optional;

public class Who implements TipoDeServicio {
	
	
	public Who() {
		
	}

	@Override
	public Optional<Paquete> procesarServicio(Dispositivo d, SistemaOperativo so_local, Paquete p) {
		
		//Env�a al equipo que origin� el paquete un nuevo paquete de tipo SendMessage que
		//contenga informaci�n del Sistema Operativo local (nombre, versi�n, IP, etc) y
		
		SendMessage sm_tipo = new SendMessage(so_local);
		PaqueteDeServicio sm = new PaqueteDeServicio();
		sm.setIpDestino(p.getIpOrigen());
		sm.setIpOrigen(p.getIpDestino());
		sm.setTtl(so_local.default_ttl);
		sm.setTipo(sm_tipo);
		
		if (d instanceof Router) {
		//agregar la tabla de ruteo
			//sm.Tabla_de_Ruteo = Optional.of(so.getTabla());
		}else {
			//No le ponemos tabla porque no tiene :D
			//sm.Tabla_de_Ruteo = Optional.empty();
		}
		Optional<Paquete> pack = Optional.of(sm);
		return pack;
	}
	
	
	
	
	

}
