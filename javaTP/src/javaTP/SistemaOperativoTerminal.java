package javaTP;

import java.util.Optional;

public class SistemaOperativoTerminal extends SistemaOperativo {
	private Terminal terminal;
	protected IP[] ip_Host;
	protected IP default_Gateway;
	
	public void instalar(String name, String ver, Terminal t) {
		terminal = t;
		instalar(name, ver);
		
	}
	
	public void setIPHost(IP ip) {
		this.ip_Host[0] = ip;
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
	
	public void validarPaquete(Paquete p, Conectable c)
	{
		if (c instanceof Terminal) {
			
			//si Paquete es de tipo de ruteo no lo proceso - lo descarto
			if (p instanceof PaqueteDeServicio)
			{
				IP ip_aux = p.getIpDestino();
				IP[] hosts = ((Terminal)c).getIP_Host();
				
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
	//void asignarIP (Terminal t){}
	public void enviarPaquete(Paquete p, Conectable c)
	{
		if(c instanceof Terminal) 
		{	
			//si el paquete no es de servicio queda descartado - no es procesado
			if (p instanceof PaqueteDeServicio)
			{
				IP ip_aux = p.getIpDestino();
				IP[] hosts = ((Terminal)c).getIP_Host();
				Conectable[] c_aux = ((Terminal) c).getConectados();
			
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
							PaqueteDeRuteo pr = new PaqueteDeRuteo(p);
							pr.setIpDestino(((Terminal) c).getDefault_Gateway());
							
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
