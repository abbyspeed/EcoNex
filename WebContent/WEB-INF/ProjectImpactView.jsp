<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="ISO-8859-1" name="viewport" content="width=device-width">
		<title>Welcome back!</title>
		<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-T3c6CoIi6uLrA9TneNEoa7RxnatzjcDSCmG1MXxSR1GAsXEV/Dwwykc2MPK8M2HN" crossorigin="anonymous">
		<script src="https://kit.fontawesome.com/4022a78895.js" crossorigin="anonymous"></script>
		<script src="/js/sidebar.js" type="text/javascript"></script>
		<style>
			<%@include file="css/contentMenu.css"%>
			<%@include file="css/sidebarNav.css"%>
			<%@include file="css/style.css"%>
			<%@include file="css/eventComponents.css"%>
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
                <li class="item active">
                    <a href="">
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
						<p>Events/${event.getName()}</p>
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
						<a href="/EcoNex/Events/DataEntry/${eventId}" class="tab-item">Data Entry</a>
						<a href="/EcoNex/Events/Instructions/${eventId}" class="tab-item">Instructions</a>
						<a href="/EcoNex/Events/EventInfo/${eventId}" class="tab-item">Event Info</a>
						<a href="/EcoNex/Events/ProjectImpact/${eventId}" class="tab-item active">Project Impact</a>
						<div class="menu-selected" style="left: 28px;"></div>
					</div>
				</div>
			</div>
			
			<div class="content-posts">
				<h3>Please select a month to enter your carbon details</h3>
				<h4>All data entries</h4>
				<div class="grid-view">
					<div class="month-card">
						<h3>Month</h3>
						<p class="sub-desc">Entry status description</p>
						<div class="sub-status">
							Submission status
						</div>
						<div class="bottom-layer">
							<div class="sub-date">
								<p>Due Date</p>
								<p>Date</p>
							</div>
							<a href="Housing/ShowForm/${eventId}" class="sub-btn">
								Opening soon
							</a>
						</div>
					</div>
					<div class="month-card new">
						<h3>Month</h3>
						<p class="sub-desc">Entry status description</p>
						<div class="sub-status">
							Submission status
						</div>
						<div class="bottom-layer">
							<div class="sub-date">
								<p>Due Date</p>
								<p>Date</p>
							</div>
							<a href="Housing/ShowForm/${eventId}" class="sub-btn new">
								Upload Details
							</a>
						</div>
					</div>
					<div class="month-card active">
						<h3>Month</h3>
						<p class="sub-desc">Entry status description</p>
						<div class="sub-status">
							Submission status
						</div>
						<div class="bottom-layer">
							<div class="sub-date">
								<p>Due Date</p>
								<p>Date</p>
							</div>
							<a href="Housing/ShowForm/${eventId}" class="sub-btn active">
								View Submission
							</a>
						</div>
					</div>
					<div class="month-card active">
						<h3>Month</h3>
						<p class="sub-desc">Entry status description</p>
						<div class="sub-status">
							Submission status
						</div>
						<div class="bottom-layer">
							<div class="sub-date">
								<p>Due Date</p>
								<p>Date</p>
							</div>
							<a href="Housing/ShowForm/${eventId}" class="sub-btn active">
								View Submission
							</a>
						</div>
					</div>
				</div>
			</div>
		</section>
	</body>
</html>