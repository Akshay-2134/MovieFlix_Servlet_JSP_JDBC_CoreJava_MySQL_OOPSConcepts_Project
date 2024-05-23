package com.jsp.movieflix_servlet_project.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.jsp.movieflix_servlet_project.dao.UserDao;
import com.jsp.movieflix_servlet_project.dto.User;
import com.jsp.movieflix_servlet_project.verification.EmailPasswordVerification;

@WebServlet(value = "/userLogin")
public class UserLoginController extends HttpServlet {
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		HttpSession httpSession = req.getSession();
		UserDao dao = new UserDao();
		String email = EmailPasswordVerification.emailVerification(req.getParameter("userEmail"));
		String password = EmailPasswordVerification.passwordVerification(req.getParameter("userPassword"));
		User user = dao.fetchUserByEmailDao(email);
		if (user != null) {
			if (user.getPassword().equals(password)) {
				httpSession.setAttribute("LoginSession", email);
				httpSession.setMaxInactiveInterval(10);
				req.setAttribute("user", user);
				req.getRequestDispatcher("home-page.jsp").forward(req, resp);
			} else {
				req.setAttribute("userMsg", "Password is invalid");
				req.getRequestDispatcher("user-login.jsp").forward(req, resp);
			}
		} else {
			req.setAttribute("userMsg", "Email  is invalid");
			req.getRequestDispatcher("user-login.jsp").forward(req, resp);
		}
	}
}
