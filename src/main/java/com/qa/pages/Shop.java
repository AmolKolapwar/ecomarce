package com.qa.pages;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.ListIterator;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import com.qa.base.Testbase;
import com.qa.utill.WaitTool;

import junit.framework.Assert;

public class Shop extends Testbase {

	@FindBy(xpath = "//div[@class='ui-slider-range ui-widget-header ui-corner-all']")
	WebElement Slider;

	@FindBy(xpath = "//a[contains(.,'Shop')]")
	WebElement Shop_Link;

	// span[@class='price']
	@FindBy(xpath = "//button[@type='submit']")
	WebElement Filter_Button;
	@FindBy(xpath = "//div[@class='price_label']")
	WebElement Price_lable;

	@FindBy(xpath = "//span[@class='price']")
	List<WebElement> Search_Result;

	 @FindBy(xpath="//a[@href='http://practice.automationtesting.in/product-category/android/']")
	 WebElement Product_Category;
	 
	 @FindBy(xpath="//ul[@class='product-categories']")
	List<WebElement>  Product_List;
	 
	 @FindBy(xpath="//ul[@class='products masonry-done']//h3")
	 List<WebElement> Product_Result;
	 
	 @FindBy(xpath="//select[@name='orderby']")
	 List<WebElement>Drop_Down;
	 @FindBy(xpath="//ul[@class='products masonry-done']")
	 List<WebElement>AllProduct_List;
	 
	 @FindBy(xpath="//a[contains(.,'Home')]")
	 WebElement Home_Link;
	 @FindBy(xpath="//a[contains(.,'Read more')]")
	 WebElement Read_More;
	 
	 @FindBy(xpath="//p[@class='stock out-of-stock']")
	 public WebElement OutOfStock_MSG;
	 
 @FindBy(xpath="//form[@class='woocommerce-ordering']")
 WebElement Drop_DownClick;
 
 @FindBy(xpath="//ul[@class='products masonry-done']//span[@class='price']")
 List<WebElement> Product_Price;
 
 @FindBy(xpath="//ul[@class='products masonry-done']//span[@class='price']//del")
 List<WebElement> Change_Price;
  
 @FindBy(xpath="//a[@href='/shop/?add-to-cart=170']")
 WebElement Add_To_Basket;
 
   @FindBy(xpath="//a[@data-product_id]")
   WebElement Add_BookName;
 @FindBy(xpath="//span[@class='cartcontents']")
WebElement Cart_Item;
 
 @FindBy(xpath="//a[@title='View Basket']")
 WebElement AddTo_Cart_Button;
 
 
 @FindBy(xpath="//a[@title='View your shopping cart']")
 WebElement CartWith_ItemNo_Price;
	int minvalue, maxvalue;
	int searchresult[];

	public Shop() {
		PageFactory.initElements(driver, this);
		//fetchText();
	}

	public void fetchText() {
		minvalue = Integer.parseInt(Price_lable.getText().substring(8, 11));
		maxvalue = Integer.parseInt(Price_lable.getText().substring(15, 18));
		searchresult = new int[Search_Result.size()];
		
		System.out.println(searchresult);
		int i = 0;
		for (WebElement webElement : Search_Result) {
			searchresult[i] = Integer.parseInt(webElement.getText().substring(1, 3));
			i++;
		}

	}

	// .moveByOffset(xOffser:230, 305)
	public void slider() throws InterruptedException {

		Shop_Link.click();
		Actions action = new Actions(driver);
		// int width=Slider.getSize().getWidth();
		action.clickAndHold(Slider).moveByOffset(71, 230).release().build().perform();
		// Slider.click();
		/*
		 * System.out.println(width); action.dragAndDropBy(Slider,
		 * 230,297).release().build().perform();
		 */
		Thread.sleep(1000);

	}

	public void getPriceOfFilter() {
		Filter_Button.click();
		 if(minvalue == 150 && maxvalue == 450) {
			Assert.assertTrue(true);
			System.out.println("Test case Pass");
			for (int j = 0; j <= searchresult.length-1; j++) {
				if (searchresult[j] >= 150 && searchresult[j] <= 450) {
					Assert.assertTrue(true);
					System.out.println("all price are in between 150 to 450");
				}
			}
		} else {
			Assert.assertTrue(false);
			System.out.println("Filter not applied properly");
		}

		/*
		 * System.out.println(Price_lable.getText().substring(8, 11));
		 * System.out.println(Price_lable.getText().length());
		 * System.out.println(Price_lable.getText().substring(15,
		 * Price_lable.getText().length()));
		 */
		//return Price_lable.getText();

	}
	
