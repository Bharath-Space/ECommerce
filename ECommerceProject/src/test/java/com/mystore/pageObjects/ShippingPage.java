package com.mystore.pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.mystore.actiondriver.Action;
import com.mystore.basec.BaseClass;

public class ShippingPage extends BaseClass {

	public ShippingPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
		// TODO Auto-generated constructor stub
	}

	@FindBy(xpath = "//div[@id='uniform-cgv']")
	WebElement terms;
	@FindBy(xpath = "//button[@class='button btn btn-default standard-checkout button-medium']")
	WebElement ProccedToCheckout;
	public void checktheTerms() {
		Action.click(getDriver()
, terms);
	}
	
	public PayementPage clickonProcced() {
		Action.click(getDriver()
, ProccedToCheckout);
		
		return new PayementPage(getDriver()
);
	}
}
