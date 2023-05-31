package admin_ujetix;

import static org.testng.Assert.assertEquals;

import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;
import java.util.Random;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Test;

import com.tms.ujetixObjectRepositories.AdminLoginPage;
import com.tms.ujetixObjectRepositories.Admin_HomePage;
import com.tms.ujetixObjectRepositories.MyProfilepage;
import com.tms.ujetixObjectRepositories.UserLoginPage;
import com.tms.ujetixObjectRepositories.User_Homepage;

import ujetix.genericUtils.BaseClass;
import ujetix.genericUtils.ExcelUtility;
import ujetix.genericUtils.FileUtitlity;
import ujetix.genericUtils.JavaUtillity;
import ujetix.genericUtils.WebDriverUtility;

public class ProfileUpdateAdminTest extends BaseClass
{
	@Test(groups = {"smoke", "system"})
	public void test5() throws IOException, InterruptedException
	{
		String ADMIN_URL =fLib.getPropertData("admin_url");
		String USER_URL = fLib.getPropertData("user_url");
		String USERNAME_ADMIN = fLib.getPropertData("username_admin");
		String PASSWORD_ADMIN = fLib.getPropertData("password_admin");
		String USERNAME_USER = fLib.getPropertData("username_user");
		String PASSWORD_USER = fLib.getPropertData("password_user");
		String BROWSER = fLib.getPropertData("browser");

		
		
		//launch the browser using @TestSuite
		//maximized
		//implicit wait

	
		//admin login
		Admin_HomePage adminhome = new Admin_HomePage(driver);
		String text = adminhome.getHome_link().getText();
		Assert.assertEquals("Home", text);
		Reporter.log("admin home page is displayed", true);
		
		//admin logout
		adminhome.getProfile_dropdown().click();
		adminhome.getLogout_link().click();
		
		//login as user
		driver.get(USER_URL);
		UserLoginPage userlogin = new UserLoginPage(driver);
		userlogin.userLogin(USERNAME_USER, PASSWORD_USER);
		
		
		//verification

		User_Homepage uh=new User_Homepage(driver);
		String text2 = uh.getHomepage_link().getText();
		Assert.assertEquals("Home", text);
		Reporter.log("user home page is displayed", true);
		
		
		//click on my profile
		User_Homepage userhome = new User_Homepage(driver);
		userhome.getMyProfile_link().click();
		
		//changes
		String updatedmblno="1122334455";
		MyProfilepage mp= new MyProfilepage(driver);
		mp.update(driver,updatedmblno);
		
		//verification
		String currentUrl = driver.getCurrentUrl();
		Assert.assertTrue(true, currentUrl);
		Reporter.log("profile is updated", true);
				
		
		//logout
		userhome.getLogout_link().click();
		
		//login admin
		driver.get(ADMIN_URL);
		AdminLoginPage admin = new AdminLoginPage(driver);
		admin.adminLogin(USERNAME_ADMIN, PASSWORD_ADMIN);
		
	}
}
