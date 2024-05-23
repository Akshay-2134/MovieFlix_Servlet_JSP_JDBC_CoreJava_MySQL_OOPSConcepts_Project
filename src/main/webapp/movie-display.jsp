<%@page import="com.jsp.movieflix_servlet_project.dto.Movie"%>
<%@page import="java.util.List"%>
<%@page import="com.jsp.movieflix_servlet_project.dao.MovieDao"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style>
body {
	display: flex;
	justify-content: center;
	align-items: center;
	height: 100vh;
}

.container {
	display: flex;
	justify-content: center;
	align-items: center;
	 
}

table {
	border: 2px solid black;
}

caption {
	font-size: 40px;
	font-weight: 16px;
}

th {
	color: yellow;
	background-color: green;
}
</style>
</head>
<body>
   <%MovieDao dao=new MovieDao();
     List<Movie> movies=dao.getAllMovieDetails();
   %>
    
	<div class="container">
		<table border="2px">
			<caption>Movie Details</caption>
			<tr>
			    <th>Id</th>
				<th>Movie Name</th>
				<th>Release Date</th>
				<th>Genres Type</th>
				<th>Language</th>
				<th>Description</th>
				<th>Production House</th>
				<th>Director Name</th>
				<th>Quality</th>
				<th>Image URL</th>
				<th>Movie Type</th>
				<th>Image</th>
				<th colspan="2">Action</th>
			</tr>
          <%for(Movie movie:movies) {%>
			<tr>
			    <td><%=movie.getId() %></td>
				<td><%=movie.getName() %></td>
				<td><%=movie.getReleasedYear() %></td>
				<td><%=movie.getGenresType() %></td>
				<td><%=movie.getLanguage() %></td>
				<td><%=movie.getDescription() %></td>
				<td><%=movie.getProductionHouse() %></td>
				<td><%=movie.getDirectorName() %></td>
				<td><%=movie.getQuality() %></td>
				<td><%=movie.getUrl() %></td>
				<td><%=movie.getType() %></td>
				<td><%=movie.getImageFecth() %></td>
				<td style="background-color: red;"><a href="adminDelete?id=<%=movie.getId()%>"><button
							style="color: red">Delete</button></a></td>
				<td style="background-color: green"><a href="update.jsp?id=<%=movie.getId()%>"><button
							style="color: green">Update</button></a></td>
			</tr>
          <%} %>
		</table>
	</div>
	<jsp:include page="all-footer.jsp" />
</body>
</html>