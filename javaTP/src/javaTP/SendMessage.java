package javaTP;

import java.util.Optional;

public class SendMessage implements TipoDeServicio{
	private SistemaOperativo so;
	//private Optional< Arraylist[] > Tabla_de_Ruteo; ¿Armar optional para cuando no es un Router?
	


	public SendMessage() {
		
	}
	public SendMessage(SistemaOperativo orig) {
		so = orig;
		
		
	}
	@Override
	public Optional<Paquete> procesarServicio(Dispositivo d, SistemaOperativo so, Paquete p) {
		Optional<Paquete> pack = Optional.empty();
		//imprimir msg
		System.out.println(so.toString());
		//if (!Tabla_de_Ruteo.isEmpty()){
		//System.out.println(Tabla_de_Ruteo.toString);
		//}
		
		return pack;
	}


	

}
