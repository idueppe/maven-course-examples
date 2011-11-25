package course.jaxws.webservice;

import javax.xml.ws.Endpoint;

import junit.framework.TestCase;
import course.jaxws.fraction.Fraction;
import course.jaxws.fraction.FractionBean;
import course.jaxws.generated.BruchDienst;
import course.jaxws.generated.FractionBeanService;

public class FractionTest extends TestCase {
	
	public void testLocalBruch() {
		Fraction bruch = new FractionBean();

		bruch.setValue(1, 2);
		assertEquals(0.5, bruch.getValue(), 0.00001);
		bruch.add(2);
		assertEquals(2.5, bruch.getValue(), 0.00001);
		bruch.mult(2);
		assertEquals(5.0, bruch.getValue(), 0.00001);
		assertFalse(bruch.isNull());
		bruch.mult(0);
		assertEquals(0, bruch.getValue(), 0.00001);
		assertTrue(bruch.isNull());
	}
	
	public void testWSBruch() {
		Endpoint endpoint = Endpoint.publish("http://localhost:9001/services",	new FractionBean());
		try {
			BruchDienst bruch = new FractionBeanService().getBruchDienstPort();
			
			bruch.setzeWert(1, 2);
			assertEquals(0.5, bruch.aktuellerWert(), 0.00001);
			bruch.addiere(2);
			assertEquals(2.5, bruch.aktuellerWert(), 0.00001);
			bruch.multipliziere(2);
			assertEquals(5.0, bruch.aktuellerWert(), 0.00001);
			assertFalse(bruch.istNull());
			bruch.multipliziere(0);
			assertEquals(0, bruch.aktuellerWert(), 0.00001);
			assertTrue(bruch.istNull());
		} finally {
			endpoint.stop();
		}
	}

}
