package com.qa.testcase;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebElement;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.qa.base.Testbase;
import com.qa.pages.LoginPage;
import com.qa.pages.MyAccount;
import com.qa.utill.ExcelUtill;
import com.qa.utill.WebEventListener;

import junit.framework.Assert;
@Listeners (WebEventListener.class)
public class LoginTestCase extends Testbase{

	Logger log = Logger.getLogger(LoginTestCase.class);
	LoginPage loginpage;
	
	//ExcelUtill loginData = new ExcelUtill(System.getProperty ("user.dir")+prop.getProperty("TESTDATA_PATH"), "Sheet1");

	MyAccount myaccount;		
	
	String loginDataexcel[][];
	public  LoginTestCase(){
		super();
	}
	
	@BeforeMethod
	public void setup() throws Exception{
		//System.out.println("Excel Path: "+System.getProperty ("user.dir")+prop.getProperty("TESTDATA_PATH"));

		intialization();
		
		loginpage =new LoginPage();
		
		
	//	int col =loginData.excel_get_cols();
		//int row=loginData.excel_get_rows();	
	//	loginDataexcel= new String [row][col];

		/*for (int r = 1; r < row; r++) {
			for (int c = 0; c < col; c++) {
				loginDataexcel[r][c] = loginData.getCellDataAsString(r, c);
			}
		}*/
		}
	
	
	/*@Test
	public void VerifyIMG(){
		
		boolean flag = loginpage.LoginImg();
		Assert.assertTrue(flag);
		
		System.out.println("Test case done -----------------------******");
	}*/

	
	/*@Test
	public void VerifyTitle(){
		
		String Title = loginpage.ValidateLoginPageTitle();
		Assert.assertEquals(Title, "My Account – Automation Practice Site");
		System.out.println("Test case done -----------------------******");
		
		log.info("Test pass ");
	}*/
	//@Test
	/*1) Open the browser
	2) Enter the URL “http://practice.automationtesting.in/”
	3) Click on My Account Menu
	4) Enter registered username in username textbox
	5) Enter password in password textbox
	6) Click on login button
	7) User must successfully login to the web page*/
	/*public void ValidLogin(){
		
		myaccount=loginpage.login(prop.getProperty("username"), prop.getProperty("password"));
		System.out.println("Test case done -----------------------******");
	}*/
	
	
	/*1) Open the browser
	2) Enter the URL “http://practice.automationtesting.in/”
	3) Click on My Account Menu
	4) Enter incorrect username in username textbox
	5) Enter incorrect password in password textbox.
	6) Click on login button
	7) Proper error must be displayed(ie Invalid username) and prompt to enter login again*/
	
	/*@Test
	public void VerifyErrorMSG(){
		
		
		loginpage.login(prop.getProperty("UserName"), prop.getProperty("Password"));
		String text = loginpage.ErrorMSG();
		
		System.out.println(text);
		Assert.assertEquals(text, "Lost your password?");
		System.out.println("Test case done -----------------------******");
	}s
	*/
	/*@Test(priority=1)
	
	1) Open the browser
	2) Enter the URL “http://practice.automationtesting.in/”
	3) Click on My Account Menu
	4) Enter valid username in username textbox
	5) Now enter empty password in the password textbox
	6) Click on login button.
	7) Proper error must be displayed(ie Invalid password) and prompt to enter login again
	public void VerifyEmptyPassword(){
	
		loginpage.login(prop.getProperty("username"), prop.getProperty("password1"));
		String Text = loginpage.EmptyPasswordMSG();
		
		System.out.println(Text);
		
		Assert.assertEquals(Text, "Error: Password is requiredrrrr.");
		System.out.println("Test case done -----------------------******");

	}*/
	/*@Test
	public void EmptyUserNameAndPassword(){
		
		loginpage.login(prop.getProperty("UserNmaee"), prop.getProperty("Password"));
		
		String TextMsg = loginpage.EmptyUserAndPassword();
		
		System.out.println(TextMsg);
		
		
			Assert.assertEquals(TextMsg, "Error: Username is required.");
			
	
			
			
		
	}
	*/
	/*@Test
	
	public void PasswordMaskng(){
		
		loginpage.login(prop.getProperty("UserName"), prop.getProperty("Password"));
		
		String Get = loginpage.PasswordMask();
		System.out.println(Get);
		Get.equals("password");
		
	}*/
	
	@Test ()
	public void LoginAuthentication(){
		
             // loginpage.login(loginDataexcel[1][0], loginDataexcel[1][1]);
		       loginpage.login(prop.getProperty("username"), prop.getProperty("password"));
		        if (loginpage.isUserLoggedIn())
		        {
		        	loginpage.singout();
		        }
				
				
				String singouttitle = loginpage.singoutpagetitle();
			    System.out.println(singouttitle);
				loginpage.navigate();
				
				
	            if (singouttitle == "My Account – Automation Practice Site"){
					
					System.out.println("Test Pass");
		            //Assert.assertEquals(singouttitle, "My Account – Automation Practice Site");

				}else {
					
					System.out.println("fail the test case ");
				}
	}
	
	@AfterMethod
	public void quit(){
		
		
		driver.quit();
	}
}
