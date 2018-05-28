package javaTP;

public abstract class Terminal implements iSO, iDispositivo
{
	protected IP ipHost;
	protected String tipoDispositivo;
	
	public Terminal()
	{
		
	}
	
	public void getDispositivo()
	{
		tipoDispositivo = "Terminal";
	}

}
