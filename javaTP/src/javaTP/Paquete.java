package javaTP;

	public class Paquete {
		
		protected IP ipDestino;
		protected IP ipOrigen;
		protected Integer ttl;
		
		public Paquete() {
			ipDestino = new IP();
			ipOrigen = new IP();
			ttl = 0;
		}
		
		public Paquete(IP orig, IP dest, Integer t) {
			ipOrigen = orig;
			ipDestino = dest;
			ttl = t;
		}
		
	}
