package configreader;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class ConfigPropReader {

	public Properties prop;
	public FileInputStream fp;

	public ConfigPropReader() {
		prop = new Properties();
		try {
			fp = new FileInputStream("./src/main/resources/config/config.properties");
			prop.load(fp);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public String getURL() {		
		return prop.getProperty("url");
	}
	
	public String getBrowser() {		
		return prop.getProperty("browser");
	}
	
	public String getUsername() {		
		return prop.getProperty("username");
	}
	
	public String getPassword() {		
		return prop.getProperty("password");
	}
	
}
