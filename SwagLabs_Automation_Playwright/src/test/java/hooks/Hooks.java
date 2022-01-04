package hooks;

import java.util.Properties;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import testbase.BasePage;
import testbase.MyLogger;
import utilities.ConfigReader;

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
		
		MyLogger.info("Launch Browser");
		String browserName=prop.getProperty("browser");
		String baseUrlName = prop.getProperty("applicationUrl");
		basePage = new BasePage();
		MyLogger.info("Browser Initiate");
		basePage.createPageInstance(browserName);
        page.navigate(baseUrlName);
	}
	

	@After
	public void closeBrowser() {
		//page.screenshot(new Page.ScreenshotOptions().setPath(Paths.get("example.png")));
		basePage.closePageInstance();
		MyLogger.info("Close browser");
	}

}
