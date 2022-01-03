package utilities;

import org.apache.logging.log4j.*;

public class LoggerUtilities {
	
	private static Logger Log=LogManager.getLogger(LoggerUtilities.class.getName());

	
	
	public static void startTestCase(String sTestCaseName) {
		Log.info("********************* " + sTestCaseName + " *********************");
		}



		// This is to print log for the ending of the test case



		public static void endTestCase(String sTestCaseName) {
		Log.info("XXXXXXXXXXXXXXXXXXXXXXX " + "-E---N---D-" + " XXXXXXXXXXXXXXXXXXXXXX");
		}



		// Need to create these methods, so that they can be called



		public static void info(String message) {
		Log.info(message);
		}



		public static void warn(String message) {
		Log.warn(message);
		}



		public static void error(String message) {
		Log.error(message);
		}



		public static void fatal(String message) {
		Log.fatal(message);
		}



		public static void debug(String message) {
		Log.debug(message);
		}

	

	
}
