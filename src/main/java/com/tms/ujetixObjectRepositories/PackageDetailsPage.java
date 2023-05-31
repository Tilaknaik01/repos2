package com.tms.ujetixObjectRepositories;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class PackageDetailsPage
{
	//declaration
	@FindBy(id = "datepicker") private WebElement strtdate;
	@FindBy(id = "datepicker1") private WebElement enddate;
	@FindBy(name = "comment")private WebElement details;
	@FindBy(name = "submit2")private WebElement book_btn;
	
	WebDriver driver;

	
	//init
	public PackageDetailsPage()
	{
		PageFactory.initElements(driver, this);
	}


	
	public WebElement getStrtdate() {
		return strtdate;
	}



	public WebElement getEnddate() {
		return enddate;
	}



	public WebElement getDetails() {
		return details;
	}



	public WebElement getBook_btn() {
		return book_btn;
	}



	//util
	public void book(String startdate, String enddate, String detailcomment)
	{
		getStrtdate().sendKeys(startdate);
		getEnddate().sendKeys(enddate);
		getDetails().sendKeys(detailcomment);
		getBook_btn().click();
		
		
	}
	public void confirmbooking() 
	{
		String currentUrl = driver.getCurrentUrl();
		if (currentUrl.contains("pkgid="))
		{
			System.out.println("booked successfully");
		} else
		{
			System.out.println("booking not confirmed");

		}
	}
	
	

	
}
