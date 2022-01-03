package stepdefinitions;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.core.Logger;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import swaglabs.pages.BasePage;
import swaglabs.pages.CheckoutPage;
import swaglabs.pages.ItemsPage;
import swaglabs.pages.LoginPage;
import utilities.LoggerUtilities;

public class LoginSteps extends BasePage{
	
	LoginPage loginPage;
	ItemsPage itemsPage;
	CheckoutPage checkoutPage;
	Logger Log=(Logger) LogManager.getLogger(LoginSteps.class);

	
	public LoginSteps()
	{
		loginPage = new LoginPage(page);
		itemsPage = new ItemsPage(page);
		checkoutPage=new CheckoutPage(page);
	}

	@Given("User launched SwagLabs application")
	public void user_launched_swag_labs_application() {
		//Log.info("User is on "+page.title()+ " Page");
	}
	

	@When("User logged in the app using username {string} and password {string}")
	public void user_logged_in_the_app_using_username_and_password(String username, String password) {
		loginPage.login(username, password);
	}

	@Then("user should be able to log in")
	public void user_should_be_able_to_log_in() {
		itemsPage.loginSuccessful();
	}

	@Then("User should not get logged in")
	public void user_should_not_get_logged_in() {
		loginPage.loginFailed();
	}
	



}
