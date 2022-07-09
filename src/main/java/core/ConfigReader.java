package core;

import org.testng.Assert;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class ConfigReader {

	private ConfigReader() {
		throw new IllegalStateException("Utility class");
	}

	private static String getConfigValue(String value){
		Properties p = new Properties();

		String environmentExecution = System.getProperty("environment");
		if (environmentExecution == null){
				environmentExecution = "DEV";
			}
			try (FileInputStream file = new FileInputStream("src/test/resources/config"+environmentExecution+".properties");) {
				p.load(file);
			}

		catch(IOException ex){
			Assert.fail(String.format("Unable to read file. Error: %s", ex.getMessage()));
		}
		return p.getProperty(value);
	}

	public static final String APP_URL = getConfigValue("appURL");
	public static final String DRIVER_PATH = getConfigValue("driverpath");
	public static final String PIPELINE_PATH = getConfigValue("pipelinepath");
	public static final String DB_CONNECT_STRING = getConfigValue("dbConnectionString");
	public static final String DB_USER = getConfigValue("dbUsername");
	public static final String DB_PSWD = getConfigValue("dbPassword");
	public static final String EMAIL = getConfigValue("email");
	public static final String PASSWORD = getConfigValue("password");

}
