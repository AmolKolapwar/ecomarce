package com.qa.testcase;

import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import junit.framework.Assert;

public class TestSoftAssert {

	
	//public static void main(String[] args) {
		
		

	
		@Test
		public void testing(){
			System.out.println("Open the browser");
			
			SoftAssert sift = new SoftAssert ();
			
			//Assert.assertEquals(true, false);
		sift.assertEquals(true, false,"Test not excute");
			System.out.println("Click on Image");
		
			
		}
		
}
