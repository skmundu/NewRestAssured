package com.apiTesting;

public class Post {
	
	
	private String id;
	private String title;
	private String author;
	
	
	
	public String getId()
	{
		System.out.println("This is a test");
		return id;
		
	}
	
	public void setId(String id)
	{
		this.id=id;
		
	}
	public String getTitle()
	{
		return title;
	}
	
	public void setTitle(String title)
	{
		this.title=title;
		
	}public String getAuthor()
	{
		return author;
	}
	
	public void setAuthor(String author)
	{
		this.author=author;
		
	}
	

}
