package net.gfu.seminar.maven;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

/**
 * Hello world!
 *
 */
public class App {
	public static void main(String[] args) {
		App app = new App();
		try {
			app.readMessageFromFile("/META-INF/application.properties");
			app.run();
		} catch (IOException e) {
			e.printStackTrace(System.err);
		}
	}

	private String message;

	public App() {
		this("Hello, world!");
	}

	public App(String message) {
		this.setMessage(message);
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public void run() {
		System.out.println(this.getMessage());
	}

	protected void readMessageFromFile(String file) throws IOException {
		InputStream inputStream = this.getClass().getResourceAsStream(file);
		Properties props = new Properties();
		props.load(inputStream);
		inputStream.close();
		this.message = props.getProperty("message");
	}
}
