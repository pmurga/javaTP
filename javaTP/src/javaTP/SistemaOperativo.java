package javaTP;

public class SistemaOperativo implements iSO {

	protected String so_nombre;
	protected IP so_ip;
	protected String so_version;
	
	
	//return del nombre del Sistema Operativo
	@Override
	public String getSO() {
		return so_nombre;
	}

	@Override
	public String getVersion() {
		return so_version;
	}

	@Override
	public IP getIPHost() {
		return so_ip;
	}

	public void instalar(String nombre, String version )
	{
		this.so_nombre = nombre;
		this.so_version = version;
	}

	public PaqueteDeServicio generarPaqueteServicio()
	{
		
	}
	
	public PaqueteDeRuteo generarPaqueteRuteo()
	{
		
	}
	
}
