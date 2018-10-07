package test;

import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;

public class BaseTest {
	public WebDriver driver;
	public String PATH_SCREENSHOTS = "C:\\errorScreenshots\\";
	//public String pathChromeDriver = "src\\test\\resources\\chromedriver.exe";
	
	//Data to use Testing bot
	  public static final String KEY = System.getenv().get("KEY_TESTINGBOT");
	  public static final String SECRET = System.getenv().get("SECRET_TESTINGBOT");
	  public static final String URL = "http://" + KEY + ":" + SECRET + "@hub.testingbot.com/wd/hub";
	  //localhost. localhost:4445/wd/hub

	
	/**
	 * Launch Chrome using TestBot
	 * @throws MalformedURLException 
	 */
	@BeforeClass
	public void setup() throws MalformedURLException {

	// Create a Chrome driver. All test and page classes use this driver.
//		System.setProperty("webdriver.chrome.driver", pathChromeDriver);
//		driver = new ChromeDriver();

//		// Maximize Window
//		driver.manage().window().maximize();
		
		DesiredCapabilities capabillities = new DesiredCapabilities();
		capabillities.setCapability("platform", "WIN7");
		capabillities.setCapability("version", "69");
		capabillities.setCapability("browserName", "chrome");

		
	        driver = new RemoteWebDriver(
	                new URL(URL),capabillities);
	        
	        

	}

	/**
	 * Close Chrome
	 */
	@AfterClass
	public void teardown() {
		driver.quit();
	}

	/**
	 * If test fails we get a schreenshot and it's stored at PATH_SCREENSHOTS.
	 * 
	 * @param testResult
	 * @throws IOException
	 */
	@AfterMethod
	public void takeScreenShotOnFailure(ITestResult testResult) throws IOException {
		if (testResult.getStatus() == ITestResult.FAILURE) {
			File scrFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
			FileUtils.copyFile(scrFile, new File(PATH_SCREENSHOTS + testResult.getName() + "-" + ".png"));
		}

	}
}
