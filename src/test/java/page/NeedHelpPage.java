package page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

public class NeedHelpPage extends BasePage {

	public NeedHelpPage(WebDriver driver, WebDriverWait wait) {
		super(driver, wait);
		// TODO Auto-generated constructor stub
	}

	// Get tittle of the NeedHelpPage
	public String title_NeedHelpPage() {
		return driver.getTitle();
	}

}
