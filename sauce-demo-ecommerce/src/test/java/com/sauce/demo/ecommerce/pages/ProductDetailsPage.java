package com.sauce.demo.ecommerce.pages;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ProductDetailsPage extends BasePage {
	
	public static final Logger logger=LogManager.getLogger(ProductDetailsPage.class);

	@FindBy(id = "back-to-products")
	WebElement backBtn;
	
	@FindBy(xpath = "//button[contains(text(),'Add')]")
	WebElement addToCartBtn;
	
	@FindBy(xpath = "//a[contains(@class,'cart')]")
	WebElement cartLink;

	@Override
	public boolean isPageLoaded() {
		return backBtn.isDisplayed();
	}
	public void clickAddToCart() throws InterruptedException {
		addToCartBtn.click();
		logger.info("Added the product to cart.");
		Thread.sleep(2000);
	}
	
	public CartPage clickCartLink() throws InterruptedException {
		cartLink.click();
		logger.info("Clicked on the cart link.");
		Thread.sleep(2000);
		return new CartPage();
		
	}
	

}
