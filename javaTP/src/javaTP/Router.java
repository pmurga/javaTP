package javaTP;

import java.util.Optional;

//import java.util.ArrayList;

public class Router extends Dispositivo {
	protected SistemaOperativoRouter sistema_operativo;
	private int nro_puertos;
	
	public Router() {
		conectados = new Conectable[2];
	}
	
	public int getNro_puertos() {
		return nro_puertos;
	}

	public Router(int cant_puertos) {
		this.conectados = new Conectable[cant_puertos];
		validar_interfaces(cant_puertos);
	}
	private void validar_interfaces(int x) {
		
		if (this.conectados.length < 2) {
			//asignar 2 puertos como default
			this.conectados = new Conectable[2];
			this.nro_puertos = 2;
		}else {
			this.nro_puertos = x;
		}
	}
	
	@Override
	public void enviar(Paquete p) {
		for(Conectable conectado: conectados) {
			conectado.recibir(p);
		}
	}

	@Override
	public void recibir(Paquete p) {
		Optional<Paquete> pack = sistema_operativo.procesarPaquete(this, p);
		if (pack.isPresent()) {
			//sistema_operativo.enviarPaquete(pack.get(), Conectable?DeberiamosPonerElEquipoQueRecibeElPaquete);
		}
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
						// getPuertoLibre retorna -1 si no encuentra un puerto libre
						if (p1 != -1) {
							
							this.conectados[p1] = d2;
							System.out.println(this + " conectado exitosamente a " + d2);

							int p2 = ((Dispositivo) d2).getPuertoLibre();
							if (p2 != -1) {
								
								((Dispositivo) d2).conectados[p2] = this;
								System.out.println(d2 + " conectado exitosamente a " + this);
								return true;
							}
						}
					}
				}
			}
			System.out.println("No se pudo conectar a " + d2);
			return false;
		}
	}
	
	public void instalar(SistemaOperativoRouter so, String name,String ver) {
		sistema_operativo = so;
		so.instalar(name, ver, this);
		
	}

	public SistemaOperativoRouter getSistema_operativo() {
		return sistema_operativo;
	}

	public boolean pertenece_IP_a_Tabla(IP ipDestino) {
		// TODO Esto deberia revisar la tabla + las ip que estan en el SO y devolver true o false segun corresponda
		return false;
	}

}
