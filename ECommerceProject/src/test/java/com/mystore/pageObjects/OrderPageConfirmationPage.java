package com.mystore.pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.mystore.basec.BaseClass;

public class OrderPageConfirmationPage extends BaseClass {

	public OrderPageConfirmationPage(WebDriver driver) {
		PageFactory.initElements(driver, this);;
		// TODO Auto-generated constructor stub
	}
	
	
	@FindBy(xpath = "//p[normalize-space(text())='Your order on My Shop is complete.']")
	WebElement ConifrmMessage;
	
	
public String validConfirmationMessage() {
	String confirmsg=ConifrmMessage.getText()	;
	return confirmsg;
}

	
	
	


}
