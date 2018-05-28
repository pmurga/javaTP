package javaTP;

public class PC extends Terminal
{

	public PC(iDispositivo device){
		this.tipo_Dispositivo = device;
	}
	
	@Override
	public String getSO() {
		// TODO Auto-generated method stub
		return this.sistema_Operativo.getSO();
	}

	@Override
	public iDispositivo getDispositivo() {
		// TODO Auto-generated method stub
		return this.tipo_Dispositivo;
	}

	@Override
	public void setIpHost(IP ip) {
		
		int i = this.ip_Host.length;
		
		if (i == 0){
			
			this.ip_Host[0].setOct1(ip.getOct1());
			this.ip_Host[0].setOct2(ip.getOct2());
			this.ip_Host[0].setOct3(ip.getOct3());
			this.ip_Host[0].setOct4(ip.getOct4());

		}else {
			this.ip_Host[i].setOct1(ip.getOct1());
			this.ip_Host[i].setOct2(ip.getOct2());
			this.ip_Host[i].setOct3(ip.getOct3());
			this.ip_Host[i].setOct4(ip.getOct4());
			
		}
		
		
	}

	@Override
	public void instalarSO(SistemaOperativo SO) {

		sistema_Operativo.so = SO.so;
		sistema_Operativo.version = SO.version;
		sistema_Operativo.ip = this.ip_Host[0];
		
	}

}
