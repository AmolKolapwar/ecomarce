package com.qa.pages;

import java.util.List;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.qa.base.Testbase;
import com.qa.utill.WaitTool;

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
