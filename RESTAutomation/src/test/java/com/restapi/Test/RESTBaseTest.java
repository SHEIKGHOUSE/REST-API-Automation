package com.restapi.Test;

import org.testng.annotations.BeforeMethod;

import com.restapi.ObjectRepo.RESTUtility;
import com.restapi.Util.ConfigurationLibrary;

public class RESTBaseTest {

	String authKey;
	
	@BeforeMethod
	public void authorization()
	{
		authKey = ConfigurationLibrary.readConfigFile("APIKey");
	}
}
