package stepDefinitions;

import java.io.File;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Date;
import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.io.FileHandler;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.Wait;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.Given;

public class RegisterStepDef {
	WebDriver driver = DriverFactory.getDriver();
	Wait<WebDriver> wait;

	@Given("User perfroms operation in background step")
	public void backgroundKeyword() {
		System.out.println("This steps are executed in Background");
	}

	@Before
	public void beforeHooks() {
		System.out.println("This steps are executed in Before Hooks");
	}

	@After
	public void afterHooks() {
		System.out.println("This steps are executed in After Hooks");
	}

	@Given("User is on the Register page")
	public void launchRegisterPage() {
		// entering website
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(300));
		System.out.println("Launching web page");
		
		try {
			driver.get("https://www.landrecords.karnataka.gov.in/service2/RTC.aspx");
		driver.manage().window().maximize();
		captureScreenshot(driver);
		}catch(Exception e) {
			captureScreenshot(driver);
		}
		
		
		
		/*
		 * System.out.println("Page Launched successfully"); String parentWindow =
		 * driver.getWindowHandle(); wait = new
		 * FluentWait<>(driver).withTimeout(Duration.ofSeconds(30)) // total wait time
		 * .pollingEvery(Duration.ofSeconds(2)) // check every 2 seconds
		 * .ignoring(NoSuchElementException.class); WebElement MutationStatusButton =
		 * wait .until(ExpectedConditions.elementToBeClickable(By.
		 * xpath("//*[text()='Mutation Status']"))); MutationStatusButton.click();
		 * 
		 * Set<String> allHandles = driver.getWindowHandles(); Iterator<String> iterator
		 * = allHandles.iterator(); while (iterator.hasNext()) { String win =
		 * iterator.next(); if (!win.equals(parentWindow)) {
		 * driver.switchTo().window(win); } }
		 * 
		 * WebElement districtDropDown = wait.until(
		 * ExpectedConditions.elementToBeClickable(By.xpath(
		 * "(//*[contains(text(),'District')])[1]/..//select")));
		 * hadleDropDown(districtDropDown, "Ramanagara");
		 * 
		 * WebElement talukDropDown = wait.until(
		 * ExpectedConditions.elementToBeClickable(By.xpath(
		 * "(//*[contains(text(),'Taluk')])[1]/..//select")));
		 * hadleDropDown(talukDropDown, "Magadi");
		 * 
		 * WebElement hobliDropDown = wait.until(
		 * ExpectedConditions.elementToBeClickable(By.xpath(
		 * "(//*[contains(text(),'Hobli')])[1]/..//select")));
		 * hadleDropDown(hobliDropDown, "KUDURU");
		 * 
		 * WebElement villgeDropDown = wait.until(
		 * ExpectedConditions.elementToBeClickable(By.xpath(
		 * "(//*[contains(text(),'Village')])[1]/..//select")));
		 * hadleDropDown(villgeDropDown, "AJJAHALLI");
		 * 
		 * WebElement surveynumInput = wait.until(
		 * ExpectedConditions.elementToBeClickable(By.
		 * xpath("//*[contains(text(),'Survey No.')]/..//input")));
		 * surveynumInput.sendKeys("113");
		 * 
		 * Actions actions = new Actions(driver);
		 * actions.sendKeys(Keys.ENTER).perform();
		 * 
		 * WebElement Surnoc = wait.until(ExpectedConditions .elementToBeClickable(By.
		 * xpath("(//*[contains(text(),'Surnoc No.')])[1]/..//select")));
		 * 
		 * hadleDropDown(Surnoc, "*");
		 * 
		 * WebElement hissa = wait.until( ExpectedConditions.elementToBeClickable(By.
		 * xpath("(//*[contains(text(),'Hissa No.')])[1]/..//select")));
		 * hadleDropDown(hissa, "3");
		 * 
		 * WebElement fetchDetails = wait
		 * .until(ExpectedConditions.elementToBeClickable(By.xpath(
		 * "//*[@id='MainContent_btnFetch']"))); captureScreenshot(driver); try {
		 * Thread.sleep(10000); } catch (InterruptedException e) { // TODO
		 * Auto-generated catch block e.printStackTrace(); }
		 */
		driver.quit();

	}

	public void hadleDropDown(WebElement ele, String option) {
		Select s = new Select(ele);
		s.selectByVisibleText(option);
	}

	public static void captureScreenshot(WebDriver driver) {
		try {
			// Default folder name
			String folderPath = System.getProperty("user.dir") + "/images";

			// Create folder if not exists
			File directory = new File(folderPath);
			if (!directory.exists()) {
				directory.mkdirs();
				System.out.println("Directory created: " + folderPath);
			}

			// Date format: 2025 Nov 22
			String dateFormat = new SimpleDateFormat("yyyy MMM dd").format(new Date());
			String fileName = "Screenshot_" + dateFormat + ".png";

			// Replace spaces with underscores (optional but recommended)
			fileName = fileName.replace(" ", "_");

			// Final file path
			File finalFile = new File(folderPath + "/" + fileName);

			// If file exists, delete it
			if (finalFile.exists()) {
				finalFile.delete();
			}

			// Take screenshot
			TakesScreenshot ts = (TakesScreenshot) driver;
			File src = ts.getScreenshotAs(OutputType.FILE);

			// Save screenshot
			FileHandler.copy(src, finalFile);

			System.out.println("Screenshot saved: " + finalFile.getAbsolutePath());

		} catch (Exception e) {
			System.out.println("Error capturing screenshot: " + e.getMessage());
		}
	}

}
