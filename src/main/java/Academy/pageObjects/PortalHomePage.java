package Academy.pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class PortalHomePage {

	WebDriver driver;

	// Constructor
	public PortalHomePage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	// Methods
	public WebElement getCourseSearchInput() {
		return CourseSearchInput;
	}

	// Elements
	private @FindBy(xpath = "//input[@id='search-courses']")
		WebElement CourseSearchInput;
}
