package com.qa.pages;

import static org.testng.Assert.assertTrue;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.qa.base.Testbase;
import com.qa.utill.WaitTool;

import junit.framework.Assert;

public class HomePage extends Testbase   {
	
	Actions action = new Actions(driver);
	@FindBy (xpath ="//a[@title='Automation Practice Site']")
	WebElement HomaPageLink;
	
	@FindBy (xpath="//div[@id='n2-ss-6-arrow-next']")
	WebElement NextArrow;
	
	@FindBy (xpath="//div[@id='n2-ss-6-arrow-previous']")
	WebElement PreviousArrow;
	
	
	@FindBy(xpath="//*[@class='row_inner_wrapper']")
    List <WebElement> Slidercout;
	
	@FindBy(xpath="//ul[@class='products']")
	List<WebElement>NewArrival;
	
	@FindBy(xpath = "//img[contains(@title,'Selenium Ruby')]")
	WebElement imgProductOne;
	
	@FindBy (xpath ="//ul[@class='tabs wc-tabs']//*[contains(text(),'Description')]")
	//@FindBy(xpath="//a[contains(.,'Description')]")
	WebElement Description;
	
	
	//@FindBy (xpath="//li[@class='reviews_tab']//*[contains(text(),'Reviews (0)')]")
	@FindBy (xpath="//a[contains(.,'Reviews (0)')]")
	WebElement Review;
	
	@FindBy(xpath="//div[@id='tab-description']")
	WebElement ProductDescription;
	
	
	@FindBy (xpath="//button[@type='submit']")
	WebElement AddToBasket;
	
	@FindBy (xpath="//div[@class='woocommerce-message']//a[@class='button wc-forward']")
	WebElement ViewBasketButton;
	
	
	@FindBy (xpath="//input[@type='number']")
	WebElement AddBookNumber;
	
	@FindBy(xpath="//p[@class='stock in-stock']")
	WebElement StockNumber;
	@FindBy (xpath="//input[@title='Qty']")
    WebElement ErroMSG;
	
	@FindBy(xpath="//img[contains(@alt,'Mastering JavaScript')]")
	WebElement Booke_Third;
	 
	@FindBy(xpath="/img[contains(@alt,'Mastering JavaScript')]")
	public WebElement Testing;
	
	@FindBy(xpath="//img[contains(@title,'Mastering JavaScript')]")
	WebElement Book_Belwo_450;
	@FindBy(xpath="//a[@class='checkout-button button alt wc-forward']")
	WebElement Proceed_Checkout;
	public HomePage() {
		PageFactory.initElements(driver, this);
	}
	
	
	public void clickOnHomePage(){
		HomaPageLink.click();		
}
	
	
	public String Homepagetitle(){	
		return driver.getTitle();
}
	
	public void SliderDispalyed(){
		
		PreviousArrow.isDisplayed();
		NextArrow.isDisplayed();
	}
	
	public int  slidercount(){
	   return Slidercout.size();
	}
	
	public int newarrival(){
		return NewArrival.size();
	}
	
	public boolean descriptiondisable(){
         return Description.isEnabled();
	}
	
	public void descriptionclick(){
		
		Actions action = new Actions(driver);
		action.moveToElement(Description).click().build().perform();
		//Description.click();	
}
	
	
	public String productDescription(){
		return ProductDescription.getText();
}
	
	
	public boolean reviewoptiondisable(){
		return Review.isDisplayed();
}
	
	
	public void reviewclick(){
		Actions action = new Actions(driver);
	    action.moveToElement(Review).click().build().perform();
}
	
	
	public String reviewtext(){
		return Review.getText();
}
	
	
	public void clickAddBasket(){
		action.moveToElement(AddToBasket).build().perform();
		
		WaitTool.click(AddToBasket, 10);
		//AddToBasket.click();
	}
	
	public boolean viewbasketbutton(){
		return ViewBasketButton.isDisplayed();
	}
	
	public String addbookmessage(){
		return ViewBasketButton.getText();
	}
	
	
	public void invalidstocknumber(String stocknum){
		
		AddBookNumber.clear();
		AddBookNumber.click();
		AddBookNumber.sendKeys(stocknum);
		AddBookNumber.getText();
	}
	
	public String stockNumber(){
		
	return	StockNumber.getText();
	}
	
	
	public String  errorMSG(){
		JavascriptExecutor js = (JavascriptExecutor)driver;

		WebElement field = ErroMSG;
		Boolean is_valid = (Boolean)js.executeScript("return arguments[0].checkValidity();", field);
	   String message = (String)js.executeScript("return arguments[0].validationMessage;", field);
	      System.out.println(message);
	    return message;
	   //  return is_valid;
	}

	
	public void selectThirdbook(){
		
		Booke_Third.click();
	}
public ProductPage  selectfromnewarrivals(){
	 WaitTool.click(imgProductOne, 10);
	  return  new ProductPage();
		
	}

public void selectBook(){
	Book_Belwo_450.click();
}



public boolean verifyUI(){

	boolean flag2 = false;
	List<WebElement> ElementsList = driver.findElements(By.tagName("body"));
	

	String[] tempList = ElementsList.get(0).getText().split("\n");



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
	expectedResult.add("SUBSCRIBE HERE");
	expectedResult.add("© Automation Practice Site 2018");

	for (int k = 0; k < expectedResult.size(); k++) {
		Boolean flag = false;
		for (int i = 0; i < tempList.length; i++) {

		if (tempList[i].equalsIgnoreCase(expectedResult.get(k))) {
				System.out.println(tempList[i]);
				System.out.println(expectedResult.get(k));
				Assert.assertEquals(tempList[i], expectedResult.get(k));
				flag = true;
				break;

		}
			
			

		}
		if(!flag){
			System.out.println("Not Found "+expectedResult.get(k));
		}
		flag2=flag;
		
		

	}
return flag2;
}



public CheckOut proceedchekout(){
	if(Proceed_Checkout.isEnabled()){
		WaitTool.click(Proceed_Checkout, 10);
		
	}else{
		System.out.println("Proceed To Checkout Button Disable");
	}
	driver.getTitle();
	return new CheckOut();
}
}
