package com.entrata.resources;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class Constants {

	public static final String url;
	public static final String browser;
	public static final String firstName;
	public static final String lastName;
	public static final String email;
	public static final String company;
	public static final String phone;
	public static final String jobtitle;

	static {
		Properties Prop = new Properties();
		FileInputStream ip = null;
		try {
			ip = new FileInputStream(
					System.getProperty("user.dir") + "//src//main//java//com//entrata//data//config.properties");
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			Prop.load(ip);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		url = Prop.getProperty("url");
		browser = Prop.getProperty("browser");
		firstName = Prop.getProperty("firstName");
		lastName = Prop.getProperty("lastName");
		email = Prop.getProperty("email");
		company = Prop.getProperty("company");
		phone = Prop.getProperty("phone");
		jobtitle = Prop.getProperty("jobtitle");

	}

}
