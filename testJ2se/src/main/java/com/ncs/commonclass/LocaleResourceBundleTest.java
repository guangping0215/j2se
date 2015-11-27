package com.ncs.commonclass;

import java.io.IOException;
import java.util.Locale;
import java.util.ResourceBundle;

public class LocaleResourceBundleTest {

	public static void main(String[] args) throws IOException {
		Locale loc1 = new Locale("zh","CN");
		Locale loc2 = new Locale("en","US");
		Locale loc3 = new Locale("fr","FR");
		ResourceBundle rb1 = ResourceBundle.getBundle("com/ncs/commonclass/message", loc1);
		ResourceBundle rb2 = ResourceBundle.getBundle("com/ncs/commonclass/message", loc2);
		ResourceBundle rb3 = ResourceBundle.getBundle("com/ncs/commonclass/message", loc3);
		System.out.println(rb1.getString("message"));
		System.out.println(rb2.getString("message"));
		System.out.println(rb3.getString("message"));
	}
	
}
