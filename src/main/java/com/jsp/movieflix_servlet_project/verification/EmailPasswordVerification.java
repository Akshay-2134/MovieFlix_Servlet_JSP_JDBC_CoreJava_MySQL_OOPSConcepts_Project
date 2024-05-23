package com.jsp.movieflix_servlet_project.verification;

import java.util.regex.Pattern;

/**
 * 
 * @author Akshay Chauhan
 */
public class EmailPasswordVerification {

	public static String emailVerification(String emailVerification) {
      
		/**
		 * Pattern class is inside java.util.regex;
		 */
		boolean character = Pattern.compile("[a-z]").matcher(emailVerification).find();
		boolean number=Pattern.compile("[0-9]").matcher(emailVerification).find();
		boolean special=Pattern.compile("[@.]").matcher(emailVerification).find();
		return (character) ? emailVerification : null;
	}
	public static  String passwordVerification(String password) {
		
		/**
		 * Pattern class is inside java.util.regex;
		 */
		boolean character = Pattern.compile("[a-zA-Z]").matcher(password).find();
		boolean number= Pattern.compile("[0-9][@.$%#!&*!()]").matcher(password).find();
		boolean special=Pattern.compile("[@.$%#!&*]").matcher(password).find();
		return (character) ? password : null;
	}

}
