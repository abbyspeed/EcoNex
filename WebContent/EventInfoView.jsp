<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="ISO-8859-1">
		<title>EcoNex</title>
		<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-T3c6CoIi6uLrA9TneNEoa7RxnatzjcDSCmG1MXxSR1GAsXEV/Dwwykc2MPK8M2HN" crossorigin="anonymous">
		<script src="https://kit.fontawesome.com/4022a78895.js" crossorigin="anonymous"></script>
		<script src="/js/content-menu.js" type="text/javascript"></script>
		<style>
			<%@include file="/css/contentMenu.css"%>
			<%@include file="/css/sidebarNav.css"%>
			<%@include file="/css/dashboardContent.css"%>
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
						<a href="#" class="tab-item">Instructions</a>
						<a href="#" class="tab-item active">Event Info</a>
						<a href="#" class="tab-item">Project Impact</a>
						<div class="menu-selected"></div>
					</div>
				</div>
			</div>
			
			<div class="content-posts">
				<div class="tab-content">
					<h3 class="event-slogan">
						Save energy for a better <br>
						environment now and tomorrow
					</h3>
					<div class="event-section">
						<h4>WHAT IS IT?</h4>
						<hr>
						<div class="event-desc">
							<p>
								This competition aims to provide encouragement and motivation to the 
								residents of the Iskandar Puteri City Council, MBIP to <b>cultivate a low-
								carbon lifestyle</b>. Through the competition to reduce the use of water (m3), 
								electricity (kWh) and also the amount of recycling (kg), it can help the world, 
								especially MBIP in efforts to reduce carbon production.
							</p>
						</div>
					</div>
					<div style="height: 70px"></div>
					<div class="event-section">
						<h4>STARTING ON</h4>
						<hr>
						<div class="event-desc">
							<h1 style="font-size: 108px;">1 NOV 2023</h1>
							<p style="width: 100%; text-align: right;">
								Until April 2024
							</p>
						</div>
					</div>
				</div>
			</div>
		</section>
		
	</body>
</html>