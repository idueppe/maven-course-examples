package net.gfu.seminar.maven;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.io.IOException;
import java.io.InputStream;

import org.apache.log4j.Logger;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class AppTest {

	private static final Logger LOG = Logger.getLogger(AppTest.class);
	private App app;

	@Before
	public void setUp() throws Exception {
		app = new App();
	}

	@After
	public void tearDown() throws Exception {
		app = null;
	}

	@Test
	public void testDefaultMessage() {
		String message = app.getMessage();
		assertEquals("Hello, world!", message);
		LOG.debug(message);
	}

	@Test
	public void testMessage() {
		String message = "Hello World! Here is demo1.";
		app.setMessage(message);
		assertEquals(message, app.getMessage());
	}

	public void testTestResources() throws IOException {
		app.run();
		InputStream resourceAsStream = this.getClass().getResourceAsStream(
				"/test.properties");
		// expected behavior
		assertTrue(resourceAsStream.available() > 1);
		resourceAsStream.close();
	}

	public void testAppResources() throws IOException {
		app.run();
		InputStream resourceAsStream = this.getClass().getResourceAsStream(
				"/META-INF/application.properties");
		// expected behavior
		assertTrue(resourceAsStream.available() > 1);
		resourceAsStream.close();
	}

	@Test
	public void testMessageFromProperties() throws IOException {
		app.readMessageFromFile("/test.properties");
		assertEquals("foo", app.getMessage());
	}


}
