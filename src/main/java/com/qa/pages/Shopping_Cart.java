package com.qa.pages;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.qa.base.Testbase;
import com.qa.utill.WaitTool;

public class Shopping_Cart extends Testbase {

	@FindBy(xpath="//a[@href='/shop/?add-to-cart=170']")
	 WebElement Add_To_Basket;
	 
	 @FindBy(xpath="//span[@class='cartcontents']")
	WebElement Cart_Item;
	 
	 @FindBy(xpath="//a[@title='View Basket']")
	 WebElement AddTo_Cart_Button;
	 
	 
	 
	 
		public Shopping_Cart()
		{
			PageFactory.initElements(driver, this);
			
		}
		
		
	public boolean add_To_Basket_View_Functionality()
	{
		Shop_Link.click();
		driver.manage().timeouts().pageLoadTimeout(10, TimeUnit.SECONDS);
		Add_To_Basket.click();
		WaitTool.waitForElementPresent(AddTo_Cart_Button, 5);
		
		System.out.println("Item Added in cart");
		/*Actions builder = new Actions(driver);
		builder.m(Cart_Item).build().perform();*/
		//Cart_Item.click();
		String carditem = Cart_Item.getText();
		System.out.println("Print cart item :" + carditem);
		
		if (!carditem.equals(0))
		{
			System.out.println("Cart Not Null");
			return true;
		}else{
			
			return false;
		}
		
	}
	

	public Checkout doCheckout() {
		//WebDriverWait wait = new WebDriverWait(Browser.driver(),50);
	   // System.out.println("Mouse over top cart area done");
	    //WebDriverWait wait = new WebDriverWait(Browser.driver(),30);
		if (!(WaitTool.waitForElementPresent(proceedToCheckout,30)))
			{
				goToCartImage(1);
			}
	//	wait.until(ExpectedConditions.visibilityOf(proceedToCheckout));
	 //   System.out.println("waiting for checkout button on top cart");
	    proceedToCheckout.click();
	    System.out.println("Clicked on checkout button done");
	    Checkout checkout = new Checkout();
	    return checkout;
	
}
}
