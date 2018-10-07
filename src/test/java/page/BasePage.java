package page;

import java.util.ArrayList;

import org.openqa.selenium.WebDriver;

public class BasePage {
	public WebDriver driver;

	// Constructor
	public BasePage(WebDriver driver) {
		this.driver = driver;		
	}

	// Change to desired Tab
	public void changeChromeTab(int tabSelected) {
		// Swap Chrome tab. New window is opened when Join Button is clicked
		ArrayList<String> availableWindows = new ArrayList<String>(driver.getWindowHandles());
		if (!availableWindows.isEmpty()) {
			driver.switchTo().window(availableWindows.get(tabSelected));
		}

	}

	// Get Source Code of the Web Page
	public String getSourceCodeOfHTMLPage() {
		return driver.getPageSource();
	}
}