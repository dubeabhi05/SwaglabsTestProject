package utilities;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class ConfigReader {
	
	private Properties prop;
	/*
	 * This method will return data from properties file
	 * 
	 */
	String configFile=System.getProperty("user.dir")+"//src//test//resources//propertiesfile//Config.properties";
	public Properties initProp() {
			prop=new Properties();
			
			
			try {
				
				FileInputStream fi=new FileInputStream(configFile);
				prop.load(fi);
			} catch (FileNotFoundException e) {
				
				e.printStackTrace();
			} catch (IOException e) {
			
				e.printStackTrace();
			}
			return prop;
	}

}
