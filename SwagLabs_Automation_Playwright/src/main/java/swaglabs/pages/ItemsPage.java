package swaglabs.pages;

import org.junit.Assert;

import com.microsoft.playwright.Page;

public class ItemsPage extends BasePage {
	Page page;
	
	private static final String cartBtn = "#shopping_cart_container > a";
	private static final String checkoutBtn = "[data-test=\"checkout\"]";
	public ItemsPage(Page page) {
		this.page = page;
	}
    
	
	public void orderProduct(String ProductName) {
	    click("//div[text()='" + ProductName + "']/following::button[1]");
		click(cartBtn);
		Assert.assertTrue(page.isVisible("text="+ProductName));
		click(checkoutBtn);
	}

	public void loginSuccessful() {
		Assert.assertTrue(page.isVisible("text=Products"));
	}
	
}
