package javaTP;

public class redPrueba {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		PC pc1 = new PC();
		SistemaOperativoTerminal nilux = new SistemaOperativoTerminal();
		pc1.instalar(nilux, "NILUX", "V1");
		pc1.getSO().configurarIP();

	}

}
