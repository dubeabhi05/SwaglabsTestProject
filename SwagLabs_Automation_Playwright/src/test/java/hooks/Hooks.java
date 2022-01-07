package hooks;

import java.util.Properties;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import testbase.BasePage;
import utilities.ConfigReader;
import utilities.Log;

public class Hooks extends BasePage{

	BasePage basePage;
	Properties prop;
	private ConfigReader configReader;



	@Before(order =0)
	public void getProperty()
	{
		configReader=new ConfigReader();
		prop=configReader.initProp();
	}

	@Before (order =1)
	public void launchBrowser() {

		Log.info("Tests are starting!");
		String browserName=prop.getProperty("browser");
		String baseUrlName = prop.getProperty("applicationUrl");
		basePage = new BasePage();
		basePage.createPageInstance(browserName);
		page.navigate(baseUrlName);
		page.waitForLoadState();
		Log.info("Test execution in progress");
	}


	@After
	public void closeBrowser() {
		//page.screenshot(new Page.ScreenshotOptions().setPath(Paths.get("example.png")));
		Log.info("Tests are ending!");
		basePage.closePageInstance();

	}

}
