package javaTP;

import java.util.ArrayList;

public class SistemaOperativoRouter extends SistemaOperativo {
	private IP[] ips;
	private DirRed[] TablaRuteo;
	private int cantRutas;
	
	public SistemaOperativoRouter() {
		
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
	
	
}
