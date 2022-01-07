package stepdefinitions;

import org.junit.Assert;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import testbase.BasePage;
import utilities.Log;
import swaglabs.pages.CheckoutPage;
import swaglabs.pages.ItemsPage;
import swaglabs.pages.LoginPage;

public class BuyProduct extends BasePage   {
	

	
	private LoginPage loginPage=new LoginPage(page);
	private ItemsPage itemsPage=new ItemsPage(page);
	private CheckoutPage checkoutPage=new CheckoutPage(page);
		    
		
	@When("User adds {string} product to the cart")
	public void user_adds_product_to_the_cart(String product) {
		Log.info("Add product to the cart");
		itemsPage.orderProduct(product);
	   
	}
	@When("User enters Checkout details with {string}, {string}, {string}")
	public void user_enters_checkout_details_with(String firstname, String lastname, String postalcode) {
		Log.info("Add Checkut Details");
		checkoutPage.fillCheckoutDetails(firstname, lastname, postalcode);
	}
	@When("User completes Checkout process")
	public void user_completes_checkout_process() {
		Log.info("Complete Checkout");
	   checkoutPage.completeCheckout();
	}
	@Then("User should get the Confirmation of Order")
	public void user_should_get_the_confirmation_of_order() {
		Log.info("Verify the confirmation of order");
		Assert.assertTrue(checkoutPage.checkoutSuccessful());
	}


}
