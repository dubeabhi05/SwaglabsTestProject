package swaglabs.pages;

import org.junit.Assert;
import testbase.BasePage;
import testbase.CommonUtilities;

import com.microsoft.playwright.Page;

public class ItemsPage extends BasePage {
	Page page;
	
	private static final String cartBtn = "#shopping_cart_container > a";
	private static final String checkoutBtn = "[data-test=\"checkout\"]";
	 private static CommonUtilities commonutil =new CommonUtilities();
	public ItemsPage(Page page) {
		this.page = page;
	}
    
	
	public void orderProduct(String ProductName) {
		commonutil.click("//div[text()='" + ProductName + "']/following::button[1]");
		commonutil.click(cartBtn);
		Assert.assertTrue(page.isVisible("text="+ProductName));
		commonutil.click(checkoutBtn);
	}

	public boolean loginSuccessful() {
		boolean loginState = page.isVisible("text=Products");
		commonutil.takeScreenshot("LoginSucessful");
		return loginState;
		//Assert.assertTrue(page.isVisible("text=Products"));
	}
	public String getHomePageTitle() {
		 return page.title();
	  }
	
}
