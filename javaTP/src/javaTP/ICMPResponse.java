package javaTP;


import java.util.Date;
import java.util.Timer;

public class ICMPResponse implements TipoDeServicio{
	private IP origen;
	private String servicio;
	private Date timestamp;
	
	@Override
	public String getServicio() {
		// TODO Auto-generated method stub
		return servicio;
	}
	public IP getOrigen() {
		return origen;
	}
	public void setOrigen(IP origen) {
		this.origen = origen;
	}
	public Date getTimestamp() {
		return timestamp;
	}
	public void setTimestamp(Date timestamp) {
		this.timestamp = timestamp;
	}
	public void setServicio(String servicio) {
		this.servicio = servicio;
	}

	
	public ICMPResponse() {
		servicio = "ICMPResponse";
	}
	public ICMPResponse(Date t,IP p) {
		servicio = "ICMPResponse";
		origen = p;
		timestamp = t;
	}
}
