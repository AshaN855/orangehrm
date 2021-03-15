package com.orangehrm.generics;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class WebDriverCommonLib {
	/**
	 * Note: Implicitwait for element present in Gui
	 * @param driver
	 */
	public void implicitWait(WebDriver driver)
	{
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	}
	
	/**
	 * Note: Explicitwait for element present in Gui
	 * @param driver
	 * @param element
	 */
	public void ExplicitWait(WebDriver driver, WebElement element)
	{
		WebDriverWait wait=new WebDriverWait(driver, 10);
		wait.until(ExpectedConditions.invisibilityOf(element));
	}
	
	/**
	 * Note: Customewait for element present in Gui
	 * @param element
	 */
	public void customWait(WebElement element)
	{
		int i=0;
		try {
			while(i<100)
			{
				element.isDisplayed();
				break;
			}
			
		} catch (Exception e) {
			i++;
		}	
	}
}
