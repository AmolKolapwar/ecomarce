package com.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.qa.base.Testbase;

public class OrderSuccessPage extends Testbase{

	@FindBy(xpath="//div//p[@class='woocommerce-thankyou-order-received']")
	WebElement SuccessMsg;
	
	public void OrderSuccessPage(){
		PageFactory.initElements(driver, this);
	}
	
	
	public String Successmsg(){
		
		return SuccessMsg.getText();
		  
	}
	
}
