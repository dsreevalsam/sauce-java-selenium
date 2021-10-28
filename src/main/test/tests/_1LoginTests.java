package main.test.tests;


import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import main.java.sauce.pages._1LoginPage;
import main.java.sauce.pages._2InventoryPage;
import main.test.core.BasicTestObject;

public class _1LoginTests extends BasicTestObject{

	 @DataProvider (name = "username")
     public Object[][] dpMethod(){
	 return new Object[][] {{"standard_user"}, {"performance_glitch_user"}};
     }
	
	@Test(dataProvider = "username")
	public void _01validateUserLogin(String username) {
		_1LoginPage loginPage=new _1LoginPage(driver);
		loginPage.gotoLoginPage(getInputProperty("appurl"));
		_2InventoryPage invPage=loginPage.login(username, "secret_sauce");
		Assert.assertTrue(invPage.isInventoryLoaded());
		invPage.logout();
	}
	
	@Test
	public void _02validateLockedUserLogin() {
		_1LoginPage loginPage=new _1LoginPage(driver);
		loginPage.gotoLoginPage(getInputProperty("appurl"));
		_2InventoryPage invPage=loginPage.login("locked_out_user", "secret_sauce");
		Assert.assertEquals(loginPage.getErrorMessage(),"Epic sadface: Sorry, this user has been locked out.");
	}
	
	

}
