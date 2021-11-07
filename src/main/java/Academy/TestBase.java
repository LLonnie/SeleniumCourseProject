package Academy;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.safari.SafariDriver;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

public class TestBase {

	public WebDriver driver;
	public Properties properties;

	public WebDriver initializeDriver() throws IOException {

		// Pull browser from properties file.
		properties = new Properties();
		FileInputStream fileInputStream = new FileInputStream("src/main/resources/test.properties");
		properties.load(fileInputStream);
		String browserName = properties.getProperty("browser").toLowerCase();

		// Set driver to the browser from the test.properties file.
		switch (browserName) {
			case "chrome":
				WebDriverManager.chromedriver().driverVersion("95.0.4638").setup();
				driver = new ChromeDriver();
				break;

			case "firefox":
				WebDriverManager.firefoxdriver().driverVersion("0.30.0").setup();
				driver = new FirefoxDriver();
				break;

			case "ie":
				WebDriverManager.iedriver().setup();
				driver = new InternetExplorerDriver();
				break;

			case "edge":
				WebDriverManager.edgedriver().driverVersion("95.0.1020.30").setup();
				driver = new EdgeDriver();
				break;

			case "safari":
				WebDriverManager.safaridriver().setup();
				driver = new SafariDriver();
				break;

			default:
				System.out.println("We are trying to use an unsupported browser.");
		}

		// Set default implicit wait.
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

		// Return the created driver object.
		return driver;
	}

	public String getScreenShotPath(WebDriver driver, String testCaseName) throws IOException {
		File image = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		String screenshotDestination = System.getProperty("user.dir") + "\\reports\\screenshots\\" + testCaseName + ".png";
		FileUtils.copyFile(image, new File(screenshotDestination));
		return screenshotDestination;
	}
}