	public  void prodcutCategoery(){
		
		Product_Category.click();
		System.out.println(Product_List.size());
		for (int i=0;i<Product_List.size();i++)
		{
			System.out.println("Print the Product List"+Product_List.get(i).getText());
			 this.productSerachResult();
		}
	}
	
	public boolean  productSerachResult(){
		Product_Category.click();

		System.out.println(Product_Result.size());
		for(int j=0;j<Product_Result.size();j++)
		{
			 System.out.println("Print the Product Search Result:" + Product_Result.get(j).getText().equals("Android Quick Start Guide"));
			 return true;
			// Assert.assertEquals("Android Quick Start Guide", Product_Result.get(j));
			 // String text = Product_Result.get(j).getText();
			 
		}
		return false;
		
	}
	
	public void sorting(){
		 
		String arr[] = {"Default sorting","Sort by popularity","Sort by average rating","Sort by newness","Sort by price: low to high","Sort by price: high to low"};
		Select Dropdowoptions = new Select(driver.findElement(By.xpath("//select[@name='orderby']")));
	
		List<WebElement> getoptions = Dropdowoptions.getOptions();
		System.out.println(getoptions.size());
	
		for(int i =0;i<getoptions.size();i++){
			 String text = getoptions.get(i).getText();
		     System.out.println(text);
			Assert.assertEquals(arr[i], getoptions.get(i).getText());
		}
	}

	
	
	public void lowToHighPrice()
	
	{
		Shop_Link.click();
		Drop_DownClick.click();
		
		List<WebElement>Price =Product_Price;
		for(int k=0;k<Price.size();k++)
		{
			
			String price = Price.get(k).getText().substring(1);
			System.out.println(price);
			System.out.println("String str starts with quick: "+price.startsWith("600.00?450.00"));

			
		}
		
		List<WebElement> BeforeFilter = AllProduct_List;
		for(int j =0;j<BeforeFilter.size();j++)
		{
			String beforefilter = BeforeFilter.get(j).getText();
			System.out.println("Print the Before Filter Apply List:" + beforefilter);
		}
		
		//Selecting low to high option from drop down list
		Select Dropdowoptionst = new Select(driver.findElement(By.xpath("//select[@name='orderby']")));
		Dropdowoptionst.selectByValue("price");
		List<WebElement> price= AllProduct_List;
		 ArrayList<Float> priceList = new ArrayList<Float>();
		    for (int i = 0; i<price.size(); i=i+1) {
		    	String test = price.get(i).getText();
				System.out.println("After Filter Apply List:" +test);
		    }  
		   
		   ListIterator<WebElement> test =BeforeFilter.listIterator();
		   ListIterator<WebElement> test2 =price.listIterator();
		    if (test!= test2){
		    	
		    	System.out.println("Sort Apply Sucessfully low to high ");
		    }
	}
	
	
	public void lowToHighFilter() throws InterruptedException{
		Shop_Link.click();
		Drop_DownClick.click();
		Select Dropdowoptionst = new Select(driver.findElement(By.xpath("//select[@name='orderby']")));
		Dropdowoptionst.selectByValue("price");
		System.out.println("Low To High Filter Apply");
		
		//Storing the price of current filter.......
		List<WebElement> price= Product_Price;
		 Thread.sleep(500);
		 
		 //Stiring the old remove price....
		List<WebElement>change=Change_Price;
		price.remove(change);//using this method remove old price from current list for comparing the 
		
		
	    System.out.println(price.size());
		 ArrayList<Float> priceList = new ArrayList<Float>();
		    for (int i = 0; i<price.size(); i++) {
		       priceList.add(Float.parseFloat(price.get(i).getText().substring(1,6))); 
		       System.out.println(priceList);
				//System.out.println("String str starts with quick: "+priceList.startsWith("600.00?450.00"));

		    }  
		    
		   /* Collections.sort(priceList);
		    System.out.println("List in Asseding order:"  + priceList);*/
		    if(!ascendingCheck(priceList)){
		        Assert.fail("Not is ascending order");
		    }
	}
	
	Boolean ascendingCheck(ArrayList<Float> data){         
        for (int i = 0; i < data.size()-1; i++) {
            if (data.get(i) > data.get(i+1)) {
                return false;
            }       
         }
         return true;
     }
	
