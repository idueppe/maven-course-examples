package course.jaxws.bean;

import javax.ejb.Stateless;
import javax.xml.ws.WebServiceRef;

import course.jaxws.generated.BruchDienst;
import course.jaxws.generated.FractionBeanService;

@Stateless
public class FractionEJB {

	@WebServiceRef(FractionBeanService.class)
	private BruchDienst bruch;

	public double bruch(long a, long b) {
		bruch.setzeWert(a, b);
		double aktuellerWert = bruch.aktuellerWert();
		System.out.println("EJB > "+aktuellerWert);
		return aktuellerWert;
	}

}
