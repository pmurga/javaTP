package javaTP;


import java.util.Date;
import java.util.Timer;

public class ICMPResponse implements TipoDeServicio{
	private Date timestamp;
	
	
	public Date getTimestamp() {
		return timestamp;
	}
	public void setTimestamp(Date timestamp) {
		this.timestamp = timestamp;
	}
	
	public ICMPResponse(Date t) {
		timestamp = t;
	}
	
}
