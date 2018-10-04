package com.restassured.sept28.newRestAssured;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.jayway.restassured.RestAssured;
import com.jayway.restassured.http.ContentType;
import com.jayway.restassured.response.Response;

//import static com.jayway.restassured.RestAssured.*;

public class WeatherGetResults {
	
	
	
	//Chapter 07
	//@Test
	public void test_01()
	{
		
		Response response= RestAssured.when().
				get("http://api.openweathermap.org/data/2.5/weather?q=Delhi&appid=404cd44dcfe1f42f2a05d15468ec9647");
		
		System.out.println("Status code is--->"+response.getStatusCode());
		System.out.println("***********************************************");
		
		Assert.assertEquals(response.statusCode(), 200);
		
		System.out.println("Session ID is--->"+response.getSessionId());
		System.out.println("***********************************************");
		
		System.out.println("Response Body is --->"+response.getBody().asString());// always use asString() with body 
		System.out.println("***********************************************");
		
		System.out.println("Header is--->"+response.getHeaders());
		System.out.println("***********************************************");
		
		
		
	}

	//Chapter 08
	//@Test
	public void test_02()
	{
		
				RestAssured.given().
				params("q","Delhi").
				params("appid","404cd44dcfe1f42f2a05d15468ec9647").
				when().
				get("http://api.openweathermap.org/data/2.5/weather").
				then().
				assertThat().statusCode(200);
				
				
		
			}
	//Chapter 9
	//@Test
	public void test_03()
	{

				Response response=RestAssured.given().
				param("q","Delhi").
				parameters("appid","404cd44dcfe1f42f2a05d15468ec9647").
				when().
				get("http://api.openweathermap.org/data/2.5/weather");
				
				
				System.out.println("The response is "+response.getBody().asString());
		
		
		
	}

	//chapter 12**First program**
	//@Test
	public void test_04()
	{
		
		String weatherReport=RestAssured.given().
				param("q","Ranchi").
				parameters("appid","404cd44dcfe1f42f2a05d15468ec9647").
				when().
				get("http://api.openweathermap.org/data/2.5/weather").
				then().
				contentType(ContentType.JSON).
				extract().
				path("weather[0].description");
		
		System.out.println("Weather Report is "+ weatherReport);
	
	
	
	}
	//Chapter 12 **Second program**
	//@Test
	public void test_05()
	{
		
		Response response=RestAssured.given().
				param("q","Ranchi").
				parameters("appid","404cd44dcfe1f42f2a05d15468ec9647").
				when().
				get("http://api.openweathermap.org/data/2.5/weather");
		
		
		String actualWeatherReport=response.then().
				contentType(ContentType.JSON).
				extract().
				path("weather[0].description");
				
		
		Assert.assertEquals(actualWeatherReport, "Haze");
		
	}
	
	//Chapter13
	@Test
	public void test_06()
	{
		
		Response responseByCity=RestAssured.given().
				param("q","Ranchi").
				parameters("appid","404cd44dcfe1f42f2a05d15468ec9647").
				when().
				get("http://api.openweathermap.org/data/2.5/weather");
		
		
		float lon=responseByCity.then().
				contentType(ContentType.JSON).
				extract().
				path("coord.lon");
		
		float lat=responseByCity.then().
				contentType(ContentType.JSON).
				extract().
				path("coord.lat");
				
		Response responseByGegrophic=RestAssured.given().
				param("lon",lon).
				param("lat",lat).
				parameters("appid","404cd44dcfe1f42f2a05d15468ec9647").
				when().
				get("http://api.openweathermap.org/data/2.5/weather");
		
		
		System.out.println("The response by city is---------------------> "+responseByCity.getBody().asString());
		System.out.println("*****************************************");
		
		
		System.out.println("The response by gegrophic coordinates is---------------------------> "+responseByGegrophic.getBody().asString());
		System.out.println("*****************************************");
		
		
		//Assert.assertEquals(responseByCity.body().asString(), responseByGegrophic.body().asString());
		
	
	}
	
}
