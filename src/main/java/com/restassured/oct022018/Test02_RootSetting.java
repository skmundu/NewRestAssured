package com.restassured.oct022018;

import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;

import org.hamcrest.Matchers;
import org.testng.annotations.Test;

import io.restassured.matcher.ResponseAwareMatcher;
import io.restassured.response.Response;

public class Test02_RootSetting {
	
	
	//@Test
	public void testWithoutRoot()
	{
		given().
			get("http://services.groupkt.com/country/get/iso3code/ITA").
		then().
		body("RestResponse.result.name",is("Italy")).
		body("RestResponse.result.alpha2_code",is("IT")).
		log().all();
			
	}
	
	//@Test
	public void testRoot()
	{
		given().
			get("http://services.groupkt.com/country/get/iso3code/ITA").
		then().
		root("RestResponse.result").
		body("name",is("Italy")).
		body("alpha2_code",is("IT")).
		log().all();
			
	}
	
	@Test
	public void testDetachRoot()
	{
		given().
			get("http://services.groupkt.com/country/get/iso3code/ITA").
		then().
		root("RestResponse.result").
		body("name",is("Italy")).
		body("alpha2_code",is("IT")).
		detachRoot("RestResponse.result").
		body("RestResponse.result.alpha3_code",is("ITA")).
		log().all();
			
	}

}
