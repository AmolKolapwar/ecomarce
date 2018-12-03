package com.qa.utill;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;

import com.qa.base.Testbase;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;


public class TestUtill extends Testbase {

	  public static final long PAGE_LOAD_TIMEOUT_ = 20;
	
	  public static long IMPLICIT_WAIT= 10;
	
	//Actions action = new Actions(driver);
	
	public static void takeScreenshotAtEndOfTest(String methodName, WebDriver driver) throws IOException {
		//File scrFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		//String currentDir = System.getProperty("user.dir");
		
		//Files.copy(scrFile, new File(prjprop.getProperty("ScreenShotPath") + System.currentTimeMillis() + ".png"));
		
		
		File scrFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		//String currentDir = System.getProperty("user.dir");
		try{
		FileUtils.copyFile(scrFile, new File(prop.getProperty("ScreenShotPath") + methodName + ".png"));
		}catch(IOException e){
			System.out.println(e);
			e.printStackTrace();
		}
		System.out.println("Screenshot captured");
		}
	
	
	
}
