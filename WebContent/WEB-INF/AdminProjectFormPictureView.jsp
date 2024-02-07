<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Project Information - Admin</title>
    <!-- Include Bootstrap CSS here -->
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
    <script src="https://kit.fontawesome.com/4022a78895.js" crossorigin="anonymous"></script>
	<style>
		<%@include file="css/sidebarNav.css"%>
		<%@include file="css/dataEntryContent.css"%>
		<%@include file="css/style.css"%>
	</style>
</head>
<body>
	<nav class="sideBar">
			<div class="sideBar-header">
				<a href="#">
					<img src="https://res.cloudinary.com/dprlflxcj/image/upload/v1701198691/img/logo_medium_e6ci8s.svg"/>
				</a>
				<a class="toggle">
					<img src="https://res.cloudinary.com/dprlflxcj/image/upload/v1701070223/icons/Menu_Alt_05_nffut7.svg" class="toggle">
				</a>
			</div>
			
			<ul class="items">
                <li class="item">
                    <a href="/EcoNex/Admin/Dashboard">
                        <i class="fa-solid fa-house fa icon"></i>
                        <span class="text">Home</span>
                    </a>
                </li>
                <li class="item active">
                    <a href="/EcoNex/Admin/Projects/ViewAll">
                        <i class="fa-regular fa-calendar icon"></i>
                        <span class="text">Projects</span>
                    </a>
                </li>
                <li class="divider"></li>
                <li class="item">
                    <a href="/EcoNex/Admin/Settings">
                        <i class="fa-solid fa-gear icon"></i>
                        <span class="text">Settings</span>
                    </a>
                </li>
            </ul>
		</nav>
		
		<section class="content">
			<div class="content-header">
				<div class="title" style="text-align: center;">
					<a class="back" href="/EcoNex/Admin/Projects/ViewSubmissions/${userId}/${eventId}">
						<i class="fa-solid fa-chevron-left" style="color: #000000; margin-right: 15px;"></i>
						<span>Back</span>
					</a>
					<p>Projects/Create New Project</p>
					<h2>Create Your New Project</h2>
					<p class="reminder">Please enter all relevant information regarding the project. Ensure the information is 
					precise to minimize changes that can confuse the participants later.
					</p>
				</div>
				<div class="line"></div>
			</div>
			<div class="content-posts">
				<div class="left">
					<div></div>
					<button class="btn-cancel">Leave</button>
				</div>
				<div class="center">
					<div class="form">
						<h3 style="margin-bottom: 20px">Project Information</h3>
						<form action="added" method="post" enctype="multipart/form-data">

			                <label for="projectImage">Upload Image</label>
		                    <input type="file" id="projectImage" name="projectImage" required>
			                
				            <input type="submit" id="submit-form" hidden>
						</form>
					</div>
				</div>

				<div class="right">
					<label class="submit-btn" for="submit-form" tabindex="0">Create</label>
				</div>
		    </div>
  		</section>	
    <!-- Include Bootstrap JS and jQuery here -->
    <script src="https://code.jquery.com/jquery-3.5.1.slim.min.js"></script>
    <script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.5.3/dist/umd/popper.min.js"></script>
    <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
</body>
</html>
