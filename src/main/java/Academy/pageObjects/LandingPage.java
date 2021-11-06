package Academy.pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LandingPage {

	WebDriver driver;

	// Constructor
	public LandingPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}



	// Methods

	public WebElement getLoginLink() {
		return loginLink;
	}



	// Web Elements
	@FindBy(xpath = "//a[contains(@href, 'sign_in')]")
		WebElement loginLink;
}
