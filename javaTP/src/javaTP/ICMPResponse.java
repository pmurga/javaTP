package javaTP;


import java.sql.Timestamp;
import java.util.Date;
import java.util.Optional;


public class ICMPResponse implements TipoDeServicio{
	private Timestamp timestamp;
	private IP equip_orig;
	
	
	public Date getTimestamp() {
		return timestamp;
	}
	public void setTimestamp(Timestamp timestamp) {
		this.timestamp = timestamp;
	}
	
	public ICMPResponse(IP ip) {
		timestamp = new Timestamp(System.currentTimeMillis());
		equip_orig = ip;
	}
	@Override
	public Optional<Paquete> procesarServicio(Dispositivo d, SistemaOperativo so, Paquete p) {
		Optional<Paquete> pack = Optional.empty();
		
		System.out.println("Recibido ICMP desde: "+ equip_orig.toString()  + "TimeStamp: "+timestamp.toString());
		
		return pack;
	}
	
}
