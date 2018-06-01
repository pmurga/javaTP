package javaTP;

public abstract class Terminal extends Dispositivo implements iConexion
{
	protected IP ip_Host;
	protected Dispositivo tipo_Dispositivo;
	protected IP default_Gateway;
	protected SistemaOperativo sistema_Operativo; 
	
	//permitir al usuario instalar un SO de su preferencia - por defecto los dispositivos no tendran un SO instalado (?)
	public abstract void instalar(SistemaOperativo SO);
	public abstract String getSO();
	public abstract void setIpHost(IP ip);
	
	public Terminal()
	{
		this.nroPuertos = 1;
	}
	
	@Override
	public void conectar(Dispositivo d)
	{
		if (this.destino != d)
		{
			this.destino = d;
			//d.conectar(this); HAY QUE HACER UPCASTING DE ESTO
		}
		
	}
	
	public void enviar(Paquete p)
	{
		// la la
	}
	public void recibir(Paquete p)
	{
		//la la
	}
	
}
