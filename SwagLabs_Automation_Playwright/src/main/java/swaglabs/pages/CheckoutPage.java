package swaglabs.pages;

import java.nio.file.Paths;
import java.util.Date;

import org.junit.Assert;

import com.microsoft.playwright.Page;

public class CheckoutPage extends BasePage{

	Page page;
	private static final String firstName = "//input[@id='first-name']";
	private static final String lastName = "//input[@id='last-name']";
	private static final String postalCode = "//input[@id='postal-code']";
	private static final String cancelBtn = "//button[@id='cancel']";
	private static final String continueBtn = "//input[@id='continue']";
	private static final String finishBtn = "//button[@id='finish']";
	private static final String successfulStatusMsg = "//h2[contains(text(),'THANK YOU FOR YOUR ORDER')]";
	

	public CheckoutPage(Page page) { 
		this.page = page;
	}

	public void fillCheckoutDetails(String firstname,String lastname, String postalcode)
	{
		
		fillData(firstName, firstname);
		fillData(lastName, lastname);
		fillData(postalCode, postalcode);
	}

	public void completeCheckout() {
		click(continueBtn);
		click(finishBtn);
	}

	public void checkoutSuccessful() {
		//boolean visible =page.isVisible(successfulStatusMsg);
		Assert.assertTrue(getPage().isVisible(successfulStatusMsg));
		//Assert.assertTrue(visible);
		page.screenshot(new Page.ScreenshotOptions().setPath(Paths.get("CheckoutSuccessful.png")));
	}

	public void cancelCheckout() {
		click(cancelBtn);

	}






}
