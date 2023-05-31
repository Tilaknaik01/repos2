package ujetix.genericUtils;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.tms.ujetixObjectRepositories.AdminLoginPage;
import com.tms.ujetixObjectRepositories.Admin_HomePage;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseClass 
{
	public FileUtitlity fLib = new FileUtitlity();
	public ExcelUtility eLib = new ExcelUtility();
	public WebDriverUtility wLib = new WebDriverUtility();
	public WebDriver driver;
	public JavaUtillity jLib = new JavaUtillity();
	public static WebDriver sdriver;

	// connect to DB
	@BeforeSuite(groups = {"smoke","integration","system"})
	public void Config_BS() throws Throwable
	{
		//dLib.connectToDb();
		System.out.println("-- connected to DB");
	}

	
	
	//@Parameters("BROWSER")   //only for cross browser testing
	@BeforeClass(groups = {"smoke","integration","system"})
	public void config_BC() throws Throwable
	{
		String BROWSER = fLib.getPropertData("browser");//make it disable for cross browser testing
		if(BROWSER.equalsIgnoreCase("chrome"))
		{
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
			System.out.println("browser launched");
		}
		else
		{
			WebDriverManager.firefoxdriver().setup();
			driver = new FirefoxDriver();
		}

		wLib.maximizeWindow(driver);
		wLib.waitTillPageGetsLoad(driver);
		sdriver=driver; // to initialize the static driver

	}

	// login to Application
	@BeforeMethod(groups = {"smoke","integration","system"})
	public void confi_BM() throws Throwable
	{
		String URL = fLib.getPropertData("admin_url");
		String USERNAME = fLib.getPropertData("username_admin");
		String PASSWORD = fLib.getPropertData("password_admin");

		driver.get(URL);

		wLib.waitTillPageGetsLoad(driver);

		AdminLoginPage lp = new AdminLoginPage(driver);
		lp.adminLogin(USERNAME, PASSWORD);
		System.out.println("-- Logged in successfully --");
	}

	//logout from Appln
	@AfterMethod(groups = {"smoke","integration","system"})
	public void config_AM()
	{
		Admin_HomePage hp = new Admin_HomePage(driver);
		hp.getProfile_dropdown().click();
		hp.getLogout_link().click();
		System.out.println("-- logged out from appl --");
	}

	// close the browser
	@AfterClass(groups = {"smoke","integration","system"})
	public void config_AC()
	{
		driver.quit();
		System.out.println("browser closed");
	}

	// disconnect database
	@AfterSuite(groups = {"smoke","integration","system"})
	public void config_AS() throws Throwable
	{
		System.out.println("connection closed");
	}

}
