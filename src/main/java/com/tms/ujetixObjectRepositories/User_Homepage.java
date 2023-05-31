package com.tms.ujetixObjectRepositories;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class User_Homepage
{
	//declaration
	@FindBy(linkText = "Home") private WebElement homepage_link;
	@FindBy(linkText = "About") private WebElement about_link;
	@FindBy(linkText = "Tour Packages") private WebElement tourPackage_link;
	@FindBy(linkText = "Privacy Policy") private WebElement privacy_link;
	@FindBy(linkText = "Terms of Use") private WebElement terms_link;
	@FindBy(linkText = "Contact Us") private WebElement contact_link;
	@FindBy(partialLinkText = "Write Us") private WebElement writeUs_link;
	
	@FindBy(linkText = "My Profile") private WebElement myProfile_link;
	@FindBy(linkText = "Change Password") private WebElement changePwd_link;
	@FindBy(linkText = "My Tour History") private WebElement myTourHistory_link;
	@FindBy(linkText = "Issue Tickets") private WebElement issueTkt_link;
	
	@FindBy(partialLinkText = "Logout") private WebElement logout_link;

	//initialization
	public User_Homepage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}

	public WebElement getHomepage_link() {
		return homepage_link;
	}

	public WebElement getAbout_link() {
		return about_link;
	}

	public WebElement getTourPackage_link() {
		return tourPackage_link;
	}

	public WebElement getPrivacy_link() {
		return privacy_link;
	}

	public WebElement getTerms_link() {
		return terms_link;
	}

	public WebElement getContact_link() {
		return contact_link;
	}

	public WebElement getWriteUs_link() {
		return writeUs_link;
	}

	public WebElement getMyProfile_link() {
		return myProfile_link;
	}

	public WebElement getChangePwd_link() {
		return changePwd_link;
	}

	public WebElement getMyTourHistory_link() {
		return myTourHistory_link;
	}

	public WebElement getIssueTkt_link() {
		return issueTkt_link;
	}

	public WebElement getLogout_link() {
		return logout_link;
	}
	
	//business library
	
	public boolean userHomepage_verification(WebDriver driver, String title) 
	{
		
		if (title.contains("TMS"))
		{
			return true;
		} 
		else
		{
			return false;
		}
	}

}
