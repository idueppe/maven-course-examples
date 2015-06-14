package course.jaxws.webservice;

import javax.xml.ws.WebServiceRef;

import course.jaxws.generated.BruchDienst;
import course.jaxws.generated.FractionBeanService;

public class FractionClient {
	
	@WebServiceRef(wsdlLocation="http://localhost:9000/service?wsdl") 
	private static FractionBeanService service;

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		BruchDienst bruch = service.getBruchDienstPort();
		bruch.setzeWert(12, 3);
		bruch.aktuellerWert();

	}

}
