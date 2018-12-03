package com.qa.testcase;

import java.util.List;

import org.apache.log4j.Logger;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.qa.base.Testbase;
import com.qa.pages.LoginPage;
import com.qa.pages.MyAccount;

import junit.framework.Assert;

public class MyAccountTestCase  extends Testbase{

	Logger Log = Logger.getLogger(MyAccountTestCase.class);
	
	LoginPage loginpage;
	MyAccount myaccount;
	
	public MyAccountTestCase(){
		
		super();
	}
	
	@BeforeMethod
	
	public void setup(){
		
		intialization();
		loginpage =new LoginPage();
		Log.info("Call Login Method And Login In To System");
		myaccount = loginpage.login(prop.getProperty("username"), prop.getProperty("password"));
		myaccount = new MyAccount();
		
		
	}
	
	
	/*@Test(description ="Test Case No 1")
	public void Clickondashboard(){
		Log.info("Click on Dahboard");
		myaccount.Dashboardt();
		Log.info("Verify Text On Dashboard");

		             String Dashboardtext = myaccount.HelloText();
		            if (Dashboardtext.contains("Hello amit (not amit? Sign out)")) {

			                   Assert.assertEquals(Dashboardtext, "Hello amit (not amit? Sign out)");
                              System.out.println("Test Case Pass----------------");
		           } else {

			                     System.out.println("Test Case Fail ---------------");
		}

	}*/

	
	/*@Test(description ="Test Case No 2")
	public void verifyOrderCount(){
		 myaccount.clickOrderLink();
		 myaccount.getProductsOrderCount();			
	}
*/
	
	
	/*@Test(description ="Test Case No 3")
	public void navigateToOrdeDetilspage(){
		 myaccount.clickOrderLink();
         myaccount.navigateToOrderDetilsPage();
	}*/
	
	/*@Test(description ="Test Case No 4")
	public void orderStatus(){
		
		 myaccount.clickOrderLink();
         myaccount.navigateToOrderDetilsPage();
         if (myaccount.orderDeailsIsDispayed()== true){
        	 
        	 List<String> Orderstatus =  myaccount.getOrderStatus();
             System.out.println("Print the Order No,Date & Status :"  +Orderstatus );
         }
         
         
      
        
	}
	*/
	
	/*@Test(description ="Test Case No 5")
	public void verifyAddressPageText(){
		
		 myaccount.clickOrderLink();
         myaccount.navigateToOrderDetilsPage();
         myaccount.addresLinkClick();
         myaccount.addresLinkClick();  
         Assert.assertTrue(myaccount.addresLinkClick());
         
         
	}*/
	
	/*@Test(description ="Test Case No 6")
	public void verifyEditAddressButton() throws InterruptedException{
		
		 myaccount.clickOrderLink();
         myaccount.navigateToOrderDetilsPage();
         myaccount.addresLinkClick();
          myaccount.billingAddresEdit();
        	 Assert.assertTrue( myaccount.billingAddresEdit=true);
        	 myaccount.sendFirstName("Testing");
        	String gettext = myaccount.getUpdateMessage();
        	System.out.println(gettext);
        	Assert.assertEquals("Address changed successfully.", gettext);
         
         
	}*/
	

	@Test(description ="Test Case No 8")
	public void verifyLogout(){
		myaccount.clickOrderLink();
	    myaccount.navigateToOrderDetilsPage();
	    myaccount.logout();
	    Assert.assertTrue(true);
		
	}
	
	@AfterMethod
	public void quit(){
		
		driver.quit();
	
	}
}
