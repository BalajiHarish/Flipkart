package com.qa.testcases;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import com.qa.driver.DriverClass;

public class BaseTest {
	
	protected BaseTest() {
		
	}

	@BeforeMethod
	protected void setUp() throws Exception { 
		
		DriverClass.initializeDriver("chrome", "https://www.flipkart.com/");
	}

	@AfterMethod
	protected void tearDown() {

		DriverClass.quitDriver();
	}

}
