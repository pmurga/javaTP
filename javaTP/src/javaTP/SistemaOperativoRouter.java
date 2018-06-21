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
		this.TablaRuteo = new DirRed[2];
		this.cantRutas = 2;
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
		cantRutas = nro_puertos;
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
	
	public String toStringTablaRuteo() {
		String s="";
		int pos = 0;
		for(DirRed dir : TablaRuteo) {
			
			if(dir != null) {
				s = (s + "Dir. Red de Destino: "+ dir + " Puerto: "+ pos +"|"); 
			}
			pos++;
		}
		return s;
	}
	public void mostrarRutas() {
		int pos = 0;
		System.out.println(" _____________________________________________________");
		System.out.println("|Dir. Red de Dest.			       Puerto | ");
		System.out.println("|_____________________________________________________|");

		for(DirRed dir : TablaRuteo) {
			
			if(dir != null) {
				System.out.println("|"+ dir + "   				 " + pos  );
			}
			pos++;
		}
		System.out.println("|_____________________________________________________|");

	}
	public boolean eliminarRuta(int pos) {
		
		if (pos < TablaRuteo.length) {
			this.TablaRuteo[pos] = null;
			return true;
		}
		return false;
	}
	
	public boolean hayEspacioTabla() {
		for(int x=0; x < this.TablaRuteo.length ; x++) {
			if(this.TablaRuteo[x] == null) {
				return true;
			}
		}
		return false;
	}
	
	public int getEspacioLibre() {
		for(int x=0; x < this.TablaRuteo.length ; x++) {
			if(this.TablaRuteo[x] == null) {
				return x;
			}
		}
		System.out.println("Error - No hay ningun puerto libre en el dispositivo");
		return -1;
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
			
			if(dr != null) {
				if (dr.esMismaRed(ip)) {
					return true;
				}
			}	
		}
		return false;
	}
	public int getPuertoInterfaz(IP ip) {
		
		int i=0;
		for (DirRed dr: TablaRuteo) {
			
			if(dr != null) {
				if (dr.esMismaRed(ip)) {
					return i;
				}
			i++;
			}
		}
		System.out.println("Error - No existe la ip de destino del paquete en la tabla de ruteo");
		return -1;
	}
	public void recibirPaquete(Dispositivo d, Paquete p) {
		
		if (d instanceof Router) {
			// Compruebo que el paquete de ruteo sea para el router
			if (p instanceof PaqueteDeServicio) {
				for(IP i : ips) {
					// si encuentro que ip destino del paquete es una ip asignada a mi router entonces..
					// se asume que las ip asignadas a las interfaces de router son unicas
					if (i.esMismaIP(p.getIpDestino())){
						
						procesarPaquetePropio(d,p);
					}
				}
			}else if(p instanceof PaqueteDeRuteo) {
				procesarPaquete(d, p);
			}	
		}	
	}
	
	private void procesarPaquetePropio(Dispositivo d, Paquete p) {
		
		if(p instanceof Who) {
			procesarWho(d,p);
		}else if(p instanceof ICMPRequest) {
			procesarICPMRequest(d,p);
		}else if(p instanceof ICMPResponse) {
			procesarICPMResponse(d,p);
		}
	}
	private void procesarICPMResponse(Dispositivo d , Paquete p) {
		((ICMPResponse)p).procesar(d);
	}
	private void procesarICPMRequest(Dispositivo d, Paquete p) {
		if (this.pertenece_IP_a_Tabla(((PaqueteDeRuteo)p).getContainer().getIpDestino())) 
		{
			// extraigo el paquete de servicio del paquete de ruteo
			ICMPResponse p_aux = new ICMPResponse(p.getIpOrigen());
			Optional<Paquete>pack = ((ICMPResponse)p_aux).procesar(d, this);				
			//obtengo puerto al que corresponde enviar segun Tabla de Ruteo
			int i = getPuertoInterfaz(p.getIpDestino());
			if (i != -1) {
				//envio paquete al puerto correspondiente
				if(pack.isPresent()) {
					this.router.enviar(pack.get(), i);
				}
			}	
		}
	}
	private void procesarWho(Dispositivo d, Paquete p) {
		
		for (IP ip : ips)
		{
		
			if (ip.esMismaIP(p.getIpDestino()) ) 
			{
				// extraigo el paquete de servicio del paquete de ruteo
				Who p_aux = new Who(p.getIpOrigen(),p.getIpDestino(),p.getTtl());
				Optional<Paquete>pack = ((Who)p_aux).procesar(d, this);				
				//obtengo puerto al que corresponde enviar segun Tabla de Ruteo
				int i = getPuertoInterfaz(p.getIpDestino());
				if (i != -1) {
					//envio paquete al puerto correspondiente
					if(pack.isPresent()) {
						this.router.enviar(pack.get(), i);
					}
				}	
			}
			
		}
		
	}
	public void procesarPaquete(Dispositivo d , Paquete p)
	{
			Paquete sm;
			// Compruebo que el paquete tenga Time To Live
			if (p.ttl > 0) {
				p.ttl--;
				// Compruebo si el paquete dentro del paquete de ruteo esta direccionado hacia
				// algunas de las ip en mi tabla
				if (this.pertenece_IP_a_Tabla(((PaqueteDeRuteo)p).getContainer().getIpDestino())) 
				{
					// extraigo el paquete de servicio del paquete de ruteo
					sm = ((PaqueteDeRuteo)p).getContainer();
					//obtengo puerto al que corresponde enviar segun Tabla de Ruteo
					int i = getPuertoInterfaz(sm.getIpDestino());
					if (i != -1) {
						//envio paquete al puerto correspondiente
						this.router.enviar(sm,i);
					}

				} else {
						
						if (TieneDefaultInt()) 
						{
							// enviar paquete de ruteo con cont adentro por default interface
							sm = new PaqueteDeRuteo(((PaqueteDeRuteo)p).getContainer());
							sm.setIpDestino(p.getIpDestino());
							sm.setIpOrigen(ips[getDefault_int()]);
							sm.setTtl(default_ttl);
							this.router.enviar(sm, getDefault_int());
						} else {
							// enviar SendMessage al origen del paquete que se esta procesando
							// Posible punto para exception
							sm = new SendMessage(p.getIpDestino(), ((PaqueteDeRuteo)p).getContainer().getIpOrigen(), default_ttl,
									"Este equipo no posee una salida valida, mensaje rechazado");
							
							//obtengo puerto al que corresponde enviar segun Tabla de Ruteo
							int i = getPuertoInterfaz(p.getIpOrigen());
							if (i != -1) {
								//envio paquete al puerto correspondiente
								this.router.enviar(sm,i);
							}
						}
					}
			
			} 
			
	}
		
	
}
