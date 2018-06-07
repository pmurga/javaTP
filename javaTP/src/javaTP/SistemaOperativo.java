package javaTP;

import java.util.Optional;

public class SistemaOperativo implements Instalable {

	protected String so_nombre;
	protected IP so_ip;
	protected String so_version;
	protected Integer default_ttl;
	
	
	//return del nombre del Sistema Operativo
	@Override
	public String getSO() {
		return so_nombre;
	}

	@Override
	public String getVersion() {
		return so_version;
	}

	@Override
	public IP getIPHost() {
		return so_ip;
	}

	public void instalar(String nombre, String version )
	{
		this.so_nombre = nombre;
		this.so_version = version;
	}

	/*
	public PaqueteDeServicio generarPaqueteServicio()
	{
		
	}
	
	public PaqueteDeRuteo generarPaqueteRuteo()
	{
		
	}
	*/
	//UNA VEZ QUE SE QUE EL PAQUETE A PROCESAR ES PARA MI, USO ESTE METODO
	//Deberia ser utilizado en la instruccion "Recibir" del dispositivo (mas alla de si es un Router o una Terminal)
	public Optional<Paquete> procesarPaquete(Dispositivo d, Paquete p){
		return  p.procesar(d, this);	
	}
	
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
						this.procesarPaquete(((Dispositivo)c), p);
					}
				}
			}
		}
	}
	
	@Override
	public String toString() {
		return "SistemaOperativo [so_nombre=" + so_nombre + ", so_ip=" + so_ip + ", so_version=" + so_version
				+ ", default_ttl=" + default_ttl + "]";
	}
	
	
}
