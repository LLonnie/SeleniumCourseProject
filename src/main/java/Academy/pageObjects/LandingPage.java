package Academy.pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class LandingPage {

	WebDriver driver;

	// Constructor
	public LandingPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}



	// Methods
	public LoginPage getLoginLink() {
		loginLink.click();
		return new LoginPage(driver);
	}

	public WebElement getFeaturedCoursesHeader() {
		return featuredCoursesHeader;
	}

	public WebElement getNavigationList() {
		return navigationList;
	}

	public List<WebElement> getNavigationLinks() {
		return navigationLinks;
	}



	// Web Elements
	private @FindBy(xpath = "//a[contains(@href, 'sign_in')]")
		WebElement loginLink;

	private @FindBy(xpath = "//section[@class='courses-section'] //h2")
		WebElement featuredCoursesHeader;

	private @FindBy(xpath = "//div[@class='header-upper'] //ul[contains(@class, 'navigation')]")
		WebElement navigationList;

	private @FindBy(xpath = "//div[@class='header-upper'] //ul/li/a")
		List<WebElement> navigationLinks;
}
