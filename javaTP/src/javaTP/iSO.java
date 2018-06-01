package javaTP;

//Sistema Operativo
public interface iSO 
{
	
	public String getSO();
	public String getVersion();
	public IP getIPHost();
	public void instalar(String nombre, String version);
	

}
