package com.sauce.demo.ecommerce.pages;

import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;

public class ProductsPage extends BasePage {
	
	public static final Logger logger=LogManager.getLogger(ProductsPage.class);
	
	@FindBy(xpath = "//button[contains(text(),'Open Menu')]")
	WebElement menuBtn;
	
	@FindBy(xpath = "//div[contains(text(),'Swag')]")
	WebElement swagLogo;
	
	@FindBy(linkText = "shopping_cart_link")
	WebElement cartLink;
	
	@FindBy(xpath = "//div[@class='inventory_item_name ']")
	List<WebElement>productNames;
	
	@FindBy(xpath = "//div[@class='inventory_item_desc']")
	List<WebElement>prodDescription;
	
	@FindBy(xpath = "//div[@class='inventory_item_price']")
	List<WebElement>prodPrice;
	
	@FindBy(xpath = "//button[contains(text(),'cart')]")
	List<WebElement>addToCartBtn;
	
	@FindBy(xpath = "//div[@class='inventory_item_description']")
	List<WebElement>inventoryItems;
	
	@FindBy(xpath = "//a")
	List<WebElement>links;
	
	@FindBy(linkText = "All Items")
	WebElement allItemsLink;
	
	@FindBy(linkText = "About")
	WebElement aboutLink;
	
	@FindBy(linkText = "Logout")
	WebElement logoutLink;
	
	@FindBy(linkText = "Reset App State")
	WebElement resetLink;
	
	@FindBy(xpath = "//button[contains(text(),'Close')]")
	WebElement closeBtn;

	@Override
	public boolean isPageLoaded() {
		return driver.getTitle().equals("Swag Labs");
	}
	
	public ProductDetailsPage clickProduct(String name) throws InterruptedException {
		for(WebElement p:productNames) {
			if(p.getText().contains(name)) {
				p.click();
				logger.info("Selected the product.");
				break;
			}
		}
		Thread.sleep(2000);
		return new ProductDetailsPage();
	}

}
