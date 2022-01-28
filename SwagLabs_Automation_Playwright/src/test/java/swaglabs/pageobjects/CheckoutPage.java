package swaglabs.pageobjects;


import com.microsoft.playwright.Page;

import testbase.BasePage;
import testbase.CommonUtilities;

public class CheckoutPage {

	Page page;
	private static final String firstName = "//input[@id='first-name']";
	private static final String lastName = "//input[@id='last-name']";
	private static final String postalCode = "//input[@id='postal-code']";
	private static final String cancelBtn = "//button[@id='cancel']";
	private static final String continueBtn = "//input[@id='continue']";
	private static final String finishBtn = "//button[@id='finish']";
	private static final String successfulStatusMsg = "//h2[contains(text(),'THANK YOU FOR YOUR ORDER')]";
	private static CommonUtilities commonutil =new CommonUtilities();

	public CheckoutPage(Page page) { 
		this.page = page;
	}

	public void fillCheckoutDetails(String firstname,String lastname, String postalcode)
	{

		commonutil.fillData(firstName, firstname);
		commonutil.fillData(lastName, lastname);
		commonutil.fillData(postalCode, postalcode);
	}

	public void completeCheckout() {
		commonutil.click(continueBtn);
		commonutil.click(finishBtn);
	}

	public boolean checkoutSuccessful() {
		boolean checkoutState =page.isVisible(successfulStatusMsg);
		commonutil.takeScreenshot("CheckoutSuccessful");
		return checkoutState;
	}

	public void cancelCheckout() {
		commonutil.click(cancelBtn);

	}






}
