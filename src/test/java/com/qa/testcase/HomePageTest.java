package com.qa.testcase;


import static org.assertj.core.api.Assertions.assertThat;

import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.log4j.Logger;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.qa.base.Testbase;
import com.qa.pages.Address_Form;
import com.qa.pages.CheckOut;
import com.qa.pages.HomePage;
import com.qa.pages.MyCart;
import com.qa.pages.OrderSuccessPage;
import com.qa.pages.ProductPage;
import com.qa.pages.Shop;

import junit.framework.Assert;

public class HomePageTest extends Testbase {

	
	
	


	public JavascriptExecutor jsExec;

	Logger log = Logger.getLogger(LoginTestCase.class);
	HomePage homepaget;
	boolean flag;

	public HomePageTest() {

		super();
	}

	@BeforeMethod
	public void setup() {

		intialization();

		homepaget = new HomePage();
		
	}

	/*
	 * @Test
	 * 
	 * public void VerifyHomePageTilte() {
	 * 
	 * // Assert.assertEquals("Automation Practice //
	 * Site","homepaget.Homepagetitle()" ); homepaget.clickOnHomePage();
	 * 
	 * String Tilte = homepaget.Homepagetitle(); log.info(
	 * "Home page title is--->" + Tilte); Assert.assertEquals(Tilte,
	 * "Automation Practice Site");
	 * 
	 * // System.out.println("Verify HomePage Tilte"+ //
	 * homepaget.Homepagetitle()) }
	 * 
	 * @Test public void VerifySliderCount() {
	 * 
	 * homepaget.clickOnHomePage();
	 * 
	 * int count = homepaget.slidercount(); // System.out.print( "Page count" +
	 * homepaget.Slidercount());
	 * 
	 * if (count == 3) { System.out.println("Yes count is correct");
	 * 
	 * }else{
	 * 
	 * System.out.println("No count is Incorrect"); } }
	 * 
	 * @Test public void VerifyNewArrivala(){
	 * 
	 * homepaget.clickOnHomePage(); try{ int NewArrival =
	 * homepaget.newarrival();
	 * 
	 * if(NewArrival==3){ flag = true; } }catch (Exception e){ }
	 * Assert.assertTrue("Condtion Not Match", flag); }
	 * 
	 * @Test(dependsOnMethods ="VerifyNewArrivala" ) public void
	 * verifyNavigateToProductPage(){
	 * 
	 * homepaget.clickOnHomePage(); homepaget.verifyAddBasketFromNewArrivals();
	 * String ProductTitle = driver.getTitle();
	 * System.out.println(ProductTitle); }
	 */

	/*
	 * @Test public void verifyDescriptionFeild() throws InterruptedException{
	 * homepaget.clickOnHomePage(); homepaget.verifyAddBasketFromNewArrivals();
	 * if(homepaget.descriptiondisable()){
	 * 
	 * //homepaget.reviewclick(); homepaget.descriptionclick(); String
	 * ProductDescription = homepaget.productDescription(); System.out.println(
	 * "Print the Prodcut Description"+ ProductDescription);
	 * Assert.assertEquals(ProductDescription,
	 * "The Selenium WebDriver Recipes book is a quick problem-solving guide to automated testing web applications with Selenium WebDriver. It contains hundreds of solutions to real-world problems, with clear explanations and ready-to-run test scripts you can use in your own projects."
	 * ); } else{ System.out.println("Description Link Not Clickable");
	 * }System.err.println("");
	 * 
	 * }
	 * 
	 * 
	 * @Test public void verifyProductReview(){ homepaget.clickOnHomePage();
	 * homepaget.verifyAddBasketFromNewArrivals();
	 * if(homepaget.reviewoptiondisable()){
	 * 
	 * //homepaget.reviewclick(); homepaget.reviewclick(); String
	 * ReviewDescription = homepaget.reviewtext(); System.out.println(
	 * "Print the Prodcut Description"+ ReviewDescription);
	 * //Assert.assertEquals(ReviewDescriptions,
	 * "The Selenium WebDriver Recipes book is a quick problem-solving guide to automated testing web applications with Selenium WebDriver. It contains hundreds of solutions to real-world problems, with clear explanations and ready-to-run test scripts you can use in your own projects."
	 * ); } else{ System.out.println("Description Link Not Clickable");
	 * }System.err.println("");
	 * 
	 * }
	 */

