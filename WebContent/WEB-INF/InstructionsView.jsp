<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>EcoNex User Guide</title>
    <!-- Include Bootstrap CSS here -->
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
    <script src="https://kit.fontawesome.com/4022a78895.js" crossorigin="anonymous"></script>
    <script src="/js/content-menu.js" type="text/javascript"></script>
    <style>
			<%@include file="css/contentMenu.css"%>
			<%@include file="css/sidebarNav.css"%>
			<%@include file="css/dashboardContent.css"%>
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
                    <a href="#">
                        <i class="fa-solid fa-house fa icon"></i>
                        <span class="text">Home</span>
                    </a>
                </li>
                <li class="item active">
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
						<p>Events/Iskandar Puteri Low Carbon Competition</p>
						<h2>Iskandar Puteri Low Carbon Competition</h2>
					</div>
					<div class="profileBadge">
						<a href="#">
							<span>Nurnabihah</span>
							<img src="https://res.cloudinary.com/dprlflxcj/image/upload/v1701259220/img/user_i1inw7.jpg">
						</a>
					</div>
				</div>
				<div class="line">
					<div class="menu">
						<a href="#" class="tab-item">Data Entry</a>
						<a href="#" class="tab-item active">Instructions</a>
						<a href="EventInfoView.jsp" class="tab-item">Event Info</a>
						<a href="#" class="tab-item">Project Impact</a>
						<div class="menu-selected" style="left: 135px;"></div>
					</div>
				</div>
			</div>
		    <div class="container mt-5">
		        <h1 class="mb-4">Welcome to EcoNex - User Guide</h1>
		        
		        <!-- Feature 1: Streamlined Data Entry -->
		        <div class="card mb-4">
		            <div class="card-header">
		                Feature 1: Streamlined Data Entry
		            </div>
		            <div class="card-body">
		                <p class="card-text">
		                    EcoNex provides an easy-to-use interface for entering your carbon consumption data. Simply click on the "Enter Data" button and follow the prompts to submit your monthly information.
		                </p>
		            </div>
		        </div>
		
		        <!-- Feature 2: Automated Data Calculation -->
		        <div class="card mb-4">
		            <div class="card-header">
		                Feature 2: Automated Data Calculation
		            </div>
		            <div class="card-body">
		                <p class="card-text">
		                    Say goodbye to manual calculations! EcoNex uses advanced algorithms to automatically calculate your carbon reduction based on the data you provide. This ensures accuracy and reduces errors.
		                </p>
		            </div>
		        </div>
		
		        <!-- Feature 3: Data Representation and Reporting -->
		        <div class="card">
		            <div class="card-header">
		                Feature 3: Data Representation and Reporting
		            </div>
		            <div class="card-body">
		                <p class="card-text">
		                    Explore your contributions! EcoNex generates detailed reports and graphs, allowing you to track your progress and compare it with your community's achievements. Stay motivated and make a positive impact.
		                </p>
		            </div>
		        </div>
				
		        
		        <a href="index.html" class="btn btn-primary mt-4">Start Using EcoNex</a>
		    </div>
    	</section>
    <!-- Include Bootstrap JS and jQuery here -->
    <script src="https://code.jquery.com/jquery-3.5.1.slim.min.js"></script>
    <script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.5.3/dist/umd/popper.min.js"></script>
    <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
</body>
</html>
