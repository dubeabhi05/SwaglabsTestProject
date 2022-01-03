package swaglabs.pages;

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
	

	public void createPageInstance(String browserName) {
	
		if(browserName.equalsIgnoreCase("chromium"))
		{
		playwright = Playwright.create();
	
		browser = playwright.chromium().launch(new BrowserType.LaunchOptions().setChannel("chrome").setHeadless(false));
		context = browser.newContext();
		page = context.newPage();
		}
		else if(browserName.equalsIgnoreCase("Webkit"))
		{
			playwright = Playwright.create();
			
			browser = playwright.webkit().launch(new BrowserType.LaunchOptions().setChannel("webkit").setHeadless(false));
			context = browser.newContext();
			page = context.newPage();
		}
		else
		{
			throw new IllegalArgumentException("Could not launch a browser for type ");
		
		}
		
	}

	
	
	public void closePageInstance() {
	
		page.close();
	}

	public Page getPage() {
		return page;
	}
	
	public void fillData(String selector, String value)
	{
		page.fill(selector, value);
	}
	
	public void click(String selector)
	{
		page.click(selector);
	}
}
