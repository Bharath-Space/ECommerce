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

public class AddtoCartPage extends BaseClass {

	public AddtoCartPage(WebDriver driver) {
		PageFactory.initElements(driver, this); // ✅ Use getDriver()
	}

	@FindBy(xpath = "//select[@id='group_1']")
	WebElement size;

	@FindBy(xpath = "//input[@id='quantity_wanted']")
	WebElement quantity;

	@FindBy(xpath = "//span[normalize-space()='Add to cart']")
	WebElement AddtoCartBtn;

	@FindBy(xpath = "//h2[normalize-space()='Product successfully added to your shopping cart']")

	WebElement addtoCartMessage;

	@FindBy(xpath = "//a[@title='Proceed to checkout']")
	WebElement proccedTocheckoutBtn;

	public void selectSize(String size1) {

		Action.selectByVisibleText(size1, size);

	}

	public void enterQauantity(String quantity1) {

		Action.type(quantity, quantity1);
	}

	public void clickonAddtoCart() {
		Action.click(getDriver(), AddtoCartBtn); // 
	}

	public boolean validateAddtoCart() {
		((WebDriver) getDriver()).manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

		return Action.isDisplayed(getDriver(), addtoCartMessage); // ✅ Use getDriver()
	}

	public WebElement getAddtoCartMessage() {
		return addtoCartMessage;
	}

	public OrderPage clickOnCheckout() {
	    WebDriverWait wait = new WebDriverWait(getDriver(), Duration.ofSeconds(10));
	    wait.until(ExpectedConditions.elementToBeClickable(proccedTocheckoutBtn));
	    Action.JSClick(getDriver(), proccedTocheckoutBtn);
	    return new OrderPage(getDriver());
	}
}