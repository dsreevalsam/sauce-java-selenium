package main.test.tests;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import main.java.sauce.pages._1LoginPage;
import main.java.sauce.pages._2InventoryPage;
import main.java.sauce.pages._3ProductDetails;
import main.java.sauce.pages._4CartPage;
import main.java.sauce.pages._5UserInfoPage;
import main.java.sauce.pages._6CheckoutOverview;
import main.java.sauce.pages._7CheckoutCompletePage;
import main.test.core.BasicTestObject;

public class _2AddProductsAndCheckoutTest extends BasicTestObject{
	
	 @DataProvider (name = "username")
     public Object[][] dpMethod(){
	 return new Object[][] {{"standard_user"}, {"problem_user"}};
     }
	
	@Test(dataProvider = "username")
	public void validateAddProduct(String username) throws InterruptedException {
		_1LoginPage loginPage=new _1LoginPage(driver);
		loginPage.gotoLoginPage(getInputProperty("appurl"));
		
		_2InventoryPage invPage=loginPage.login(username, "secret_sauce");
		String price=invPage.getPriceOfProduct("Sauce Labs Backpack");
		_3ProductDetails detailsPage=invPage.openProduct("Sauce Labs Backpack");
		
		Assert.assertEquals(detailsPage.getName(), "Sauce Labs Backpack");
		Assert.assertEquals(detailsPage.getPrice(), price);
		detailsPage.addOrRemoveCart();
		Assert.assertEquals(detailsPage.getCartItems(), "1");
		
		
		_4CartPage cart=detailsPage.gotoCart();
		Assert.assertEquals(cart.getName(), "Sauce Labs Backpack");
		Assert.assertEquals(cart.getPrice(), price);
		
		_5UserInfoPage userPage=cart.checkout();
		userPage.addUserinfo("user name", "last name", "12345");
		
		_6CheckoutOverview checkout=userPage.continueToCheckout();
		Assert.assertEquals(checkout.getName(), "Sauce Labs Backpack");
		Assert.assertEquals(checkout.getPrice(), price);
		Assert.assertEquals(checkout.getTotal(), "Total: $32.39");
		
		_7CheckoutCompletePage complete=checkout.finish();
		Assert.assertEquals(complete.getSuccessMessage(),"THANK YOU FOR YOUR ORDER");


	}

}
