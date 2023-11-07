package com.sauce.demo.ecommerce.tests;

import java.time.Duration;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.sauce.demo.ecommerce.pages.CartPage;
import com.sauce.demo.ecommerce.pages.CheckoutCompletePage;
import com.sauce.demo.ecommerce.pages.CheckoutOverviewPage;
import com.sauce.demo.ecommerce.pages.CheckoutPage;
import com.sauce.demo.ecommerce.pages.LoginPage;
import com.sauce.demo.ecommerce.pages.ProductDetailsPage;
import com.sauce.demo.ecommerce.pages.ProductsPage;
import com.sauce.demo.ecommerce.utils.PropertyReader;

public class E2ETesting extends BaseTest {
	
	public static final Logger logger=LogManager.getLogger(E2ETesting.class);
	
	CartPage cartPage;
	LoginPage loginPage;
	CheckoutCompletePage checkoutCompletePage;
	CheckoutOverviewPage checkoutOverviewPage;
	CheckoutPage checkoutPage;
	ProductsPage productsPage;
	ProductDetailsPage productDetailsPage;
	
	@Test
	public void launchTest() throws InterruptedException {
		driver.get(PropertyReader.retrieveProperty("url"));
		loginPage=new LoginPage();
		logger.info("-----New Test started.-----");
		driver.manage().window().maximize();
		Assert.assertTrue(loginPage.isPageLoaded(), "Page not loaded");
		Thread.sleep(2000);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	}
	
	@Test(dependsOnMethods = "launchTest")
	public void loginTest() throws InterruptedException {
		
		productsPage =loginPage.loginAsStandardUser();
		Assert.assertTrue(productsPage.isPageLoaded(), "Products page not loaded");
	}
	
	@Test(dependsOnMethods ="loginTest" )
	public void selectProductTest() throws InterruptedException {
		productDetailsPage=productsPage.clickProduct("Bike");
		Assert.assertTrue(productDetailsPage.isPageLoaded(), "Product details not loaded.");
	}
	
	@Test(dependsOnMethods = "selectProductTest")
	public void addToCartTest() throws InterruptedException {
		productDetailsPage.clickAddToCart();
	}
	
	@Test(dependsOnMethods ="addToCartTest" )
	public void goToCartTest() throws InterruptedException {
		cartPage = productDetailsPage.clickCartLink();
		Assert.assertTrue(cartPage.isPageLoaded(), "Cart not displaying.");
	}
	
	@Test(dependsOnMethods ="goToCartTest" )
	public void checkOutTest() {
		checkoutPage = cartPage.clickCheckout();
		Assert.assertTrue(checkoutPage.isPageLoaded(), "Checkout page not loaded.");
		checkoutPage.typeFirstname("First Name");
		checkoutPage.typeLastname("Last Name");
		checkoutPage.typePostalcode("12345");
		checkoutOverviewPage=checkoutPage.clickContinue();
		Assert.assertTrue(checkoutOverviewPage.isPageLoaded(), "Checkout overview not loaded.");
	}
	
	@Test(dependsOnMethods ="checkOutTest" )
	public void finishCheckoutTest() throws InterruptedException {
		checkoutCompletePage=checkoutOverviewPage.clickFinish();
		Assert.assertTrue(checkoutCompletePage.isPageLoaded(), "Checkout complete page not loaded.");
		logger.info("Checkout complete.");
		logger.info("-----Test complete.-----");
	}

}
