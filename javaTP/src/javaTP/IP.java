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
	
	public boolean esMismaIP(IP ip_aux)
	{
		//heredado de DirRed
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
	public void fromString(String msg) throws IllegalArgumentException, IPInvalidaException  {
		if (msg.contains(".")) {
		    // Split it.
			String[] parts = msg.split(".", 4);
			oct1 = Integer.parseInt(parts[0]);
			oct2 = Integer.parseInt(parts[1]);
			oct3 = Integer.parseInt(parts[2]);
			oct4 = Integer.parseInt(parts[3]);
			if (!esValida() ){throw new IPInvalidaException();} 
			
		} else {
		    throw new IllegalArgumentException("String " + msg + " does not contain .");
		}
		
	}
	public boolean esValida() {
		boolean es = false;
		if((oct1 < 255 || oct1 > 0)&&(oct2 < 255 || oct2 > 0)&&(oct3 < 255 || oct3 > 0)&&(oct4 < 255 || oct4 > 0)) {
			es = true;
		}
		return es;
	}
}
