package com.qa.testcase;

import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class Testng_Annotatios {

	
	@BeforeSuite
	public void beforesuite()
	{
           System.out.println("Run BeforeSuite");
	}
	
	@BeforeTest
	public void beforetest(){
		
		System.out.println("Run beforetest");
	}
	
	@BeforeClass
	public void beforeclass(){
		
		System.out.println("Run beforeclass");
	}
	
	
	@BeforeMethod
	public void beforemethod(){
		System.out.println("Run beforemethod");
	}
	
	
	@Test
	public void test1(){
		System.out.println("Test run first 1");
	}
	
	
	
	@Test
	public void test2(){
		
		System.out.println("Test run second 2");
	}
	
	@AfterSuite
	public void aftersuit(){
		
		System.out.println("Run After suit");
	}
	
	@AfterTest
	public void aftertest(){
		
		System.out.println("Run After Test");
	}
	
	@AfterClass
	public void afterclass(){
		
		System.out.println("Run After Class");
	}
	
	@AfterMethod
	public void aftermethod(){
		System.out.println("Run After method");
	}
	
	
}
