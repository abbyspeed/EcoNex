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
		@media ( min-width : 768px) {
			.card-container {
				max-width: 500px;
				heigth: auto;
				margin-bottom: 24px;
				padding-left: 30px;
			}
		}
		
		@media ( max-width : 768px) {
			.card-container {
				width: 100%;
				margin-bottom: 24px;
			}
		}
		/* CONTENT HEADER */
		.section-content {
			width: calc(100% - 235px);
			position: relative;
			left: 235px;
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
                    <a href="/EcoNex/Dashboard">
                        <i class="fa-solid fa-house fa icon"></i>
                        <span class="text">Home</span>
                    </a>
                </li>
                <li class="item active">
                    <a href="/EcoNex/Events/ViewAll">
                        <i class="fa-regular fa-calendar icon"></i>
                        <span class="text">Events</span>
                    </a>
                </li>
                <li class="divider"></li>
                <li class="item">
                    <a href="/EcoNex/Settings">
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
						<p>Events</p>
						<h3>Upcoming and Ongoing</h3>
						<p></p>
					</div>
					<div class="profileBadge">
						<a href="/EcoNex/Settings">
							<span>${sessionScope.user.getUsername()}</span>
						</a>
					</div>
				</div>
			</div>
		</section>
				
		<div class="section-content">
			<div>
				<c:if test="${not empty eventList}">
					<c:forEach var="event" items="${eventList}">
							<!-- Card -->
							<div class="card-container">
								<div class="card container-fluid">
									<!-- Card image -->
									<!--  
									<img class="card-img-top"
										src="https://images.pexels.com/photos/2747449/pexels-photo-2747449.jpeg?cs=srgb&dl=pexels-wolfgang-2747449.jpg&fm=jpg">
									<img class="card-img-top">
									-->
									<iframe src="https://www.facebook.com/plugins/post.php?href=https%3A%2F%2Fwww.facebook.com%2Fphoto%2F%3Ffbid%3D560459829605070%26set%3Da.560459822938404&show_text=false&width=500" width="500" height="533" style="border:none;overflow:hidden" scrolling="no" frameborder="0" allowfullscreen="true" allow="autoplay; clipboard-write; encrypted-media; picture-in-picture; web-share"></iframe>
									<!-- Card content -->
									<div class="card-body">
										<!-- Title -->
										<h4 class="card-title">
											<a>${event.getName()}</a>
										</h4>
										<!-- Text -->
										<p class="card-text">
											<span><b>Event Status: </b></span>${event.getStatus()}
										</p>
										<p class="card-text">
											<span><b>Duration: </b>${event.getStartDate()} - ${event.getEndDate()}
										</p>
										<p class="card-text">
											<span><b>Area: </b>Iskandar Puteri region
										</p>
										<!-- Button -->
										<a href="/EcoNex/Events/DataEntry/${event.getEventId()}" class="btn btn-lg btn-primary btn-login"
											style="background-color: #080930">Register</a>
									</div>
								</div>
							</div>
							<!-- Card -->
					</c:forEach>
				</c:if>
				<c:if test="${empty eventList}">
					<p style="padding-left: 30px;">You have no events.</p>
				</c:if>
			</div>
		</div>
		<!-- MDB -->
		<script type="text/javascript"
			src="https://cdnjs.cloudflare.com/ajax/libs/mdb-ui-kit/7.0.0/mdb.umd.min.js"></script>
	</body>
</html>