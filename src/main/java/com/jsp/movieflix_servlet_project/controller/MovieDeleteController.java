package com.jsp.movieflix_servlet_project.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.jsp.movieflix_servlet_project.dao.MovieDao;

@WebServlet(value = "/adminDelete")
public class MovieDeleteController extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		HttpSession httpSession = req.getSession();
		MovieDao dao = new MovieDao();
		int id = Integer.parseInt(req.getParameter("id"));
		
		dao.deleteMovieById(id);
		req.getRequestDispatcher("movie-display.jsp").forward(req, resp);

//		if (httpSession.getAttribute("adminSession") != null) {
//			httpSession.invalidate();
//			dao.deleteMovieById(id);
//			req.setAttribute("adminMsg", "Movie details deleted");
//			req.getRequestDispatcher("movie-display.jsp").forward(req, resp);
//		}else {
//			req.setAttribute("adminMsg", "Movie details  not deleted");
//			req.getRequestDispatcher("movie-display.jsp").forward(req, resp);
//		}

	}

}
