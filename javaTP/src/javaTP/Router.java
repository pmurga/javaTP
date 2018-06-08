package javaTP;

//import java.util.ArrayList;

public class Router extends Dispositivo {

	protected Conectable[] conectados;
	protected int puertos;
	protected int default_int;
	protected boolean tieneDefaultInt;
	protected SistemaOperativoRouter sistema_operativo;
	
	public Router() {
		this.tieneDefaultInt = false;
		this.conectados = new Conectable[2];
	}
	
	public Router(int size_interfaces) {
		this.tieneDefaultInt = false;
		this.conectados = new Conectable[size_interfaces];
		validar_interfaces();
	}
	
	private void validar_interfaces() {
		
		if (this.conectados.length < 2) {
			//asignar 2 puertos como default
			this.conectados = new Conectable[2];
		}
	}
	
	public void setDefaultInt(int i) {
		
		this.default_int = i;
		this.tieneDefaultInt = true;
	}
	
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
		// TODO Esto deberia revisar la tabla + las ip que estan en el SO y devolver true o false segun corresponda
		return false;
	}

	public boolean existe_Interfaz_Defautl() {
		// TODO Nothing. Done.
		return tieneDefaultInt;
	}

	public IP get_IP_from_Default_Interface() {
		// TODO esto deberia dar la ip asociada al default interface.
		return null;
	}
	

}
