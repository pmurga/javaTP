package javaTP;

public class ICMPRequest implements TipoDeServicio{
	private IP orig;
	private String servicio;
	
	
	@Override
	public String getServicio() {
		// TODO Auto-generated method stub
		return null;
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


	public ICMPRequest() {
		servicio = "ICMPRequest";
	}
	public ICMPRequest(IP p) {
		orig = p;
		servicio = "ICMPRequest";
	}
}
