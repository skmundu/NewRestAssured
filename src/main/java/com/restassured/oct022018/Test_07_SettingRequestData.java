package com.restassured.oct022018;

import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;

import static org.codehaus.groovy.tools.StringHelper.*;
import java.io.InputStream;
import java.util.List;

import org.hamcrest.Matchers;

import org.testng.annotations.Test;



import io.restassured.http.ContentType;
import io.restassured.http.Cookie;
import io.restassured.matcher.ResponseAwareMatcher;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;


public class Test_07_SettingRequestData {
	
	
	
	
	
	//@Test
	public void testConnectRequest()
	{
		
		given().
			request("CONNECT","https://api.fonts.com/request/json/Accounts/").
		then().
			statusCode(404).
			log().all();
		
	}
	
	@Test
	public void testRequestQueryparameters()
	{
		
		given().
			queryParam("q", "Delhi").
			queryParam("appid","404cd44dcfe1f42f2a05d15468ec9647").
			pathParam("section","weather").
		when().
			get("https://api.openweathermap.org/data/2.5/{section}").
			//request("CONNECT","https://api.openweathermap.org/data/2.5/weather?q=London").
		then().
			statusCode(200).
			log().all();
		
		}
	

}
