package test;		

import java.util.ArrayList;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import page.LoginPage;		
public class LoginDownloadQustodioLinkTest  extends BaseTest{		
	    
	    //Create datasheet
	    @DataProvider(name = "registerFormData")
	    public Object [][] create_dataset1() {
	  	  return new Object[][] {
	  			  {"Qustodio Family Portal",
	  				   "Descargar Qustodio - Qustodio"}
	  			  
	  	  };
	    }
	    
		/**
		 * Download Qustodio application link is redirecting to Qustodio webPAge
		 * @throws InterruptedException
		 */	    
	    @Test(dataProvider = "registerFormData")			
		public void testDownloadQustodioLink(String titleToCheck, String tittleHomePage) throws InterruptedException {	

	    	LoginPage lp = new LoginPage(driver,wait);
	    	//Open Login Page
	    	lp.goToLoginPage();  
			
	    	//Check we are where we want
			Assert.assertEquals(lp.title_LoginPage(driver),titleToCheck);

			//Click Join button
			lp.btn_JoinQustodio(driver).click();
						
			ArrayList<String> availableWindows = new ArrayList<String>(driver.getWindowHandles()); 
			if (!availableWindows.isEmpty()) { 
			driver.switchTo().window(availableWindows.get(1)); 
			}
			
			Assert.assertTrue(driver.getTitle().contains(tittleHomePage));
			
		}	
	    
		
}	