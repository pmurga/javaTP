package javaTP;

import java.util.Optional;

public class SendMessage extends PaqueteDeServicio{
	private String msg;
	public SendMessage() {}
	public String getMsg() {
		return msg;
	}
	public void setMsg(String msg) {
		this.msg = msg;
	}
	public void agregarMsg(String s) {
		msg = msg + s;
	}
	public SendMessage(IP orig, IP dest, Integer t, String msg) {
		super(orig, dest, t);
		this.msg = msg;
		
	}
	/*@Override
	public Optional<Paquete> procesarServicio(Dispositivo d, SistemaOperativo so, Paquete p) {
		Optional<Paquete> pack = Optional.empty();
		System.out.println(msg);
		return pack;
	}*/
	@Override
	public Optional<Paquete> procesar(Dispositivo d, SistemaOperativo so) {
		System.out.println(msg);
		return Optional.empty();
	}
}
