package com.jsp.movieflix_servlet_project.controller;

import java.io.IOException;
import java.time.LocalDate;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.servlet.http.Part;

import com.jsp.movieflix_servlet_project.dto.User;
import com.jsp.movieflix_servlet_project.service.UserService;
import com.jsp.movieflix_servlet_project.verification.EmailPasswordVerification;

@WebServlet("/userRegistration")
@MultipartConfig
public class UserRegisterController extends HttpServlet {
    
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		HttpSession httpSession=req.getSession();
		UserService service=new UserService();
		
	  String name=req.getParameter("name");
	  String email = req.getParameter("email");
	  String password = req.getParameter("password");
	  LocalDate date=LocalDate.parse(req.getParameter("dob"));
	  long phone=Long.parseLong(req.getParameter("phone"));
	  String gender=req.getParameter("gender");
	  Part image=req.getPart("profilePic");
	  
	  System.out.println(name);
	 
	  User user=new User(name, email, password, date, phone, gender, image.getInputStream());
	  User u=service.userRegistrationService(user);
	  if(u!=null) {
		  req.setAttribute("userMsg", "User Registered Successfuly");
		  req.getRequestDispatcher("user-login.jsp").forward(req, resp);
	  }else {
		  req.setAttribute("userMsg", "Your Session is Out");
		  req.setAttribute("userMsg", "email must contain @. and number (abc@123gmail.com)");
		  req.setAttribute("userPass", "Password must contain any specia char,number,alphabet,one Uppercase");
		  req.getRequestDispatcher("user-register.jsp").forward(req, resp);
	  }
	  
	}
}
