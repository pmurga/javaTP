package javaTP;

import java.util.Optional;

public class PaqueteDeServicio extends Paquete{
	public TipoDeServicio tipo;	 
	
	public PaqueteDeServicio() {
		super();
		
	}
	
	
	public boolean esMismaRed(IP p) {return ipDestino.esMismaRed(p);}
	
	public PaqueteDeServicio(IP orig, IP dest, Integer t) {
		super(orig,dest,t);
		
	}
	

	public TipoDeServicio getTipo() {
		return tipo;
	}


	public void setTipo(TipoDeServicio tipo) {
		this.tipo = tipo;
	}


	@Override
	public Optional<Paquete> procesar(Dispositivo d, SistemaOperativo so) {
		return tipo.procesarServicio(d,so,this);
		
	}
	
}
