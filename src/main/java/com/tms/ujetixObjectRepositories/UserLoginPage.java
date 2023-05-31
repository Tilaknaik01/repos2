package com.tms.ujetixObjectRepositories;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class UserLoginPage 
{
	@FindBy(xpath = "//li[@class='sigi']") private WebElement signin_link;
	@FindBy(xpath = "//h3[text()='Signin with your account ']/following-sibling::input[@id='email']") private WebElement usernameUser;
	@FindBy(xpath = "//h3[text()='Signin with your account ']/following-sibling::input[@id='password']") private WebElement passwordUser;
	@FindBy(name = "signin")private WebElement signin_btn;
	@FindBy(xpath = "//a[.='Sign Up']") private WebElement signup_btn;

	//initialization
	public UserLoginPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}

		
	
	
	
	public WebElement getSignin_link() {
		return signin_link;
	}





	public WebElement getUsernameUser() {
		return usernameUser;
	}





	public WebElement getPasswordUser() {
		return passwordUser;
	}





	public WebElement getSignin_btn() {
		return signin_btn;
	}





	public WebElement getSignup_btn() {
		return signup_btn;
	}





	//utilization
	public void userLogin(String username, String password) 
	{
		signin_link.click();
		usernameUser.sendKeys(username);
		passwordUser.sendKeys(password);
		signin_btn.click();
		
	}

}