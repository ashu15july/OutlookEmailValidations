package utilities;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

public class ConfigFileReader {
	private Properties properties;
	private final String propertyFilePath= ".\\Configs\\Configuation.properties";

	
	public ConfigFileReader(){
		BufferedReader reader;
		try {
			reader = new BufferedReader(new FileReader(propertyFilePath));
			properties = new Properties();
			try {
				properties.load(reader);
				reader.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
			throw new RuntimeException("Configuration.properties not found at " + propertyFilePath);
		}		
	}
	
	public String getSubject(){
		String driverPath = properties.getProperty("subject");
		if(driverPath!= null) return driverPath;
		else throw new RuntimeException("Subject is not specified in the Configuration.properties file.");		
	}
	
	public String getBody() {		
		String body = properties.getProperty("body");
		if(body != null) return body;
		else throw new RuntimeException("body of the mail is not specified in the Configuration.properties file.");		
	}
	
	public String getApplicationUrl() {
		String url = properties.getProperty("url");
		if(url != null) return url;
		else throw new RuntimeException("url is not specified in the Configuration.properties file.");
	}
	
	public String getDriverPath() {
		String driverPath = properties.getProperty("driverPath");
		if(driverPath != null) return driverPath;
		else throw new RuntimeException("driverPath is not specified in the Configuration.properties file.");
	}
	
	

}
