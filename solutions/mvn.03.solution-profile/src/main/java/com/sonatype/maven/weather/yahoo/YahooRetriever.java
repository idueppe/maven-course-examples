package com.sonatype.maven.weather.yahoo;

import java.io.InputStream;
import java.net.URL;
import java.net.URLConnection;

import org.apache.log4j.Logger;

public class YahooRetriever {

	private static Logger log = Logger.getLogger(YahooRetriever.class);

	public InputStream retrieve(String zipcode) throws Exception {
		log.trace( "Retrieving Weather Data for ZIP code:" + zipcode);
		String url = "http://weather.yahooapis.com/forecastrss?p=" + zipcode;
		URLConnection conn = new URL(url).openConnection();
		log.debug("URLConnection established to: " + url);
		return conn.getInputStream();
	}

}
