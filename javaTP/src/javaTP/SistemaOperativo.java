package javaTP;

import java.util.Optional;

public class SistemaOperativo implements Instalable {

	protected String so_nombre;
	protected String so_version;
	protected Integer default_ttl;
	
	public SistemaOperativo() {
		// TODO Auto-generated constructor stub
		default_ttl = 255;
	}
	//return del nombre del Sistema Operativo
	@Override
	public String getSO() {
		return so_nombre;
	}

	@Override
	public String getVersion() {
		return so_version;
	}

	public void instalar(String nombre, String version )
	{
		this.so_nombre = nombre;
		this.so_version = version;
	}

	/*
	//UNA VEZ QUE SE QUE EL PAQUETE A PROCESAR ES PARA MI, USO ESTE METODO
	//Deberia ser utilizado en la instruccion "Recibir" del dispositivo (mas alla de si es un Router o una Terminal)
	public Optional<Paquete> procesarPaquete(Dispositivo d, Paquete p){
		return  p.procesar(d, this);	
	}
	*/
	
	
	
	@Override
	public String toString() {
		return "SistemaOperativo [so_nombre=" + so_nombre +  " ,so_version=" + so_version
				+ ", default_ttl=" + default_ttl + "]";
	}
	
	
}
