package newRestAssured;

import java.io.File;
import java.io.IOException;
import java.net.URISyntaxException;
import java.util.HashMap;

import org.apache.http.Header;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.util.EntityUtils;
import org.json.JSONException;
import org.json.JSONObject;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.naveenautolabs.TestBase;
import com.naveenautolabs.util.TestUtils;
import com.naveenautolabsClient.RestClient;


public class GetAPITest extends TestBase{
	TestBase testBase;
	String serviceUrl,apiUrl,url,serviceUrl_1,apiUrl_1;
	RestClient restClient;
	CloseableHttpResponse httpResponse;
	
	ExtentReports reports;
	ExtentTest testinfo;
	ExtentHtmlReporter htmlReporter;
	
	
	@BeforeTest
	public void setup() 
	{
		
		//Extent report
		
		htmlReporter=new ExtentHtmlReporter(new File("C:\\Users\\dell\\workspace\\newRestAssured\\src\\main\\java\\com\\naveenautolabs\\extentreport\\AutomationReport.html"));
		htmlReporter.loadXMLConfig(new File("C:\\Users\\dell\\workspace\\newRestAssured\\src\\main\\java\\com\\naveenautolabs\\extentreport\\extent-config.xml"));
		
		reports=new ExtentReports();
		
		reports.attachReporter(htmlReporter);
		
		
		
		testBase=new TestBase();
		serviceUrl=prop.getProperty("url");
		apiUrl=prop.getProperty("serviceUrl");
		
		url=serviceUrl+apiUrl;
		
		

		
		apiUrl_1=prop.getProperty("url_1");
		
	}
	
	@Test
	public void getTest() throws ClientProtocolException, IOException, JSONException
	{
		
		restClient=new RestClient();
		
		httpResponse=restClient.get(url);
		
		
		
		//Status Code
		int statusCode=httpResponse.getStatusLine().getStatusCode();
		System.out.println("Status code is"+statusCode);
		
		Assert.assertEquals(statusCode, 200);  //Chapter4
		
		
		
		//Response Body
		String responseString=EntityUtils.toString(httpResponse.getEntity(),"UTF-8"); //converts the response json body in string
		JSONObject responseJson=new JSONObject(responseString);
		System.out.println("Response JSON from API---->"+ responseJson);
		
		
		String str=TestUtils.getValueByPath(responseJson,"/per_page");
		System.out.println("The per_page parsed value is "+str);
	
		
		Assert.assertEquals(Integer.parseInt(str), 3);
		
		
		//Get value form JSON array
		
		String last_name=TestUtils.getValueByPath(responseJson, "/data[0]/last_name");
		
		System.out.println("The last name is -->"+last_name);
		
		//Header
		Header[] headerArray=httpResponse.getAllHeaders();
		HashMap<String,String> allHeaders=new HashMap<String,String>();
		//allHeaders.putAll(headerArray);
		for(Header header:headerArray)
		{
			allHeaders.put(header.getName(), header.getValue());
		}
		System.out.println("Header array is "+allHeaders);
		
		
		
		
	}
	
	@Test
		public void getTestwithHeader() throws ClientProtocolException, IOException, JSONException
		{
			
			restClient=new RestClient();
			
			HashMap<String,String> headerMap=new HashMap<String,String>();
			headerMap.put("q","Delhi");
			headerMap.put("appid", "404cd44dcfe1f42f2a05d15468ec9647");
			
			
			
			httpResponse=restClient.get(apiUrl_1,headerMap);
			
			
			
			//Status Code
			int statusCode=httpResponse.getStatusLine().getStatusCode();
			System.out.println("Status code is"+statusCode);
			
			//Assert.assertEquals(statusCode, 200);  //Chapter4
			
			
			
			//Response Body
			String responseString=EntityUtils.toString(httpResponse.getEntity(),"UTF-8"); //converts the response json body in string
			JSONObject responseJson=new JSONObject(responseString);
			System.out.println("Response JSON from API---->"+ responseJson);
			
			
		
			
			//Get value form JSON array
			
					
			//Header
			Header[] headerArray=httpResponse.getAllHeaders();
			HashMap<String,String> allHeaders=new HashMap<String,String>();
			//allHeaders.putAll(headerArray);
			for(Header header:headerArray)
			{
				allHeaders.put(header.getName(), header.getValue());
			}
			System.out.println("Header array is "+allHeaders);
			
			
			
			
		}
		
		@Test
		public void getTestUsingURI() throws ClientProtocolException, IOException, JSONException, URISyntaxException
		{
			
			restClient=new RestClient();
			
			HashMap<String,String> headerMap=new HashMap<String,String>();
			headerMap.put("q","Delhi");
			headerMap.put("appid", "404cd44dcfe1f42f2a05d15468ec9647");
			
			
			
			httpResponse=restClient.get();
			
			
			
			//Status Code
			int statusCode=httpResponse.getStatusLine().getStatusCode();
			System.out.println("Status code is"+statusCode);
			
			//Assert.assertEquals(statusCode, 200);  //Chapter4
			
			
			
			//Response Body
			String responseString=EntityUtils.toString(httpResponse.getEntity(),"UTF-8"); //converts the response json body in string
			JSONObject responseJson=new JSONObject(responseString);
			System.out.println("Response JSON from API---->"+ responseJson);
			
			
		
			
			//Get value form JSON array
			
					
			//Header
			Header[] headerArray=httpResponse.getAllHeaders();
			HashMap<String,String> allHeaders=new HashMap<String,String>();
			//allHeaders.putAll(headerArray);
			for(Header header:headerArray)
			{
				allHeaders.put(header.getName(), header.getValue());
			}
			System.out.println("Header array is "+allHeaders);
			
			
			
			
		}

}
