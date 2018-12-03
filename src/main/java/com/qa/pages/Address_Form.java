package com.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import com.qa.base.Testbase;

public class Address_Form extends Testbase{

	
	
	 private String First_Name;
	 private String Last_Name;
	 private String Company_Name;
	 private String Phone_Number;
	 private String Country_Code;
	 private String Address_Field1;
	 private String Address_Filed2;
	 private String City;
	 private String State;
	 private String Post_Code;

	
	 public String getFirst_Name() {
			return First_Name;
		}
		public void setFirst_Name(String email) {
			this.First_Name = First_Name;
		}
	
    public  String gatLast_Name(){	
    	return Last_Name;
    }
 
    public void setLast_Name(String Last_Name){
    	this.Last_Name = Last_Name;
    }
   
    
    public  String getPhone_Number(){
    	return Phone_Number;
    }
 
    public void setPhone_Number(String Phone_Number){
    	this.Phone_Number = Phone_Number;
    }
    
    
    public  String getCompany_Name(){
    	return Company_Name;
    }
 
    public void setCompany_Name(String Company_Name){
    	this.Company_Name = Company_Name;
    }
    
    
    public  String getCountry_Code(){
    	return Country_Code;
    }
 
    public void setCountry_Code(String Country_Code){
    	this.Country_Code = Country_Code;
    }
    
    public  String getAddress_Field1(){
    	return Address_Field1;
    }
 
    public void setAddress_Field1(String Address_Field1){
    	this.Address_Field1 = Address_Field1;
    }
   
    public  String getAddress_Filed2(){
    	return Address_Filed2;
    }
 
    public void setAddress_Filed2(String Address_Filed2){
    	this.Address_Filed2 = Address_Filed2;
    }
    
    
    public  String getCity(){
    	return City;
    }
 
    public void setCity(String City){
    	this.City = City;
    }
    
    public  String getState(){
    	return State;
    }
 
    public void setState(String State){
    	this.State = State;
    }
    
    public  String getPost_Code(){
    	return Post_Code;
    }
 
    public void setPost_Code(String Post_Code){
    	this.Post_Code = Post_Code;
    }
} 
    