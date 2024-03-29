<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
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
			<%@include file="../css/sidebarNav.css"%>
			<%@include file="../css/dashboardContent.css"%>
			<%@include file="../css/style.css"%>
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
                <li class="item <%= request.getParameter("homeActive")%>">
                    <a href="/EcoNex/Admin/Dashboard">
                        <i class="fa-solid fa-house fa icon"></i>
                        <span class="text">Home</span>
                    </a>
                </li>
                <li class="item <%= request.getParameter("projectActive")%>">
                    <a href="/EcoNex/Admin/Projects/ViewAll">
                        <i class="fa-regular fa-calendar icon"></i>
                        <span class="text">Projects</span>
                    </a>
                </li>
                <li class="divider"></li>
                <li class="item <%= request.getParameter("settingsActive")%>">
                    <a href="/EcoNex/Admin/Settings">
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
						<p><%= request.getParameter("pageName") %></p>
						<h3><%= request.getParameter("heading") %></h3>
						<p><%= request.getParameter("subheading") %></p>
					</div>
					<div class="profileBadge">
						<a href="#">
							<c:set value="${sessionScope.user.username}" var="username" />
							<span><c:out value="${username}"></c:out></span>
							<c:set value="${requestScope.profilePic}" var="profilePic"></c:set>
							<c:if test="${profilePic == null} }">
								<img src="https://res.cloudinary.com/dprlflxcj/image/upload/v1701259220/img/user_i1inw7.jpg">
							</c:if>
							
							<c:if test="${profilePic != null} }">
								<img src="data:image/jpeg;base64,${profilePic}}">
							</c:if>
						</a>
					</div>
				</div>
			</div>

		</section>
	</body>
</html>