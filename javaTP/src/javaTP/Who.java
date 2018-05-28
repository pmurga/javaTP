package javaTP;

public class Who implements TipoDeServicio {
	private IP orig;
	private String servicio;
	
	
	public String getServicio() {
		return servicio;
	}
	public void setServicio(String servicio) {
		this.servicio = servicio;
	}
	public IP getOrig() {
		return orig;
	}
	public void setOrig(IP orig) {
		this.orig = orig;
	}
	
	public Who() {
		servicio = "Who";
	}
	
	public Who(IP p) {
		orig = p;
		servicio = "Who";
	}
	
	
	

}
