package admin_ujetix;

import java.io.IOException;
import java.util.List;

import org.checkerframework.common.util.report.qual.ReportCall;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.tms.ujetixObjectRepositories.AdminLoginPage;
import com.tms.ujetixObjectRepositories.Admin_HomePage;
import com.tms.ujetixObjectRepositories.CreatePackagePage;
import com.tms.ujetixObjectRepositories.Tour_Package_Page;
import com.tms.ujetixObjectRepositories.UserLoginPage;
import com.tms.ujetixObjectRepositories.User_Homepage;
import com.tms.ujetixObjectRepositories.Write_Us_Popup;

import ujetix.genericUtils.BaseClass;
import ujetix.genericUtils.ExcelUtility;
import ujetix.genericUtils.FileUtitlity;
import ujetix.genericUtils.JavaScriptUtility;
import ujetix.genericUtils.JavaUtillity;
import ujetix.genericUtils.WebDriverUtility;

public class CreatePkgAsAdminTest extends BaseClass
{
	@Test
	public void test1() throws IOException
	{
		String ADMIN_URL =fLib.getPropertData("admin_url");
		String USER_URL = fLib.getPropertData("user_url");
		String USERNAME_ADMIN = fLib.getPropertData("username_admin");
		String PASSWORD_ADMIN = fLib.getPropertData("password_admin");
		String USERNAME_USER = fLib.getPropertData("username_user");
		String PASSWORD_USER = fLib.getPropertData("password_user");
		String BROWSER = fLib.getPropertData("browser");

		
		//launch the browser by base class
		//admin login by @beforeclass
		Admin_HomePage home = new Admin_HomePage(driver);
		String text = home.getHome_link().getText();
		boolean h = home.verifyAdminHomePage();
		Assert.assertTrue(h);
		Reporter.log("admin home page is displayed", true);

		
		

		//create tour package dropdown
		home.createTourPackagePage();

		//Random value
		int number = jLib.getRandomNumber();

		String PKG_NAME = eLib.getDataFromExcel("Sheet2", 1, 0)+number;
		String PKG_TYPE =eLib.getDataFromExcel("Sheet2", 1, 1);
		String PKG_LOCATION = eLib.getDataFromExcel("Sheet2", 1, 2);
		String PKG_PRICE = eLib.getDataFromExcel("Sheet2", 1, 3);
		String PKG_FEATURE = eLib.getDataFromExcel("Sheet2", 1, 4);
		String PKG_DETAILS = eLib.getDataFromExcel("Sheet2", 1, 5);
		String PKG_IMAGE = eLib.getDataFromExcel("Sheet2", 1, 6);

		//enter the details
		CreatePackagePage create = new CreatePackagePage(driver);
		create.createTourPakage(driver,PKG_NAME, PKG_TYPE, PKG_LOCATION, PKG_PRICE, PKG_FEATURE, PKG_DETAILS, PKG_IMAGE);


		//taking the screenshot of created paged

		wLib.takeScreenShot(driver, "confirm");

		//admin logout
		home.logoutCLick();

		//click on back button
		AdminLoginPage adminlogin  = new AdminLoginPage(driver);
		adminlogin.getBack_link().click();

		//user login
		UserLoginPage userlogin = new UserLoginPage(driver);
		userlogin.userLogin(USERNAME_USER, PASSWORD_USER);
	

		//verification of user log in
		String title = driver.getTitle();
		User_Homepage user_homepage = new User_Homepage(driver);
		boolean user = user_homepage.userHomepage_verification(driver, title);
		Assert.assertTrue(user);
		Reporter.log("user home page is displayed", true);
		
		//tour package clicking
		
		Tour_Package_Page tpname = new Tour_Package_Page(driver);
		//tpname.clickOnDetails(driver, PKG_NAME);
		
		
		//clicking on write us link
		User_Homepage user_home = new User_Homepage(driver);
		//user_home.getTourPackage_link();
		
		
		
		//logout as user
		user_home.getLogout_link().click();

		//admin login
		driver.get(ADMIN_URL);
		adminlogin.adminLogin(USERNAME_ADMIN, PASSWORD_ADMIN);
		boolean admin_ver = home.verifyAdminHomePage();
		Assert.assertTrue(admin_ver);
		Reporter.log("admin home page is displayed", true);
		
		home.manageTourPackagePage();
		
		
		//logout by using@afterclass
	}
}
