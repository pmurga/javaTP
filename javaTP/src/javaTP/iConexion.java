package javaTP;

public interface iConexion 
{
	
	public void enviar(Paquete p);
	public void recibir(Paquete p);
	public void conectar(Dispositivo d); /* paso por parametro un dispositivo de destino y lo conecta el actual al mismo - varia segun dispositivo */

}
