package com.tms.ujetixObjectRepositories;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindBys;
import org.openqa.selenium.support.PageFactory;

import ujetix.genericUtils.WebDriverUtility;

public class Admin_HomePage
{
	//declaration
	@FindBy(linkText = "Home")private WebElement home_link;
	@FindBy(xpath = "//span[text()='Dashboard']") private WebElement dashboard_link;
	@FindBy(xpath = "//span[.=' Tour Packages']")private WebElement tourPkg_link;
	@FindBy(linkText = "Create") private WebElement createTourPackage_link;
	@FindBy(linkText = "Manage") private WebElement manageTOurPackage_link;
	@FindBy(xpath = "//span[.='Manage Users']") private WebElement manageUsers_link;
	@FindBy(xpath = "//span[.='Manage Booking']") private WebElement managebookings_link;
	@FindBy(xpath = "//span[.='Manage Issues']") private WebElement manageIssues_link;
	@FindBy(xpath = "//span[.='Manage Enquiries']") private WebElement manageEnqury_link;
	@FindBy(xpath = "//span[.='Manage Pages']") private WebElement managePages_link;
	@FindBy(xpath = "//i[@class='fa fa-angle-down']") private WebElement profile_dropdown;
	@FindBy(linkText = " Profile") private WebElement profile_link;
	@FindBy(xpath = "//a[@href='logout.php']") private WebElement logout_link;


	//initialization
	public Admin_HomePage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	
	

		public WebElement getHome_link() {
		return home_link;
	}



	public WebElement getDashboard_link() {
		return dashboard_link;
	}



	public WebElement getTourPkg_link() {
		return tourPkg_link;
	}



	public WebElement getCreateTourPackage_link() {
		return createTourPackage_link;
	}



	public WebElement getManageTOurPackage_link() {
		return manageTOurPackage_link;
	}



	public WebElement getManageUsers_link() {
		return manageUsers_link;
	}



	public WebElement getManagebookings_link() {
		return managebookings_link;
	}



	public WebElement getManageIssues_link() {
		return manageIssues_link;
	}



	public WebElement getManageEnqury_link() {
		return manageEnqury_link;
	}



	public WebElement getManagePages_link() {
		return managePages_link;
	}



	public WebElement getProfile_dropdown() {
		return profile_dropdown;
	}



	public WebElement getProfile_link() {
		return profile_link;
	}



	public WebElement getLogout_link() {
		return logout_link;
	}


	
	
	
	
	

	//utilization
	public void homePage()
	{
		home_link.click();
	}
	public boolean verifyAdminHomePage() 
	{
		
		String h = home_link.getText();
		
		if (h.contains("Home")) 
		{
			return true;
		}
		else 
		{
			return false;
		}
	}
	
	public void createTourPackagePage() 
	{
		tourPkg_link.click();
		createTourPackage_link.click();
	}
	public void manageTourPackagePage() 
	{
		tourPkg_link.click();
		managebookings_link.click();
	}
	public void profileDetailsPage()
	{
		profile_dropdown.click();
		profile_link.click();
	}
	public void logoutCLick()
	{
		profile_dropdown.click();
		logout_link.click();
	}
}


