package com.mystore.pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.mystore.actiondriver.Action;
import com.mystore.basec.BaseClass;

public class AccountCreationPage extends BaseClass {

	public AccountCreationPage(WebDriver driver) {
		PageFactory.initElements(getDriver(), this);
	}
		// TODO Auto-generated constructor stub
	

	@FindBy(xpath = "//h3[normalize-space(text())='Create an account']")
	WebElement formTitle;

	public   boolean ValidateAccountCreatePAge() {
	return	Action.isDisplayed(getDriver(), formTitle);
		
	}

}
