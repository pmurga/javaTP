package javaTP;

public class Who implements TipoDeServicio {
	
	
	public Who() {
	}
	
	@Override
	public void procesarServicio(SistemaOperativo so, Paquete p) {
		PaqueteDeServicio sm = new PaqueteDeServicio(p.ipDestino, p.ipOrigen, so.ttl);
		
		sm.tipo = new SendMessage(so);
		//so.enviar(sm);
		
		
		
	}
	
	
	

}
