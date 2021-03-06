package javaTP;



public class PaqueteDeRuteo extends Paquete {
	private Paquete container;
	
	public Paquete getContainer() {
		return container;
	}
	public void setContainer(Paquete p) {
		this.container = p;
	}

	public PaqueteDeRuteo() {
		super();
	}
	public PaqueteDeRuteo(IP orig, IP dest, Integer t) {
		super(orig,dest,t);
	}
	public PaqueteDeRuteo(Paquete c) {
		super();
		container = c;
	}
/*
	@Override
	public Optional<Paquete> procesar(Dispositivo d, SistemaOperativo so) {
		// Valido que el paquete de ruteo este en un Router. Caso contrario, descarto,
		// devolviendo un Empty.
		if (d instanceof Router) {
			Paquete sm;
			// Compruebo que el paquete de ruteo sea para el router
			// Compruebo que el paquete tenga Time To Live
			if (so.so_ip.equals(this.ipDestino)) {
				
				if (ttl > 0) {
					this.ttl--;
					// Compruebo si el paquete dentro del paquete de ruteo esta direccionado hacia
					// algunas de las ip en mi tabla
					if (((Router) d).pertenece_IP_a_Tabla(cont.getIpDestino())) {
						// enviar paquete al destino
						sm = cont;
					} else {
						if (((Router) d).existe_Interfaz_Defautl()) {
							// enviar paquete de ruteo con cont adentro por default
							sm = new PaqueteDeRuteo(cont);
							sm.setIpDestino(((Router) d).get_IP_from_Default_Interface());
							sm.setIpOrigen(so.getIPHost());
							sm.setTtl(so.default_ttl);
						} else {
							// enviar SendMessage
							// Posible punto para exception
							sm = new SendMessage(so.getIPHost(), cont.getIpOrigen(), so.default_ttl,
									"Este equipo no posee una salida valida, mensaje rechazado");
						}
					}
					Optional<Paquete> pack = Optional.of(sm);
					return pack;
				} else {
					// Se descarta el paquete, ya que el paquete no tiene TTL.
					return Optional.empty();
				}
			} else {
				// Se descarta el paquete, ya que el paquete no estaba dirigido hacia este
				// equipo.
				return Optional.empty();
			}
		} else {
			// Se descarta el paquete, ya que terminales no procesan paquetes de ruteo.
			return Optional.empty();
		}

	}
*/
}
