package com.surajanbhule;

public class Helper {
	
	public  String getShortString(String s) {
		if(s.length()<40)
			return s;
		else
			return s.substring(0,20);
	}
}
