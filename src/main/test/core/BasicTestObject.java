package main.test.core;

import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;


public class BasicTestObject extends TestBase{
	
	@BeforeSuite
	public void beforeSuite() {
	}

	@BeforeTest
	public void beforeTest() {
		System.out.println("before test");
		initWebDriver(getConfigProperty("browser"));
		
		
	}

	@BeforeMethod
	public void beforeMethod() {
		
	}

	@AfterTest
	public void afterTest() {
//		System.out.println("After Test");

	}

	@BeforeClass
	public void beforeClass() {
		driver.get(getInputProperty("appurl"));
		}


	@AfterClass
	public void afterClass() {
		} 

	

	@AfterSuite
	public void afterSuite() {
		driver.quit();
	}



}
