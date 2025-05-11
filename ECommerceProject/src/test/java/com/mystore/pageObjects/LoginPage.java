package com.mystore.pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.mystore.actiondriver.Action;
import com.mystore.basec.BaseClass;

public class LoginPage extends BaseClass {

	public LoginPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	// TODO Auto-generated constructor stub

	@FindBy(xpath = "//input[@id='email']")
	WebElement username;

	@FindBy(xpath = "//input[@id='passwd']")
	WebElement password;

	@FindBy(xpath = "//span[normalize-space()='Sign in']")
	WebElement signInBtn;

	@FindBy(xpath = "//input[@id='email_create']');")
	WebElement emailForNewAccnt;

	@FindBy(xpath = "//button[@name='SubmitCreate']")
	WebElement createNewAccntBtn;

	public HomePage login(String userNme, String pwd) {
		Action.type(username, userNme);
		Action.type(password, pwd);
		Action.click(getDriver()
, signInBtn);
		return new HomePage();
	}

	public AdresssPage login1(String userNme, String pwd) {
		Action.type(username, userNme);
		Action.type(password, pwd);
		Action.click(getDriver()
, signInBtn);
		return new AdresssPage(getDriver()
);
	}

	public AccountCreationPage createnewAcccount(String newEmail) {
		Action.type(emailForNewAccnt, newEmail);
		Action.click(getDriver()
, createNewAccntBtn);

		return new AccountCreationPage(getDriver()
);
	}

}
