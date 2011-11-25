package course.jaxws.webservice;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import javax.ejb.embeddable.EJBContainer;
import javax.naming.Context;
import javax.naming.NamingException;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

import course.jaxws.bean.FractionEJB;

public class FractionEJBTest {
	private static EJBContainer ejbContainer;
	private static Context ctx;

	@BeforeClass
	public static void setUp() {
		ejbContainer = EJBContainer.createEJBContainer();
		ctx = ejbContainer.getContext();
	}

	@AfterClass
	public static void tearDown() {
		ejbContainer.close();
	}

	@Test
	public void testFindAll() {
		try {
			FractionEJB fraction = (FractionEJB) ctx.lookup("java:global/classes/FractionEJB!course.jaxws.bean.FractionEJB");
			assertNotNull(fraction);
			
			double result = fraction.bruch(4, 2);
			assertTrue(Math.abs(2.0 - result) < 0.01);
		
		} catch (NamingException e) {
			throw new AssertionError(e);
		}
	}
}