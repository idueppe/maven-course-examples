package com.sonatype.maven.weather.yahoo;

import java.io.InputStream;
import java.net.Authenticator;
import java.net.URL;
import java.net.URLConnection;

import org.apache.log4j.Logger;

public final class YahooRetriever {

	private static Logger log = Logger.getLogger(YahooRetriever.class);

	public InputStream retrieve(final String zipcode) throws Exception {
		log.info("Retrieving Weather Data for " + zipcode);
		final String url = "http://weather.yahooapis.com/forecastrss?p=" + zipcode;
		final URLConnection conn = new URL(url).openConnection();
		if (useProxy() && useProxyAuthentication()) {
			String httpProxyUser = System.getProperty("http.proxyUsername");
			String httpProxyPassword = System.getProperty("http.proxyPassword");
			log.info("Using Proxy with authentication");
			Authenticator.setDefault(new ProxyAuthenticator(httpProxyUser,
					httpProxyPassword));
		}
		return conn.getInputStream();
	}

	private boolean useProxyAuthentication() {
		final String proxyUser = System.getProperty("http.proxyUsername");
		final String proxyPassword = System.getProperty("http.proxyPassword");
		if (proxyUser != null && proxyPassword != null) {
			log.debug("Using Proxy user: + " + proxyUser + "with password"
					+ proxyPassword);
			return true;
		}
		return false;
	}

	/**
	 * 
	 * @return
	 * @see <a
	 *      href="http://download.oracle.com/javase/6/docs/technotes/guides/net/proxies.html">Proxy</a>
	 * @see <a
	 *      href="http://download.oracle.com/javase/6/docs/technotes/guides/net/properties.html">Networking
	 *      Properties</a>
	 */
	private boolean useProxy() {
		final String proxyHost = System.getProperty("http.proxyHost");
		final String proxyPort = System.getProperty("http.proxyPort");
		if (proxyHost != null && proxyPort != null) {
			log.debug("Using Proxy: + " + proxyHost + ":" + proxyPort);
			return true;
		}
		return false;
	}

}
