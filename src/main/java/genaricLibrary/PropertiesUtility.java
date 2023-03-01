package genaricLibrary;
/**
 * This class contain reusable methods to perform on
 * Properties file
 * @author cw 
 */

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class PropertiesUtility {
	
	private Properties property;
	
	public void propertiesInitialization(String filepath)
	{
		FileInputStream fis=null;
		
		try {
			fis=new FileInputStream(filepath);
		}
		catch(FileNotFoundException e)
		{
			e.printStackTrace();
		}
		property =new Properties();
		try {
			property.load(fis);
		}
		catch(IOException e)
		{
			e.printStackTrace();
		}
	
	} 
	
	/**
	 * This method is used to read data from properties file
	 * @param key
	 * @author cw
	 * @return
	 */
	
	public String fetchProperty(String key) {
		return property.getProperty(key);
	}
}
