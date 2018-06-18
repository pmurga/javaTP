package javaTP;

import java.util.Optional;

import javax.management.openmbean.OpenDataException;

//import java.util.ArrayList;

public class SistemaOperativoRouter extends SistemaOperativo {
	private IP[] ips;
	private DirRed[] TablaRuteo;
	private int cantRutas;
	
	public SistemaOperativoRouter() {
		super();
	}
	
	public void addDirRed(DirRed dir_red) {
		//validar que la dir_red sea valida
		if(dir_red.esRedValida()) {
			//verificar que haya espacio en la tabla
			if ((this.hayEspacioTabla())) {
				int pos = this.getEspacioLibre();
				this.TablaRuteo[pos] = dir_red;
			}
		}
	}
	
	public void addIP(IP ip, Router r) {
		//validar que la ip sea valida
		if (ip.validar()) {
			//validar que tiene puertos para asignar una nueva ip
			if (this.tieneIpLibres(r)){
				int ip1 = this.getIpLibre(r);
				this.ips[ip1] = ip;
			}
			
		}
	}
	
	public void setIP(IP ip, int puerto)
	{
		//validar que ip sea valida
		if (ip.validar()) {
			//puerto esta dentro de la capacidad actual de ips del router
			if (puerto <= this.ips.length)
			{
				this.ips[puerto] = ip;
			}
		}
			
	}
	
	public boolean hayEspacioTabla() {
		boolean hay = false;
		if (this.TablaRuteo.length > this.cantRutas) {
			hay = true;
		}
		return hay;
	}
	
	public int getEspacioLibre() {
		return this.TablaRuteo.length;
	}
	
	public boolean tieneIpLibres(Router r)
	{
		
		if (r.tienePuertosLibres())
		{
			return true;
		}
		return false;
	}
	public int getIpLibre(Router r)
	{
		return r.getPuertoLibre();
	}
	public void recibirPaquete(Dispositivo d, Paquete p) {
		Optional<Paquete> pack = procesarPaquete(d,p);
		if (pack.isPresent()) {
			enviarPaquete(d,pack.get());
		}
		
		
	}
	public void enviarPaquete(Dispositivo d, Paquete p) {
		d.enviar(p);
	}
	
	public Optional<Paquete> procesarPaquete(Dispositivo d, Paquete p){
		Optional<Paquete> pack = Optional.empty();
		if (d instanceof Router) {
			Paquete sm;
			// Compruebo que el paquete de ruteo sea para el router
			// Compruebo que el paquete tenga Time To Live
			if (this.so_ip.equals(p.ipDestino)) {
				
				if (p.ttl > 0) {
					p.ttl--;
					// Compruebo si el paquete dentro del paquete de ruteo esta direccionado hacia
					// algunas de las ip en mi tabla
					if (this.pertenece_IP_a_Tabla(((PaqueteDeRuteo)p).getCont().getIpDestino())) {
						// enviar paquete al destino
						sm = ((PaqueteDeRuteo)p).getCont();
					} else {
						if (((Router) d).existe_Interfaz_Defautl()) {
							// enviar paquete de ruteo con cont adentro por default
							sm = new PaqueteDeRuteo(((PaqueteDeRuteo)p).getCont());
							sm.setIpDestino(((Router) d).get_IP_from_Default_Interface());
							sm.setIpOrigen(getIPHost());
							sm.setTtl(default_ttl);
						} else {
							// enviar SendMessage
							// Posible punto para exception
							sm = new SendMessage(getIPHost(), ((PaqueteDeRuteo)p).getCont().getIpOrigen(), default_ttl,
									"Este equipo no posee una salida valida, mensaje rechazado");
						}
					}
					pack = Optional.of(sm);
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

		return pack;
		
	}
	
	
}