	Boolean descendingCheck(ArrayList<Float> data){         
        for (int i = 0; i < data.size()-1; i++) {
            if (data.get(i) < data.get(i+1)) {
                return false;
            }       
         }
         return true;
     }
	public void high_To_Low() throws InterruptedException{
		Shop_Link.click();
		Drop_DownClick.click();
		Select Dropdowoptionst = new Select(driver.findElement(By.xpath("//select[@name='orderby']")));
		Dropdowoptionst.selectByValue("price-desc");
		System.out.println("Apply High To Low Filter ");
		
		//Storing the price of current filter.......
		List<WebElement> price= Product_Price;
		 Thread.sleep(500);
		 
		 //Stiring the old remove price....
		List<WebElement>change=Change_Price;
		price.remove(change);//using this method remove old price from current list for comparing the 
		
		
	    System.out.println(price.size());
		 ArrayList<Float> priceList = new ArrayList<Float>();
		    for (int i = 0; i<price.size(); i++) {
		       priceList.add(Float.parseFloat(price.get(i).getText().substring(1,6))); 
		       System.out.println(priceList);
				//System.out.println("String str starts with quick: "+priceList.startsWith("600.00?450.00"));

		    }  
		    
		   /* Collections.sort(priceList);
		    System.out.println("List in Asseding order:"  + priceList);*/
		    if(ascendingCheck(priceList)){
		        Assert.fail("Not is ascending order");
		    }
	}
	
	public void  outofStockProduct() throws InterruptedException{
		Shop_Link.click();
		Thread.sleep(1000);
		Actions home = new Actions(driver);
		home.moveToElement(Home_Link).build().perform();
		WaitTool.click(Home_Link, 5);
		//Home_Link.click();
	   // Thread.sleep(1000);
		
		
		String HomePageUrl= "http://practice.automationtesting.in/";
		System.out.println(URL(HomePageUrl));
		try{

			WaitTool.click( Read_More, 5);
			System.out.println(getURL());
		}catch(Exception e){
			System.out.println(e);
		}
		

		
		
	}
	


	public void selectPopularityitem()
	
	{
		
		Shop_Link.click();
		Drop_DownClick.click();
		
		//.....Using this get the default sort list result.......
		List<WebElement> defaultsearch = AllProduct_List;
 	      for (int j=0;j<defaultsearch.size();j++)
	
	{
		String test = defaultsearch.get(j).getText();
		System.out.println("Print the default list:" +test);
	}
	
	
	//Click on drop down list and select value from list and store the value in list and compare list sequence. 
		Select Dropdowoptionst = new Select(driver.findElement(By.xpath("//select[@name='orderby']")));
		Dropdowoptionst.selectByValue("popularity");
		List<WebElement> popularityresult = AllProduct_List;
		System.out.println(popularityresult.size());
		    for(int i =0;i<popularityresult.size();i++)
		
		{
			 String text = popularityresult.get(i).getText();
		     System.out.println(text);
		    
		if (defaultsearch.iterator() !=popularityresult )
		
		{
			System.out.println("Currently populartiyt list dispalyed");
		}else{
			
			System.out.println("Sort not working proper");
		}
		
		
	}
	
		  
		
		    
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
	
	
	public CheckOut gotocart(){
		
		Shop_Link.click();
		try{
		Add_To_Basket.click();
		
		System.out.println(CartWith_ItemNo_Price.getText());
		WaitTool.waitForElementPresent(AddTo_Cart_Button, 5);
		AddTo_Cart_Button.click();
		}catch (Exception e){
			System.out.println(e);
		}
		return new CheckOut();
		
		
	}
	
	public HomePage cardclick(){
		String getcardno = CartWith_ItemNo_Price.getText();
	if (!getcardno.equals(0)){
		Actions action = new Actions(driver);
		
		action.moveToElement(CartWith_ItemNo_Price).click().build().perform();
	  
	   
	}
	HomePage page = new HomePage();
	return page;
	
	}
}
//Use this code for verif sorting result collections.sort method user for assending order 
/*//*ArrayList<String> obtainedList = new ArrayList<>(); 
List<WebElement> elementList= driver.findElements(By.xpath(YourLocator));
for(webElement we:elementList){
   obtainedList.add(we.getText);
}
ArrayList<String> sortedList = new ArrayList<>();   
for(String s:obtainedList){
sortedList.add(s);
}
Collections.sort(sortedList);
Assert.assertTrue(sortedList.equals(obtainedList));
	}*/






