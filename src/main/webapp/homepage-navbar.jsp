
<%@page import="com.jsp.movieflix_servlet_project.dto.User"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>User Dashboard - MovieFlex</title>
<style type="text/css">
body {
	margin: 0;
	font-family: Arial, sans-serif;
}

.navbar {
	position: fixed;
	top: 0;
	left: 0;
	width: 100%;
	background-color: #333;
	padding: 10px 0;
	z-index: 1000;
}

.container {
	max-width: 1200px;
	margin: 0 auto;
	padding: 0 20px;
	display: flex;
	justify-content: space-between;
	align-items: center;
}

.logo {
	color: #fff;
	margin: 0;
}

.dashboard {
    display: none;
    position: absolute;
    top: 50px; /* Adjusted to accommodate navbar height */
    right: 20px;
    background-color: #fff;
    border: 1px solid #ccc;
    border-radius: 5px;
    padding: 10px;
}

.dashboard-section {
    margin-bottom: 10px;
}

.profile-info {
    display: flex;
    align-items: center;
    margin-bottom: 20px;
   
    cursor: pointer;
}


.profile-info img {
    width: 30px;
    height: 30px;
    border-radius: 50%;
    margin-right: 10px;
    
}


.profile-info h4 {
    margin: 0;
}

.search-form {
    display: flex;
}

.search-form input[type="text"] {
    padding: 5px;
    border: 1px solid #ccc;
    border-radius: 5px;
    width: 200px;
}

.search-form input[type="submit"] {
    background-color: #007bff;
    border: none;
    color: #fff;
    padding: 5px 10px;
    cursor: pointer;
    border-radius: 5px;
    margin-left: 10px;
}

/* Show dashboard on hover */
.profile-info:hover .dashboard {
    display: block;
}

</style>
</head>
<body>
<%

User user=(User)request.getAttribute("user");

%>
<nav class="navbar">
    <div class="container">
        <h1 class="logo">MovieFlex</h1>

        <!-- Search Form -->
        <form class="search-form" action="searchMovie">
            <input type="text" placeholder="Enter your movie name" />
            <input type="submit" value="Search" />
        </form>

        <!-- Show user's name and profile picture in the navbar -->
        <div class="profile-info">
        	<%if(user!=null){%>
            	<span style="color: #fff;">Good morning<%=user.getName()%></span> <!-- Replace John Doe with actual username -->
            <%}%>
            <img src="https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcTU0zYcypyreQSHIWXlpNM2hnAi6gJlYkX3vA&s" alt="User Avatar">
            <!-- User Dashboard (Hidden by default, shown on hover) -->
            <div class="dashboard">
                <div class="dashboard-section">
                    <h4>User Profile</h4>
                    <p>Username: <%=user.getName() %></p>
                    <p>Email: <%= user.getEmail()%></p>
                </div>
                <div class="dashboard-section">
                    <a href="#">Logout</a>
                </div>
            </div>
        </div>
    </div>
</nav>

</body>
</html>
