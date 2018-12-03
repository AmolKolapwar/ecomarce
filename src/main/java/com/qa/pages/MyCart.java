package com.qa.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.qa.base.Testbase;
import com.qa.utill.WebTable;

public class MyCart extends Testbase{

	
	 
	 @FindBy(xpath="//a[@href='/shop/?add-to-cart=170']")
	 WebElement Add_To_Basket;
	 
	 @FindBy(xpath="//span[@class='cartcontents']")
	 WebElement Cart_Item;
	 
	 @FindBy(xpath="//a[@title='View Basket']")
	 WebElement AddTo_Cart_Button;
	 
	  private StringBuffer verificationErrors = new StringBuffer();
	  WebElement table =Testbase.driver.findElement(By.xpath("//table"));
	  WebTable tableFunctions=new WebTable(table);
	  int rowCount=tableFunctions.getRowCount();
	  int colCount=tableFunctions.getColumnCountFromHeader();
	 
	 public MyCart()
	 {
   	 
		 PageFactory.initElements(driver, this);
		 
	 }
	 
	 public void verifyProductInTable() {
			String url=Testbase.driver.getCurrentUrl();
			String source= Testbase.driver.getPageSource();
			System.out.println("Current URL=" +url);
			System.out.println("Number of rows:" +rowCount);
			System.out.println("Number of columns:" +colCount);
		
			try {	
			  
			 		  
				for(int i=1;i<rowCount;i++){
				
				  WebElement text=tableFunctions.getElement(i,1);
				  if(text.getText().contains("Functional Programming in JS")){
	                 System.out.println("link:" +text.getAttribute("href"));	//not returning URL of the particular product		
					 System.out.println("Element is added to the cart");
					
				  }
				  else
				  {
					  System.out.println("link:" +text.getAttribute("href"));	
					  System.out.println("Element not added to the cart");
				  }
				}
			
			} catch (Error e) {
				//Capture and append Exceptions/Errors
				verificationErrors.append(e.toString());
			}
		  
		}
	 
	 
	 
}
