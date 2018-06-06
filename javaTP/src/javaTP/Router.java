package javaTP;

public class Router extends Dispositivo {

	@Override
	public void enviar(Paquete p) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void recibir(Paquete p) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public boolean conectar(Conectable d) {
		// TODO Auto-generated method stub
		return false;
	}

	public boolean pertenece_IP_a_Tabla(IP ipDestino) {
		// TODO Auto-generated method stub
		return false;
	}

	public boolean existe_Interfaz_Defautl() {
		// TODO Auto-generated method stub
		return false;
	}

	public IP get_IP_from_Default_Interface() {
		// TODO Auto-generated method stub
		return null;
	}

}
