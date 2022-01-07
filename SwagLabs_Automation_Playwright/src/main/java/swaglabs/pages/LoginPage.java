package swaglabs.pages;

import org.junit.Assert;
import testbase.BasePage;
import testbase.CommonUtilities;

import com.microsoft.playwright.Page;

public class LoginPage extends BasePage {
	   
	    private static final String userName = "//input[@id='user-name']";
	    private static final String userPassword = "//input[@id='password']";
	    private static final String btnLogin = "//input[@id='login-button']";
	    private static CommonUtilities commonutil =new CommonUtilities();

	Page page;
	
	  public LoginPage(Page page) { 
		  this.page = page;
     }
	  
	  public void login(String username,String password) {
	      commonutil.fillData(userName, username);
	      commonutil.fillData(userPassword, password);
	      commonutil.click(btnLogin);
	}
	 
	  
	public boolean loginFailed() {
		boolean visible = page.isVisible("//h3[text()='Epic sadface: Sorry, this user has been locked out.']");
		commonutil.takeScreenshot("loginFailed");
		return visible;
	
	}
	
	 

}
