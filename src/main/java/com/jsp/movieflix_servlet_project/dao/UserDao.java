package com.jsp.movieflix_servlet_project.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.jsp.movieflix_servlet_project.connection.MovieFlixConnection;
import com.jsp.movieflix_servlet_project.dto.User;
import com.jsp.movieflix_servlet_project.verification.EmailPasswordVerification;

/**
 * UserRegistration method which will help the Program to register to use and
 * save his/her details for parament inside mysql database
 * 
 * @author Akshay Chauhan
 */
public class UserDao {

	private Connection connection = MovieFlixConnection.getMovieFlixConnection();

	private final String INSERT_USER_QUERY = "insert into user(name,email,password,dob,phone,gender,image) values(?,?,?,?,?,?,?)";

	private final String FETCH_USER_BY_EMAIL_QUERY = "SELECT * FROM user where email=?";

	public User userRegistrationDao(User user) {
		try {
			PreparedStatement ps = connection.prepareStatement(INSERT_USER_QUERY);
			ps.setString(1, user.getName());
			ps.setString(2, user.getEmail());
			ps.setString(3, user.getPassword());
			ps.setObject(4, user.getDob());
			ps.setLong(5, user.getPhone());
			ps.setString(6, user.getGender());
		    ps.setBlob(7,user.getImage());
			ps.execute();
			return user;
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}
	}

	/**
	 * fetchUserByEmail for login (06-05-24)
	 */

	public User fetchUserByEmailDao(String userEmail) {
		try {
			PreparedStatement ps = connection.prepareStatement(FETCH_USER_BY_EMAIL_QUERY);
			ps.setString(1, userEmail);
			ResultSet rs = ps.executeQuery();
			rs.next();
			String email = rs.getString("email");
			String password = rs.getString("password");
			String name  = rs.getString("name");
			return new User(email, password,name);

		} catch (SQLException e) {
			// TODO: handle exception
			e.printStackTrace();
			return null;
		}
	}
	
	
}
