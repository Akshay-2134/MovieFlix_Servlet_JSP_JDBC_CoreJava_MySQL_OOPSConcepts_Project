package com.jsp.movieflix_servlet_project.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.jsp.movieflix_servlet_project.connection.MovieFlixConnection;
import com.jsp.movieflix_servlet_project.dto.Admin;

public class AdminDao {
     
	private Connection connection=MovieFlixConnection.getMovieFlixConnection();
	
	private final String SELECT_QUERY_FOR_LOGin="select email,password from admin where email=?";
	
	public Admin fetchAdminByEmailForLoginDao(String adminEmail) {
		
		try {
			PreparedStatement ps=connection.prepareStatement(SELECT_QUERY_FOR_LOGin);
			ps.setString(1, adminEmail);
			ResultSet rs=ps.executeQuery();
			
			rs.next();
			String email=rs.getString("email");
			String password=rs.getString("password");
			return new Admin(email,password);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
	}
}
