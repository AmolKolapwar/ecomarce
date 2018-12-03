package com.qa.utill;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.qa.base.Testbase;

public class WaitTool {

	
		/** Default wait time for an element. 7  seconds. */ 
		public static final int DEFAULT_WAIT_4_ELEMENT = 7; 
		/** Default wait time for a page to be displayed.  12 seconds.  
		 * The average webpage load time is 6 seconds in 2012. 
		 * Based on your tests, please set this value. 
		 * "0" will nullify implicitlyWait and speed up a test. */ 
		public static final int DEFAULT_WAIT_4_PAGE = 30; 


		public static boolean waitForElementPresent(WebElement element, int timeOutInSeconds) {
			
			try{
				Testbase.driver.manage().timeouts().implicitlyWait(0, TimeUnit.SECONDS); //nullify implicitlyWait() 
				
				WebDriverWait wait = new WebDriverWait(Testbase.driver, timeOutInSeconds); 
				element = wait.until(ExpectedConditions.visibilityOf(element));
				
				Testbase.driver.manage().timeouts().implicitlyWait(DEFAULT_WAIT_4_PAGE, TimeUnit.SECONDS); //reset implicitlyWait
				return true; //return the element
			} catch (Exception e) {
				e.printStackTrace();
				return false;
			} 
//			return null; 
		}
		
public static boolean waitForElementVisable(WebElement element, int timeOutInSeconds) {
			
			try{
				Testbase.driver.manage().timeouts().implicitlyWait(0, TimeUnit.SECONDS); //nullify implicitlyWait() 
				
				WebDriverWait wait = new WebDriverWait(Testbase.driver, timeOutInSeconds); 
				element = wait.until(ExpectedConditions.visibilityOf(element));
				
				Testbase.driver.manage().timeouts().implicitlyWait(DEFAULT_WAIT_4_PAGE, TimeUnit.SECONDS); //reset implicitlyWait
				return true; //return the element
			} catch (Exception e) {
				e.printStackTrace();
				return false;
			} 
//			return null; 
		}
public static void senkeys(WebDriver driver, WebElement element,int timeout,String value)
{
	
	WebDriverWait wait =new WebDriverWait (driver,timeout);
	wait.until(ExpectedConditions.visibilityOf(element));
	element.sendKeys(value);
	
}
public static boolean  click( WebElement element,int timeout)
{
	
	
	try{
	WebDriverWait wait =new WebDriverWait (Testbase.driver,timeout);
	wait.until(ExpectedConditions.elementToBeClickable(element));
	element.click();
	return true;
	}catch(Exception e)
	{
		e.printStackTrace();
		return false;
	}
}
		/**
		  * Wait for the element to be present in the DOM, and displayed on the page. 
		  * And returns the first WebElement using the given method.
		  * 
		  * @param WebDriver	The driver object to be used 
		  * @param By	selector to find the element
		  * @param int	The time in seconds to wait until returning a failure
		  *
		  * @return WebElement	the first WebElement using the given method, or null (if the timeout is reached)
		  */
				
	 }
	/*
	 * References: 
	 * 1. Mark Collin's post on: https://groups.google.com/forum/?fromgroups#!topic/webdriver/V9KqskkHmIs%5B1-25%5D
	 * 	  Mark's code inspires me to write this class. Thank you! Mark. 
	 * 2. Andre, and Tarun Kumar's post on: https://groups.google.com/forum/?fromgroups=#!topic/selenium-users/6VO_7IXylgY  
	 * 3. Explicit and Implicit Waits: http://seleniumhq.org/docs/04_webdriver_advanced.html
	 * 
	 * Note: 
	 * 1. Instead of creating new WebDriverWait() instance every time in each methods, 
	 *    I tried to reuse a single WebDriverWait() instance, but I found and tested 
	 *    that creating 100 WebDriverWait() instances takes less than one millisecond. 
	 *    So, it seems not necessary.  
	 */


