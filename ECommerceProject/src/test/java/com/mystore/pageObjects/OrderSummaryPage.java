package com.mystore.pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.mystore.actiondriver.Action;
import com.mystore.basec.BaseClass;

public class OrderSummaryPage extends BaseClass {

	public OrderSummaryPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
		// TODO Auto-generated constructor stub
	}

	@FindBy(xpath = "//span[normalize-space()='I confirm my order']")
	WebElement ConifrmOrderBtn;
	
	public OrderPageConfirmationPage ClickOnconfirmButton() {
		
		Action.click(getDriver()
, ConifrmOrderBtn);
		return new OrderPageConfirmationPage(getDriver()
);
	}
	

	
	
	
	
	
	
	
	
	
	
}
//button[@class="button btn btn-default button-medium"]