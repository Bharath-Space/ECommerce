package com.mystore.testCases;

import java.time.Duration;

import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.mystore.basec.BaseClass;
import com.mystore.pageObjects.AddtoCartPage;
import com.mystore.pageObjects.HomePage;
import com.mystore.pageObjects.IndexPage;
import com.mystore.pageObjects.LoginPage;
import com.mystore.pageObjects.SearchResultPage;

public class AddtoCartPageTest extends BaseClass {
	IndexPage ip;
	LoginPage lp;
	HomePage hp;
	SearchResultPage sp;
	AddtoCartPage acp;
	 @Test(groups={"Regression","Smoke"})
	public void addtocart() throws InterruptedException {
		ip = new IndexPage(getDriver());
		sp = ip.searchProduct(p.getProperty("Searchproduct"));
		acp = sp.clickOnProduct();

		acp.selectSize("M");
		acp.enterQauantity("1");

		acp.clickonAddtoCart();

		WebDriverWait wait = new WebDriverWait(getDriver(), Duration.ofSeconds(10));
		wait.until(ExpectedConditions.visibilityOf(acp.getAddtoCartMessage()));

		boolean result = acp.validateAddtoCart();
		Assert.assertTrue(result, "Product was not added to cart");

		// ✅ Proceed to checkout to actually verify the cart
		acp.clickOnCheckout();
		Thread.sleep(5000);// Navigate to the cart page

		// Optional: add an assertion for cart page content here
	}
}
