<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="ISO-8859-1">
		<title>NexCode - Events</title>
		<!-- Font Awesome -->
		<link
			href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.0.0/css/all.min.css"
			rel="stylesheet" />
		<!-- Google Fonts -->
		<link
			href="https://fonts.googleapis.com/css?family=Roboto:300,400,500,700&display=swap"
			rel="stylesheet" />
		<!-- MDB -->
		<link
			href="https://cdnjs.cloudflare.com/ajax/libs/mdb-ui-kit/7.0.0/mdb.min.css"
			rel="stylesheet" />
		<style>
			<%@ include file="css/sidebarNav.css"%>
			<%@ include file="css/style.css"%>
			<%@ include file="css/eventComponents.css"%>
		</style>
	</head>
	<body>
		<jsp:include page="/WEB-INF/components/Sidebar.jsp">
			<jsp:param name="pageName" value="Projects" />
			<jsp:param name="heading" value="Ongoing" />
			<jsp:param name="subheading" value="" />
			<jsp:param name="projectActive" value="active" />
		</jsp:include>
		<div class="section-content">
			<div>
				<c:if test="${not empty ongoingList}">
					<c:forEach var="upcomingEvent" items="${ongoingList}">
						<!-- Card -->
						<div class="card-container" style="padding-left: 30px;">
							<div class="card container-fluid">
								<!-- Card image -->
								<img class="card-img-top"
									src="https://res-console.cloudinary.com/dprlflxcj/media_explorer_thumbnails/839294ea3c0fed2c0118d3586d812ca0/detailed"
									alt="Card image cap">
								<!-- Card content -->
								<div class="card-body">
									<!-- Title -->
									<h4 class="card-title">
										<a>${ongoingList}</a>
									</h4>
									<!-- Text -->
									<p class="card-text">
										<span><b>Participants: </b></span>
									</p>
									<p class="card-text">
										<span><b>Duration: </b>
									</p>
									<p class="card-text">
										<span><b>Area: </b>Iskandar Puteri region
									</p>
									<!-- Button -->
									<a href="/EcoNex/Admin/Projects/ViewProject/2/1" class="btn btn-lg btn-primary btn-login"
										style="background-color: #080930">View Project</a>
								</div>
							</div>
						</div>
						<!-- Card -->
					</c:forEach>
			</c:if>
			<c:if test="${empty ongoingList}">
				<p style="padding-left: 30px;">You have no ongoing events.</p>
			</c:if>
			</div>
			<div class="upcoming-container">
				<!-- Upcoming Text -->
				<div class="upcoming-header">
					<h3>Upcoming</h3>
					<a href="/EcoNex/Admin/Projects/ProjectForm">
						<i class="fa fa-plus" aria-hidden="true"></i>
						Create New Project
					</a>
				</div>
				<c:if test="${not empty upcomingList}">
					<c:forEach var="upcomingEvent" items="${upcomingList}">
						<!-- Card -->
						<div class="card-container">
							<div class="card container-fluid">
								<!-- Card image -->
								<img class="card-img-top"
									src="https://res-console.cloudinary.com/dprlflxcj/media_explorer_thumbnails/839294ea3c0fed2c0118d3586d812ca0/detailed"
									alt="Card image cap">
								<!-- Card content -->
								<div class="card-body">
									<!-- Title -->
									<h4 class="card-title">
										<a>${upcomingEvent}</a>
									</h4>
									<p class="card-text">
										<span><b>Participants: </b></span>
									</p>
									<p class="card-text">
										<span><b>Duration: </b>
									</p>
									<p class="card-text">
										<span><b>Area: </b>Iskandar Puteri region
									</p>
									<!-- Button -->
									<a href="#" class="btn btn-lg btn-primary btn-login"
										style="background-color: #080930">View Project</a>
								</div>
							</div>
						</div>
						<!-- Card -->
					</c:forEach>
				</c:if>
				<c:if test="${empty upcomingList}">
					<p style="margin-top: 40px;">There are no upcoming events.</p>
				</c:if>
			</div>
		</div>
		<!-- MDB -->
		<script type="text/javascript"
			src="https://cdnjs.cloudflare.com/ajax/libs/mdb-ui-kit/7.0.0/mdb.umd.min.js"></script>
	</body>
</html>