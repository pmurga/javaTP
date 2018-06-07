package javaTP;

import java.sql.Timestamp;

import java.util.Optional;

public class ICMPResponse extends PaqueteDeServicio {
	private Timestamp timestamp;
	private IP equip_orig;

	public Timestamp getTimestamp() {
		return timestamp;
	}

	public void setTimestamp(Timestamp timestamp) {
		this.timestamp = timestamp;
	}

	public ICMPResponse(IP ip) {
		super();
		timestamp = new Timestamp(System.currentTimeMillis());
		equip_orig = ip;
	}

	@Override
	public Optional<Paquete> procesar(Dispositivo d, SistemaOperativo so) {

		System.out.println("Recibido ICMP desde: " + equip_orig.toString() + "TimeStamp: " + timestamp.toString());

		return Optional.empty();
	}

}
