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
	public Properties initProp() {
			prop=new Properties();
			try {
				
				FileInputStream fi=new FileInputStream("./src/test/resources/config.properties");
				prop.load(fi);
			} catch (FileNotFoundException e) {
				
				e.printStackTrace();
			} catch (IOException e) {
			
				e.printStackTrace();
			}
			return prop;
	}

}
