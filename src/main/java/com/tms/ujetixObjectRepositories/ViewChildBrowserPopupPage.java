package com.tms.ujetixObjectRepositories;

import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.devtools.v110.page.Page;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ViewChildBrowserPopupPage
{
	@FindBy(xpath = "//textarea") private WebElement textarea;
	@FindBy(xpath = "//input") private WebElement update_btn;

	public ViewChildBrowserPopupPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}

	public WebElement getTextarea() {
		return textarea;
	}

	public WebElement getUpdate_btn() {
		return update_btn;
	}

	//business libraries
	public String updatePopup(WebDriver driver)
	{
		String title=null;
		Set<String> windowsId = driver.getWindowHandles();
		for(String i:windowsId)
		{
			driver.switchTo().window(i);
			title = driver.getTitle();
		}
		return title;


	}
}