package com.naveenautolabs;

import org.testng.annotations.Test;

import com.jayway.restassured.response.Response;

import static com.jayway.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;
public class GetCallBdd {

	
	@Test
	public void test_numberofcircits2017()
	{
		
		/*
		given()
		when()
		then()
		assert()
		*/
		
		given().
		when().
		get("http://ergast.com/api/f1/2010/circuits.json").
		then().
		assertThat().
		body("MRData.CircuitTable.Circuits.circuitId",hasSize(19)).and().
		statusCode(200).
		and().
		header("content-length",equalTo("4350"));
		
		
		
		Response response=given().
				when().
				get("http://ergast.com/api/f1/2010/circuits.json");
				
				//then().
				//extract().
				//path("MRData.CircuitTable.Circuits.circuitId");
		
		String str=response.jsonPath().get("MRData.CircuitTable.Circuits.circuitId[2]"); //2nd way to extract the result
		
		
		
		System.out.println("The value at 2nd position is --->"+str);
				
		
		
		
		
		
		
		
	}





}
