<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>User Registration Page</title>
<style>
body, html {
	margin: 0;
	padding: 0;
	font-family: "Roboto", sans-serif;
	background-color: #f4f4f4; /* Added background color */
}

.navbar {
	background-color: black;
	color: white;
	padding: 15px;
	display: flex;
	justify-content: space-between;
}

.navbar a {
	padding: 10px;
	color: white;
	text-decoration: none;
}

.navbar a:hover {
	color: lightgray;
}

.parallax-bg {
	background-image: url("https://user-images.githubusercontent.com/33485020/108069438-5ee79d80-7089-11eb-8264-08fdda7e0d11.jpg");
	height: 50%;
	background-attachment: fixed;
	background-position: center;
	background-repeat: no-repeat;
	background-size: cover;
	display: flex;
	justify-content: center;
	align-items: center;
}

.form-container {
	width: 100%;
	padding: 20px;
	margin-top: 20px;
	background-color: rgba(255, 255, 255, 0.7);
	border-radius: 15px;
	max-width: 600px; /* Adjusted max-width */
	box-shadow: 0px 0px 10px rgba(0, 0, 0, 0.1);
}

.form-container h3 {
	color: green;
	text-align: center;
}

.form-group {
	margin-bottom: 20px;
}

.form-group label {
	display: block;
	font-weight: bold;
	margin-bottom: 5px;
}

.form-control {
	width: calc(100% -10px); /* Adjusted width */
	padding: 10px;
	border-radius: 5px;
	border: 1px solid #ccc;
}

.btn-primary {
	background-color: green;
	color: white;
	border: none;
	padding: 10px 20px;
	border-radius: 5px;
	cursor: pointer;
	width: 100%; /* Adjusted width */
}

.btn-primary:hover {
	background-color: darkgreen;
}
</style>
</head>
<body>
  <%String userMsg=(String) request.getAttribute("userMsg");%>
	<nav class="navbar">
		<a href="#">MovieFlex-User</a>
		<div id="com">
			<a href="index.jsp">Home</a> <a href="#">Logout</a>
		</div>
	</nav>
	<div class="parallax-bg">
		<div class="form-container">
			<h3>User Registration</h3>
			<%if(userMsg!=null){ %>
			  <h5><%=userMsg %></h5>
			  <%} %>
			<form id="registrationForm" action="userRegistration" method="post" enctype="multipart/form-data">
				<div class="form-group">
					<label for="name">Name:</label> <input type="text"
						class="form-control" id="name" name="name" required>
				</div>
				<div class="form-group">
					<label for="email">Email:</label> <input type="email"
						class="form-control" id="email" name="email" required>
				</div>
				<div class="form-group">
					<label for="password">Password:</label> <input type="password"
						class="form-control" id="password" name="password" required>
				</div>
			
				<div class="form-group">
					<label for="dob">Date of Birth:</label> <input type="date"
						class="form-control" id="dob" name="dob" required>
				</div>
				<div class="form-group">
					<label for="phone">Phone:</label> <input type="tel"
						class="form-control" id="phone" name="phone" required>
				</div>
				<div class="form-group">
					<label for="gender">Gender:</label> <select class="form-control"
						id="gender" name="gender" required>
						<option value="">Select</option>
						<option value="male">Male</option>
						<option value="female">Female</option>
						<option value="other">Other</option>
					</select>
				</div>
				<div class="form-group">
					<label for="profilePic">Profile Picture:</label> <input type="file"
						class="form-control" id="profilePic" name="profilePic"
						accept="image/*">
				</div>
				<button type="submit" class="btn-primary">Register</button>
			</form>
		</div>
	</div>
	<jsp:include page="all-footer.jsp" />
</body>
</html>