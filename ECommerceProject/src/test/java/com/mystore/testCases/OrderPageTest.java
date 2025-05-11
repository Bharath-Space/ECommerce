package com.mystore.testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.mystore.basec.BaseClass;
import com.mystore.pageObjects.AddtoCartPage;
import com.mystore.pageObjects.HomePage;
import com.mystore.pageObjects.IndexPage;
import com.mystore.pageObjects.LoginPage;
import com.mystore.pageObjects.OrderPage;
import com.mystore.pageObjects.SearchResultPage;

public class OrderPageTest extends BaseClass {
	IndexPage ip;
	LoginPage lp;
	HomePage hp;
	SearchResultPage sp;
	AddtoCartPage acp;
	OrderPage op;

	 @Test(groups="Regression")
	public void verifyTotalPrice() {
		ip = new IndexPage(getDriver()
);

//			lp = ip.clickOnSignin();
//			hp = lp.login(p.getProperty("username"), p.getProperty("password"));
		sp = ip.searchProduct(p.getProperty("Searchproduct"));
		acp = sp.clickOnProduct();

		acp.selectSize("L");
		acp.enterQauantity("1");

		acp.clickonAddtoCart();
		op = acp.clickOnCheckout();

		
		double unit = op.getUnitPrice();
		double shipping = op.getShippingPrice();
		double expectedTotal = unit + shipping;
		double actualTotal = op.getTotalPrice();
		
		System.out.println("Unit Price: $" + unit);
	    System.out.println("Shipping Price: $" + shipping);
	    System.out.println("Expected Total: $" + expectedTotal);
	    System.out.println("Actual Total: $" + actualTotal);
		Assert.assertEquals(actualTotal,  expectedTotal);
	}
}
