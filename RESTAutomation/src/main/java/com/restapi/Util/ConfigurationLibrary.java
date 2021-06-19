package com.restapi.Util;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class ConfigurationLibrary {
	
	
	static File file;
	static FileInputStream fin;
	public static String readConfigFile(String key)
	{
		Properties prop = new Properties();
		
		try {
			
			file = new File(".//ConfigData//App.config");
			fin = new FileInputStream(file);
			prop.load(fin);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return prop.getProperty(key);
		
	}

}
