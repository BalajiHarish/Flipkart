package com.qa.utils;

public final class DynamicXpathUtils {

	private DynamicXpathUtils() {
		
	}
	
	public static String getNewXpath(String xpath, String value) {
		return String.format(xpath, value); 
	}
	
	public static String getNewXpath(String xpath, Object value1, Object value2) {
		return String.format(xpath, value1, value2);
	}
}
