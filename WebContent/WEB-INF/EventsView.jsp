<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
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
<%@ include file="/css/sidebarNav.css"%>
<%@ include file="/css/dashboardContent.css"%>
<%@ include file="/css/style.css"%>
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
	<jsp:include page="/WEB-INF/components/Sidebar.jsp">
		<jsp:param name="pageName" value="Events" />
		<jsp:param name="heading" value="Ongoing" />
		<jsp:param name="subheading" value="" />
		<jsp:param name="eventActive" value="active" />
	</jsp:include>
	<div class="section-content">
		<div>
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
							<a>Iskandar Puteri Low Carbon Calendar Competition</a>
						</h4>
						<!-- Text -->
						<p class="card-text">
							<span><b>Eligibility: </b></span>Approved
						</p>
						<p class="card-text">
							<span><b>Participation Status: </b>Not joined yet.
						</p>
						<p class="card-text">
							<span><b>Duration: </b>01/11/2023 - 30/04/2024
						</p>
						<p class="card-text">
							<span><b>Area: </b>Iskandar Puteri region
						</p>
						<!-- Button -->
						<a href="#" class="btn btn-lg btn-primary btn-login"
							style="background-color: #080930">Register</a>
					</div>
				</div>
			</div>
			<!-- Card -->
		</div>
		<div class="title" style="padding-left: 30px;">
			<!-- Upcoming Text -->
			<h3>Upcoming</h3>
			<p>There are no upcoming events.</p>
		</div>
	</div>
	<!-- MDB -->
	<script type="text/javascript"
		src="https://cdnjs.cloudflare.com/ajax/libs/mdb-ui-kit/7.0.0/mdb.umd.min.js"></script>
</body>
</html>