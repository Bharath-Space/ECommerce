package com.mystore.pageObjects;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.mystore.actiondriver.Action;
import com.mystore.basec.BaseClass;

public class OrderPage extends BaseClass {

	public OrderPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//li[@class='price special-price']")
	WebElement unitPrice;

	@FindBy(xpath = "//td[@id='total_shipping']")
	WebElement shippingPrice;

	@FindBy(xpath = "//td[@id='total_price_container']")
	WebElement totalprice;

	@FindBy(xpath = "//span[text()='Proceed to checkout']")
	WebElement proceedToCheckout;

	// Method to get unit price
	public Double getUnitPrice() {
		Action.scrollByVisibilityOfElement(getDriver(), unitPrice);
		String unitText = unitPrice.getText(); // e.g., "$16"
		return Double.parseDouble(unitText.replaceAll("[^\\d.]", ""));
	}

	// Method to get shipping price
	public Double getShippingPrice() {
		Action.scrollByVisibilityOfElement(getDriver(), shippingPrice);
		String shippingText = shippingPrice.getText(); // e.g., "$7"
		return Double.parseDouble(shippingText.replaceAll("[^\\d.]", ""));
	}

	// Method to get total price from UI
	public Double getTotalPrice() {
		Action.scrollByVisibilityOfElement(getDriver(), totalprice);
		String totalText = totalprice.getText(); // e.g., "$23"
		return Double.parseDouble(totalText.replaceAll("[^\\d.]", ""));
	}

	public LoginPage clickOnCheckout() {
		// Scroll to the checkout button and click
		Action.scrollByVisibilityOfElement(getDriver(), proceedToCheckout);
		getDriver().manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		Action.click(getDriver(), proceedToCheckout);
		return new LoginPage(getDriver());
	}
}
