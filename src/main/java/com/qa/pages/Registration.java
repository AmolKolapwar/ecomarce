package com.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.qa.base.Testbase;

public class Registration extends Testbase {

	
	
	@FindBy(xpath = "//input[@id='reg_email']")
	WebElement RegEnail;
	
	@FindBy(xpath = "//input[@id='reg_password']")
	WebElement PasswordField;
	
	@FindBy (xpath ="//input[@value='Register']")
	WebElement RegistarButton;
	
	
	@FindBy (xpath =" //ul[@class='woocommerce-error']//li")
	WebElement InvalidEmail;
	
	@FindBy(xpath = "//ul[@class='woocommerce-error']")
	WebElement EmaptyEmailid;
	
    public Registration(){
		
		PageFactory.initElements(driver, this);
	}
    
    
    
    public boolean RegistraButton(){
    	
    	return RegistarButton.isEnabled();
    }
    
    public String Pagetitle(){
    	
    	return driver.getTitle();
    }
    
    
    public String InvalidEmail(){
    	
    	return InvalidEmail.getText();
    }
    
    
    public String EmptyEmail(){
    	
    	return EmaptyEmailid.getText();
    }
    public MyAccount Registartion(String name, String password)
    {
    	
    	RegEnail.sendKeys(name);
    	PasswordField.sendKeys(password);
    	RegistarButton.click();
    	return  new MyAccount();
    }
    
    
}
