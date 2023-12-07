<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Project Information - Admin</title>
    <!-- Include Bootstrap CSS here -->
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
    <style>
			<%@include file="/css/sidebarNav.css"%>
			<%@include file="/css/style.css"%>
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
                <li class="item active">
                    <a href="#">
                        <i class="fa-solid fa-house fa icon"></i>
                        <span class="text">Home</span>
                    </a>
                </li>
                <li class="item">
                    <a href="#">
                        <i class="fa-regular fa-calendar icon"></i>
                        <span class="text">Events</span>
                    </a>
                </li>
                <li class="divider"></li>
                <li class="item">
                    <a href="#">
                        <i class="fa-solid fa-gear icon"></i>
                        <span class="text">Settings</span>
                    </a>
                </li>
            </ul>
		</nav>
		
		<section class="content">
			<div class="content-header">
				<div class="item">
					<div class="title">
						<p>Project Information - Admin</p>
					</div>
					<div class="profileBadge">
						<a href="#">
							<span>Nurnabihah</span>
							<img src="https://res.cloudinary.com/dprlflxcj/image/upload/v1701259220/img/user_i1inw7.jpg">
						</a>
					</div>
				</div>
			</div>
	<div class="container mt-5">
        <h1 class="mb-4">Project Information</h1>
        <form action="submitProjectInfo.jsp" method="POST" enctype="multipart/form-data">
            <!-- Project Name -->
            <div class="form-group">
                <label for="projectName">Name:</label>
                <input type="text" class="form-control" id="projectName" name="projectName" required>
            </div>

            <!-- Project Slogan -->
            <div class="form-group">
                <label for="projectSlogan">Slogan:</label>
                <input type="text" class="form-control" id="projectSlogan" name="projectSlogan" required>
            </div>

            <!-- Project Description -->
            <div class="form-group">
                <label for="projectDescription">Description:</label>
                <textarea class="form-control" id="projectDescription" name="projectDescription" rows="4" required></textarea>
            </div>

            <!-- Project Start Date (Calendar Input) -->
            <div class="form-group">
                <label for="startDate">Start Date:</label>
                <input type="date" class="form-control" id="startDate" name="startDate" required>
            </div>

            <!-- Project End Date -->
            <div class="form-group">
                <label for="endDate">End Date:</label>
                <input type="date" class="form-control" id="endDate" name="endDate" required>
            </div>

            <!-- Beautified Image Upload Section -->
            <div class="form-group">
                <label for="projectImage">Upload Image:</label>
                <div class="custom-file">
                    <input type="file" class="custom-file-input" id="projectImage" name="projectImage" required>
                    <label class="custom-file-label" for="projectImage">Choose an image</label>
                </div>
            </div>

            <button type="submit" class="btn btn-primary">Submit</button>
        </form>
    </div>
  		</section>	
    </div>
    <!-- Include Bootstrap JS and jQuery here -->
    <script src="https://code.jquery.com/jquery-3.5.1.slim.min.js"></script>
    <script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.5.3/dist/umd/popper.min.js"></script>
    <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
</body>
</html>
