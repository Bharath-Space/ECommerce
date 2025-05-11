package com.mystore.testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.mystore.basec.BaseClass;
import com.mystore.pageObjects.AccountCreationPage;
import com.mystore.pageObjects.IndexPage;
import com.mystore.pageObjects.LoginPage;

public class AccountCreationTest extends BaseClass {
	IndexPage ip;
	LoginPage lp;

	AccountCreationPage ap;
@Test(groups="Sanity")
	public void createAccount() {
		ip = new IndexPage(getDriver()
);
		lp = ip.clickOnSignin();

		ap = lp.createnewAcccount(p.getProperty("email"));

		boolean result = ap.ValidateAccountCreatePAge();
		System.out.println("Validate:" + result);
		Assert.assertTrue(result);

	}
}