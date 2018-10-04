package newRestAssured;

import java.io.File;
import java.lang.reflect.Method;

import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;

public class ExtentReportTestStudy {

	ExtentReports reports;
	ExtentTest testinfo;
	ExtentHtmlReporter htmlReporter;
	
	
	//Registering of Initilizing the objects
	@BeforeTest	
	public void setup()
	{
		htmlReporter=new ExtentHtmlReporter(new File("C:\\Users\\dell\\workspace\\newRestAssured\\src\\main\\java\\com\\naveenautolabs\\extentreport\\AutomationReport.html"));
		htmlReporter.loadXMLConfig(new File("C:\\Users\\dell\\workspace\\newRestAssured\\src\\main\\java\\com\\naveenautolabs\\extentreport\\extent-config.xml"));

	
		reports=new ExtentReports();
		
		reports.setSystemInfo("UAT Environment","OffShore Testing");
		
		reports.attachReporter(htmlReporter);
		
	
		
	}
	
	
	@Test
	public void test_01()
	{
		testinfo.assignCategory("Sanity"); //Adding category****Interview Question
		Assert.assertEquals(10, 10);
		testinfo.log(Status.INFO,"Sample test01");

	}
	
	@Test
	public void test_02()
	{
		testinfo.assignCategory("Smoke");
		testinfo.log(Status.INFO,"Sample test02");
		Assert.assertEquals(10, 20);
		
	}
	@Test
	public void test_03()
	{
		testinfo.assignCategory("Sanity");
		Assert.assertEquals(10, 10);
		testinfo.log(Status.INFO,"Sample test03");
	}
	
	@Test
	public void test_04()
	{
		testinfo.assignCategory("Smoke");
		Assert.assertEquals(10, 1);
		testinfo.log(Status.INFO,"Sample test04");
	}
	
	@Test
	public void test_05()
	{
		testinfo.assignCategory("Sanity");
		Assert.assertEquals(10, 10);
		testinfo.log(Status.INFO,"Sample test05");
	}
	
	@Test
	public void test_06()
	{
		testinfo.assignCategory("Regression");
		Assert.assertEquals(10, 10);
		testinfo.log(Status.INFO,"Sample test06");
	}
	
	@Test
	public void test_07()
	{
		testinfo.assignCategory("Sanity");
		Assert.assertEquals(10, 1);
		testinfo.log(Status.INFO,"Sample test07");
	}
	
	@Test
	public void test_08()
	{
		testinfo.assignCategory("Regression");
		Assert.assertEquals(10, 10);
		testinfo.log(Status.INFO,"Sample test08");
	}
	@Test
	public void test_09()
	{
		testinfo.assignCategory("Regression");
		Assert.assertEquals(10, 10);
		testinfo.log(Status.INFO,"Sample test09");
	}@Test
	public void test_10()
	{
		testinfo.assignCategory("Sanity");
		Assert.assertEquals(10, 10);
		testinfo.log(Status.INFO,"Sample test10");
	}
	
	
	//Registering the test cases
	@BeforeMethod
	public void register(Method method)
	{
		String testName=method.getName();
		testinfo=reports.createTest(testName);
		
		
	}
	//Putting log as the result
	@AfterMethod
	public void captureStatus(ITestResult result)
	{
	
		if(result.getStatus()==ITestResult.SUCCESS){
			testinfo.log(Status.PASS,"The Test method name is "+result.getName()+" Is passed");
		}else if(result.getStatus()==ITestResult.FAILURE){
			testinfo.log(Status.FAIL,"The Test method name is "+result.getName()+" Is Failed");
		}
		
	}
	
	@AfterTest
	public void tearOff()
	{
		reports.flush();
	}
	

}
	