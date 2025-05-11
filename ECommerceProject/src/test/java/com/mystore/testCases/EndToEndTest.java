package com.mystore.testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.mystore.basec.BaseClass;
import com.mystore.pageObjects.AddtoCartPage;
import com.mystore.pageObjects.AdresssPage;
import com.mystore.pageObjects.HomePage;
import com.mystore.pageObjects.IndexPage;
import com.mystore.pageObjects.LoginPage;
import com.mystore.pageObjects.OrderPage;
import com.mystore.pageObjects.OrderPageConfirmationPage;
import com.mystore.pageObjects.OrderSummaryPage;
import com.mystore.pageObjects.PayementPage;
import com.mystore.pageObjects.SearchResultPage;
import com.mystore.pageObjects.ShippingPage;

public class EndToEndTest extends BaseClass {
	IndexPage ip;
	LoginPage lp;
	HomePage hp;
	SearchResultPage sp;
	AddtoCartPage acp;
	OrderPage op;
	AdresssPage ap;
	ShippingPage shp;
	PayementPage pm;
	OrderSummaryPage os;
	OrderPageConfirmationPage ocp;
	
	 @Test(groups="Regression")
	public void endToEndTest() {

		ip = new IndexPage(getDriver()
);

//		lp = ip.clickOnSignin();
//		hp = lp.login(p.getProperty("username"), p.getProperty("password"));
		sp = ip.searchProduct(p.getProperty("Searchproduct"));
		acp = sp.clickOnProduct();

		acp.selectSize("L");
		acp.enterQauantity("1");

		acp.clickonAddtoCart();
		op = acp.clickOnCheckout();
		lp = op.clickOnCheckout();
		ap = lp.login1(p.getProperty("username"), p.getProperty("password"));
		shp = ap.ClickonChecout();
		
		
		shp.checktheTerms();
		pm = shp.clickonProcced();
		os = pm.clickOnPayement();
		ocp = os.ClickOnconfirmButton();
		String actualMsg = ocp.validConfirmationMessage();
		System.out.println(actualMsg);
		String expectedmsg = "Your order on My Shop is complete.";

		Assert.assertEquals(actualMsg, expectedmsg);

	}

}
