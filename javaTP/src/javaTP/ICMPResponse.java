package javaTP;


import java.util.Timer;

public class ICMPResponse implements TipoDeServicio{
	private IP origen;
	private String servicio;
	private Timer timestamp;
	
	@Override
	public String getServicio() {
		// TODO Auto-generated method stub
		return null;
	}
	public IP getOrigen() {
		return origen;
	}
	public void setOrigen(IP origen) {
		this.origen = origen;
	}
	public Timer getTimestamp() {
		return timestamp;
	}
	public void setTimestamp(Timer timestamp) {
		this.timestamp = timestamp;
	}
	public void setServicio(String servicio) {
		this.servicio = servicio;
	}

	
	public ICMPResponse() {
		servicio = "ICMPResponse";
	}
	public ICMPResponse(Timer t,IP p) {
		servicio = "ICMPResponse";
		origen = p;
		timestamp = t;
	}
}
