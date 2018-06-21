package javaTP;

public class pruebas_main {

	public static void main(String[] args) 
	{
		
		System.out.println("_________________");
		System.out.println("CASO 1: Terminal <-> Terminal");
		System.out.println("");

		
		pruebas_PC pc1 = new pruebas_PC();
		pruebas_PC pc2 = new pruebas_PC();
		SistemaOperativoTerminal nilux = new SistemaOperativoTerminal();
		SistemaOperativoTerminal doors = new SistemaOperativoTerminal();
			
		IP ip1 = new IP(192, 168, 1, 10);
		IP ip2 = new IP(192, 168, 1, 20);
		
		System.out.println("PC1: " + pc1);
		pc1.instalar(nilux, "NILUX", "V1");
		System.out.println("SO de pc1: " + pc1.getSO().toString());
		pc1.getSO().setIPHost(ip1);
		for (IP ip : pc1.getSO().getIP_Host())
		{
			System.out.println("IP de PC1 --> " + ip.toString());
		}
		
		System.out.println("");
		System.out.println("PC2: " + pc2);
		pc2.instalar(doors, "DOORS", "V1");
		System.out.println("SO de pc2: " + pc2.getSO().toString());
		pc2.getSO().setIPHost(ip2);
		for (IP ip : pc2.getSO().getIP_Host())
		{
			System.out.println("IP de PC2 --> " + ip.toString());
		}
		
		System.out.println("");
		System.out.println(">>>Conectar pc1 a pc2");

		pc1.conectar(pc2);
		
		IP origen = pc1.getSO().getIP_Host()[0];
		IP destino = pc2.getSO().getIP_Host()[0];
				
		
		Paquete p1 = new ICMPRequest(origen ,destino , 50);
		
		System.out.println("");
		System.out.println(">>>Enviar ICMPRequest de Pc1 a Pc2");
		pc1.getSO().enviarPaquete(p1, pc2);
		
		System.out.println("_________________");
		System.out.println("CASO 2(Hub y envio de paquete entre terminales de mismo hub): ");
		System.out.println("Hub");
		System.out.println("|-> Pc3");
		System.out.println("|-> Pc4");
		System.out.println("");

		
		pruebas_PC pc3 = new pruebas_PC();
		pruebas_PC pc4 = new pruebas_PC();
		SistemaOperativoTerminal utunbu = new SistemaOperativoTerminal();
		SistemaOperativoTerminal camOS = new SistemaOperativoTerminal();
		
		IP ip3 = new IP(192, 168, 1, 30);		
		System.out.println("PC3: " + pc3);
		pc3.instalar(utunbu, "UTUNBU", "V16.04");
		System.out.println("SO de pc3: " + pc3.getSO().toString());
		pc3.getSO().setIPHost(ip3);
		for (IP ip : pc3.getSO().getIP_Host())
		{
			System.out.println("IP de PC3 --> " + ip.toString());
		}
		
		System.out.println("");

		IP ip4 = new IP(192, 168, 1, 40);
		System.out.println("PC4: " + pc4);
		pc4.instalar(camOS, "camOS", "vLOW MOUNTAIN");
		System.out.println("SO de pc4: " + pc4.getSO().toString());
		pc4.getSO().setIPHost(ip4);
		for (IP ip : pc4.getSO().getIP_Host())
		{
			System.out.println("IP de PC4 --> " + ip.toString());
		}
		
		System.out.println("");		
		pruebas_Hub4 hub4p = new pruebas_Hub4();
		System.out.println("Hub de 4 Puertos: " + hub4p);
		
		System.out.println("");		
		System.out.println(">>>Conectar Hub 4 puertos a pc3 y pc4");		
		hub4p.conectar(pc3);
		hub4p.conectar(pc4);
		
		IP origen2 = pc3.getSO().getIP_Host()[0];
		IP destino2 = pc4.getSO().getIP_Host()[0];	
		
		Paquete p2 = new ICMPRequest(origen2 ,destino2 , 50);
		
		System.out.println("");
		System.out.println(">>>Enviar ICMPRequest de Pc3 a Pc4");
		pc3.getSO().enviarPaquete(p2, pc4);
		
		
		System.out.println("_________________");
		System.out.println("CASO 3 (envio de paquetes entre dos terminales de subnet distintas): ");
		System.out.println("Router");
		System.out.println("|-> Hub");
		System.out.println("|  |-> Pc3");
		System.out.println("|  |-> Pc4");
		System.out.println("|");
		System.out.println("|-> Pc5");
		System.out.println("");

		pruebas_Router2Interfaces router2int = new pruebas_Router2Interfaces();
		System.out.println("Router de 2 Interfaces / Puertos: " + router2int);
		SistemaOperativoRouter pisco = new SistemaOperativoRouter();
		router2int.instalar(pisco, "PISCO", "V4.5.1");
		System.out.println(router2int.getSistema_operativo());
		IP ipR1 = new IP(192,168,1,1);
		IP ipR2 = new IP(10,1,1,1);
		router2int.getSistema_operativo().setIP(ipR1, 0);
		router2int.getSistema_operativo().setIP(ipR2, 1);
		router2int.getSistema_operativo().mostrarIPs();
		System.out.println("");
		
		pruebas_PC pc5 = new pruebas_PC();
		SistemaOperativoTerminal pint = new SistemaOperativoTerminal();
		IP ip5 = new IP(10, 1, 1, 5);
		System.out.println("PC5: " + pc5);
		pc5.instalar(pint, "PINT", "V5");
		System.out.println("SO de pc5: " + pc5.getSO().toString());
		pc5.getSO().setIPHost(ip5);
		for (IP ip : pc5.getSO().getIP_Host())
		{
			System.out.println("IP de PC5 --> " + ip.toString());
		}

		System.out.println("");	
		System.out.println(">>>Conectar pc5 directo a router");		
		router2int.conectar(pc5);
		System.out.println("");	
		System.out.println(">>>Conectar hub4puertos directo a router");		
		router2int.conectar(hub4p);

		IP origen3 = pc5.getSO().getIP_Host()[0];
		IP destino3 = pc4.getSO().getIP_Host()[0];	
		
		Paquete p3 = new ICMPRequest(origen3 ,destino3 , 50);
		
		System.out.println("");
		System.out.println(">>>Enviar ICMPRequest de Pc5 a Pc4");
		System.out.println("");
		pc5.getSO().enviarPaquete(p3, pc4);
		
		
		
	}

}
