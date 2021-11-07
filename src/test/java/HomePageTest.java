import Academy.TestBase;
import Academy.pageObjects.LandingPage;
import Academy.pageObjects.LoginPage;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.*;

import java.io.IOException;

public class HomePageTest extends TestBase {

	public WebDriver driver;
	private static final Logger log = LogManager.getLogger(HomePageTest.class.getName());

	LandingPage landingPage;
	LoginPage loginPage;

	@BeforeClass
	public void testSetup() throws IOException {
		log.info("Initializing the driver before any tests.");
		driver = initializeDriver();
	}

	@AfterClass
	public void testCleanup() {
		log.info("Closing the window at the end of testing.");
		driver.close();
	}

	@Test(dataProvider = "users")
	public void userLogin(String username, String password) {

		landingPage = new LandingPage(driver);

		log.info("Navigating to the url in the test.properties file.");
		driver.get(properties.getProperty("url"));

		log.info("Clicking the login link on the landing page.");
		loginPage = landingPage.getLoginLink();

		log.info("Entering the username and password and attempting login.");
		loginPage.getEmailInput().sendKeys(username);
		loginPage.getPasswordInput().sendKeys(password);
		loginPage.getLoginButton().click();
	}

	@Test
	public void featuredCoursesHeader() {

		landingPage = new LandingPage(driver);

		log.info("Navigating to the url in the test.properties file.");
		driver.get(properties.getProperty("url"));
		log.info("Asserting that the header of the featured courses section has the expected text.");
		Assert.assertEquals(landingPage.getFeaturedCoursesHeader().getText(), "Featured Courses");
	}

	@Test
	public void isNavigationHeaderVisible() {

		landingPage = new LandingPage(driver);

		log.info("Navigating to the url in the test.properties file.");
		driver.get(properties.getProperty("url"));
		log.info("Asserting that the navbar header is visible on the page.");
		Assert.assertTrue(landingPage.getNavigationList().isDisplayed());
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
