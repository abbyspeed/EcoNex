<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Housing Information Form</title>
    <!-- Include Bootstrap CSS here -->
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
    <style>
			<%@include file="/css/sidebarNav.css"%>
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
						<p>Housing Information Form</p>
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
	        <h1 class="mb-4">Enter Your Housing Information</h1>
	        <form action="submitHousingInfo.jsp" method="POST">
	            <!-- Area in Johor (Dropdown) -->
	            <div class="form-group">
	                <label for="area">Area in Johor:</label>
	                <select class="form-control" id="area" name="area">
	                    <option value="Area 1">Area 1</option>
	                    <option value="Area 2">Area 2</option>
	                    <option value="Area 3">Area 3</option>
	                    <!-- Add more options as needed -->
	                </select>
	            </div>
	
	            <!-- Category of House (Dropdown) -->
	            <div class="form-group">
	                <label for="houseCategory">Category of House:</label>
	                <select class="form-control" id="houseCategory" name="houseCategory">
	                    <option value="Single-Family">Single-Family</option>
	                    <option value="Apartment">Apartment</option>
	                    <option value="Condo">Condo</option>
	                    <!-- Add more options as needed -->
	                </select>
	            </div>
	
	            <!-- Name of Housing/Institution/School/Office -->
	            <div class="form-group">
	                <label for="housingName">Name of Housing/Institution/School/Office:</label>
	                <input type="text" class="form-control" id="housingName" name="housingName">
	            </div>
	
	            <!-- Number of Households -->
	            <div class="form-group">
	                <label for="numHouseholds">Number of Households:</label>
	                <input type="number" class="form-control" id="numHouseholds" name="numHouseholds">
	            </div>
	
	            <!-- Address -->
	            <div class="form-group">
	                <label for="address">Address:</label>
	                <input type="text" class="form-control" id="address" name="address">
	            </div>
	
	            <!-- Postcode -->
	            <div class="form-group">
	                <label for="postcode">Postcode:</label>
	                <input type="text" class="form-control" id="postcode" name="postcode">
	            </div>
	
	            <button type="submit" class="btn btn-primary">Submit</button>
	        </form>
	    </div>
    </section>
    <!-- Include Bootstrap JS and jQuery here -->
    <script src="https://code.jquery.com/jquery-3.5.1.slim.min.js"></script>
    <script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.5.3/dist/umd/popper.min.js"></script>
    <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
</body>
</html>
    
    <!-- Include Bootstrap JS and jQuery here -->
    <script src="https://code.jquery.com/jquery-3.5.1.slim.min.js"></script>
    <script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.5.3/dist/umd/popper.min.js"></script>
    <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
</body>
</html>
