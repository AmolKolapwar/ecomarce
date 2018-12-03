package com.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.qa.base.Testbase;
import com.qa.utill.WaitTool;
public class LoginPage extends Testbase{
	
	
	@FindBy(xpath = "//input[contains(@name,'username')]")
	WebElement Username;
	
	@FindBy(xpath = "//input[@id='password']")
	WebElement Password;
	
	@FindBy(xpath = "//input[@name='login']")
	WebElement Login;
	
	@FindBy(xpath = "//a[contains(.,'Lost your password?')]")
	WebElement ForgoPassword;
	
	@FindBy(xpath = "//label[@for='rememberme'][contains(.,'Remember me')]")
	WebElement RememberText;
	
	@FindBy(xpath = "//input[contains(@class,'woocommerce-Input woocommerce-Input--checkbox')]")
	WebElement Checkbox;
	
	@FindBy(xpath = "//h2[contains(.,'Login')]")
	WebElement LoginText;
	
	@FindBy(xpath = "//ul[@class='woocommerce-error']//li//a[contains(@href, 'http://practice.automationtesting.in/my-account/lost-password/')]")
	WebElement ErrorMSG;
	//a[contains(.,'Logout')]
	
	
	
	//@FindBy(xpath = "//li[contains(.,'Error: Password is required.')]")
	
	@FindBy(xpath="//ul[@class='woocommerce-error']//li")
	WebElement EmptyPassowrdMSG;
	
	
	@FindBy(xpath="//a[contains(text(),'Sign out')]")
	WebElement sign_Out;
	
	public LoginPage(){
		
		PageFactory.initElements(driver, this);
	}
	public String ValidateLoginPageTitle(){
	
		return driver.getTitle();
	
	}
	
	public boolean LoginImg(){
		
		return LoginText.isDisplayed();
	}
	
	public String ErrorMSG(){
		
		return  ErrorMSG.getText();
		
        
	}
	
	public String EmptyPasswordMSG(){
		return EmptyPassowrdMSG.getText();
	}
	
	public String EmptyUserAndPassword(){
		
	return 	EmptyPassowrdMSG.getText();
	}
	
	
	public String   PasswordMask(){
		
return Password.getAttribute("type") ;
	}
	
	public boolean isUserLoggedIn()
	{			
	 	if ( WaitTool.waitForElementPresent(sign_Out, 5) )
	 	{		 	
	 		return true;
	 	}
	 	else
	 	{		 		
	 		return false;
	 	}
	}
	
	 public LoginPage doSignOut()
	 {
		 if (isUserLoggedIn())
		 {
			 sign_Out.click();
			LoginPage signInPage = new LoginPage();
			return signInPage;
		 }
		 else
		 {
			 System.out.println("Nobody is singed in so cannot signOut");
			 return null;
		 }
	 }
	public void singout(){
		sign_Out.click();
		
	}
	
public String singoutpagetitle(){
	
	return driver.getTitle();
	
	
}
	
	public MyAccount login(String name,String password){
		
		Username.sendKeys(name);
		Password.sendKeys(password);
		Login.click();
	
		return  new MyAccount();
		
	}
	
	
}
