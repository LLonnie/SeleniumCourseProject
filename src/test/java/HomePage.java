import Academy.WebDriverSetup;
import Academy.pageObjects.LandingPage;
import Academy.pageObjects.LoginPage;
import org.testng.annotations.Test;

import java.io.IOException;

public class HomePage extends WebDriverSetup {

	@Test
	public void BasePageNavigation() throws IOException {
		driver = InitializeDriver();

		LandingPage landingPage = new LandingPage(driver);
		LoginPage loginPage = new LoginPage(driver);

		driver.get("http://rahulshettyacademy.com");
		
		landingPage.getLoginLink().click();

		loginPage.getEmailInput().sendKeys("test@test.com");
		loginPage.getPasswordInput().sendKeys("password");
		loginPage.getLoginButton().click();
	}
}
