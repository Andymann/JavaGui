package misc;

public class PinManager {

	private static PinManager instance = null;
	private String sPIN ="";
	
	public static PinManager getInstance() {
		if(instance==null) {
			instance = new PinManager();
		}
		return instance;
	}
	
	private PinManager() {
		
	}
	
	
	public void addDigit(char pDigit) {
		this.sPIN += pDigit;
		System.out.println("PinManager.addDigit(): '" + pDigit + "'. Gesamt:" + sPIN);
	}
	
	public void resetPIN() {
		this.sPIN = "";
	}
	
	public String getPIN() {
		return this.sPIN;
	}
}
