package com.naveenautolabs;

import java.io.FileInputStream;
import java.util.Properties;

public class TestBase {
	
	public Properties prop;
	
	public TestBase()
	{
		try {
		prop=new Properties();
		
			FileInputStream fis=new FileInputStream("C:\\Users\\dell\\workspace\\newRestAssured\\src\\main\\java\\com\\naveenautolabs\\config.properties");
			prop.load(fis);
		
		
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
		
	}
	
	

}
