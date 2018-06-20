package javaTP;

public class PruebasJavaTP {

	public static void main(String[] args) 
	{
		
		PC pc1 = new PC();
		PC pc2 = new PC();
		SistemaOperativoTerminal nilux = new SistemaOperativoTerminal();
		SistemaOperativoTerminal doors = new SistemaOperativoTerminal();
			
		IP ip1 = new IP(192, 168, 1, 10);
		IP ip2 = new IP(192, 168, 1, 20);
		IP ip3 = new IP(192, 168, 1, 30);
		IP ip4 = new IP(192, 168, 1, 40);

		pc1.instalar(nilux, "NILUX", "V1");
		pc1.getSO().setIPHost(ip1);
		pc2.instalar(doors, "DOORS", "V1");
		pc2.getSO().setIPHost(ip2);

		
		
		
		
		//para despues
		//pc1.getSO().configurarIP();
		
		
		
		
		
		/*
		Terminal PC1 = new (); 
		Terminal PC2 = new T; 
		Terminal PC3; 
		Conectable[] Ds = new Conectable[3];

		Ds[0] = PC1;
		Ds[1] = PC2;
		Ds[2] = PC3;
		
		*/
		
	}

}
