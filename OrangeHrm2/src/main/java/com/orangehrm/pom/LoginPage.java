package com.orangehrm.pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {
	@FindBy(xpath = "//input[@id='txtUsername']")
	private WebElement userNameTbx;
	
	@FindBy (xpath = "//input[@id='txtPassword']")
	private WebElement passWordTbx;
	
	@FindBy (xpath = "//input[@id='btnLogin']")
	private WebElement loginBtn;
	
	public LoginPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}

	public WebElement getUserNameTbx() {
		return userNameTbx;
	}

	public WebElement getPassWordTbx() {
		return passWordTbx;
	}

	public WebElement getLoginBtn() {
		return loginBtn;
	}

	public void clickLogin(String un, String pwd) throws InterruptedException
	{
		userNameTbx.clear();
		userNameTbx.sendKeys(un);
		passWordTbx.clear();
		passWordTbx.sendKeys(pwd);
		loginBtn.click();
	}
}
