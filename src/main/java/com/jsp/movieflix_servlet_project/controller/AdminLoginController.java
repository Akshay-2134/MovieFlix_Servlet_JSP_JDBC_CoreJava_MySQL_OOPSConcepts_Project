package com.jsp.movieflix_servlet_project.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.jsp.movieflix_servlet_project.dao.AdminDao;
import com.jsp.movieflix_servlet_project.dto.Admin;


@WebServlet(value="/adminLogin")
public class AdminLoginController extends HttpServlet {
    
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		HttpSession httpSession=req.getSession();
		AdminDao dao = new AdminDao();
		String email = req.getParameter("adminEmail");
		String password = req.getParameter("adminPassword");
		Admin admin = dao.fetchAdminByEmailForLoginDao(email);
		if (admin != null) {
			if (admin.getAdminPassword().equals(password)) {
				httpSession.setAttribute("adminSession", email);
				httpSession.setMaxInactiveInterval(220);
				req.getRequestDispatcher("movie-register.jsp").forward(req, resp);
			} else {
				req.setAttribute("adminMsg", "Password is invalid");
				req.getRequestDispatcher("admin-login.jsp").forward(req, resp);
			}
		} else {
			req.setAttribute("adminMsg", "Email  is invalid");
			req.getRequestDispatcher("admin-login.jsp").forward(req, resp);
		}
	}

}
