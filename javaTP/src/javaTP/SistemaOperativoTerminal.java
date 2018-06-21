package javaTP;

import java.util.Optional;
import java.util.Scanner;

public class SistemaOperativoTerminal extends SistemaOperativo {
	private Terminal terminal;
	protected IP[] ip_Host;
	protected IP default_Gateway;
	private Scanner teclado;
	//private System	consola;
	
	public SistemaOperativoTerminal() {
		ip_Host = new IP[1];
		teclado = new Scanner(System.in);
	}
	
	public void instalar(String name, String ver, Terminal t) {
		terminal = t;
		instalar(name, ver);
		
	}
	
	public void setIPHost(IP ip) {
		this.ip_Host[0] = ip;
		//set default gateway (automatico)
		this.default_Gateway = new IP(ip.getOct1(),ip.getOct2(),ip.getOct3(),1);
		System.out.println("!!!!!DG " + default_Gateway);
	}
	public IP[] getIP_Host() {
		return ip_Host;
	}
	public IP getDefault_Gateway() {
		return default_Gateway;
	}
	public void setDefault_Gateway(IP default_Gateway) {
		this.default_Gateway = default_Gateway;
	}
	
	public void configurarIP() {
		System.out.println("Inserte la IP de este Equipo, separando los Octetos por puntos:");
		String msg;
		IP i = new IP();
		do {
		msg = teclado.nextLine();
		try {
			i.fromString(msg);
		} catch (IllegalArgumentException | IPInvalidaException e) {
			e.printStackTrace();
		}
		}while (!i.esValida());
		setIPHost(i);
	}
	
	public void validarPaquete(Paquete p, Conectable c)
	{
		if (c instanceof Terminal) {
			
			//si Paquete es de tipo de ruteo no lo proceso - lo descarto
			if (p instanceof PaqueteDeServicio)
			{
				IP ip_aux = p.getIpDestino();
				IP[] hosts = getIP_Host();
				
				//verifico para cada ip asignada a mi host
				for (IP host : hosts)
				{
					//validar si la ip de destino del paquete es igual a alguna de las ip de mi host
					if (ip_aux.esMismaIP(host))
					{
						Optional<Paquete> pack = ((PaqueteDeServicio)p).procesar(((Dispositivo) c), this);
						if(pack.isPresent()) {		
						enviarPaquete(pack.get(), c);
						//break para el for o validar que no suceda mas de 1 vez
						}
					}
				}
			}
		}
	}
	public void enviarPaquete(Paquete p, Conectable c)
	{
		if(c instanceof Terminal) 
		{	
			//si el paquete no es de servicio queda descartado - no es procesado
			if (p instanceof PaqueteDeServicio)
			{
				IP ip_aux = p.getIpDestino();
				IP[] hosts = getIP_Host();
				
				Conectable[] c_aux = this.terminal.getConectados();
			
				//verifico para cada ip asignada a mi host
				for (IP host : hosts)
				{
					//validar si la ip de destino del paquete pertenece a la misma red que la ip donde estoy parado
					if (ip_aux.esMismaRed(host))
					{
						for (Conectable conectado : c_aux)
						{
							//enviar paquete a dispositivo conectado a interfaz de la terminal
							conectado.recibir(p);
						}		
					}else 
						{
							//rearmar Paquete como PaqueteDeRuteo y asignar destino como defaultGateway de mi equipo
							PaqueteDeRuteo pr = new PaqueteDeRuteo();
							pr.setContainer(p);
							pr.setIpDestino(getDefault_Gateway());
							
							for (Conectable conectado : c_aux)
							{
								//enviar paquete a dispositivo conectado a defaultGateway
								conectado.recibir(p);
							}	
						}
				}
			}
		}
	}


}
