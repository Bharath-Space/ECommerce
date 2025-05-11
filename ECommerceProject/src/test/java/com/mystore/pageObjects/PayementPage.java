package com.mystore.pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.mystore.actiondriver.Action;
import com.mystore.basec.BaseClass;

public class PayementPage extends BaseClass{

	public PayementPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
		// TODO Auto-generated constructor stub
	}

	@FindBy(xpath = "//a[@title='Pay by bank wire']")
	WebElement payByBankwire;
	
	
	@FindBy(xpath = "//a[@title='Pay by check']")
	WebElement payByCheck;
	
	
	public OrderSummaryPage clickOnPayement() {
		Action.click(getDriver()
, payByBankwire);
		return new OrderSummaryPage(getDriver()
);
	}
}
