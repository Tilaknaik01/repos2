package admin_ujetix;

import java.io.IOException;
import java.net.URL;
import java.time.Duration;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Test;

import com.tms.ujetixObjectRepositories.AdminLoginPage;
import com.tms.ujetixObjectRepositories.Admin_HomePage;
import com.tms.ujetixObjectRepositories.ManageBookingPage;
import com.tms.ujetixObjectRepositories.MyTOurHistoryPage;
import com.tms.ujetixObjectRepositories.UserLoginPage;
import com.tms.ujetixObjectRepositories.User_Homepage;

import ujetix.genericUtils.BaseClass;
import ujetix.genericUtils.ExcelUtility;
import ujetix.genericUtils.FileUtitlity;
import ujetix.genericUtils.JavaScriptUtility;
import ujetix.genericUtils.JavaUtillity;
import ujetix.genericUtils.WebDriverUtility;

public class Manage_bookingAsAdminTest extends BaseClass
{

	@Test(groups = {"smoke", "system"}, retryAnalyzer =ujetix.genericUtils.IRetryAnalyser.class )//we need to ca;; package name with iretrylistener with.class
	public void test3() throws IOException 
	{

		String ADMIN_URL =fLib.getPropertData("admin_url");
		String USER_URL = fLib.getPropertData("user_url");
		String USERNAME_ADMIN = fLib.getPropertData("username_admin");
		String PASSWORD_ADMIN = fLib.getPropertData("password_admin");
		String USERNAME_USER = fLib.getPropertData("username_user");
		String PASSWORD_USER = fLib.getPropertData("password_user");
		String BROWSER = fLib.getPropertData("browser");

		//launch the browser using @beforeSuite
		
		//implicit wait

		//maximize browser
		
		//login as admin using @before method
		Admin_HomePage adminhome = new Admin_HomePage(driver);
		String text = adminhome.getHome_link().getText();
		Assert.assertEquals(text,"Home");
		Reporter.log("admin home page is displayed",true);

		
		//manage bookings
		adminhome.getManagebookings_link().click();


		//scroll to element
		String Comments="Tilak111";
		ManageBookingPage manageBooking = new ManageBookingPage(driver);
		JavaScriptUtility jsu = new JavaScriptUtility(driver);
		
		jsu.scrollDown();
		manageBooking.confirm_btnCLick(driver, Comments);

		//accepting the alert arised
		String alert_text="Do you really want to cancel booking";
		wLib.alertPopupAndAcceppt(driver, alert_text);

		//logout as admin
		Admin_HomePage home_admin = new Admin_HomePage(driver);
		home_admin.logoutCLick();


		//user login
		AdminLoginPage adminlogin = new AdminLoginPage(driver);
		adminlogin.getBack_link().click();
		driver.get(USER_URL);
		UserLoginPage userlogin = new UserLoginPage(driver);
		userlogin.userLogin(USERNAME_USER, PASSWORD_USER);

		//verify user login 
	
		User_Homepage user_home = new User_Homepage(driver);
		String text2 = user_home.getHomepage_link().getText();
		Assert.assertEquals("Home", text2);
		Reporter.log("user home page is displayed", true);
		
		
		//click on booking history
		user_home.getMyTourHistory_link().click();
		
		//click on cancel button
		MyTOurHistoryPage mytour = new MyTOurHistoryPage(driver);
		jsu.scrollDown();
		mytour.mytourlist(driver, Comments);
		wLib.alertPopupAndAcceppt(driver, alert_text);
		
		//logout as user
		user_home.getLogout_link().click();
		
		//loginas admin
		driver.get(ADMIN_URL);
		AdminLoginPage loginadmin= new AdminLoginPage(driver);
		loginadmin.adminLogin(USERNAME_ADMIN, PASSWORD_ADMIN);
		String text3 = adminhome.getHome_link().getText();
		Assert.assertEquals("Home",text3);
		Reporter.log("admiin home page is displayed",true);
		
		
	}

}
