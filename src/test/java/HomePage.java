import Academy.WebDriverSetup;
import org.testng.annotations.Test;

import java.io.IOException;

public class HomePage extends WebDriverSetup {

	@Test
	public void BasePageNavigation() throws IOException {
		driver = InitializeDriver();

		driver.get("http://rahulshettyacademy.com");
	}
}
