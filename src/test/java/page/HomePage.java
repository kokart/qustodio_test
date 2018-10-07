package page;

import org.openqa.selenium.WebDriver;

public class HomePage extends BasePage {

	public HomePage(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}

	// Get tittle of the HomePage
	public String title_HomePagee() {
		return driver.getTitle();
	}

}
