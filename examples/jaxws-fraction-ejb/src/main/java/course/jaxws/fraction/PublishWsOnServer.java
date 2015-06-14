package course.jaxws.fraction;

import javax.swing.JOptionPane;
import javax.xml.ws.Endpoint;

public class PublishWsOnServer {

	public static void main(String[] args) {
		Endpoint endpoint = Endpoint.publish("http://localhost:9000/services",	new FractionBean());
		JOptionPane.showMessageDialog(null, "Server beenden");
		endpoint.stop();
	}
}