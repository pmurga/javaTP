package javaTP;

import java.util.ArrayList;

public class Router extends Dispositivo {

	private Conectable[] conectados;
	private int puertos;
	
	@Override
	public void enviar(Paquete p) {
		// TODO Auto-generated method stub

	}

	@Override
	public void recibir(Paquete p) {
		// TODO Auto-generated method stub

	}

	@Override
	public boolean conectar(Conectable d2) {
		{
			// validar que this no es mismo dispositivo que d2 (para que no se conecte a si
			// mismo)
			if (!(this.equals(d2))) {
				// validar que this tenga puerto libre para conectar
				if (this.tienePuertosLibres()) {
					// validar que d2 tenga puerto libre para conectar
					if (((Dispositivo) d2).tienePuertosLibres()) {
						int p1 = this.getPuertoLibre();
						this.conectados[p1] = d2;
						int p2 = ((Dispositivo) d2).getPuertoLibre();
						((Dispositivo) d2).conectados[p2] = this;
						return true;
					}
				}
			}
			return false;
		}
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
