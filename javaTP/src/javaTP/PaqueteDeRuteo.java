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
			Paquete sm = Null();
			//Compruebo que el paquete de ruteo sea para el router
			if(so.so_ip.equals(this.ipDestino)) {
				this.ttl --;
				//Compruebo que el paquete tenga Time To Live
				if (ttl > 0) {
					//Compruebo si el paquete dentro del paquete de ruteo esta direccionado hacia algunas de las ip en mi tabla
					if(((Router) d).pertenece_IP_a_Tabla(cont.getIpDestino())) {
						//enviar paquete al destino
						sm = cont;
					}else {
						if(((Router) d).existe_Interfaz_Defautl()) {
							//enviar paquete de ruteo con cont adentro por default
							sm = new PaqueteDeRuteo(cont);
							sm.setIpDestino(((Router) d).get_IP_from_Default_Interface());
							sm.setIpOrigen(so.getIPHost());
							sm.setTtl(so.default_ttl);
						}else {
							//enviar SendMessage
							//Posible punto para exception
							sm = new SendMessage(so.getIPHost(), cont.getIpOrigen(), so.default_ttl, "Este equipo no posee una salida valida, mensaje rechazado");
							/*SendMessage sm_tipo = new SendMessage();
							sm_tipo.setMsg("Este equipo no posee una salida valida, mensaje rechazado");
							((PaqueteDeServicio)sm).tipo = sm_tipo;
							*/
						}
					}
				}
				
				Optional<Paquete> pack = Optional.of(sm);
				return pack;
			}else {
				return  Optional.empty();
			}
		}else {
			//Se descarta el paquete, ya que terminales no procesan paquetes de ruteo. 
			return Optional.empty();
		}
	}
	private Paquete Null() {
		// TODO Auto-generated method stub
		return null;
	}
	
	
	
}