	/*
	 * @Test public void verifyBookAdd(){
	 * 
	 * homepaget.clickOnHomePage(); homepaget.verifyAddBasketFromNewArrivals();
	 * homepaget.clickAddBasket(); verifyAddBasketFromNewArrivals String
	 * BasketMSG = homepaget.addbookmessage(); System.out.println(
	 * "Print the Message" + BasketMSG);
	 * 
	 * if (BasketMSG.equals("VIEW BASKET")){
	 * Assert.assertTrue(homepaget.viewbasketbutton()); System.out.println(
	 * "View Basket Button Enable"); }else{
	 * 
	 * System.out.println("View Basket Button Not Disable"); }
	 * 
	 * 
	 * // homepaget.viewbasketbutton();
	 * 
	 * }
	 */
	
	
	/*@Test
	public void verifyInvalidbookstock() throws InterruptedException {
		homepaget.clickOnHomePage();
		homepaget.selectfromnewarrivals();

		System.out.println(homepaget.stockNumber());
        int GetNumber = Integer.parseInt(homepaget.stockNumber().substring(0, 3));
        
		GetNumber = GetNumber + 1;

		String num = Integer.toString(GetNumber);
		System.out.println("Print the new number: " + num);

		// if (GetNumber.equals("257 in stock")) {
		homepaget.invalidstocknumber(num);
		Thread.sleep(2000);
		homepaget.clickAddBasket();

		String msg = homepaget.errorMSG();

		System.out.println("Print the error message :" + msg);
		Assert.assertEquals(msg, "Value must be less than or equal to 257.");

		// } /*else {
		//System.out.println("Verify Stock Number");
		// }*/

		//Assert.assertEquals("abc", gettext2(homepaget.Testing));
		//assert ! homepaget.Testing.isDisplayed();
	//}//
	
