package javaTP;


public class IP extends DirRed{
	private int oct4;
	private boolean es;
	
	public int getOct4() {
		return oct4;
	}
	public void setOct4(int oct4) {
		this.oct4 = oct4;
	}
	public boolean isEs() {
		return es;
	}
	public void setEs(boolean es) {
		this.es = es;
	}
	
	public boolean validar() {
		es = false;
		if (oct1 <= 0) {
			if (oct4 != 0 && oct4 != 255) {
				es = true;
			}
		}
		return es;
	}

	public IP() {super(); oct4 = 0;}
	public IP (int n1, int n2, int n3, int n4) {
		super(n1,n2,n3);
		oct4 = n4;	
		validar();
			}
	public boolean esMismaRed(IP dest) {
		boolean es = false;
		if (oct1==dest.getOct1()) {
			if(oct2==dest.getOct2()) {
				if(oct3==dest.getOct3()) {
					es = true;
				}
			}
			
		}
		return es;
	}
	public boolean esMismaIP(IP ip_aux)
	{
		if (this.esMismaRed(ip_aux))
		{
			if (this.oct4 == ip_aux.oct4)
			{
				return true;
			}
		}
		return false;
	}
	@Override
	public String toString() {
		return "IP: "+oct1+"."+oct2+"."+oct3+"."+oct4;
	}
}
