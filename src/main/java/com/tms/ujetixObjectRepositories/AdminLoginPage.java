package com.tms.ujetixObjectRepositories;

import org.openqa.selenium.By.ByLinkText;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import ujetix.genericUtils.FileUtitlity;
import ujetix.genericUtils.IPathConstants;

/**
 * login page
 * @author Tilak LN
 *
 */
public class AdminLoginPage 
{
	//declaration
	@FindBy(name="username") private WebElement uname_textfield;
	@FindBy(name="password") private WebElement pwd_textfield;
	@FindBy(name="login") private WebElement login_btn;
	@FindBy(linkText = "Back to home") private WebElement back_link;

	//initialization
	public AdminLoginPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}

		
	public WebElement getUname_textfield() {
		return uname_textfield;
	}


	public WebElement getPwd_textfield() {
		return pwd_textfield;
	}


	public WebElement getLogin_btn() {
		return login_btn;
	}


	public WebElement getBack_link() {
		return back_link;
	}


	//utilization
	public void adminLogin(String username, String password)
	{
		uname_textfield.sendKeys(username);
		pwd_textfield.sendKeys(password);
		login_btn.click();
	}
















}
