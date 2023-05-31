package ujetix.genericUtils;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class FileUtitlity 
{
	/**
	 * 
	 * to fetch the data from property file
	 * @param key
	 * @return
	 * @throws IOException
	 */
	public String getPropertData(String key) throws IOException 
	{
		FileInputStream fis = new FileInputStream(IPathConstants.propertyPath);
		Properties prop = new Properties();
		prop.load(fis);
		String value = prop.getProperty(key);
		return value;
	}
}
