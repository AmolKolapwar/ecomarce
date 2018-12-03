package com.qa.pages;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.apache.log4j.Logger;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.qa.base.Testbase;

import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.LoadableComponent;
import org.openqa.selenium.support.ui.WebDriverWait;

public class MyAccount extends Testbase {

	
	
	@FindBy (xpath="//li[@class='woocommerce-MyAccount-navigation-link woocommerce-MyAccount-navigation-link--dashboard is-active']//a[contains(@href,'http://practice.automationtesting.in/my-account/')]")
	WebElement Dashboard;
	
	@FindBy (xpath ="//p[contains(.,'Hello')]")
	WebElement DashBoartText;
	
	
	@FindBy(xpath="//a[contains(.,'Orders')]")
	WebElement Orderlink;
	
	@FindBy(xpath="//a[contains(@class,'button view')]")
	WebElement Goshop_Button;
	
	
	@FindBy(xpath="//div[@class='woocommerce-MyAccount-content']")
	List<WebElement> Get_OrdeDetils;
	
	@FindBy(xpath="//table[@class='woocommerce-MyAccount-orders shop_table shop_table_responsive my_account_orders account-orders-table']")
	List <WebElement> Order_Details;
	
	@FindBy(xpath="//div[@class='woocommerce-MyAccount-content']")
	WebElement Order_DetailsPage;
	
	
	//@FindBy(xpath="//div[@class='woocommerce-MyAccount-content']//p")
	//WebElement Order_Number;
	
	@FindBy(xpath="//mark[@class='order-number']")
	WebElement Order_Number;
	
	@FindBy(xpath="//mark[@class='order-status']")
	
	WebElement Order_Status;
	
	@FindBy(xpath="	//mark[@class='order-date']")
	
	WebElement Order_Date;
	
	@FindBy(xpath="//a[contains(.,'Addresses')]")
	WebElement Address_Link;
	@FindBy(xpath="//h3[contains(.,'Billing Address')]")
	WebElement BillingAddres_Text;
	
	@FindBy(xpath="//h3[contains(.,'Shipping Address')]")
	WebElement ShippingAddress_Text;
	
	@FindBy(xpath="//a[@class='edit'][@href='http://practice.automationtesting.in/my-account/edit-address/billing']")
	WebElement BillingAddress_Edit;
	
	@FindBy(xpath="//input[contains(@name,'billing_first_name')]")
	WebElement First_Name;
	
	@FindBy(xpath="//input[contains(@class,'button')]")
	WebElement SaveAddress_Button;
	
	@FindBy(xpath="//div[@class='woocommerce-message'][contains(.,'Address changed successfully.')]")
	WebElement Update_Message;
	
	@FindBy(xpath="//a[contains(.,'Logout')]")
	WebElement Logout;
	public MyAccount(){
		
		PageFactory.initElements(driver, this);
	}
	
	
	public void Dashboardt(){
		
		Dashboard.click();	
	}
	
	
	public String  HelloText(){
		
	return	DashBoartText.getText();
	}
	
	
	public void clickOrderLink(){
		
		Orderlink.click();
		/*if(Goshop_Button.getText().equals("GO SHOP")){
			
			System.out.println("Text Match :" +Goshop_Button.getText());
		}else{
			
			System.out.println("Goshop Button Not Enable" +Goshop_Button.getText());
		}*/
		
	}
	
	public int getOrderDetails(){
		
		return Order_Details.size();
		
	}
	
	
	 public List<String> getProductsOrderCount(){
	    List<String> products = new ArrayList<String>();
		List<WebElement> productList = Get_OrdeDetils;
        int totlalsize= productList.size();
		System.out.println("No. of elements in product list - " + totlalsize);

	     return products;

	}
	 
	public void navigateToOrderDetilsPage() {

		Goshop_Button.click();

		String contains = Order_DetailsPage.getText();
		

		System.out.println(contains);

		if (contains.contains("Order Details")) {

			System.out.println("Navigate To Order Details Page");
		} else {

			System.out.println("Wrong Page");
		}
	}
	
	
	
	public  List<String>  getOrderStatus(){
	
		
		String date =Order_Date.getText();
		String status=Order_Status.getText();
		String nmber=Order_Number.getText();
		return Arrays.asList(nmber,date,status);
	}
		public boolean  orderDeailsIsDispayed(){
			
		return Order_DetailsPage.isDisplayed();
		 
		}
		
		public boolean  addresLinkClick(){
			Address_Link.click();
			String getcurrenturl= driver.getCurrentUrl();
			System.out.println("After Navigate Pring the URL :"  +getcurrenturl);
			if (ShippingAddress_Text.isDisplayed() && BillingAddres_Text.isDisplayed() ){
				ShippingAddress_Text.getText();
				BillingAddres_Text.getText();
				System.out.println(ShippingAddress_Text.getText());
				System.out.println(BillingAddres_Text.getText());
				return true;
			} else{
				
				System.out.println("Element Not Visable");
			}
			return false;
			}
	
		public void  addressPageElementIsDispayed(){
			
			ShippingAddress_Text.isDisplayed();
			BillingAddres_Text.isDisplayed();
			
		}
		
		public boolean billingAddresEdit() throws InterruptedException{
		try{
			if(BillingAddress_Edit.isEnabled()){
				Thread.sleep(1000);
				//WebDriverWait wait = new WebDriverWait(webDriver, timeoutInSeconds);
				//wait.until(ExpectedConditions.visibilityOfElementLocated(BillingAddress_Edit));
				BillingAddress_Edit.click();
				System.out.println("After Navigation Print The URL:" +driver.getCurrentUrl());
			return true;
			}
		}catch (  NoSuchElementException  e){
			
			
		}
			
				
			//
			return false;
		}
		
		public void sendFirstName(String name){
           First_Name.clear();
           First_Name.sendKeys(name);
          // SaveAddress_Button.click();
           
		}
		public String getUpdateMessage(){
			
			   SaveAddress_Button.click();
	        return   Update_Message.getText();
		}
		
		
		public boolean logout(){
			
			if (Logout.isDisplayed()){
				
				Logout.click();
				return true;
			}
			
			return false;
		}
		
		
     public MyAccount myaccount(){
		return  new MyAccount();
		
		
	}


	
	
	
}
