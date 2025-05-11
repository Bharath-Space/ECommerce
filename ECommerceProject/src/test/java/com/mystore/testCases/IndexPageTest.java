package com.mystore.testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.mystore.basec.BaseClass;
import com.mystore.pageObjects.IndexPage;

public class IndexPageTest extends BaseClass {
    IndexPage ip;

    @Test(groups="Smoke")
    public void verifyLogo() {
    	
    	
        ip = new IndexPage(getDriver()
); // ✅ initialize class-level variable with driver
        boolean result = ip.validateLogo();
        Assert.assertTrue(result);
    }

    @Test(groups="Smoke")
    public void verifyTitle() {
        ip = new IndexPage(getDriver()
); // ✅ initialize here too, if not using @BeforeMethod
        String act_title = ip.getMyStoreTitle();
        System.out.println("Actual Title is:" +act_title);
        Assert.assertEquals(act_title, "My Shop");
    }
}
