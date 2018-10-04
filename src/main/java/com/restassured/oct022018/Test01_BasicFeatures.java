package com.restassured.oct022018;

import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;

import org.hamcrest.Matchers;
import org.testng.annotations.Test;

import io.restassured.matcher.ResponseAwareMatcher;
import io.restassured.response.Response;

public class Test01_BasicFeatures {
	
	
	
	
	//Check Status code 
	//@Test
	public void testCodeStatus()
	{
		given().
			get("http://jsonplaceholder.typicode.com/posts/3").
		then().
			statusCode(200);
		
	}
	
	
	//Log the output to console
	//@Test
	public void testLogging()
	{
		given().
		get("http://services.groupkt.com/country/get/all").
	then().
		statusCode(200).
		log().all();
	}

	//@Test
	public void validateEqualsTo()
	{
		given().
		get("http://services.groupkt.com/country/get/all").
	then().
	assertThat().
	statusCode(200).
	body("RestResponse.Result.alpha3_code", hasItems("IND","CHE")); //Needs to static import hamcast Matches
	
	//USE 	and() for increase readibility
	
		
		
		

	}
	
	
	//************************XML related**************************
	
	
	@Test
	public void testSingleContent()
	{
		given().
		get("http://thomas-bayer.com/sqlrest/CUSTOMER/10/").
		then().
		body("CUSTOMER.ID",equalTo("10")).
				log().all();
	
	
	
	}
	
	//Using has XPath seel line nu 82
	@Test
	public void testSingleContent_1()
	{
		given().
		get("http://thomas-bayer.com/sqlrest/CUSTOMER/10/").
		then().
		body(hasXPath("//CUSTOMER/FIRSTNAME",containsString("Sue"))).
				log().all();
	
	
	
	}




	
}

