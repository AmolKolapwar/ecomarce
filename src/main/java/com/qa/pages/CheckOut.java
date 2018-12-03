package com.qa.pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

import com.qa.base.Testbase;
import com.qa.utill.WaitTool;

public class CheckOut extends Testbase{

	@FindBy(xpath="//h3[contains(.,'Billing Details')]")
	WebElement Billing_Details;
	
	@FindBy(xpath="//h3[contains(.,'Additional Information')]")
	WebElement Additional_Information;
	
	@FindBy(xpath="//h3[contains(.,'Your order')]")
	WebElement Your_Order;
	
	@FindBy(xpath = "//label[@for='payment_method_bacs'][contains(.,'Direct Bank Transfer')]")
	WebElement Payment_lable;
	
	@FindBy(xpath ="//a[contains(.,'Click here to enter your code')]")
	WebElement Coupan_Link;
	
	@FindBy(xpath="//input[@id='billing_first_name']")
	WebElement First_Name;
	
	@FindBy(xpath="//input[@id='billing_last_name']")
	WebElement Last_Name;
	
	@FindBy(xpath="//input[@id='billing_company']")
	WebElement Company_Name;
	
	@FindBy(xpath="//input[@id='billing_phone']")
	WebElement Phone_Number;
	
	@FindBy(xpath="//select[@id='billing_country']")
	WebElement  Country_Code;
	
	@FindBy(xpath="//input[@id='billing_address_1']")
	WebElement Address_Field1;
	
	@FindBy(xpath="//input[@id='billing_address_2']")
	WebElement Address_Filed2;
	
    @FindBy(xpath="//input[@id='billing_city']")
    WebElement City;
	
    @FindBy(xpath="//select[@id='billing_state']")
	WebElement  State;
    
  //  @FindBy(xpath="//ul[@class='wc_payment_methods payment_methods methods']")
    //List<WebElement> Payment_Options;
	
    @FindBy(xpath="//input[@id='billing_postcode']")
	WebElement Post_Code;
	
    
    @FindBy(xpath="//input[@id='place_order']")
    WebElement Place_OrderButton;
    
    @FindBy(xpath="//input[@id='payment_method_cod']")
    WebElement COD;
    @FindBy(xpath="//div[@class='woocommerce']//p[@class='woocommerce-thankyou-order-received']")
	WebElement SuccessMsg;

	public CheckOut(){
		
		PageFactory.initElements(driver, this);
	}
	
public  CheckOut goregistraction(){
		
		CheckOut checkout = new CheckOut();
		return checkout;
	}

public String Successmsg(){
	
	return SuccessMsg.getText();
	  
}
	public boolean FillAddressForPlaceOrder( ) throws InterruptedException 
	{
		
		/*First_Name.sendKeys(registrationDetails.getFirst_Name());
		Last_Name.sendKeys(registrationDetails.gatLast_Name());
		Company_Name.sendKeys(registrationDetails.getCompany_Name());
		Phone_Number.sendKeys(registrationDetails.getPhone_Number());
		Select country = new Select(Country_Code);
		country.selectByValue(registrationDetails.getCountry_Code());
		Address_Field1.sendKeys(registrationDetails.getAddress_Field1());
		Address_Filed2.sendKeys(registrationDetails.getAddress_Filed2());
		City.sendKeys(registrationDetails.getCity());
    	Select state = new Select(State);
		state.selectByValue(registrationDetails.getState());
		Post_Code.sendKeys(registrationDetails.getPost_Code());
		Place_OrderButton.click();
		if (driver.getCurrentUrl().equals("order-received"))
		return true;
		else
			return false;*/
		First_Name.sendKeys(prop.getProperty("First_Name"));
		
		Last_Name.sendKeys(prop.getProperty("Last_Name"));
		 Address_Field1.sendKeys(prop.getProperty("Address1"));
	     Address_Filed2.sendKeys(prop.getProperty("Address2"));
		 City.sendKeys(prop.getProperty("city"));
		 Company_Name.sendKeys(prop.getProperty("company"));
			//Select country = new Select(Country_Code);

		//	country.selectByValue(prop.getProperty("country"));
		 Phone_Number.sendKeys(prop.getProperty("phone"));
		 Post_Code.sendKeys(prop.getProperty("postcode"));
	//	 Actions action = new Actions(driver);
	//	WaitTool.waitForElementPresent(State, 10);
	//	action.moveToElement(State);
		// Thread.sleep(500);
	    //	Select state = new Select(State);

	    //	state.selectByValue(prop.getProperty("state"));
			//Place_OrderButton.sendKeys(Keys.RETURN);

		 return true;
	}
	
