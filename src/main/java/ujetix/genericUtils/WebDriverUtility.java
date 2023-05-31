package ujetix.genericUtils;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Set;

import javax.swing.text.Element;

import org.apache.commons.io.FileUtils;
import org.apache.xmlbeans.impl.soap.Text;
import org.apache.xmlbeans.impl.xb.xsdschema.Public;
import org.openqa.selenium.Alert;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class WebDriverUtility
{
	
	public Object waitTillPageGetsLoad;


	/**
	 * 
	 * maximize the window
	 * @param driver
	 */
	public void maximizeWindow(WebDriver driver)
	{
		driver.manage().window().maximize();
	}
	
	
	
	/**
	 * 
	 * minimize the window
	 * @param driver
	 */
	public void minimizeWindow(WebDriver driver)
	{
		driver.manage().window().minimize();
	}
	
	
	
	/**
	 * for implicit wait timeout (wait TIll Page Gets Load)
	 * @param driver
	 */
	public void waitTillPageGetsLoad(WebDriver driver)
	{
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(IPathConstants.implicitDuration));
	}
	
	
	/**
	 * 
	 * to wait till the element is vissible 
	 * @param driver
	 * @param element
	 */
	public void waitTillElementToBeVissible(WebDriver driver, WebElement element) 
	{
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(IPathConstants.explicitDuration));
		wait.until(ExpectedConditions.visibilityOf(element));
	}
	
	
	
	/**
	 *  to wait untill element To Be Clickablein UI
	 * @param driver
	 * @param element
	 */
	public void elementToBeClickable(WebDriver driver, WebElement element) 
	{
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(IPathConstants.explicitDuration));
		wait.until(ExpectedConditions.elementToBeClickable(element));
	}
	
	
	
	/**
	 * 
	 * this method will wait untill the alert will arise
	 * @param driver
	 */
	public void waitForAlertPopup(WebDriver driver)
	{
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(IPathConstants.explicitDuration));
		wait.until(ExpectedConditions.alertIsPresent());
	}
	
	
	/**
	 * this method will wait untill the title gets loaded in webpage
	 * @param driver
	 * @param title
	 */
	public void waitForTItle(WebDriver driver, String title) 
	{
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(IPathConstants.explicitDuration));
		wait.until(ExpectedConditions.titleContains(title));
	}
	
	
	/**
	 * 
	 * this method will wait untill url of webpage gets loaded
	 * @param driver
	 * @param url
	 */
	public void waitForURL(WebDriver driver, String url)
	{
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(IPathConstants.explicitDuration));
		wait.until(ExpectedConditions.urlContains(url));
	}
	
	/**
	 * this method will ignore  if it is NoSuchELement Exception
	 * @param driver
	 */
	public void ignoreNoSuchELementException(WebDriver driver)
	{
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(IPathConstants.explicitDuration));
		wait.ignoring(NoSuchElementException.class);
	}
	
	
	/**
	 * this method is used to handle the dropdown  based on index value
	 * @param element
	 * @param index
	 */
	public void selectElementInDropdown(WebElement element, int index)
	{
		Select select = new Select(element);
		select.selectByIndex(index);
	}
	
	
	/**
	 * this method is used to handle the dropdown based on id or value
	 * @param element
	 * @param value
	 */
	public void selectElementInDropdown(WebElement element, String value)
	{
		Select select = new Select(element);
		select.selectByValue(value);
	}
	
	
	
	/**
	 * this method is used to handle the dropdown based on vissible text
	 * @param text
	 * @param element
	 */
	public void selectElementInDropdown(String text, WebElement element)
	{
		Select select = new Select(element);
		select.selectByVisibleText(text);
	}
	
	
	/**
	 * this method is used to  get the text of all options in the dropdown
	 * @param element
	 */
	public void getAllOptionsFromDropdown(WebElement element)
	{
		Select select = new Select(element);
		List<WebElement> opt = select.getOptions();
		for(WebElement option:opt)
		{
			String text = option.getText();
			System.out.println(text);
		}
	}
	
	/**
	 * this methos is used for mouse over action on element
	 * @param driver
	 * @param element
	 */
	public void mouseOverAction(WebDriver driver, WebElement element)
	{
		Actions a = new Actions(driver);
		a.moveToElement(element).perform();
	}
	
	
	/**
	 * this method is used for right click action  on element
	 * @param driver
	 * @param element
	 */
	public void rightClick(WebDriver driver, WebElement element)
	{
		Actions a = new Actions(driver);
		a.contextClick(element).perform();
	}
	
	/**
	 * this merhod is used to double click on element
	 * @param driver
	 * @param element
	 */
	public void doubleClick(WebDriver driver, WebElement element)
	{
		Actions a = new Actions(driver);
		a.doubleClick(element).perform();
	}
	
	
	/**
	 * 
	 * this method contains to switch to the element based on index
	 * @param driver
	 * @param index
	 */
	public void switchFrame(WebDriver driver, int index)
	{
		driver.switchTo().frame(index);
	}
	
	
	/**
	 * this method contains to switch based on id of the element 
	 * @param id
	 * @param driver
	 */
	public void switchFrame(int id,WebDriver driver)
	{
		driver.switchTo().frame(id);
	}
	
	
	/**
	 * this method contains to switch to the frames based on web element
	 * @param driver
	 * @param element
	 */
	public void switchFrame(WebDriver driver, WebElement element)
	{
		driver.switchTo().frame(element);
	}
	
	
	/**
	 * this method contains toswitch back to the default browser
	 * @param driver
	 */
	public void switchFrame(WebDriver driver)
	{
		driver.switchTo().defaultContent();
	}
	
	
	/**
	 * 
	 * this method is used to accept the popup
	 * @param driver
	 * @param text
	 */
	public void alertPopupAndAcceppt(WebDriver driver, String text) 
	{
		Alert a = driver.switchTo().alert();
		if (a.getText().trim().equalsIgnoreCase(text.trim()))
		{
			System.out.println("alert is present");
		}
		else
		{
			System.out.println("alert is not present");
		}
		a.accept();
	}
	
	
	/**
	 * this method is used to dismiss the popup
	 * @param driver
	 * @param text
	 */
	public void alertPopupAndDismiss(WebDriver driver,String text) 
	{
		Alert a = driver.switchTo().alert();
		if (a.getText().trim().equalsIgnoreCase(text.trim()))
		{
			System.out.println("alert is present");
		}
		else
		{
			System.out.println("alert is not present");
		}
		a.dismiss();
	}
	
	
	/**
	 * this method used to pass the path of the file to upload
	 * @param element
	 * @param path
	 */
	public void fileUpload(WebElement element,String path)
	{
		element.sendKeys(path);
	}
	
	
	
	
	
	/**
	 * custom wait to change the polling time
	 * @param duration
	 * @param element
	 */
	public void custmoWait(int duration,WebElement element,long pollingtime)
	{
		int count=0;
		while (count<duration)
		{
			try 
			{
				element.click();
				break;
			}
			catch(Exception e) 
			{
				try 
				{
					Thread.sleep(pollingtime);
				} 
				catch (InterruptedException e1)
				{
					e1.printStackTrace();
				}
			}
		}
	}
	
	
	
	/**
	 * taking screenshot
	 * @param driver
	 * @param screenshotName
	 * @return
	 * @throws IOException
	 */
	public String takeScreenShot(WebDriver driver, String screenshotName) throws IOException
	{
		TakesScreenshot tss=(TakesScreenshot)driver;
		File src = tss.getScreenshotAs(OutputType.FILE);
		LocalDateTime localdatetime= LocalDateTime.now();
		String localdatetimes = localdatetime.toString().replace(":", "-");
		File dst = new File("./screenShots/"+screenshotName+""+localdatetimes+".png");
		FileUtils.copyFile(src, dst);
		return screenshotName;
	}
	
	/**
	 * this method is used to switch to child window using title
	 * @param driver
	 * @param title
	 */
	
	
	public void switchWindow(WebDriver driver, String title)
	{
		Set<String> set = driver.getWindowHandles();
		for( String s:set)
		{
			driver.switchTo().window(s);
			String text = driver.getTitle();
			if (text.contains(title)) 
			{
				break;
			}
		}
	}
	
	
	/**
	 * this method is used to switch to child window using url
	 * @param driver
	 * @param url
	 */
	public void switchWindow(String url,WebDriver driver)
	{
		Set<String> set = driver.getWindowHandles();
		for( String s:set)
		{
			driver.switchTo().window(s);
			String URL = driver.getCurrentUrl();
			if (URL.contains(url)) 
			{
				break;
			}
		}	
		
	}

	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
