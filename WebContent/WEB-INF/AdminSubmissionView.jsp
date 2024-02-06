<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Submissions - Admin</title>
    <!-- Include Bootstrap CSS here -->
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-T3c6CoIi6uLrA9TneNEoa7RxnatzjcDSCmG1MXxSR1GAsXEV/Dwwykc2MPK8M2HN" crossorigin="anonymous">
	<script src="https://kit.fontawesome.com/4022a78895.js" crossorigin="anonymous"></script>
	<script src="/js/sidebar.js" type="text/javascript"></script>
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
    <style>
		<%@include file="css/contentMenu.css"%>
		<%@include file="css/sidebarNav.css"%>
		<%@include file="css/style.css"%>
		<%@include file="css/eventComponents.css"%>
	</style>
	<style>
        /* Custom CSS for tabs */
        .custom-tabs .nav-link {
            border: none; /* Remove the border */
        }
        .custom-tabs .nav-link.active {
            color: #90EE90 !important;
            border: none;
        }
        
        /* Custom CSS for hr and bottom margin */
        .custom-hr {
            border-color: #90EE90;
            margin-bottom: 20px;
        }
         .custom-tab-content {
            background-color: #fff; /* Set background color to white */
            padding: 20px; 
        }
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
                <a href="">
                    <i class="fa-regular fa-calendar icon"></i>
                    <span class="text">Projects</span>
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
					<p>Projects/${event.getName()}</p>
					<h2>${event.getName()}</h2>
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
					<a href="/EcoNex/Admin/Projects/ViewProject/${userId}/${eventId}" class="tab-item">Event Info</a>
					<a href="/EcoNex/Admin/Projects/ViewSubmission/${userId}/${eventId}" class="tab-item active">Submissions</a>
					<a href="/EcoNex/Admin/Projects/ViewAnalytics/${userId}/${eventId}" class="tab-item">Analytics</a>
					<div class="menu-selected" style="left: 135px;"></div>
				</div>
			</div>
		</div>
		
		<div class="content-posts">
			<h3>This project has ${housingList.size()} total submissions.</h3>
			<c:choose>
				<c:when test="${housingList != null}">
					<div class="month-section">
						<h4>Month</h4>
						<div class="user-entries">
							<p style="padding: 15px;">Username</p>
							<div class="user-entries-details">
								<table>
									<tr>
										<th>Area</th>
										<th>Category</th>
									</tr>
									<tr>
										<td>AreaValue</td>
										<td>CategoryValue</td>
									</tr>
								</table>
							</div>
							<a href="">View Submission</a>
						</div>
					</div>
				</c:when>
				
				<c:otherwise>
			        <div class="alert alert-warning">
			            <p>Oops, no submissions yet. Come back later!</p>
			        </div>
		        </c:otherwise>
	        </c:choose>
	    </div>
 	</section>
    <!-- Include Bootstrap JS and jQuery here -->
    <script src="https://code.jquery.com/jquery-3.5.1.slim.min.js"></script>
    <script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.5.3/dist/umd/popper.min.js"></script>
    <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
</body>
</html>