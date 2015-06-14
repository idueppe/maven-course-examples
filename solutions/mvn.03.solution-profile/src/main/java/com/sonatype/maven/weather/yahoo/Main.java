package com.sonatype.maven.weather.yahoo;

import java.io.InputStream;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;

public class Main {
	
	private static Logger log = Logger.getLogger(Main.class);

	public static void main(String[] args) throws Exception {
		// Configure Log4J
		PropertyConfigurator.configure(Main.class.getClassLoader().getResource(	"log4j.properties"));

		// Read the Zip Code from the Command-line (if none supplied, use 02101)
		String zipcode = "02101";
		if (args != null && args.length > 0) { 
			zipcode = args[0];
		}
		log.info("Using Zip Code: " + zipcode);

		// Start the program
		new Main(zipcode).start();
	}

	private String zip;

	public Main(String zip) {
		this.zip = zip;
	}

	public void start() throws Exception {
		// Retrieve Data
		InputStream dataIn = new YahooRetriever().retrieve(zip);
		// Parse Data
		Weather weather = new YahooParser().parse(dataIn);
		// Format (Print) Data
		System.out.print(new WeatherFormatter().format(weather));
	}

}
