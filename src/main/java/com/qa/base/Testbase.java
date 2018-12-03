package com.qa.base;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.events.EventFiringWebDriver;
import org.testng.annotations.Parameters;
import org.testng.asserts.SoftAssert;

import com.qa.utill.TestUtill;
import com.qa.utill.WebEventListener;

import io.github.bonigarcia.wdm.WebDriverManager;

import org.apache.commons.io.FileUtils;
import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.Capabilities;
import org.openqa.selenium.NoSuchCookieException;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.events.EventFiringWebDriver;


public class Testbase {
	
		public static WebDriver driver;
	public static Properties prop;
	public SoftAssert  softassert= new SoftAssert();
	public static EventFiringWebDriver e_driver;
	public static WebEventListener eventListener;
	
	//Actions action = new Actions(driver);
	public Testbase(){
		
		try {
			
			prop = new Properties();
			
			FileInputStream ip= new FileInputStream("D:\\Amol_Workplace_new\\Ecomarce\\src\\main\\java\\com\\qa\\config\\config.properties");
			prop.load(ip);
		}catch(FileNotFoundException e ){
			
			e.printStackTrace();
		}catch(IOException e){
			
			e.printStackTrace();
		}
	}
//@Parameters("brwoserName")
	public static void intialization(){
		
		String brwoserName= prop.getProperty("brwoser");
		if (brwoserName.equals("chrome")){
			
			//WebDriverManager.chromedriver().setup();
			System.setProperty("webdriver.chrome.driver", "D:\\Amol_BkUp\\NewProject\\Mavan\\chromedriver.exe");
			//WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
		}else if (brwoserName.equals("FF")){
			//WebDriverManager.firefoxdriver().setup();
			System.setProperty("webdriver.gecko.driver","D:\\Amol_BkUp\\NewProject\\Mavan\\geckodriver.exe");
			driver = new FirefoxDriver();
		}
		
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().pageLoadTimeout(TestUtill.PAGE_LOAD_TIMEOUT_, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(TestUtill.IMPLICIT_WAIT, TimeUnit.SECONDS);
		
		
		e_driver = new EventFiringWebDriver(driver);
		// Now create object of EventListerHandler to register it with
		// EventFiringWebDriver
		eventListener = new WebEventListener();
		e_driver.register(eventListener);
		driver = e_driver;
		driver.get(prop.getProperty("url"));
		

		
	}
	
	public void navigate(){
		
		driver.navigate().back();
	}
	
	
	public String gettext2(WebElement testing){
		String testText = testing.getText();
		return testText;
		
	}
	



	

public String getURL(){
		
		return driver.getCurrentUrl();
	}

public boolean URL(String msg){
	
	System.out.println(driver.getCurrentUrl().equals(msg));
	return true;
}
	
     public boolean  isDispalyed(By by){
	try{
	driver.findElement(by);
	return true;
	
	}catch(NoSuchCookieException e){
	return false;
}
	}	
     
    
	public void Quit(){
		
		driver.quit();
	}
	}


