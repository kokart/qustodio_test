package page;

import org.openqa.selenium.WebDriver;

public class NeedHelpPage extends BasePage {

	public NeedHelpPage(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}

	// Get tittle of the NeedHelpPage
	public String title_NeedHelpPage() {
		return driver.getTitle();
	}

}
