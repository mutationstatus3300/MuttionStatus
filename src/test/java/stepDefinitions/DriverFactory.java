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

			ChromeOptions options = new ChromeOptions();
			options.addArguments("--headless=new"); // new headless mode
			options.addArguments("--no-sandbox"); // required in CI environments
			options.addArguments("--disable-dev-shm-usage"); // prevent shared memory issues
			options.addArguments("--disable-gpu"); // optional for headless
			options.addArguments("--window-size=1920,1080");

			// Launch the chrome browser
			driver = new ChromeDriver(options);
		}
		return driver;
	}

}
