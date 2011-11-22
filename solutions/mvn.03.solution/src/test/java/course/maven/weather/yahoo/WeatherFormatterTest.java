package course.maven.weather.yahoo;

import java.io.InputStream;

import junit.framework.TestCase;

import org.apache.commons.io.IOUtils;

import com.sonatype.maven.weather.yahoo.Weather;
import com.sonatype.maven.weather.yahoo.WeatherFormatter;
import com.sonatype.maven.weather.yahoo.YahooParser;

public class WeatherFormatterTest extends TestCase {

	public WeatherFormatterTest(String name) {
		super(name);
	}

	public void testFormat() throws Exception {
		InputStream nyData = getClass().getClassLoader().getResourceAsStream("ny-weather.xml");
		Weather weather = new YahooParser().parse(nyData);
		String formattedResult = new WeatherFormatter().format(weather);
		InputStream expected = getClass().getClassLoader().getResourceAsStream("format-expected.dat");
		assertEquals(IOUtils.toString(expected), formattedResult);
	}
}
