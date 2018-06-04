package javaTP;

import java.util.Optional;

public abstract class Paquete {
		
		protected IP ipDestino;
		protected IP ipOrigen;
		protected Integer ttl;
		
		public IP getIpDestino() {
			return ipDestino;
		}

		public void setIpDestino(IP ipDestino) {
			this.ipDestino = ipDestino;
		}

		public IP getIpOrigen() {
			return ipOrigen;
		}

		public void setIpOrigen(IP ipOrigen) {
			this.ipOrigen = ipOrigen;
		}

		public Integer getTtl() {
			return ttl;
		}

		public void setTtl(Integer ttl) {
			this.ttl = ttl;
		}

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
		
		public abstract Optional<Paquete> procesar(Dispositivo d, SistemaOperativo so);
		public boolean esMismaRed(IP dest){return ipDestino.esMismaRed(dest);}
		
	}