	@Test
	public void testing() throws InterruptedException{
		
		//List<String> actualResult = new ArrayList<String>();
		List<WebElement>ElementsList =driver.findElements(By.tagName("body"));
				// List<WebElement>driver.findElements(By.xpath("//*"));
		//driver.getPageSource();
		System.out.println(Integer.toString(ElementsList.size()));
	
		for(WebElement element : ElementsList) {
		   
		 System.out.println(  element.getText());
				  
		 
		 
		}             
		  List<String> expectedResult = new ArrayList<String>();
		  expectedResult.add("Shop");                  
		  expectedResult.add("My Account");
		  expectedResult.add("Test Cases");
		  expectedResult.add("AT Site");
		  expectedResult.add("Demo Site");
		  expectedResult.add("0 Items?0.00");
		  expectedResult.add("Login");
		  expectedResult.add("Username or email address *");
		  expectedResult.add("Password *");
		  expectedResult.add("Remember me");
		  expectedResult.add("Lost your password?");
		  expectedResult.add("Register");
		  
		  expectedResult.add("Email address *");
		  expectedResult.add("Password *");
		  expectedResult.add(" SUBSCRIBE HERE");
		  expectedResult.add("© Automation Practice Site 2018");
		  
		  assertThat(expectedResult).isEqualTo(ElementsList);
		  System.out.println(expectedResult);
	
		  //assertThat(expectedResult).containsAll(element);
//Assert.assertEquals(expectedResult, ElementsList);
		  
if( ElementsList.size() == expectedResult.size() && (ElementsList.containsAll(expectedResult))){
	
	System.out.println("List Match ");
	
}else{
	
	System.out.println("List Not Match");
}
		  
		  

/* for(int i=0;i<expectedResult.size();i++) {
			    if(ElementsList.get(i)(expectedResult.get(i))) {
			        System.out.println("Search function verified");
			    }else {
			        System.out.println("Search function verification failed"+ElementsList.get(i));
			    }
			}*/
//	}
		// assertThat(actualResult).containsAll(expectedResult);

	/*@Test
	public void Add_To_Basket_Coupan() throws InterruptedException{
		
		homepaget.clickOnHomePage();
		log.info("Landing to Home Page");
		
		homepaget.selectfromnewarrivals();
		homepaget.clickAddBasket();
		Shop shop = new Shop();
		
		homepaget = shop.cardclick();
		
		ProductPage product = new ProductPage();
		homepaget = product.entercoupancode("krishnasakinala");
		Thread.sleep(5000);
		homepaget = product.getAmout();
		Assert.assertTrue(true);
	}
	*/
	
	
	/*@Test
	public void verify_CoupanValue_GraterThan_450(){
		
		homepaget.clickOnHomePage();
		homepaget.selectBook();
		homepaget.clickAddBasket();
		Shop shop = new Shop();

		homepaget = shop.cardclick();
		ProductPage product = new ProductPage();
		homepaget = product.entercoupancode("krishnasakinala");
       
        String subTotal= product.Sub_total.getText().substring(1);
		float amount = Float.valueOf(subTotal);
        if (amount< 450){
        	
    		String ErrorMsg=product.Coupan_Errormsg.getText();
    		System.out.println("Print the Error Msg:"  +ErrorMsg  );
    		
    	}else{
    		
    		System.out.println("Test case Fail");
    	}
	}*/
	
	/*@Test
	public void removeBookMsg(){
		
		homepaget.clickOnHomePage();
		homepaget.selectBook();
		homepaget.clickAddBasket();
		Shop shop = new Shop();

		homepaget = shop.cardclick();
		ProductPage product = new ProductPage();
		homepaget =product.removeBook();
	}*/
	
	
	/*@Test(groups={"sanity"})
	public void verify_TotalPriceGrater_ToSubtotal(){
		
		homepaget.clickOnHomePage();
		homepaget.selectBook();
		homepaget.clickAddBasket();
		Shop shop = new Shop();

		homepaget = shop.cardclick();
		ProductPage product = new ProductPage();

		String SubTotal = product.subtotal().substring(1);
		System.out.println("Print the subtotal Amount:"  + SubTotal);
		float subtotal = Float.valueOf(SubTotal);
		float tax= subtotal*2/100;
		float total =subtotal+tax;
		
		System.out.println("Print the total amount:  "+total );
		if (total>subtotal){
			System.out.println("Test Case Pass Total  Grater Than SubTotal Amount");
			Assert.assertNotSame(total, subtotal);
		}else{
			
			System.out.println("Test Case Fail ");
		}
		
	}*/
	/*
	@Test (groups={"smoke"},dependsOnMethods = { "verify_TotalPriceGrater_ToSubtotal" })
	public void   checkOutPocees()
	{
		homepaget.clickOnHomePage();
		homepaget.selectBook();
		homepaget.clickAddBasket();
		Shop shop = new Shop();

		homepaget = shop.cardclick();
		homepaget.proceedchekout();
		CheckOut checkout = new CheckOut();
		log.info("Verify Element Displayed on Not ");
		homepaget = checkout.elementDisplayed();
		
			
			
	}
	*/

	@Test(retryAnalyzer =com.qa.utill.Myretry.class,groups= {"sanity"})
	public void check_Out_PaymentGatway() throws InterruptedException{

		homepaget.clickOnHomePage();
		homepaget.selectBook();
		homepaget.clickAddBasket();
		Shop shop = new Shop();

		homepaget = shop.cardclick();
		homepaget.proceedchekout();
		CheckOut checkout = new CheckOut();
		//homepaget = 
	    Address_Form address = new Address_Form();
	  //  homepaget = checkout.FillAddressForPlaceOrder(registrationDetails);
	     address.setFirst_Name(prop.getProperty("First_Name"));
		 address.setLast_Name(prop.getProperty("Last_Name"));
		 address.setAddress_Field1(prop.getProperty("Address1"));
		 Thread.sleep(5000);
	     address.setAddress_Filed2(prop.getProperty("Address2"));
		 address.setCity(prop.getProperty("city"));
		 Thread.sleep(5000);
		 address.setCompany_Name(prop.getProperty("company"));
		// address.setCountry_Code(prop.getProperty("country"));
		 Thread.sleep(5000);
		 address.setPhone_Number(prop.getProperty("phone"));
		 address.setPost_Code(prop.getProperty("postcode"));
		 address.setState(prop.getProperty("state"));
         checkout.FillAddressForPlaceOrder();
    	   Thread.sleep(5000);
    	   OrderSuccessPage ordermsg= new OrderSuccessPage();
    	   checkout.selectPaymentMethodtwo();
    	   
    	   Assert.assertEquals("Thank you. Your order has been received.", checkout.Successmsg());
    	   
     	  
       }
	
	
	@AfterMethod
	public void quit() {

		ArrayList<String> tabs = new ArrayList<String>(driver.getWindowHandles());
		System.out.println("No. of tabs: " + tabs.size());
		driver.quit();
	}
}
