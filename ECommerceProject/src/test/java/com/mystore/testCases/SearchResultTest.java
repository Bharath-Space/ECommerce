package com.mystore.testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.mystore.basec.BaseClass;
import com.mystore.pageObjects.HomePage;
import com.mystore.pageObjects.IndexPage;
import com.mystore.pageObjects.LoginPage;
import com.mystore.pageObjects.SearchResultPage;

public class SearchResultTest extends BaseClass {
	IndexPage ip;
	LoginPage lp;
	HomePage hp;
	SearchResultPage sp;

//	Printed Chiffon Dress
	 @Test(groups="Smoke")
	public void productAvailabilty() {

		ip = new IndexPage(getDriver()
);
		sp = ip.searchProduct(p.getProperty("Searchproduct"));
		boolean result = sp.isproductAvailable();
		System.out.println("product:" + result);
		Assert.assertTrue(result);
	}

}
