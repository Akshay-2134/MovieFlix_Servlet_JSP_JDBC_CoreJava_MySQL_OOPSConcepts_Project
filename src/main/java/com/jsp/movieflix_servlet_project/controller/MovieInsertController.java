package com.jsp.movieflix_servlet_project.controller;

import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.time.LocalDate;

import javax.imageio.ImageIO;
import javax.imageio.ImageWriteParam;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.servlet.http.Part;

import com.jsp.movieflix_servlet_project.dao.MovieDao;
import com.jsp.movieflix_servlet_project.dto.Movie;

@WebServlet(value = "/movieRegister")
@MultipartConfig
public class MovieInsertController extends HttpServlet {
	MovieDao dao = new MovieDao();

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		HttpSession httpSession = req.getSession();

		String name = req.getParameter("name");
		String releaseDate = req.getParameter("release");
		String genresType = req.getParameter("genresType");
		String lanaguage = req.getParameter("language");
		String description = req.getParameter("description");
		String productionHouse = req.getParameter("productionhouse");
		String directorName = req.getParameter("directorname");
		String quality = req.getParameter("quality");
		String url = req.getParameter("url");
		String type = req.getParameter("movie");
		Part part = req.getPart("poster");

//		InputStream inputStream = part.getInputStream();
//		BufferedImage originalImage = ImageIO.read(inputStream);
//		int newWidth = 20; // Set your desired width
//		int newHeight = 20; // Set your desired height
//		BufferedImage resizedImage = new BufferedImage(newWidth, newHeight, BufferedImage.TYPE_INT_RGB);
//		Graphics2D g = resizedImage.createGraphics();
//		g.drawImage(originalImage, 0, 0, newWidth, newHeight, null);
//		g.dispose();
//
//		// Convert BufferedImage back to InputStream
//		ByteArrayOutputStream baos = new ByteArrayOutputStream();
//		ImageWriteParam param = ImageIO.getImageWritersByFormatName("jpg").next().getDefaultWriteParam();
//		param.setCompressionMode(ImageWriteParam.MODE_EXPLICIT);
//		param.setCompressionQuality(1.0f); // Set compression quality to best
//		ImageIO.write(resizedImage, "jpg", baos);
//		InputStream resizedInputStream = new ByteArrayInputStream(baos.toByteArray());
//
//		// Reset stream position to beginning
//		resizedInputStream.reset();

		Movie movie = new Movie(name, LocalDate.parse(releaseDate), genresType, lanaguage, description, productionHouse,
				directorName, quality, part.getInputStream(), url, type);

		if (httpSession.getAttribute("adminSession") != null) {
			dao.saveMovieDao(movie);
			req.setAttribute("adminMsg", "Movie Registered Successfuly");
			req.getRequestDispatcher("movie-register.jsp").forward(req, resp);
		} else {
			req.setAttribute("adminMsg", "Your Session is Out");
			req.getRequestDispatcher("admin-login.jsp").forward(req, resp);
		}

	}
}
