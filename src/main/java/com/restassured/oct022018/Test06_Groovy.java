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


public class Test06_Groovy {
	
	//@Test
	public void testLengthOfResponse()
	{
		given().
		param("text", "islands").
		when().
			get("http://services.groupkt.com/country/search").
		then().
			body("RestResponse.result.alpha3_code*.length().sum()",greaterThan(40)).log().all();  //Using Grovy
			
	}
	
	
	//************************* VERY IMPORTANT*****************************
	//@Test
	public void gettingList()
	{
		Response response=given().
				param("text", "islands").
				when().
					get("http://services.groupkt.com/country/search");
				
		JsonPath jsonPathEvaluator = response.jsonPath();
		
		List<String> list=jsonPathEvaluator.getList("RestResponse.result.name");
				
		for(String s:list)
		{
			System.out.println(s);
		}
		
		
		System.out.println("Cookies are-->"+response.getCookies());
	
	}
	
	//@Test
	public void gettingList_Using_Grovy()
	{
		String response=given().
				param("text", "islands").
				when().
					get("http://services.groupkt.com/country/search").asString();
				
		//JsonPath jsonPathEvaluator = response.jsonPath();
		
	
		List<String> list=JsonPath.from(response).getList("RestResponse.result.findAll{it.name.length()>20}.name");//From is from Json path
		System.out.println("the Number of the Names are-->"+list.size());
		//jsonPathEvaluator.getList("RestResponse.result.name");
				
		for(String s:list)
		{
			System.out.println(s);
		}
		
		
	}
	
	@Test
	public void getCookies()
	{
		Response response=given().
				when().
					get("http://jsonplaceholder.typicode.com/photos");
				
		/*
		JsonPath jsonPathEvaluator = response.jsonPath();
		
		List<String> list=jsonPathEvaluator.getList("RestResponse.result.name");
				
		for(String s:list)
		{
			System.out.println(s);
		}
		
		*/
		System.out.println("Cookies are-->"+response.getCookies());
	
		Cookie coo=response.getDetailedCookie("__cfduid");
		
		System.out.println("If the cookie has expiry date:"+coo.hasExpiryDate());
		System.out.println("cookie has expiry date of :"+coo.getExpiryDate());
		
				
	}
	
	

}
