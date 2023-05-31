package admin_ujetix;

import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Test;

import com.tms.ujetixObjectRepositories.AdminLoginPage;
import com.tms.ujetixObjectRepositories.Admin_HomePage;
import com.tms.ujetixObjectRepositories.CreatePackagePage;
import com.tms.ujetixObjectRepositories.PackageDetailsPage;
import com.tms.ujetixObjectRepositories.Tour_Package_Page;
import com.tms.ujetixObjectRepositories.UserLoginPage;
import com.tms.ujetixObjectRepositories.User_Homepage;

import io.github.bonigarcia.wdm.WebDriverManager;
import ujetix.genericUtils.BaseClass;
import ujetix.genericUtils.ExcelUtility;
import ujetix.genericUtils.JavaScriptUtility;
import ujetix.genericUtils.WebDriverUtility;

public class ConfirmBookingAsAdminVerifyAsUserTest extends BaseClass
{
	@Test
	public void test7() throws EncryptedDocumentException, FileNotFoundException, IOException, InterruptedException 
	{

		//TO FETCH PROPERTIES DATA
		String ADMIN_URL =fLib.getPropertData("admin_url");
		String USER_URL = fLib.getPropertData("user_url");
		String USERNAME_ADMIN = fLib.getPropertData("username_admin");
		String PASSWORD_ADMIN = fLib.getPropertData("password_admin");
		String USERNAME_USER = fLib.getPropertData("username_user");
		String PASSWORD_USER = fLib.getPropertData("password_user");
		String BROWSER = fLib.getPropertData("browser");

		
		//lauch the browser by base class

		//admin login by @beforeclass

		//create tourpackage dropdown
		Admin_HomePage home = new Admin_HomePage(driver);
		home.createTourPackagePage();

		//Random value
		int number = jLib.getRandomNumber();

		String PKG_NAME= eLib.getDataFromExcel("Sheet2", 1, 0);
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

		//admin logout karna
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
		user_homepage.userHomepage_verification(driver, title);
		
		//tour package clicking
		user_homepage.getTourPackage_link().click();

		//Select given package
		Tour_Package_Page tour=new Tour_Package_Page(driver);
		JavaScriptUtility jsu = new JavaScriptUtility(driver);
		jsu.scrollDown();
		tour.clickOnDetails(driver, title);

		//Book the package 
		
		String startdate="12-09-2023";
		String enddate="22-09-2023";
		String detailscomment="details"+jLib.getRandomNumber();
		
		PackageDetailsPage pdp=new PackageDetailsPage();
		pdp.book(startdate, enddate, detailscomment);

		pdp.confirmbooking();
		
		
		
		
//		//Admin Login 
//		wp.getAdminLoginLnk().click();
//		AdminLoginPage alp=new AdminLoginPage(driver);
//		alp.loginAdmin(ADMINUSERNAME, ADMINPASSWORD);
//
//		//Navigate to ManageBooking page
//		AdminHomePage ahp=new AdminHomePage(driver);
//		ahp.getManageBookingLnk().click();
//
//		ManageBookingsPage mbp=new ManageBookingsPage(driver);
//		mbp.confirmBooking(comment);
//
//		//Log out from admin
//		ahp.logoutAdmin();
//		alp.goToWelcomePage();
//
//		//Login as User
//		wp.signInUser(USERUSERNAME, USERPASSWORD);
//
//		//Navigate to My Tour History page
//		uhp.getMyTourHistoryLnk().click();
//		MyTourHistoryPage mthp=new MyTourHistoryPage(driver);
//		System.out.println(mthp.bookingStatus(comment));
//		jsutil.scrollUp();
//
//		//Log out as User
//		uhp.userLogout();
	}
}
