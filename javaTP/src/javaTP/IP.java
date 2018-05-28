package javaTP;


public class IP {
	private int oct1;
	private int oct2;
	private int oct3;
	private int oct4;
	private boolean es;
	
	public int getOct1() {
		return oct1;
	}
	public void setOct1(int oct1) {
		this.oct1 = oct1;
	}
	public int getOct2() {
		return oct2;
	}
	public void setOct2(int oct2) {
		this.oct2 = oct2;
	}
	public int getOct3() {
		return oct3;
	}
	public void setOct3(int oct3) {
		this.oct3 = oct3;
	}
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

	public IP() {oct1 = 0; oct2 = 0; oct3 = 0; oct4 = 0;}
	public IP (int n1, int n2, int n3, int n4) {
		oct1 = n1;
		oct2 = n2;
		oct3 = n3;
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
}
