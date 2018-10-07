package page;

import org.openqa.selenium.WebDriver;

public class DashBoardPage extends BasePage {

	public DashBoardPage(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}

	// Get tittle of the DashBoard Page
	public String title_DashBoardPage() {
		return driver.getTitle();
	}

}
