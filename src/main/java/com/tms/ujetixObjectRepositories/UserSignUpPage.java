package com.tms.ujetixObjectRepositories;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class UserSignUpPage
{
	@FindBy(name = "fname")
	private WebElement name_text;

	@FindBy(name = "mobilenumber")
	private WebElement mblno;

	@FindBy(xpath = "//input[@placeholder=Email id']")
	private WebElement mailid;

	@FindBy(xpath = "//input[@name='fname']/..//input[@id='email']")
	private WebElement mail_text;

	@FindBy(xpath = "//input[@name='fname']/..//input[@name='password']")
	private WebElement pwd_text;

	@FindBy(id = "submit")
	private WebElement create_btn;


	//init
	public UserSignUpPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}




	public WebElement getName_text() {
		return name_text;
	}




	public WebElement getMblno() {
		return mblno;
	}




	public WebElement getMailid() {
		return mailid;
	}




	public WebElement getMail_text() {
		return mail_text;
	}




	public WebElement getPwd_text() {
		return pwd_text;
	}




	public WebElement getCreate_btn() {
		return create_btn;
	}




	//business library
	public void usersignup(String name, String mblno, String mailid, String pwd, WebDriver driver)
	{
		getName_text().sendKeys(name);
		getMblno().sendKeys(mblno);
		getMail_text().sendKeys(mailid);
		getPwd_text().sendKeys(pwd);
		getCreate_btn().click();		

	}



}
