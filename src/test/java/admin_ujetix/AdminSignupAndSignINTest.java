package admin_ujetix;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Test;

import com.fasterxml.jackson.annotation.JsonUnwrapped;
import com.tms.ujetixObjectRepositories.AdminLoginPage;
import com.tms.ujetixObjectRepositories.Admin_HomePage;
import com.tms.ujetixObjectRepositories.MyProfilepage;
import com.tms.ujetixObjectRepositories.UserLoginPage;
import com.tms.ujetixObjectRepositories.UserSignUpPage;
import com.tms.ujetixObjectRepositories.User_Homepage;

import ujetix.genericUtils.BaseClass;
import ujetix.genericUtils.FileUtitlity;
import ujetix.genericUtils.JavaScriptUtility;
import ujetix.genericUtils.WebDriverUtility;

public class AdminSignupAndSignINTest extends BaseClass
{
	@Test
	public  void test6() throws IOException 
	{		
		
		String ADMIN_URL =fLib.getPropertData("admin_url");
		String USER_URL = fLib.getPropertData("user_url");
		String USERNAME_ADMIN = fLib.getPropertData("username_admin");
		String PASSWORD_ADMIN = fLib.getPropertData("password_admin");
		String USERNAME_USER = fLib.getPropertData("username_user");
		String PASSWORD_USER = fLib.getPropertData("password_user");



		//launch the browser using @TestSuite
		//maximized
		//implicit wait
		
		//verifie admin home page
		Admin_HomePage ah = new Admin_HomePage(driver);
		String text = ah.getHome_link().getText();
		Assert.assertEquals("Home", text);
		Reporter.log("admin home page is displayed sucessfully", true);

		//logout as admin
		Admin_HomePage admin = new Admin_HomePage(driver);
		admin.logoutCLick();

		//login as user
		driver.get(USER_URL);
		UserLoginPage userlogin = new UserLoginPage(driver);
		userlogin.userLogin(USERNAME_USER, PASSWORD_USER);
		
		//verify the user
		User_Homepage uh = new User_Homepage(driver);
		String text2 = ah.getHome_link().getText();
		Assert.assertEquals("Home", text2);
		Reporter.log("user home page is displayed sucessfully", true);

		
		//logout as user
		User_Homepage userhome= new User_Homepage(driver);
		userhome.getLogout_link().click();
		
		
		//signup as user
		userlogin.getSignup_btn().click();
		int r = jLib.getRandomNumber();
		String name="user"+r;
		String mblno="1122334455";
		String email="user"+r+"@gmail.com";
		String pwd=email;

		UserSignUpPage usersignup = new UserSignUpPage(driver);
		usersignup.usersignup(name, mblno, email, pwd, driver);

		// click on signup button and login
		userlogin.userLogin(email, pwd);
		
		//verification
		String title = driver.getTitle();
		boolean userverif = userhome.userHomepage_verification(driver, title);
		Assert.assertTrue(userverif);
		
		//clicking on myprofile
		userhome.getMyProfile_link().click();

		//changes
		String updatedmblno="1122334455";
		MyProfilepage mp= new MyProfilepage(driver);
		mp.update(driver,updatedmblno);
		
		
		//verification
		String confirm_text = mp.getConfirm_text().getText();
		Assert.assertEquals(confirm_text, "SUCCESS");
		Reporter.log("updated sucessfully", true);
		


		//logout
		userhome.getLogout_link().click();
		//login admin
		driver.get(ADMIN_URL);
		AdminLoginPage adminlogin = new AdminLoginPage(driver);
		adminlogin.adminLogin(USERNAME_ADMIN, PASSWORD_ADMIN);
		Assert.assertEquals("Home", text);
		Reporter.log("admin home page is displayed sucessfully", true);




	}
}
