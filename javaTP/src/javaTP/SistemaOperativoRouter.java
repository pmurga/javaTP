package javaTP;

import java.util.Optional;

public class SistemaOperativoRouter extends SistemaOperativo {
	private IP[] ips;
	private DirRed[] TablaRuteo;
	private int cantRutas;
	private Router router;
	protected int default_int; 
	protected boolean tieneDefaultInt; 

	public SistemaOperativoRouter() {
		super();
		this.tieneDefaultInt = false;
		//por defecto la cantidad de interfaces minimas de router es 2
		ips = new IP[2];
	}
	
    public void setDefault_int(int i) {
		this.default_int = i;
		this.tieneDefaultInt = true;
	}
	public int getDefault_int() {
		return default_int;
	}
	
	public void instalar(String name, String ver, Router r) {
		router = r;
		int nro_puertos = router.getNro_puertos();
		if( nro_puertos > 2) {
			//si se detecta que la cantidad de puertos del router es mayor que la cantidad default(2) se rearma el array con la cantidad correcta
			rearmarIps(nro_puertos);		
		}
		instalar(name, ver);	
	}
	private void rearmarIps(int nro_puertos) {
		IP[] ips_aux = new IP[nro_puertos];
		for(int i=0; i<ips.length ; i++) {
			ips_aux[i] = ips[i];
		}
		ips = new IP[nro_puertos];
		for(int j=0; j<ips_aux.length ; j++) {
			ips[j] = ips_aux[j];
		}
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
		if (ip.esRedValida()) {
			//puerto esta dentro de la capacidad actual de ips del router
			if (puerto <= this.ips.length)
			{
				this.ips[puerto] = ip;
			}
		}
			
	}
	
	public boolean TieneDefaultInt() {
		return tieneDefaultInt;
	}

	public IP[] getIps() {
		return ips;
	}

	public void mostrarIPs() {
		int i = 0;
		for(IP ip : ips)
		{
			System.out.println("El Router tiene la IP: " + ip + " asignada al puerto " + i );
			i++;
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
	public boolean pertenece_IP_a_Tabla(IP ip) {
		
		for (DirRed dr: TablaRuteo) {
			
			if (dr.esMismaRed(ip)) {
				return true;
			}
		}
		return false;
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
			// Compruebo que el paquete de ruteo sea para el router
			if (p instanceof PaqueteDeServicio) {
				for(IP i : ips) {
					
					// si encuentro que ip destino del paquete es una ip asignada a mi router entonces..
					// se asume que las ip asignadas a las interfaces de router son unicas
					if (i.esMismaIP(p.getIpDestino())){
						
						//procesarPaquetePropio
					}
				}
			}else if(p instanceof PaqueteDeRuteo) {
				System.out.println("estoy aca");
				return procesarPaquete2(d, p);
			}	
		}
		return pack;
	}
	
	public Optional<Paquete> procesarPaquete2(Dispositivo d , Paquete p)
	{
			Paquete sm;
			Optional<Paquete> pack = Optional.empty();

			// Compruebo que el paquete tenga Time To Live
			if (p.ttl > 0) {
				p.ttl--;
				// Compruebo si el paquete dentro del paquete de ruteo esta direccionado hacia
				// algunas de las ip en mi tabla
				
				System.out.println(p);
				if (this.pertenece_IP_a_Tabla(((PaqueteDeRuteo)p).getContainer().getIpDestino())) 
				{
					// extraigo el paquete de servicio del paquete de ruteo y lo envio al destino
					sm = ((PaqueteDeRuteo)p).getContainer();

				} else {
						if (TieneDefaultInt()) 
						{
							// enviar paquete de ruteo con cont adentro por default
							sm = new PaqueteDeRuteo(((PaqueteDeRuteo)p).getContainer());
							sm.setIpDestino(p.getIpDestino());
							sm.setIpOrigen(ips[getDefault_int()]);
							sm.setTtl(default_ttl);
						} else {
							// enviar SendMessage al origen del paquete que se esta procesando
							// Posible punto para exception
							sm = new SendMessage(p.getIpDestino(), ((PaqueteDeRuteo)p).getContainer().getIpOrigen(), default_ttl,
									"Este equipo no posee una salida valida, mensaje rechazado");
						}
					}
				pack = Optional.of(sm);
				return pack;
			} else {
				// Se descarta el paquete, ya que el paquete no tiene TTL.
				return Optional.empty();
			}
	}
		
	
}
