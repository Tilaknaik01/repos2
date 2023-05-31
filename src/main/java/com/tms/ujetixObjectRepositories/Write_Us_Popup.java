package com.tms.ujetixObjectRepositories;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import com.fasterxml.jackson.core.sym.Name;

public class Write_Us_Popup
{
	@FindBy(id = "country")private WebElement SelectIssue;
	@FindBy(name = "description")private WebElement description;
	@FindBy(xpath = "//button[.='Submit']")private WebElement submit_btn;
	
	public Write_Us_Popup(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}

	public WebElement getSelectIssue() {
		return SelectIssue;
	}

	public WebElement getDescription() {
		return description;
	}

	public WebElement getSubmit_btn() {
		return submit_btn;
	}
	
	
	//business libraries
	public void create_Issue(String message)
	{
		Select drop = new Select(SelectIssue);
		drop.selectByIndex(1);
		description.sendKeys("message");
		submit_btn.click();
		
		
	}
	
}
