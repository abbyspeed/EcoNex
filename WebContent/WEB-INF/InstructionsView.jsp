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
						<p>Events/${event.getName()}</p>
						<h2>${event.getName()}</h2>
					</div>
					<div class="profileBadge">
						<a href="/EcoNex/Settings">
							<span>${user.getUsername()}</span>
						</a>
					</div>
				</div>
				<div class="line">
					<div class="menu">
						<a href="/EcoNex/Events/DataEntry/${event.getEventId()}" class="tab-item">Data Entry</a>
						<a href="/EcoNex/Events/Instructions/${event.getEventId()}" class="tab-item active">Instructions</a>
						<a href="/EcoNex/Events/EventInfo/${event.getEventId()}" class="tab-item">Event Info</a>
						<a href="/EcoNex/Events/ProjectImpact/${event.getEventId()}" class="tab-item">Project Impact</a>
						<div class="menu-selected"  style="left: 135px;"></div>
					</div>
				</div>
			</div>
			<div class="content-posts">
			    <div class="container mt-5">
			        <h1 class="mb-4">User Guide</h1>
			        
			        <div class="card mb-4">
			            <div class="card-header">
			                Rules to Follow
			            </div>
			            <div class="card-body">
			                <p class="card-text">
			                    <ol>
			                    	<li>This competition is open specifically to residents within the administrative area of Iskandar Puteri City Council only.</li>
			                    	<li>Each house/public institution/private company/school within the MBIP area can send only <b>one</b> entry.</li>
			                    	<li>The selection of the winning criteria is based on the amount of savings, the highest reduction in water and electricity consumption and the amount of recycling.</li>
									<li>Winners are notified online and also at a presentation ceremony to be organized in December.</li>
									<li>MBIP reserves the right to amend the conditions and changes regarding the competition without any prior notification.</li>
									<li>MBIP's decision is <b>final</b> and no appeals will be entertained.</li>
			                    </ol>
			                </p>
			            </div>
			        </div>

			        <div class="card mb-4">
			            <div class="card-header">
			                Entry Reminders
			            </div>
			            <div class="card-body">
			                <p class="card-text">
			                    <ol>
			                    	<li>Start by entering your housing details first.</li>
			                    	<li>There will be 3 categories: <b>Electricity</b>, <b>Water</b> and <b>Recycling Waste</b></li>
			                    	<li>You are only allowed to key in information that is true (in which proof is under your possession).</li>
									<li>Any false information or act of impersonating someone will be taken <b>seriously</b>.</li>
			                    </ol>
			                </p>
			            </div>
			        </div>
			        <div style="height: 20px"></div>
				</div>
		    </div>
    	</section>
    <!-- Include Bootstrap JS and jQuery here -->
    <script src="https://code.jquery.com/jquery-3.5.1.slim.min.js"></script>
    <script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.5.3/dist/umd/popper.min.js"></script>
    <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
</body>
</html>
