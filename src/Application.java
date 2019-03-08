import javax.swing.SwingUtilities;

import controller.ControllerImpl;
import model.ObserverData;
import view.ViewFactory;

public class Application {

	public static void main(String[] args) {
		System.setProperty("java.net.preferIPv4Stack" , "true");
		SwingUtilities.invokeLater(new Runnable() {
	        public void run() {
	            ControllerImpl.getInstance().init();
	        }
	    });
		
		//----Outside of EDT
		try {Thread.sleep(2500);} catch (InterruptedException e) {}         
        ControllerImpl.getInstance().makeNotify(ObserverData.ODTYPE_TEST, ObserverData.OPVALUE_UNDEFINED, "Das ist ein TEST.", ObserverData.OPBOOL_UNDEFINED);
         
//         try {Thread.sleep(600);} catch (InterruptedException e) {}         
//         ControllerImpl.getInstance().makeNotify(ObserverData.ODTYPE_BG_COLOR, ObserverData.OPVALUE_UNDEFINED, "0xAABBCC", ObserverData.OPBOOL_UNDEFINED);
        
        try {Thread.sleep(600);} catch (InterruptedException e) {}         
        ControllerImpl.getInstance().selectView(ViewFactory.VIEWNAME_TEST2);
	}
}
