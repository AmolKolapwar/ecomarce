package com.qa.testcase;

import org.apache.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.qa.base.Testbase;
import com.qa.pages.MyAccount;
import com.qa.pages.Registration;

public class RegistartionTest extends Testbase {

	Logger log = Logger.getLogger(RegistartionTest.class);
	
	MyAccount myaccount;

	Registration registration;
	
	public RegistartionTest(){
		super();
	}
	
	
	@BeforeMethod
	
    public void setup(){
		
		intialization();
		
		
		registration = new Registration();
	}
	
	
	@Test (priority =1)
	public void verifyButtonenable(){
		
		log.info("verify the registration button is enable or not");
		boolean flag = registration.RegistraButton();
		Assert.assertTrue(flag);
		
	}
	
	
	
	@Test (priority =2)
	
	public void RegistrationSuccess(){
		
		registration.Registartion(prop.getProperty("Password"), prop.getProperty("Password"));
		
		  log.info("Verify Registration success");
		  registration.equals(myaccount);
	    	
	          String Title = registration.Pagetitle();
	          System.out.println(Title);
	           Assert.assertEquals(Title, "My Account – Automation Practice Site");
	           log.info("Verify Current Page title");
	}
	
	
	@Test (priority =3)
	
	public void VerifyInvalidemail(){
		
		registration.Registartion(prop.getProperty("UserEmailid"), prop.getProperty("Password1"));
		String Email = registration.InvalidEmail();
		
		log.info("Verify message for invalid email id ");
		System.out.println(Email);
	/*	
		if (Email !="Error: Please provide a valid email address."){
			
			System.out.println("Test Pass");
		}else{
			
			System.out.println("Test Case Fail");
		}*/
		Assert.assertEquals(Email, "Error: Please provide a valid email address.");
		}
	
	
@Test (priority =4)
	
	public void VerifyEmptyEmail(){
		
		registration.Registartion(prop.getProperty("UserEmailid1"), prop.getProperty("PasswordT"));
		String EmptyEmail = registration.EmptyEmail();
		
		log.info("Verify message for invalid email id ");
		System.out.println(EmptyEmail);
	/*	
		if (Email !="Error: Please provide a valid email address."){
			
			System.out.println("Test Pass");
		}else{
			
			System.out.println("Test Case Fail");
		}*/
		Assert.assertEquals(EmptyEmail, "Error: Please provide a valid email address.");
		}
	
	@AfterMethod
	
	public void Quit(){
		driver.quit();
	}
}
