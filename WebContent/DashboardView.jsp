<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="ISO-8859-1" name="viewport" content="width=device-width">
		<title>Welcome back!</title>
		<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-T3c6CoIi6uLrA9TneNEoa7RxnatzjcDSCmG1MXxSR1GAsXEV/Dwwykc2MPK8M2HN" crossorigin="anonymous">
		<style>
			<%@include file="/css/sidebarNav.css"%>
			<%@include file="/css/dashboardContent.css"%>
			<%@include file="/css/style.css"%>
		</style>
	</head>
	<body>
		<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/js/bootstrap.bundle.min.js" integrity="sha384-C6RzsynM9kWDrMNeT87bh95OGNyZPhcTNXj1NW7RuBCsyN/o0jlpcV8Qyq46cDfL" crossorigin="anonymous"></script>
		<nav class="sideBar">
			<div class="sideBar-header">
				<a href="#">
					<img src="#"/>
				</a>
				<i class="# toggle"></i>
			</div>
			
			<ul class="sideBar-items">
                <li class="sideBar-item">
                    <a href="#" class="active">
                        <i class="fa-solid fa-wave-square"></i>
                        Home
                    </a>
                </li>
                <li class="sideBar-item">
                    <a href="#" class="">
                        <i class="fa-solid fa-bell"></i>
                        Events
                    </a>
                </li>
                <li class="sideBar-divider"></li>
                <li class="sideBar-item">
                    <a href="#" class="">
                        <i class="fa-solid fa-bell"></i>
                        Settings
                    </a>
                </li>
            </ul>
		</nav>
		
		<section class="content">
			<div class="content-header">
				<div>
					<p>Dashboard</p>
					<h3>Hello, Nurnabihah</h3>
					<p>Check out what's new today</p>
				</div>
				<div>
					<p>Nurnabihah</p>
					<a href="#">
						
					</a>
				</div>
			</div>
			
			<div class="content-posts">
				<div class="dashboardCard">
					<h2 style="">
						SELAMAT MENYAMBUT HARI KERJA PERMBERSIHAN
					</h2>
					<div class="dashboardCard-img"></div>
					<div class="dashboardCard-btn">Check it out</div>
				</div>
				<div class="dashboardCard" style="margin-top: 30px">
					<h2>
						POLY-<br>CARBONATE: WHAT IS IT TODAY?
					</h2>
					<div class="dashboardCard-img"></div>
					<div class="dashboardCard-btn">Check it out</div>
				</div>
			</div>
		</section>
	</body>
</html>