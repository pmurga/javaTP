package javaTP;

public abstract class Terminal implements iSO, iDispositivo, iConexion
{
	protected IP[] ip_Host;
	protected iDispositivo tipo_Dispositivo;
	protected IP default_Gateway;
	protected iSO sistema_Operativo; 
	protected iConexion interfaz_terminal;
	
	//permitir al usuario instalar un SO de su preferencia - por defecto los dispositivos no tendran un SO instalado (?)
	public abstract void instalarSO(iSO SO);
	
	public abstract void setIpHost(IP ip);

}
