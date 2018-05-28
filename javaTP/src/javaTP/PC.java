package javaTP;

public class PC extends Terminal
{

	public PC(iDispositivo device){
		this.tipo_Dispositivo = device;
	}
	
	@Override
	public iSO getSO() {
		// TODO Auto-generated method stub
		return this.sistema_Operativo;
	}

	@Override
	public iDispositivo getDispositivo() {
		// TODO Auto-generated method stub
		return this.tipo_Dispositivo;
	}

	@Override
	public void instalarSO(iSO SO) {

		this.sistema_Operativo = SO;
		
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

}
