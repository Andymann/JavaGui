package model;

import java.util.Observable;
import java.util.Observer;

public class Model extends Observable {

	private static String NAME = "Test-Project";
	private static String VERSION = "008";

	public Model() {
		this.init();
		// this.initArtNetServer();
		// this.initArtNetClient();
	}

	private void init() {

	}

	public String getVersion() {
		return VERSION;
	}

	public String getName() {
		return NAME;
	}

	public void addObserver(Observer pObserver) {
		super.addObserver(pObserver);
	}

	public void makeNotify(int pObserverType, int pValue, String pText, boolean pBool) {
		ObserverData obsData = new ObserverData(pObserverType, pValue, pText, pBool);
		this.setChanged();
		this.notifyObservers(obsData);
	}

	// public void sendDMX() {
	// byte[] dmxData = new byte[512];
	// this.artNetClient.broadcastDmx(01, 01, dmxData);
	// }

}// model
