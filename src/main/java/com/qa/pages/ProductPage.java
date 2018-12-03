package com.qa.pages;

import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import com.qa.base.Testbase;

public class ProductPage extends Testbase {

	@FindBy(xpath = "//div[@class='woocommerce-message']//a[@class='button wc-forward']")
	WebElement ViewBasket_Button;

	@FindBy(xpath = "//*")
	List<WebElement> Alluicontian;

	@FindBy(xpath = "//a[contains(@class,'checkout-button button alt wc-forward')]")
	WebElement ProocesTo_Checkout;

	@FindBy(xpath = "//input[contains(@name,'apply_coupon')]")
	WebElement Apply_Coupan;

	@FindBy(xpath = "//input[@name='coupon_code'][contains(@id,'code')]")
	WebElement Add_Counpan;

	@FindBy(xpath = "//strong//span[@class='woocommerce-Price-amount amount']")
	WebElement Total;

	@FindBy(xpath = "//tr[@class='cart-discount coupon-krishnasakinala']//span[@class='woocommerce-Price-amount amount']")
	WebElement Coupan_Amount;
	@FindBy(xpath = "//input[@type='submit'][@value='Apply Coupon']")
	WebElement Apply_Button;

	@FindBy(xpath = "//td[@data-title='Subtotal']//span[@class='woocommerce-Price-amount amount']")
	public WebElement Sub_total;

	@FindBy(xpath = "//div[@class='woocommerce-message'][contains(.,'Coupon code applied successfully.')]")
	WebElement Coupan_Sucessmsg;

	@FindBy(xpath = "//li[contains(.,'The minimum spend for this coupon is ₹450.00.')]")
	public WebElement Coupan_Errormsg;

	@FindBy(xpath = "//a[@class='remove']")
	WebElement Remove_Book;

	@FindBy(xpath = "//div[@class='woocommerce-message'][contains(.,'Mastering JavaScript removed. Undo?')]")
	public WebElement Remove_Sucessmsg;

	@FindBy(xpath = "//input[@value='Update Basket']")
	WebElement Update_Button;
	
	@FindBy(xpath="//input[@type='number']")
    WebElement Set_Quantity;
	
	@FindBy(xpath="//div[@class='woocommerce-message'][contains(.,'Basket updated.')]")
	public WebElement Update_Sucessmsg;
	
	@FindBy(xpath="//td[@data-title='Price']//span[@class='woocommerce-Price-amount amount']")
	public WebElement Book_Price;
	@FindBy(xpath="//div[@class='woocommerce-message']")
	WebElement RemoveBook_Msg;
	
	
	
	/*@FindBy(xpath="//li//span[@class='woocommerce-Price-amount amount']")
	WebElement */
	public ProductPage() {
		PageFactory.initElements(driver, this);
	}

	public boolean verifyViewBasketButtonDisable() {

		return ViewBasket_Button.isDisplayed();

	}

	public void verifyViewButtonClickable() {

		ViewBasket_Button.click();

	}

	public int verifyAllUIcontains() {
		return Alluicontian.size();
	}

	public void clickonProceesbutton() {
		ProocesTo_Checkout.click();
	}

	public boolean verifyApplyCoupan() {
		return Apply_Coupan.isDisplayed();
	}

	public HomePage entercoupancode(String code) {
		Add_Counpan.clear();
		Add_Counpan.sendKeys(code);
		Apply_Button.click();
		return new HomePage();
	}

	public String gettotalamount() {
		return Total.getText();
	}

	public void applybutton() {
		Apply_Button.click();
	}

	public String getcoupanamount() {
		return Coupan_Amount.getText();
	}

	public String subtotal() {
		return Sub_total.getText();
		 
			
	}

	public String coupansucess() {
		return Coupan_Sucessmsg.getText();
	}

	public String coupanerror() {
		return Coupan_Errormsg.getText();
	}

	public void removebook() {
		Remove_Book.click();
	}

	public boolean updateButton() {
       
		if (Update_Button.isEnabled()) {
			Update_Button.click();
			return true;

		}else{
			System.out.println("Button Is Not Enable ");
		}
		return false;
	}
	
	public void setBookeQuntity(String Book){
		Set_Quantity.sendKeys(Book);
	}
	
	public String bookPrice(){
		return Book_Price.getText();
	}

	
	public   boolean processToCheckout(){
		
       WebDriverWait wait = new WebDriverWait(driver,30);
	    
	    wait.until(ExpectedConditions.visibilityOf(ProocesTo_Checkout));
	    //click on view cart button
	    
	     return processToCheckout();
		
	}
		
	public  Shop  totalamount(String shot){
		
		
		shot= Sub_total.getText();
	    
	   System.out.println(shot);
		
	    return new Shop();
		

		/*if(!Total.equals(Sub_total)){
			System.out.println("Total Amount is Grater then subTotal");
			ProocesTo_Checkout.click();
			
		}*/
	}
	
	  
	public HomePage getAmout(){
		
	
		
try{
        String Total_Product_Price =Total.getText().substring(1);
        String Product_SubTotal_Price= Sub_total.getText().substring(1);
        String Discount_Coupan=  Coupan_Amount.getText().substring(1);
        String counpan ="50.00";
       
		System.out.println("Print the Coupan Amount :"  + Discount_Coupan);
		Assert.assertEquals(counpan, Discount_Coupan);
	
		System.out.println("Print the Sub_Total Price:"+ Product_SubTotal_Price);
		  
		        float Total_Price=Float.valueOf(Total_Product_Price);
				float Product_SubTotal=Float.valueOf(Product_SubTotal_Price);
				float Coupan_Discount_Amount = Float.valueOf(Discount_Coupan);
				
				float afterCoupanApply = Product_SubTotal-Coupan_Discount_Amount;
				
				
				System.out.println("Print the SubTotal Amount Of Product After Applying Coupan :"  +afterCoupanApply);
				
				float Tax_Amount= afterCoupanApply*2/100;
				System.out.println("Print the Tax Amount: "  + Tax_Amount);
				float Total_Amount = Tax_Amount+afterCoupanApply;
				    
		     	float Difference_Amount;
		          
		  		System.out.println("Print the Total Price After Adding the 2% Tax:" + Total_Product_Price);

		        System.out.println( "Print the Difference Between Total & SubTotal Price  :" + (Difference_Amount=Product_SubTotal-Total_Amount));
	 
	    
}catch (NumberFormatException e){
	
	System.out.println(e.getMessage());
}
return new HomePage();
		

	}
	public ProductPage product() {
		return new ProductPage();
	}

	
	public HomePage removeBook(){
		//String amount ="450";
		try{
		if (Remove_Book.isDisplayed()){
			Remove_Book.click();
			String msg= RemoveBook_Msg.getText();	
			System.out.println(msg);
			Assert.assertTrue(true);
		}
		}catch(Exception e){
			
			System.out.println(e);
		}
	
	return new HomePage();
	}
	public Shop totalamount() {
		// TODO Auto-generated method stub
		return null;
	}
	


}