package testbase;

import java.nio.file.Paths;

import com.microsoft.playwright.Page;

public class CommonUtilities extends BasePage {



	public void fillData(String selector, String value)
	{
		page.fill(selector, value);
	}

	public void click(String selector)
	{
		page.click(selector);
	}

	public void takeScreenshot(String scenarioName) {

		page.screenshot(new Page.ScreenshotOptions().setPath(Paths.get(scenarioName +".png")));

	}
	
	
}
