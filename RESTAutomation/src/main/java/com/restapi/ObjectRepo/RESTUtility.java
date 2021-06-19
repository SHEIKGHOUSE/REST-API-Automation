package com.restapi.ObjectRepo;

import com.restapi.Util.ConfigurationLibrary;

import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class RESTUtility {
	
	String baseURI="https://api.openweathermap.org/data/2.5/";
	
	public Response getCurrentWeather(String authKey,String object,String cityName,String stateCode,String countryCode)
	{
		RestAssured.baseURI = ConfigurationLibrary.readConfigFile("CurrentBaseURI")+object+"?"+"q="+"&"+"appid=";
		RequestSpecification request = RestAssured.given();
		request.param("q", cityName);
		request.param("appid", authKey);
		request.header("Content-Type","application/json");
		
		return request.get();
	
	}
	
	public Response getHourlyForecastWeather(String authKey,String object,String cityName,String stateCode,String countryCode)
	{
		RestAssured.baseURI = ConfigurationLibrary.readConfigFile("HourlyForecast")+object+"/hourly?"+"q="+"&"+"appid=";
		System.out.println(ConfigurationLibrary.readConfigFile("HourlyForecast")+object+"/hourly?"+"q="+"&"+"appid=");
		RequestSpecification request = RestAssured.given();
		request.param("q", cityName);
		request.param("appid", authKey);
		request.header("Content-Type","application/json");
		
		return request.get();
	
	}
	
	public String getNodeValue(Response response,String nodename,String ChildName)
	{
		response.getBody().asString();
		
		return JsonPath.from(response.getBody().asString()).get(nodename+"."+ChildName).toString().replace("[","").replace("]", "");
		
	}
	
	

}
