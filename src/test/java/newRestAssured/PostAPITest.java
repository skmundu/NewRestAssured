package newRestAssured;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;

import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.util.EntityUtils;
import org.json.JSONException;
import org.json.JSONObject;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.fasterxml.jackson.core.JsonGenerationException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.naveenautolabs.TestBase;
import com.naveenautolabs.data.Users;
import com.naveenautolabsClient.RestClient;

public class PostAPITest extends TestBase {
	
	
	TestBase testBase;
	String serviceUrl,apiUrl,url,serviceUrl_1,apiUrl_1;
	RestClient restClient;
	CloseableHttpResponse httpResponse;
	
	@BeforeMethod
	public void setup() 
	{
		
		testBase=new TestBase();
		serviceUrl=prop.getProperty("url");
		apiUrl=prop.getProperty("serviceUrl");
		
		url=serviceUrl+apiUrl;
		
		

		
		
		
	}
	
	@Test
	public void postApiTest() throws  IOException, JSONException
	{
		
		restClient=new RestClient();
		
		HashMap<String,String> headerMap=new HashMap<String,String>();
		headerMap.put("Content-Type","application/json");
		
		//JACKson API--Used to convert 
		ObjectMapper mapper=new ObjectMapper();
		mapper.configure(SerializationFeature.FAIL_ON_EMPTY_BEANS, false); //To dissable the error "to avoid exception, disable SerializationFeature.FAIL_ON_EMPTY_BEANS" 
		Users users= new Users("Mark","Loader");
		
		
		//System.out.println(users.GetName());
		//Object to Json
		
		mapper.writeValue(new File("C:\\Users\\dell\\workspace\\newRestAssured\\src\\main\\java\\com\\naveenautolabs\\data\\users.json"), users);
		
		
		
		//Object to JSON string
		
		String str=mapper.writeValueAsString(users);
		System.out.println(str);
		
		httpResponse=restClient.post(url, str, headerMap);
		
		int statusCode=httpResponse.getStatusLine().getStatusCode();
		System.out.println("Status Code is---->"+statusCode);
		
		
		String responseString=EntityUtils.toString(httpResponse.getEntity(),"UTF-8"); //converts the response json body in string
		JSONObject responseJson=new JSONObject(responseString);
		System.out.println("Response JSON from API---->"+ responseJson);
		
	}
	
	
	
}
