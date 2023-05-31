package admin_ujetix;

import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.List;
import java.util.Properties;
import java.util.Random;

import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Test;

import com.fasterxml.jackson.databind.deser.Deserializers.Base;
import com.tms.ujetixObjectRepositories.AdminLoginPage;
import com.tms.ujetixObjectRepositories.Admin_HomePage;
import com.tms.ujetixObjectRepositories.CreatePackagePage;
import com.tms.ujetixObjectRepositories.ManageIssues;
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

public class CreateTourAndWriteUsAndlogoutTest extends BaseClass
{
	@Test(groups = {"integration", "system"})
	public void test4() throws IOException
	{
		String ADMIN_URL =fLib.getPropertData("admin_url");
		String USER_URL = fLib.getPropertData("user_url");
		String USERNAME_ADMIN = fLib.getPropertData("username_admin");
		String PASSWORD_ADMIN = fLib.getPropertData("password_admin");
		String USERNAME_USER = fLib.getPropertData("username_user");
		String PASSWORD_USER = fLib.getPropertData("password_user");
		String BROWSER = fLib.getPropertData("browser");
		
		//launch the browser
		
		//implicit wait
		wLib.waitTillPageGetsLoad(driver);

		//maximize browser
		wLib.maximizeWindow(driver);

		//admin login
		
		//tourpackage dropdown
		Admin_HomePage home = new Admin_HomePage(driver);
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
		create.createTourPakage(driver, PKG_NAME, PKG_TYPE, PKG_LOCATION, PKG_PRICE, PKG_FEATURE, PKG_DETAILS, PKG_IMAGE);
		String text = create.getConfirmatation().getText();
		
		Assert.assertEquals("SUCCESS:Package Created Successfully", text);
		Reporter.log("Package Created Successfully", true);


		//admin logout
		home.getProfile_dropdown().click();;
		home.getLogout_link().click();
		AdminLoginPage admin_login = new AdminLoginPage(driver);
		admin_login.getBack_link();


		//user login
		driver.get(USER_URL);
		UserLoginPage user_login = new UserLoginPage(driver);
		user_login.userLogin(USERNAME_USER, PASSWORD_USER);


		//verification of log in
		String title = driver.getTitle();
		User_Homepage user_homepage = new User_Homepage(driver);
		user_homepage.userHomepage_verification(driver, title);

		//tour package clicking
		user_homepage.getTourPackage_link().click();
		JavaScriptUtility jsUtil= new JavaScriptUtility(driver);
		jsUtil.scrollDown();

		//verifie the created tour package
		Tour_Package_Page tpp = new Tour_Package_Page(driver);
		boolean packageverification = tpp.packageNameIsPresentOrNot(driver, PKG_NAME);
		Assert.assertTrue(packageverification);
		Reporter.log("package created is verified ", true);
		


		//clicking on write us link
		user_homepage.getWriteUs_link().click();;

		//dropdown
		String message="not working";
		Write_Us_Popup writeus = new Write_Us_Popup(driver);
		writeus.create_Issue(message);

		//logout as user
		user_homepage.getLogout_link().click();

		//admin login
		driver.get(ADMIN_URL);
		admin_login.adminLogin(USERNAME_ADMIN, PASSWORD_ADMIN);

		//manange issue
		home.getManageIssues_link().click();

		ManageIssues manageIssues = new ManageIssues(driver);
		//manageIssues.manageIssue();
		
		
		
		//logout as admin using @afterclass

	}
}
