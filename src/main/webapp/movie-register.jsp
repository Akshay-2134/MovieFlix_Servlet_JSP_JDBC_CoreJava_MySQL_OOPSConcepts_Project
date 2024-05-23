<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>MovieRegister</title>
<style>
body, html {
	margin: 0;
	padding: 0;
	font-family: "Roboto", sans-serif;
}

.navbar {
	background-color: black;
	color: white;
	padding: 15px;
	display: flex;
	justify-content: space-between;
}

.navbar a {
	color: white;
	text-decoration: none;
}

.navbar a:hover {
	color: lightgray;
}

#com a {
	padding: 4px;
}

.parallax-bg {
	background-image: url("https://user-images.githubusercontent.com/33485020/108069438-5ee79d80-7089-11eb-8264-08fdda7e0d11.jpg");
	height: 50%;
	background-attachment: fixed;
	background-position: center;
	background-repeat: no-repeat;
	background-size: cover;
	position: relative;
	border: 1px solid white;
}

.form-container {
	padding: 20px;
	background-color: rgba(255, 255, 255, 0.7);
	border-radius: 15px;
	margin: 50px auto;
	max-width: 700px;
	box-shadow: 0px 0px 10px rgba(0, 0, 0, 0.1);
}

.form-container h3 {
	color: green;
	text-align: center;
}

/* New CSS for label positioning */
.form-group {
	margin-bottom: 20px;
	display: flex;
	flex-wrap: wrap;
	justify-content: space-between;
	align-items: baseline; /* Align labels with their fields */
}

.form-group label {
	display: block;
	font-weight: bold;
	margin-bottom: 5px;
	flex: 0 0 100%; /* Take full width */
}

.form-control-lg {
	width: 45%;
	padding: 10px;
	border-radius: 5px;
	border: 1px solid #ccc;
	flex: 0 0 45%;
}

.btn-primary {
	background-color: green;
	color: white;
	border: none;
	padding: 10px 20px;
	border-radius: 5px;
	cursor: pointer;
}

.btn-primary:hover {
	background-color: darkgreen;
}

.text-center {
	text-align: center;
}

/* Added spacing between fields */
.form-group>* {
	margin-bottom: 10px;
}
</style>


</head>
<body>
   <%String adminMsg=(String) request.getAttribute("adminMsg") ;%>
	<%--  <jsp:include page="admin-navbar.jsp"></jsp:include>  
	<br>   --%>
	<nav class="navbar">
		<a href="#">MovieFlex-Admin</a>
		<div id="com">
			<a href="">Home</a>
			<a href="admindisplay">Display</a>
			 <a href="adminLogout">Logout</a>
		</div>
	</nav>
	<div class="parallax-bg">
		<div class="form-container">
			<h3>Movie Registration</h3>
			
			 <%
			if(adminMsg!=null){
			%>
			<h5 style="color:pink;"><%=adminMsg%></h5>
			<%
			}
			%>  
			<form id="movieForm" action="movieRegister" method="post"
				enctype="multipart/form-data">
				<div class="form-group">
					<label for="name">Movie Name</label> <input type="text"
						class="form-control form-control-lg" id="name" name="name"
						placeholder="Enter your Movie" required />
				</div>
				<div class="form-group">
					<label for="release">Release Date</label> <input type="date"
						class="form-control form-control-lg" id="release" name="release"
						required />
				</div>
				<div class="form-group">
					<label for="genresType">Genres Type</label> <input type="text"
						class="form-control form-control-lg" id="genresType"
						name="genresType" placeholder="e.g., Action, Drama" />
				</div>
				<div class="form-group">
					<label for="language">Language</label> <input type="text"
						class="form-control form-control-lg" id="language" name="language"
						placeholder="e.g., English, Hindi" />
				</div>
				<div class="form-group">
					<label for="description">Description</label> <input type="text"
						class="form-control form-control-lg" id="description"
						name="description" placeholder="Brief description of the movie" />
				</div>
				<div class="form-group">
					<label for="productionhouse">Production House</label> <input
						type="text" class="form-control form-control-lg"
						id="productionhouse" name="productionhouse"
						placeholder="e.g., Warner Bros., Yash Raj Films" />
				</div>
				<div class="form-group">
					<label for="directorname">Director Name</label> <input type="text"
						class="form-control form-control-lg" id="directorname"
						name="directorname" placeholder="Name of the director" />
				</div>
				<div class="form-group">
					<label for="quality">Quality</label> <input type="text"
						class="form-control form-control-lg" id="quality" name="quality"
						placeholder="e.g., HD, 4K" />
				</div>
				<div class="form-group">
					<label for="url">Image URL</label> <input type="text"
						class="form-control form-control-lg" id="url" name="url"
						placeholder="URL of the movie poster" />
				</div>
				<div class="form-group">
					<label for="movie">Movie Type</label> <select
						class="form-select form-control-lg"
						aria-label="Default select example" name="movie">
						<option selected>Movie Type</option>
						<option value="Bollywood">Bollywood</option>
						<option value="Hollywood">Hollywood</option>
						<option value="Tollywood">Tollywood</option>
					</select>
				</div>
				<div class="form-group">
					<label for="poster">Movie Poster</label> <input type="file"
						class="form-control form-control-lg" id="poster" name="poster"
						accept="image/*" required />
				</div>
				<div class="text-center">
					<button id="submitBtn" class="btn btn-primary btn-lg" type="submit">
						Submit</button>
				</div>
			</form>
		</div>
	</div>
	<jsp:include page="all-footer.jsp" />
</body>
</html>