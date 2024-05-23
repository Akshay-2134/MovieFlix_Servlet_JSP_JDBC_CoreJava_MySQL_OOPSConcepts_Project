package com.jsp.movieflix_servlet_project.connection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import com.mysql.cj.jdbc.Driver;

public class MovieFlixConnection {
	
	/*
	 * connecton method
	 */
	
	public static Connection getMovieFlixConnection() {
		
		try {
			Driver d=new Driver();
			DriverManager.registerDriver(d);
			
			String url="jdbc:mysql://localhost:3306/movieflix-java-servlet";
			String user="root";
			String password="Akshay@123";
			
			return DriverManager.getConnection(url, user, password);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
	}

}
