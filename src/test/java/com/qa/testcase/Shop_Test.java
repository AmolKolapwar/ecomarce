package com.qa.testcase;

import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.qa.base.Testbase;
import com.qa.pages.CheckOut;
import com.qa.pages.HomePage;
import com.qa.pages.MyCart;
import com.qa.pages.ProductPage;
import com.qa.pages.Shop;

public class Shop_Test  extends Testbase{

	Logger log = Logger.getLogger(Shop_Test.class);

	Shop shoptest;
	MyCart mycart;
	ProductPage productpage = new ProductPage();
	CheckOut checkout = new CheckOut();
	public Shop_Test() {

		super();
	}
	
	@BeforeMethod
	public void setup() {

		intialization();

		shoptest = new Shop();
}
	
	
	/*@Test
	
	public void testing() throws InterruptedException{
		
		shoptest.slider();
		shoptest.fetchText();
		shoptest.getPriceOfFilter();
		
		
	}*/
	
	/*@Test
	public void verifyProductCategory() throws InterruptedException
	{
		shoptest.slider();
	    log.info("Verify All Products Search Result");
	   
		shoptest.prodcutCategoery();
		//String testing = shoptest.productSerachResult();
		shoptest.sorting();
		
	}
	
	
*/
	
	/*@Test
	public void lowToHighSort() throws InterruptedException{
		
		shoptest.lowToHighFilter();
	}*/
	
	
	/*@Test
	public void verifyOutOfStockMsg() throws InterruptedException{
		shoptest.outofStockProduct();
		
		String outofstockmsg= shoptest.gettext2(shoptest.OutOfStock_MSG);
		Assert.assertEquals("Out of stock", outofstockmsg);
		System.out.println("*****Product out of stock Not Able To Add In Cart*********");
		
	}*/
	
	@Test
	public void verify_Cart_Item() throws InterruptedException{
		
		//shoptest.add_To_Basket_View_Functionality();
		shoptest.gotocart();
		Thread.sleep(500);
		shoptest= productpage.totalamount();
		
		System.out.println(shoptest);
		
		shoptest = checkout.elementDispyeld();
		
	}
	
	
	

	/*@Test
	
	void verify_High_To_Low() throws InterruptedException
	{
		
		shoptest.high_To_Low();
	}*/
	@AfterMethod
	public void quit() {

		ArrayList<String> tabs = new ArrayList<String>(driver.getWindowHandles());
		System.out.println("No. of tabs: " + tabs.size());
		System.out.println("Quit the  browser");
		shoptest.Quit();
	}
}