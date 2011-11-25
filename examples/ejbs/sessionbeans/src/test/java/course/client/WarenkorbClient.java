package course.client;

import course.common.Warenkorb;
import course.util.JNDI;

public class WarenkorbClient {
	
	public static void main(String[] args) throws Exception {
		String p1 = "USB-Stick", p2 = "Notebook";
		Warenkorb warenkorb = (Warenkorb) JNDI.lookup(JNDI.GLASSFISH_ENV,"course.common.Warenkorb");
		warenkorb.kaufen(p1, 5);
		warenkorb.kaufen(p2, 1);
		warenkorb.kaufen(p1, 2);
		System.out.println(warenkorb.getInhalt());
//		warenkorb = null; geht nicht 
		warenkorb.abmelden();
		
		
//		warenkorb = (Warenkorb) JNDI.lookup(JNDI.GLASSFISH_ENV,"course.common.Warenkorb");
		System.out.println("Inhalt:"+warenkorb.getInhalt());
	}
}
