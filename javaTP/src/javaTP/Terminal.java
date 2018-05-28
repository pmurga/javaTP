package javaTP;

public abstract class Terminal implements iDispositivo, iConexion
{
	protected IP[] ip_Host;
	protected iDispositivo tipo_Dispositivo;
	protected IP default_Gateway;
	protected SistemaOperativo sistema_Operativo; 
	protected iConexion interfaz_terminal;
	
	//permitir al usuario instalar un SO de su preferencia - por defecto los dispositivos no tendran un SO instalado (?)
	public abstract void instalarSO(SistemaOperativo SO);
	public abstract String getSO();
	
	public abstract void setIpHost(IP ip);
	

}
