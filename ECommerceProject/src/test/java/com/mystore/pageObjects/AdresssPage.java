package com.mystore.pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.mystore.actiondriver.Action;
import com.mystore.basec.BaseClass;
public class AdresssPage extends BaseClass {

	public AdresssPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//button[@name='processAddress']//span[contains(text(),'Proceed to checkout')]")
	WebElement proccedtoCheckout;

	public ShippingPage ClickonChecout() {
		// Scroll to the element
		Action.scrollByVisibilityOfElement(getDriver()
, proccedtoCheckout);

		// Click the element
		Action.click(getDriver()
, proccedtoCheckout);

		// Return next page object
		return new ShippingPage(getDriver()
);
	}
}
