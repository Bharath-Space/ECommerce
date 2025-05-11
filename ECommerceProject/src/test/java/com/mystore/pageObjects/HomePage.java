package com.mystore.pageObjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.mystore.actiondriver.Action;
import com.mystore.basec.BaseClass;

public class HomePage extends BaseClass {

	public HomePage() {
		PageFactory.initElements(getDriver(), this);
		// TODO Auto-generated constructor stub
	}

	@FindBy(xpath = "//a[@title='Orders']")
	WebElement orderhistory;

	public boolean validateOrderHistory() {
		return Action.isDisplayed(getDriver(), orderhistory);
	}

	public String getCurrUrl() {
		String homePageUrl = getDriver().getCurrentUrl();
		return homePageUrl;
	}

}
