package com.sauce.demo.ecommerce.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class CartPage extends BasePage{
	
	@FindBy(xpath = "//span[text()='Your Cart']")
	WebElement cartHeader;
	
	@FindBy(id = "checkout")
	WebElement checkoutBtn;

	@Override
	public boolean isPageLoaded() {
		return cartHeader.isDisplayed();
	}
	
	public CheckoutPage clickCheckout() {
		checkoutBtn.click();
		return new CheckoutPage();
	}
	

}
