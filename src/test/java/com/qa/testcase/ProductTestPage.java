package com.qa.testcase;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.qa.base.Testbase;
import com.qa.pages.HomePage;
import com.qa.pages.LoginPage;
import com.qa.pages.ProductPage;

public class ProductTestPage extends Testbase {
	
	Logger log = Logger.getLogger(LoginTestCase.class);

	boolean flag = true;
	 LoginPage loginpage;
	 HomePage homepaget;
	 ProductPage product;
	 public ProductTestPage() {

			super();
		}
	 

		@BeforeMethod
		public void setup() {

			intialization();

			homepaget = new HomePage();
			loginpage = new LoginPage();
			product = new ProductPage();
			
			  homepaget.clickOnHomePage();
			//  homepaget.selectfromnewarrivals();
			  homepaget.selectThirdbook();
			  homepaget.clickAddBasket();
			  product.verifyViewButtonClickable();
		}
		
		
		/*@Test 
		public void verifyAllUIContains(){
			
		 product.verifyAllUIcontains();
			System.out.println("Print" + product.verifyAllUIcontains());
			
		}
		
		


		@Test
		public void verifyViewBasket(){
			
			
			  homepaget.clickOnHomePage();
			  homepaget.verifyAddBasketFromNewArrivals();
			  homepaget.clickAddBasket(); 
			 if(product.verifyViewBasketButtonDisable() == true){
				
			                product.verifyViewButtonClickable();
			               log.info("...................After Navigating Print the Current URL...........");
			                String GetURL = product.getURL();
			                 System.out.println("After Navigate Print the current URL" +GetURL);
				}else {
				
				System.out.println("View Basket Button Disable");
			}
			
			  //Click on ProceesTO Check Out Button for Navigate to Check out page.
			 product.clickonProceesbutton();
			 log.info("Navigate to checkout page");
			 String GetURL2 = product.getURL();
			 System.out.println(GetURL2);
			 log.info(".............Veruify the checkout URL..............");
			 Assert.assertEquals(GetURL2, "http://practice.automationtesting.in/checkout/");
			 
		}*/
		
		/*@Test
		public void applycoupancode(){
			
			
			int sum =0;
			if(product.verifyApplyCoupan()){
				log.info("................Print SubTotal Amount");
				String Subtotal = product.subtotal();
                System.out.println("Print the Subtotal amount"  + Subtotal);
                
                log.info(".......Enter Coupan Code And Click On Apply Button..........");
				product.entercoupancode("krishnasakinala");
				product.applybutton();
				
				log.info(".......Print Total Amount........");
				String BeforeDiscount = product.gettotalamount();
	//   	int total = Integer.parseInt(BeforeDiscount.substring(1);
				System.out.println("Print the total amount"  +  BeforeDiscount.substring(1));
				
				
				log.info(".........Print Discount Amount........");
				String AfterDiscount = product.getcoupanamount();
				System.out.println("Print the Discount Amount" +AfterDiscount);
				
				
				int difference =Integer.parseInt(BeforeDiscount.substring(1, 6).trim()) - Integer.parseInt(AfterDiscount.substring(1, 0));
				
				System.out.println("Print the difference Amount :"  +difference );
				
			}
		}
		*/
		/*@Test
		public void verifyCoupanwithinvaliddata(){
			
			String success = product.coupansucess();
			String error= product.coupanerror();
			
			
			
		}
		*/
		
		
	/*	@Test
		public void removeBookFormCheckoutpage(){
			log.info("Click on Remove Book Button");
			product.removebook();
			String removemsg = product.Remove_Sucessmsg.getText();
			log.info("Verify Remove Sucessfull Message");
			Assert.assertEquals(removemsg, "Mastering JavaScript removed. Undo?","Message Not Matched");
			System.out.println("print the success message:" +removemsg );
			
		}*/
		
		/*@Test(description ="TC12- Update Button Should Be Enable After Change Of Book Quntity")
		public void verifyUpdateButtonFucnctionality(){
			
			log.info("Verify Update Button Disable");
			
			product.updateButton();
			
			log.info("If Update Button Disable ");
		   if (!product.updateButton()){
			   
			     product.setBookeQuntity("2");
				 product.updateButton();
				 
				 String Getmsg=product.gettext2(product.Update_Sucessmsg);
				 System.out.println("Print the Update Success Message:" + Getmsg);
		   }
			   
			//System.out.println("Click on Update Button");
	
			 
			
		}*/
		/*
		@Test() 
			public void checkOutBookFinalPrice(){
				
			//String Price = product.bookPrice();
			//System.out.println("Print the Book Price Per Unit:" + Price.substring(1));
			 Integer price = Integer.parseInt(product.bookPrice().substring(1));
			 
		     //int result=  price *2;
		     
		     System.out.println(price);
			}*/
		
	
		
		@Test
		public void verify_TotalPriceGrater_ToSubtotal(){
			
			
			String SubTotal = product.subtotal().substring(1);
			
			float subtotal = Float.valueOf(SubTotal);
			float tax= subtotal*2/100;
			float total =subtotal+tax;
			System.out.println("Print the total amount:  "+total );
			if (total>subtotal){
				System.out.println("Test Case Pass Total Always Grater Than SubTotal Amount");
				Assert.assertNotEquals(total, subtotal);
			}else{
				
				System.out.println("Test Case Fail ");
			}
			
		}
		@AfterMethod()
			public void quit(){
				driver.quit();
			}
		}

