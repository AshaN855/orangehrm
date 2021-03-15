package com.orangehrm.generics;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;

import com.orangehrm.pom.LoginPage;

public class BaseClass {
	static{
		System.setProperty("webdriver.chrome.driver", "./src/main/resources/driver/chromedriver.exe");
	}
	public static WebDriver driver;
	public FileLib f=new FileLib();
	public WebDriverCommonLib w=new WebDriverCommonLib();
	
	@BeforeClass
	public void openBrowser() throws IOException
	{
		//Open the browser
		driver=new ChromeDriver();
		//implicitwait
		w.implicitWait(driver);
		//maximize the browser
		driver.manage().window().maximize();
	}
	
	@BeforeMethod
	public void login() throws IOException, InterruptedException
	{
		LoginPage l=new LoginPage(driver);
		//Read url
		String url=f.getPropertyValue("url");
		driver.get(url);
		//Read username and password
		String un=f.getPropertyValue("username");
		String pwd=f.getPropertyValue("password");
		l.clickLogin(un, pwd);
	}
	
	@AfterMethod
	public void logout()
	{
		//l.clickOnLogout();
	}
	
	@AfterClass
	public void closeBrowser()
	{
		driver.close();
	}
}
