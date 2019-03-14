package model;

import java.net.SocketException;
import java.util.Observable;
import java.util.Observer;

import ch.bildspur.artnet.ArtNetClient;
import ch.bildspur.artnet.ArtNetException;
import ch.bildspur.artnet.ArtNetServer;
import ch.bildspur.artnet.packets.ArtNetPacket;
import ch.bildspur.artnet.packets.ArtPollReplyPacket;
import ch.bildspur.artnet.packets.PacketType;

public class Model extends Observable {
	
	private static String NAME = "Test-Project";
	private static String VERSION = "004";

	private ArtNetServer artNetServer;
	private ArtNetClient artNetClient;
	
	public Model() {
		this.init();
		//this.initArtNetServer();
		//this.initArtNetClient();
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
		this.notifyObservers( obsData );
	}
	
	
	private void initArtNetServer() {
		ArtPollReplyPacket aprp = new ArtPollReplyPacket();
		aprp.setLongName("Deine Mudder");
		aprp.setShortName("DM");
		
		this.artNetServer = new ArtNetServer();
		this.artNetServer.setDefaultReplyPacket(aprp);
		try {
			this.artNetServer.start();
		} catch (SocketException | ArtNetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}
	
	private void initArtNetClient() {
		this.artNetClient = new ArtNetClient( null );
		byte[] dmxData = new byte[512];
		this.artNetClient.broadcastDmx(1, 1, dmxData);
	}
	
	
//	public void sendDMX() {
//		byte[] dmxData = new byte[512];
//		this.artNetClient.broadcastDmx(01, 01, dmxData);
//	}
	
}//model
