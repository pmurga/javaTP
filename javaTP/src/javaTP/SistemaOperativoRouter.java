package javaTP;

import java.util.ArrayList;

public class SistemaOperativoRouter extends SistemaOperativo {
	private IP[] ips;
	private DirRed[] TablaRuteo;
	
	public SistemaOperativoRouter() {
		
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
	
	
}
