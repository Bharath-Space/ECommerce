package com.mystore.pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.mystore.actiondriver.Action;
import com.mystore.basec.BaseClass;

public class IndexPage extends BaseClass {

	@FindBy(xpath = "//a[@class='login']")
	WebElement signInBtn;

	@FindBy(xpath = "//img[@class='logo img-responsive']")
	WebElement myStoreLogo;

	@FindBy(xpath = "//input[@id='search_query_top']")
	WebElement searchProductBox;

	@FindBy(xpath = "//button[@name='submit_search']")
	WebElement searchButton;

	public IndexPage(WebDriver driver) { // So BAse class has pagefactory predefined clas which
//        can do the work of driver.close();.find element
		PageFactory.initElements(driver, this);
//passing driver to parents class constructor (basepage)
//base page will recieve the driver and intiate the driver
	}

	public LoginPage clickOnSignin() {
		Action.click(getDriver(), signInBtn);
		return new LoginPage(getDriver());

	}

	public boolean validateLogo() {
		return Action.isDisplayed(getDriver(), myStoreLogo);

	}

	public String getMyStoreTitle() {
		String myStoretitle = getDriver().getTitle();
		return myStoretitle;

	}

	public SearchResultPage searchProduct(String productname) {
		Action.type(searchProductBox, productname);
		Action.click(getDriver(), searchButton);
		return new SearchResultPage(getDriver());
	}

}
