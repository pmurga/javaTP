package javaTP;

public class SendMessage implements TipoDeServicio{
	private SistemaOperativo so;
	private String servicio;
	private String message;
	
	@Override
	public String getServicio() {
		// TODO Auto-generated method stub
		return null;
	}


	public SendMessage() {
		
		servicio = "SendMessage";
		message = "";
	}
	public SendMessage(String s,SistemaOperativo orig,String m) {
		so = orig;
		servicio = s;
		message = m;
		
	}

}
