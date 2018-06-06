package javaTP;

import java.util.Optional;

public class SendMessage implements TipoDeServicio{
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
	@Override
	public Optional<Paquete> procesarServicio(Dispositivo d, SistemaOperativo so, Paquete p) {
		Optional<Paquete> pack = Optional.empty();
		System.out.println(msg);
		return pack;
	}
}