   public boolean  selectCOD(){
	   
	   if (COD.isDisplayed())
	   {
		   COD.click();
		   return true;
	   }
	return false;
   }
	public void selectPaymentMethod()
	{
		String paymentMethodName = null;
		boolean paymentMethodNotAvailable = false;
		List<WebElement> paymentMethods = driver.findElements(By.xpath("//ul[@class='wc_payment_methods payment_methods methods']"));
	     System.out.println("No. of payment methods - " + paymentMethods.size());
		
		for (WebElement paymentMethod:paymentMethods)
		{			
			System.out.println(paymentMethod.getText());
			if (paymentMethod.getText().equalsIgnoreCase(paymentMethodName))
			{
				paymentMethodNotAvailable = true;
				//System.out.println("Inside payment Method click " + paymentMethod.getText());
				WebElement selectedPaymentMethod = paymentMethod.findElement(By.xpath("//input[@id='payment_method_cod']"));
				selectedPaymentMethod.click();
				if (selectedPaymentMethod.isSelected())
				{
					System.out.println("payment method selected is " + paymentMethod.getText());
					
				}
				else
				{	
			      System.out.println("payment method did not get selected " + paymentMethod.getText());
					
				}
			} 
			
		}
		if (!paymentMethodNotAvailable)
		{
			System.out.println("Payment method - '" + paymentMethodName + "' not available as an option");
			
			Assert.assertTrue(paymentMethodNotAvailable);
		}
		
	}
	
	
	public boolean selectPaymentMethodtwo() throws InterruptedException{
		
		List<WebElement> paymentMethods = driver.findElements(By.xpath("//ul[@class='wc_payment_methods payment_methods methods']"));
	     System.out.println("No. of payment methods - " + paymentMethods.size());
		
		for (WebElement paymentMethod:paymentMethods)
		{		
			
			String payment =paymentMethod.getText();
			System.out.println("Print the all Payment Method: " +payment);	
			
			
				System.out.println("Print the Method:"+COD.getText());
				
				COD.click();
				Thread.sleep(500);
				return true;
			
		}
		return false;
		
	}
	public  boolean continueCheckout(boolean pleasefillbillingAndShipping) throws InterruptedException {
		if (pleasefillbillingAndShipping)
		{
			FillAddressForPlaceOrder();
			
			
		}
		
		Place_OrderButton.click();
		return pleasefillbillingAndShipping;
		
		
		 
						
	}

	/*public  void selectShippingMethod(String selectmethodName){
		
		List<WebElement> selectMethod = driver.findElements(By.xpath("//ul[@class='wc_payment_methods payment_methods methods']"));
		
		for (WebElement shippingMethod:selectMethod){
			System.out.println("Shipping Method" + shippingMethod.getText());
			if (shippingMethod.getText().equalsIgnoreCase(selectmethodName))
			{
				//System.out.println("Insite shipping Method click " + shippingMethod.getText());
			System.out.println("Inside shipping Method -" + shippingMethod.getText());
				shippingMethod.click();
			}
		}
	}*/

	public  HomePage  elementDisplayed(){
		try{
		if(Billing_Details.isDisplayed()){
			System.out.println("Billing_Details Displayed");
		}
		if(Additional_Information.isDisplayed()){
			System.out.println("Additional_Information Displayed");
		}
		if(Your_Order.isDisplayed()){
			System.out.println("Your_Order Lable Displayed");
		}
		if(Payment_lable.isDisplayed()){
			System.out.println("Payment_lable Lable Displayed");
		}
		
		if (Coupan_Link.isDisplayed()){
			
			System.out.println("Coupan_Link Link Displayed");
		}
		else{
			
			System.out.println("Element Not Displayed ");
		}
		}catch(Exception e){
			System.out.println(e);
		}
		
	    return new HomePage();
	}
	

	
}


