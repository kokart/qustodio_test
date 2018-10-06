package test;		

import org.apache.commons.codec.binary.Base64;
import org.apache.commons.codec.binary.StringUtils;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import page.LoginPage;		
public class LoginFailsTest extends BaseTest {		
		
	    
	    //Creamos juego de pruebas
	    @DataProvider(name = "registerFormData")
	    public Object [][] create_dataset1() {
	  	  return new Object[][] {
	  			  {"Qustodio Family Portal",
	  				  "demo11@mailinator.com","ZGVtbzEx",
	  				  "Hola ALFREDO"}
	  	  };
	    }

	     
	    
		/**
		 * Test que crea un usuario de qustodio.
		 * @throws InterruptedException
		 */	    
	    @Test(dataProvider = "registerFormData")			
		public void testLoginFails(String titleToCheck, String nameForm, String passForm, String dashboardName) throws InterruptedException {	
			LoginPage lp = new LoginPage(driver,wait);
	    	//Open Login Page
			lp.goToLoginPage();			
	    	//Check we are where we want
			Assert.assertEquals(lp.title_LoginPage(driver),titleToCheck);

			lp.txtbx_UserName(driver).sendKeys(nameForm);
			lp.txtbx_Password(driver).sendKeys(StringUtils.newStringUtf8(Base64.decodeBase64(passForm)));
			lp.btn_LogIn(driver).click();
						
			//Check we are in
			Assert.assertTrue(driver.getPageSource().contains(dashboardName));
		}	
}	