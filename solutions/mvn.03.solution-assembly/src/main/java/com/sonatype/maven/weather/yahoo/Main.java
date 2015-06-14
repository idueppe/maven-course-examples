package com.sonatype.maven.weather.yahoo;

import java.io.InputStream;
import java.net.URL;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;

public class Main {

	private static final Logger LOG = Logger.getLogger(Main.class);

	public static void main(String[] args) throws Exception {
		// Configure Log4J
		URL resource = Main.class.getClassLoader().getResource(	"log4j.properties");
		System.out.println("URL to log4j.properties: "+ resource);
		PropertyConfigurator.configure(resource);

		// Read the Zip Code from the Command-line (if none supplied, use 60202)
		String zipcode = "02101";
		try {
			zipcode = args[0];
		} catch (Exception e) {
			LOG.info("No zipcode given, using default " + zipcode);
		}

		// Start the program
		new Main(zipcode).start();
	}

	private String zip;

	public Main(String zip) {
		this.zip = zip;
	}

	public final void start() throws Exception {
		// Retrieve Data
		InputStream dataIn = new YahooRetriever().retrieve(zip);
		// Parse Data
		Weather weather = new YahooParser().parse(dataIn);
		// Format (Print) Data
		String weatherMessage = new WeatherFormatter().format(weather);
		LOG.info(weatherMessage);
	}

}
