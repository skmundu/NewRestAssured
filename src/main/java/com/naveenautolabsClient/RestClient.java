package com.naveenautolabsClient;

import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.HashMap;
import java.util.Map;

import org.apache.http.Header;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.utils.URIBuilder;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;
import org.json.JSONException;
import org.json.JSONObject;

public class RestClient {

	
	//Get method
	/*
	public void get(String url) throws ClientProtocolException, IOException, JSONException
	{
		CloseableHttpClient httpClient=HttpClients.createDefault(); //Create one client connection which returns Closable HttpClient(abstract class)
		HttpGet httpget= new HttpGet(url); //httpgetrequest
		CloseableHttpResponse httpResponse=httpClient.execute(httpget); //Hit the URL and in response Headers, status and body everything
		
			
		//Status Code
		int statusCode=httpResponse.getStatusLine().getStatusCode();
		System.out.println("Status code is"+statusCode);
		
		
		//Response Body
		String responseString=EntityUtils.toString(httpResponse.getEntity(),"UTF-8"); //converts the response json body in string
		JSONObject responseJson=new JSONObject(responseString);
		System.out.println("Response JSON from API---->"+ responseJson);
	
		
		//Header
		Header[] headerArray=httpResponse.getAllHeaders();
		HashMap<String,String> allHeaders=new HashMap<String,String>();
		//allHeaders.putAll(headerArray);
		for(Header header:headerArray)
		{
			allHeaders.put(header.getName(), header.getValue());
		}
		System.out.println("Header array is "+allHeaders);
		
	
		
	}*/
	
	//Second approach Chapter4 get method without URL
	public CloseableHttpResponse get(String url) throws ClientProtocolException, IOException 
	{
		
		CloseableHttpClient httpClient=HttpClients.createDefault(); //Create one client connection which returns Closable HttpClient(abstract class)
		
		
		
		
		
		
		
		HttpGet httpget= new HttpGet(url); //httpgetrequest
		CloseableHttpResponse httpResponse=httpClient.execute(httpget); //Hit the URL and in response Headers, status and body everything
	
		return httpResponse;
	}	
	
	
	//Second approach Chapter4 get method with Header
	public CloseableHttpResponse get(String url, HashMap<String,String> headerMap) throws ClientProtocolException, IOException 
		{
			CloseableHttpClient httpClient=HttpClients.createDefault(); //Create one client connection which returns Closable HttpClient(abstract class)
			HttpGet httpget= new HttpGet(url); //httpgetrequest
			
			for(Map.Entry<String, String> entry: headerMap.entrySet())
			{
				httpget.addHeader(entry.getKey(),entry.getValue());
				
				
			}
			
			
			CloseableHttpResponse httpResponse=httpClient.execute(httpget); //Hit the URL and in response Headers, status and body everything
		
			return httpResponse;
			
		}
	
	
	//GEt with parameter
	public CloseableHttpResponse get() throws ClientProtocolException, IOException, URISyntaxException 
	{
		
		CloseableHttpClient httpClient=HttpClients.createDefault(); //Create one client connection which returns Closable HttpClient(abstract class)
		
		URI uri = new URIBuilder()
	            .setScheme("http")
	            .setHost("api.openweathermap.org/data/2.5/weather")
	            .setParameter("q", "Delhi")
	            .setParameter("appid", "404cd44dcfe1f42f2a05d15468ec9647")
	            .build();
	 
		
		
		
		
		
		
		HttpGet httpget= new HttpGet(uri); //httpgetrequest
		CloseableHttpResponse httpResponse=httpClient.execute(httpget); //Hit the URL and in response Headers, status and body everything
	
		return httpResponse;
	}	
	
	//POST Method
	
	public CloseableHttpResponse post(String url,String entityString,HashMap<String,String>headerMap ) throws ClientProtocolException, IOException

	{
		CloseableHttpClient httpClient=HttpClients.createDefault(); //Create one client connection which returns Closable HttpClient(abstract class)
		HttpPost httpPost= new HttpPost(url); //httpgetrequest
		
		httpPost.setEntity(new StringEntity(entityString)); //For Payload
		
		for(Map.Entry<String, String> entry: headerMap.entrySet())
		{
			httpPost.addHeader(entry.getKey(),entry.getValue());
			
			
		}
		
		
		CloseableHttpResponse httpResponse=httpClient.execute(httpPost); 
		
		return httpResponse;
		
	}


}
	
