package Academy.pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {

	WebDriver driver;

	// Constructor
	public LoginPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}



	// Methods
	public WebElement getEmailInput() {
		return emailInput;
	}

	public WebElement getPasswordInput() {
		return passwordInput;
	}

	public WebElement getLoginButton() {
		return loginButton;
	}

	public WebElement getLoginError() {
		return loginError;
	}


	// Web Elements
	private @FindBy(id = "email")
		WebElement emailInput;

	private @FindBy(id = "password")
		WebElement passwordInput;

	private @FindBy(xpath = "//input[@data-testid='login-button']")
		WebElement loginButton;

	private @FindBy(className = "auth-flash-error")
		WebElement loginError;
}
