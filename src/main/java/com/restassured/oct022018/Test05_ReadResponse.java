package com.restassured.oct022018;


import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;

import java.io.InputStream;

import org.hamcrest.Matchers;
import org.testng.annotations.Test;

import io.restassured.http.ContentType;
import io.restassured.matcher.ResponseAwareMatcher;
import io.restassured.response.Response;


public class Test05_ReadResponse {
	
	//@Test
	public void readResponseAsString()
	{
		String response=get("http://services.groupkt.com/country/get/all").asString();
		System.out.println(response);
		
	}
	//@Test
	public void readResponseAsInputStream()
	{
		InputStream response=get("http://services.groupkt.com/country/get/all").asInputStream();
		System.out.println(response.toString().length());
		
	}
	
	
	
	
	//@Test
	public void extractDetailsUsingPath()
	{
		
		String href=
				when().
				get("http://jsonplaceholder.typicode.com/photos/1").
				then().
				contentType(ContentType.JSON).
				body("id",equalTo(1)).
				extract().					//Extracting the Information entered in path
				path("url");
		
		
		System.out.println(href);
		
		//Hiting the url received from previous step
		
		//when().get(href).then().statusCode(200);
		//System.out.println(get(href).getStatusCode()); //*****************Certificate error 
	
	}
	
	
	@Test
	public void extractDetailsUsingResponse()
	{
		Response response=get("http://jsonplaceholder.typicode.com/photos/1").
				then().
				extract().response();
		
		
		System.out.println("Content Type--->"+response.contentType());
		System.out.println("HREF--->"+response.path("title"));
		
		System.out.println("The complete body is "+response.asString());
		
		System.out.println("the Session ID is "+response.getSessionId());
		
	}
	
	

}
