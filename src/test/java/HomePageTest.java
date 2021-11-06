import Academy.TestBase;
import Academy.pageObjects.LandingPage;
import Academy.pageObjects.LoginPage;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.io.IOException;

public class HomePageTest extends TestBase {

	@Test(dataProvider = "users")
	public void userLogin(String username, String password) throws IOException {

		driver = initializeDriver();
		LandingPage landingPage = new LandingPage(driver);
		LoginPage loginPage = new LoginPage(driver);

		driver.get(properties.getProperty("url"));
		landingPage.getLoginLink().click();
		loginPage.getEmailInput().sendKeys(username);
		loginPage.getPasswordInput().sendKeys(password);
		loginPage.getLoginButton().click();

		driver.close();
	}

	@Test
	public void featuredCoursesHeader() throws IOException {

		driver = initializeDriver();
		LandingPage landingPage = new LandingPage(driver);

		driver.get(properties.getProperty("url"));
		Assert.assertEquals(landingPage.getFeaturedCoursesHeader().getText(), "Featured Courses");

		driver.close();
	}

	@Test
	public void isNavigationHeaderVisible() throws IOException {

		driver = initializeDriver();
		LandingPage landingPage = new LandingPage(driver);

		driver.get(properties.getProperty("url"));
		Assert.assertTrue(landingPage.getNavigationList().isDisplayed());
		driver.close();
	}

	@DataProvider
	public Object[][] users() {

		Object[][] data = new Object[2][2];

		data[0][0] = "restricteduser@test.com";
		data[0][1] = "password";

		data[1][0] = "nonrestricteduser@test.com";
		data[1][1] = "password";

		return data;
	}
}
