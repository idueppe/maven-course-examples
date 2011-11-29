package course.jpa.dbutil;

import java.io.InputStream;
import java.sql.Connection;

import org.dbunit.database.DatabaseConnection;
import org.dbunit.database.IDatabaseConnection;
import org.dbunit.dataset.IDataSet;
import org.dbunit.dataset.xml.FlatXmlDataSetBuilder;
import org.dbunit.operation.DatabaseOperation;

/**
 * Loads test data in the form of DbUnit XML into a database.
 * 
 * @author idueppe
 */
public class DbUnitDataLoader {
	private InputStream testData;
	private Connection connection;

	public DbUnitDataLoader(InputStream testData, Connection connection) {
		this.testData = testData;
		this.connection = connection;
	}

	/**
	 * Replace existing data with test data
	 */
	public void populateTestData() throws Exception {
		FlatXmlDataSetBuilder builder = new FlatXmlDataSetBuilder();
		builder.setColumnSensing(true);
		IDataSet dataSet = builder.build(testData);
		IDatabaseConnection con = new DatabaseConnection(connection);
		con.getConfig().setProperty("http://www.dbunit.org/features/qualifiedTableNames", true);
		DatabaseOperation.CLEAN_INSERT.execute(con, dataSet);
	}
}
