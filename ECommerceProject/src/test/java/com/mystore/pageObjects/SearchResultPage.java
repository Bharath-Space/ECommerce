package com.mystore.pageObjects;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.mystore.actiondriver.Action;
import com.mystore.basec.BaseClass;

public class SearchResultPage extends BaseClass {

	public SearchResultPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
		; // ✅ Thread-safe WebDriver
	}

	@FindBy(xpath = "//a[@title='Printed Chiffon Dress'][normalize-space()='Printed Chiffon Dress']")
	WebElement productresult;

	public boolean isproductAvailable() {
		return Action.isDisplayed(getDriver(), productresult); // ✅ Use getDriver()
	}

//	public AddtoCartPage clickOnProduct() {
//		Action.click(driver, productresult);
//	
//		return new AddtoCartPage(driver);
//	}

	public AddtoCartPage clickOnProduct() {
		WebDriverWait wait = new WebDriverWait(getDriver(), Duration.ofSeconds(30));
		wait.until(ExpectedConditions.visibilityOf(productresult));
		wait.until(ExpectedConditions.elementToBeClickable(productresult));
		Action.scrollByVisibilityOfElement(getDriver(), productresult);
		Action.click(getDriver(), productresult);
		return new AddtoCartPage(getDriver());
	}

}
