package stepDefinitions;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class DriverFactory {

	private static WebDriver driver;

	public static WebDriver getDriver() {
		if (driver == null) {

			WebDriverManager.chromedriver().setup();

	        // Chrome options for headless mode
	        ChromeOptions options = new ChromeOptions();
	        options.addArguments("--headless=new"); // headless mode
	        options.addArguments("--disable-gpu");
	        options.addArguments("--no-sandbox");
	        options.addArguments("--disable-dev-shm-usage"); // CI memory issues
	        options.addArguments("--window-size=1920,1080");

	         driver = new ChromeDriver(options);
			
			
		}
		return driver;
	}

}
