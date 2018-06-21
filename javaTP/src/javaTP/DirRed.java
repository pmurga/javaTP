package javaTP;

public abstract class DirRed {
	protected int oct1;
	protected int oct2;
	protected int oct3; 
	
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
	
	public DirRed() {
		oct1 = 0;
		oct2 = 0;
		oct3 = 0;
	}
	
	public DirRed(int n1,int n2,int n3) {
		oct1 = n1;
		oct2 = n2;
		oct3 = n3;
	}
	
	public boolean esRedValida() {
		boolean es = false;
		if (oct1 >= 0) {
			if(oct2 >= 0) {
				if (oct3 >= 0) {
					es = true;
				}
			}
		 }
			return es;
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
