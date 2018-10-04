package com.restassured.sept28.newRestAssured;

import org.testng.annotations.Test;

import com.apiTesting.Post;
import com.jayway.restassured.RestAssured;
import com.jayway.restassured.http.ContentType;
import com.jayway.restassured.response.Response;

public class PutRequests {

	
	@Test
	public void test_01()
	{
		
		
		String str=RestAssured.given().
		when().
		get("http://localhost:3000/posts").
		then().
		extract().
		path("[0].author");
		System.out.println(str);
		
		
	}
	
	//POST Chapter 15
	//@Test
	public void test_02()
	{
		
		Response response=RestAssured.given().
		body("{ \"id\":\"05\",\"title\":\"dummyTitle\",\"author\": \"Sanjay\"} ").
		when().
		contentType(ContentType.JSON).      //This is mandatory in POST Request or it deisplay an error
		post("http://localhost:3000/posts");
		
		System.out.println(response.asString());
	}
	
	//POST Chapter 16*** 15 is not recommended
	//@Test
	public void test_03()
	{
		Post post1=new Post();
		post1.setId("06");
		post1.setTitle("API Testing");
		post1.setAuthor("Mr. Mundu");
		
		
		Response resp=RestAssured.given().
		when().
		contentType(ContentType.JSON).
		body(post1).
		post("http://localhost:3000/posts");
		
		
		System.out.println("The response is "+ resp.asString());
		
		
		
	}
	
	
}
