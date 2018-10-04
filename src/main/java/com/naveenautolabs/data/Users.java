package com.naveenautolabs.data;

public class Users {

	String name;
	String job;
	
	public Users()
	{
		
	}
	
	public Users(String name,String job)
	{
	this.name=name;
	this.job=job;
				
	}
	
	//Getters and setters method
	
	public void setName(String name)
	{
		this.name=name;
	}
	public String getName()
	{
		return name;
	}
	
	public void setJob(String job)
	{
		this.job=job;
	}
	public String getJob()
	{
		return job;
	}
	
	
}
