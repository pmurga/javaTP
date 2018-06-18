package javaTP;

public class SistemaOperativo implements Instalable {

	protected String so_nombre;
	protected String so_version;
	protected Integer default_ttl;
	
	public SistemaOperativo() {
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
	
	@Override
	public String toString() {
		return "SistemaOperativo [so_nombre=" + so_nombre +  " ,so_version=" + so_version
				+ ", default_ttl=" + default_ttl + "]";
	}
	
	
}
