<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="ISO-8859-1">
		<title>EcoNex</title>
		<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-T3c6CoIi6uLrA9TneNEoa7RxnatzjcDSCmG1MXxSR1GAsXEV/Dwwykc2MPK8M2HN" crossorigin="anonymous">
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
                    <a href="Dashboard.jsp">
                        <i class="fa-solid fa-house fa icon"></i>
                        <span class="text">Home</span>
                    </a>
                </li>
                <li class="item">
                    <a href="#">
                        <i class="fa-regular fa-calendar icon"></i>
                        <span class="text">Projects</span>
                    </a>
                </li>
                <li class="divider"></li>
                <li class="item active">
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
						<p>Analytics/${event.getName()}</p>
						<h2>${event.getName()}</h2>
					</div>
					<div class="profileBadge">
						<a href="#">
							<c:set value="${sessionScope.user.username}" var="username" />
							<span><c:out value="${username}"></c:out></span>
							<!-- <img src="https://res.cloudinary.com/dprlflxcj/image/upload/v1701259220/img/user_i1inw7.jpg"> -->
						</a>
					</div>
				</div>
				<div class="line">
					<div class="menu">
						<a href="/EcoNex/Admin/Projects/ViewProject/${userId}/${eventId}" class="tab-item">Event Info</a>
						<a href="/EcoNex/Admin/Projects/ViewSubmission/${userId}/${eventId}" class="tab-item">Submissions</a>
						<a href="/EcoNex/Admin/Projects/ViewAnalytics/${userId}/${eventId}" class="tab-item active">Analytics</a>
						<div class="menu-selected"></div>
					</div>
				</div>
			</div>
			
			<div class="content-posts">
				<div class="tab-content">
					<h3 class="event-slogan">
						This is our achievement so far
					</h3>
					<a href=""></a>
					<div class="event-section">
						
					</div>
				</div>
			</div>
		</section>
		
	</body>
</html>