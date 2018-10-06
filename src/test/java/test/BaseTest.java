package test;
 
import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
 
public class BaseTest {
    public WebDriver driver;
    public WebDriverWait wait;
    private final String PATH_SCREENSHOTS = "C:\\errorScreenshots\\";
    private String pathChromeDriver="src\\test\\resources\\chromedriver.exe";
   
    @BeforeClass
    public void setup () {
        //Create a Chrome driver. All test and page classes use this driver.
    	System.setProperty("webdriver.chrome.driver", pathChromeDriver );
    	driver = new ChromeDriver();
        //Create a wait. All test and page classes use this wait.
        wait = new WebDriverWait(driver,15);
 
        //Maximize Window
        driver.manage().window().maximize();

    }
 
    @AfterClass
    public void teardown () {
        driver.quit();
    }
  @AfterMethod 
  public void takeScreenShotOnFailure(ITestResult testResult) throws IOException { 
  	if (testResult.getStatus() == ITestResult.FAILURE)  { 
  		File scrFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE); 
  		FileUtils.copyFile(scrFile, new File(PATH_SCREENSHOTS + testResult.getName() + "-" 
  				+  ".png"));
  	} 

  }
}
