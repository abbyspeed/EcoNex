<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Submissions - Admin</title>
    <!-- Include Bootstrap CSS here -->
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
    <style>
			<%@include file="/css/sidebarNav.css"%>
			<%@include file="/css/style.css"%>
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
						<p>Admin - Submission Page</p>
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
        <!-- Tabs -->
        <ul class="nav nav-tabs custom-tabs">
            <li class="nav-item">
                <a class="nav-link active" href="#eventInfo" data-toggle="tab">Event Info</a>
            </li>
            <li class="nav-item">
                <a class="nav-link" href="#submissions" data-toggle="tab">Submissions</a>
            </li>
            <li class="nav-item">
                <a class="nav-link" href="#analytics" data-toggle="tab">Analytics</a>
            </li>
        </ul>

        <!-- Tab Content -->
        <div class="tab-content custom-tab-content">
            <!-- Event Info Tab Content -->
            <div class="tab-pane fade show active custom-tab-content" id="eventInfo">
                <!-- Content for Event Info tab -->
                <h3>Event Info</h3>
            </div>

            <!-- Submissions Tab Content -->
            <div class="tab-pane fade custom-tab-content" id="submissions">
                <!-- Content for Submissions tab -->
                <h3>Submissions</h3>
            </div>

            <!-- Analytics Tab Content -->
            <div class="tab-pane fade" id="analytics">
                <!-- Content for Analytics tab -->
                <h3>Analytics</h3>
            </div>
        </div>

        <!-- Horizontal Rule and Message -->
        <hr class="custom-hr">
        <div class="alert alert-warning">
            <p>Oops, no submissions yet. Come back later!</p>
        </div>
    </div>
 		</section>
    <!-- Include Bootstrap JS and jQuery here -->
    <script src="https://code.jquery.com/jquery-3.5.1.slim.min.js"></script>
    <script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.5.3/dist/umd/popper.min.js"></script>
    <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
</body>
</html>
