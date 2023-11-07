package com.sauce.demo.ecommerce.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class CheckoutPage extends BasePage {

	@FindBy(xpath = "//span[contains(text(),'Checkout')]")
	WebElement checkoutHeader;

	@FindBy(id = "first-name")
	WebElement firstNameBox;

	@FindBy(id = "postal-code")
	WebElement postalCodeBox;

	@FindBy(id = "last-name")
	WebElement lastNameBox;

	@FindBy(id = "continue")
	WebElement continueBtn;

	@Override
	public boolean isPageLoaded() {
		return checkoutHeader.isDisplayed();
	}
	public void typeFirstname(String fname) {
		firstNameBox.sendKeys(fname);
	}
	public void typeLastname(String lname) {
		lastNameBox.sendKeys(lname);
	}
	public void typePostalcode(String code) {
		postalCodeBox.sendKeys(code);
	}
	public CheckoutOverviewPage clickContinue() {
		continueBtn.click();
		return new CheckoutOverviewPage();
	}
	

}
