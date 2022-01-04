package stepdefinitions;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import swaglabs.pages.BasePage;
import swaglabs.pages.CheckoutPage;
import swaglabs.pages.ItemsPage;
import swaglabs.pages.LoginPage;
import testbase.MyLogger;


public class LoginSteps extends BasePage{
	
	private LoginPage loginPage=new LoginPage(page);
	private ItemsPage itemsPage=new ItemsPage(page);
	private CheckoutPage checkoutPage=new CheckoutPage(page);
	

	@Given("User launched SwagLabs application")
	public void user_launched_swag_labs_application() {
		
		MyLogger.startTestCase(new Throwable().getStackTrace()[0].getMethodName());
		MyLogger.info("Test execution in progress");
		MyLogger.info("User is on "+page.title()+ " Page");
	}
	

	@When("User logged in the app using username {string} and password {string}")
	public void user_logged_in_the_app_using_username_and_password(String username, String password) {
		MyLogger.info("Enetr Username and Password");
		loginPage.login(username, password);
	}

	@Then("user should be able to log in")
	public void user_should_be_able_to_log_in() {
		MyLogger.info("Login Sucessfull");
		itemsPage.loginSuccessful();
	}

	@Then("User should not get logged in")
	public void user_should_not_get_logged_in() {
		MyLogger.info("Login failed");
		loginPage.loginFailed();
	}
	



}
