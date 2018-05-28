package javaTP;

public class SistemaOperativo implements iSO {

	protected String so;
	protected IP ip;
	protected String version;
	
	
	//return del nombre del Sistema Operativo
	@Override
	public String getSO() {
		return so;
	}

	@Override
	public String getVersion() {
		return version;
	}

	@Override
	public IP getIPHost() {
		return ip;
	}


}
