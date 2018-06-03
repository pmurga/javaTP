package javaTP;

public class SendMessage implements TipoDeServicio{
	private SistemaOperativo so;
	


	public SendMessage() {
	}
	public SendMessage(SistemaOperativo orig) {
		so = orig;
		
	}


	@Override
	public void procesarServicio(SistemaOperativo so, Paquete p) {
		// TODO Auto-generated method stub
		
	}

}
