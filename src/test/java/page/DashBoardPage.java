package page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

public class DashBoardPage extends BasePage {

	public DashBoardPage(WebDriver driver, WebDriverWait wait) {
		super(driver, wait);
		// TODO Auto-generated constructor stub
	}

	// Get tittle of the DashBoard Page
	public String title_DashBoardPage() {
		return driver.getTitle();
	}

}
