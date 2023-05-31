package com.tms.ujetixObjectRepositories;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ManageIssues
{
	//declaration
	@FindBy(xpath = "//td[@data-th='Action ']") private List<WebElement> view_link;
	
	
	//initialization
	
	
	public ManageIssues(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	
	public List<WebElement> getView_link() {
		return view_link;
	}

	//utilization or business libraries
	public void manageIssueopen() 
	{
		int size = view_link.size()-1;
		//view_link.get(size).click();
	}
	
	
	
}
