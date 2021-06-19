package com.restapi.Test;


import org.testng.annotations.Test;

import com.restapi.ObjectRepo.ObjectRepo;
import com.restapi.ObjectRepo.RESTUtility;
import com.sun.xml.bind.v2.schemagen.Util;

import io.restassured.response.Response;
import junit.framework.Assert;

public class WeatherTest extends RESTBaseTest{
	
	RESTUtility util ;
	
	public void Init() {
	 util = new RESTUtility();
	}
	
	@Test
	public void Verify_Current_Weather()
	{
		Init();
		Response response = util.getCurrentWeather(authKey,ObjectRepo.CurrentWeather,"London", null, null);
		
		Assert.assertEquals("overcast clouds", util.getNodeValue(response, "weather", "description"));
		
	}
	
	@Test
	public void Verify_Hourly_forecast()
	{
		Init();
		Response response = util.getHourlyForecastWeather(authKey,ObjectRepo.Forecast,"London", null, null);
		
		System.out.println(util.getNodeValue(response, "weather", "description"));
		//Assert.assertEquals("overcast clouds", util.getNodeValue(response, "weather", "description"));
		
	}
	

}
