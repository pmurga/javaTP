package javaTP;

public abstract class Terminal implements iSO, iDispositivo
{
	protected IP[] ip_Host;
	protected String tipo_Dispositivo;
	protected IP default_Gateway;
	protected iSO sistema_Operativo; // hay que instanciar esto
	
	public void getDispositivo()
	{
		tipo_Dispositivo = "Terminal";
	}
	
	/*
	public void instalar(iSO SO)
	{
		SO
	}
	*/
}
