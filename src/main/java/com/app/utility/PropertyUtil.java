package com.app.utility;

public class PropertyUtil {

	public static final PropertyUtil _INSTANCE = new PropertyUtil();
	
	private PropertyUtil(){
		
	}
	
	public static PropertyUtil getInstance(){
		return _INSTANCE;
	}
	
	public static String getProperty(String property){
		return System.getProperty(property)!=null? System.getProperty(property):System.getenv(property);
	}
}
