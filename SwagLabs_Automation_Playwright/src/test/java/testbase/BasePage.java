package testbase;

import java.util.ArrayList;
import java.util.List;

import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserContext;
import com.microsoft.playwright.BrowserType;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;

public class BasePage {
	
	/**
	 * Page
	 */
	
	protected static Playwright playwright;
	protected static Browser browser;
	protected static BrowserContext context;
	protected static Page page;
	
	/*
	 * 
	 *  setSlowMo(1000).
	 */

	public void createPageInstance(String browserName) {
	
		List<String> args = new ArrayList<String>();
		args.add("--window-position=-5,-5");
		
		if(browserName.equalsIgnoreCase("chromium"))
		{
		playwright = Playwright.create();
	
		browser = playwright.chromium().launch(new BrowserType.LaunchOptions().setChannel("chrome").setSlowMo(10).setHeadless(false).setArgs(args));
		context = browser.newContext();
		page = context.newPage();
		
		}
		else if(browserName.equalsIgnoreCase("Webkit"))
		{
			playwright = Playwright.create();
			
			browser = playwright.webkit().launch(new BrowserType.LaunchOptions().setChannel("webkit").setHeadless(false).setArgs(args));
			context = browser.newContext(new Browser.NewContextOptions()
					.setViewportSize(null));
			page = context.newPage();
			
		}
		else
		{
			throw new IllegalArgumentException("Could not launch a browser ");
		
		}
		
	}


	public Page getPage() {
		return page;
	}
	
	
	public void closePageInstance() {
	
		page.close();
	}


}
