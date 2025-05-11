package com.mystore.testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.mystore.basec.BaseClass;
import com.mystore.dataProvider.DataProviders;
import com.mystore.pageObjects.HomePage;
import com.mystore.pageObjects.IndexPage;
import com.mystore.pageObjects.LoginPage;

public class LoginPageTest extends BaseClass {
	IndexPage ip;
	LoginPage lp;
	HomePage hp;

	@Test(groups = { "Smoke", "Sanity" })
	public void loginTest() {

		ip = new IndexPage(getDriver());

		lp = ip.clickOnSignin();
		hp = lp.login(p.getProperty("username"), p.getProperty("password"));
	
		String ActualUrl = hp.getCurrUrl();

		String expectedURl = "http://www.automationpractice.pl/index.php?controller=my-account";

		Assert.assertEquals(ActualUrl, expectedURl);
		System.out.println("Expected url:" + expectedURl);

	}
}
