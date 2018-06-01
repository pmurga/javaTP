package javaTP;

public interface Conectable
{
	
	public void enviar(Paquete p);
	public void recibir(Paquete p);
	public boolean conectar(Conectable d); /* paso por parametro un dispositivo de destino y lo conecta el actual al mismo - varia segun dispositivo */

}
