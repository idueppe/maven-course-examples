package course.jpa.dbutil;

import java.io.InputStream;
import java.sql.Connection;
import java.sql.SQLException;

import javax.persistence.EntityManager;

import org.hibernate.ejb.HibernateEntityManager;
import org.hibernate.jdbc.Work;

/**
 * Hibernate Entity Worker to load test data into persistence database.
 * 
 * The usage is to call the populate methode with an EntityManager (from Hibernate) and the URL to the DBUnit xml file:
 * <code>
 * 	 em = emf.createEntityManager();
 *	 PopulateDBWork.populate(em, "/db.xml");
 * </code>
 * 
 * @author idueppe
 *
 */
public final class PopulateDBWork implements Work {
	
	private InputStream testData;
	
	private PopulateDBWork(String resourceName) {
		testData = PopulateDBWork.class.getResourceAsStream(resourceName);
	}
	
	public static void populate(EntityManager em, String resourceName) {
		((HibernateEntityManager)em).getSession().doWork(new PopulateDBWork(resourceName));
	}
	
	public void execute(Connection connection) throws SQLException {
		try {
			populateDatabase(connection);
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}
	
	private void populateDatabase(Connection connection) throws Exception {
		new DbUnitDataLoader(testData, connection).populateTestData();
	}
}