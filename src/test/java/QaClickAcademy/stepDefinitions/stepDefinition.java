package QaClickAcademy.stepDefinitions;

import Academy.TestBase;
import Academy.pageObjects.LandingPage;
import Academy.pageObjects.LoginPage;
import Academy.pageObjects.PortalHomePage;
import QaClickAcademy.HomePageTest;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.io.IOException;

public class stepDefinition extends TestBase {

	public WebDriver driver;
	private static final Logger log = LogManager.getLogger(HomePageTest.class.getName());

	LandingPage landingPage;
	LoginPage loginPage;
	PortalHomePage portalHomePage;

	@Given("Initialize the browser with chrome")
	public void initialize_the_browser_with_chrome() throws IOException {
		log.info("Initializing the driver before any tests.");
		driver = initializeDriver();
	}

	@Given("Navigate to {string}")
	public void navigate_to(String url) {
		log.info("Navigating to the url in the test.properties file.");
		driver.get(url);
	}

	@Given("Click on Login link in home page to land on sign in page")
	public void click_on_login_link_in_home_page_to_land_on_sign_in_page() {
		log.info("Clicking the login link on the landing page.");
		landingPage = new LandingPage(driver);
		loginPage = landingPage.getLoginLink();
	}

	@When("User enters {string} and {string} and logs in")
	public void user_enters_and_and_logs_in(String username, String password) {
		log.info("Entering the username and password and attempting login.");
		loginPage.getEmailInput().sendKeys(username);
		loginPage.getPasswordInput().sendKeys(password);
		loginPage.getLoginButton().click();
	}

	@Then("Verify that user is successfully logged in")
	public void verify_that_user_is_successfully_logged_in() throws InterruptedException {
		log.info("Verifying that we were successfully logged in.");

		WebDriverWait wait = new WebDriverWait(driver, 10);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("input#search-courses")));

		portalHomePage = new PortalHomePage(driver);
		Assert.assertTrue(portalHomePage.getCourseSearchInput().isDisplayed());
	}
}
