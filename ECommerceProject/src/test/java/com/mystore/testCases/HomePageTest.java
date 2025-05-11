package com.mystore.testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.mystore.basec.BaseClass;
import com.mystore.pageObjects.HomePage;
import com.mystore.pageObjects.IndexPage;
import com.mystore.pageObjects.LoginPage;

public class HomePageTest extends BaseClass {
	IndexPage ip;
	LoginPage lp;
	HomePage hp;
	 @Test(groups="Smoke")
	public void verifyOrderHistory() {
		ip = new IndexPage(getDriver()
);
		lp = ip.clickOnSignin();
		
		hp = lp.login(p.getProperty("username"), p.getProperty("password"));
		boolean result = hp.validateOrderHistory();
		System.out.println("Display:" + result);
		Assert.assertTrue(result);

	}

}
