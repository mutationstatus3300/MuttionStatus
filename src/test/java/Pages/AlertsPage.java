package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AlertsPage {

	WebDriver driver;

	@FindBy(xpath = "//button[contains(text(),'    click the button to display an  alert box:')]")
	public WebElement alertButton;

	public AlertsPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

}
