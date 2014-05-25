package com.mycompany.weather;

import junit.framework.TestCase;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.htmlunit.HtmlUnitDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.WebDriverWait;

public class WeatherIntegrationTest extends TestCase {
	private static Logger LOG = Logger.getLogger(WeatherIntegrationTest.class);

	private WebDriver driver = new HtmlUnitDriver();

	protected void setUp() {
		driver.get("http://localhost:8080/");
	}

	public void testGetWeatherForZip02101() {
        // Find the text input element by its name
        WebElement element = driver.findElement(By.name("zip"));

        element.clear();
        // Enter something to search for
        element.sendKeys("02101");

        // Now submit the form. WebDriver will find the form for us from the element
        element.submit();

        LOG.info("Url is: " + driver.getCurrentUrl());
        
        // Wait for the page to load, timeout after 10 seconds
        (new WebDriverWait(driver, 10)).until(new ExpectedCondition<String>() {
            public String apply(WebDriver d) {
                return d.getPageSource();
            }
        });
        String actualPage = driver.getPageSource();
        LOG.info("Page content is: " + actualPage );
        assertTrue(actualPage.contains("Boston, MA, US"));
	}

	protected void tearDown() {
		// Close the browser
		driver.quit();
	}
}
