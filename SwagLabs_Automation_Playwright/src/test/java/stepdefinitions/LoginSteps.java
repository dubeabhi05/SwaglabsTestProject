package stepdefinitions;


import java.lang.reflect.Method;

import org.testng.Assert;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import swaglabs.pageobjects.CheckoutPage;
import swaglabs.pageobjects.ItemsPage;
import swaglabs.pageobjects.LoginPage;
import testbase.BasePage;
import testbase.CommonUtilities;



public class LoginSteps extends BasePage{
	
	private LoginPage loginPage=new LoginPage(page);
	private ItemsPage itemsPage=new ItemsPage(page);
	private CheckoutPage checkoutPage=new CheckoutPage(page);
	private static CommonUtilities commonutil =new CommonUtilities();

	@Given("User launched SwagLabs application")
	public void user_launched_swag_labs_application() {
		
		System.out.println("Page title is :"+page.title());
		
		//Log.info("I am at the login page");
	}
	

	@When("User logged in the app using username {string} and password {string}")
	public void user_logged_in_the_app_using_username_and_password(String username, String password) {
		//Log.info("Enter Username and Password");
		loginPage.login(username, password);
	}

	
	@Then("user should be able to log in")
	public void user_should_be_able_to_log_in() {
		//Log.info("Login Sucessfull");
		Assert.assertTrue(itemsPage.loginSuccessful());
	}
	
	@And("ItemPage title should be {string}")
	public void item_page_title_should_be(String title) {
	    Assert.assertEquals(itemsPage.getHomePageTitle(), title);
	}

	@Then("User should not get logged in")
	public void user_should_not_get_logged_in() {
	//	Log.info("Login failed");
		Assert.assertTrue(loginPage.loginFailed());
		
	}
	



}
