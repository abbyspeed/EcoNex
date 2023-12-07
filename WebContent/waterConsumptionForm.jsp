<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Water Consumption Form</title>
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
						<p>Water Consumption Form</p>
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
        <h1 class="mb-4">Water Consumption Form</h1>
        <form action="submitWaterConsumption.jsp" method="POST" enctype="multipart/form-data">
            <!-- Total Days -->
            <div class="form-group">
                <label for="totalDays">Total Days:</label>
                <input type="number" class="form-control" id="totalDays" name="totalDays">
            </div>

            <!-- Prorate Factor -->
            <div class="form-group">
                <label for="prorateFactor">Prorate Factor:</label>
                <input type="number" step="0.01" class="form-control" id="prorateFactor" name="prorateFactor">
            </div>

            <!-- Current Usage -->
            <div class="form-group">
                <label for="currentUsage">Current Usage:</label>
                <input type="number" step="0.01" class="form-control" id="currentUsage" name="currentUsage">
            </div>

            <!-- Current Amount -->
            <div class="form-group">
                <label for="currentAmount">Current Amount:</label>
                <input type="number" step="0.01" class="form-control" id="currentAmount" name="currentAmount">
            </div>

            <!-- Upload Water Consumption Bill -->
			<div class="form-group">
			    <label for="billFile">Upload Water Consumption Bill:</label>
			    <div class="custom-file">
			        <input type="file" class="custom-file-input" id="billFile" name="billFile">
			        <label class="custom-file-label" for="billFile">Choose file</label>
			    </div>
			</div>


            <!-- Description of Rainwater Savings -->
            <div class="form-group">
                <label for="rainwaterSavings">Description of Rainwater Savings:</label>
                <textarea class="form-control" id="rainwaterSavings" name="rainwaterSavings" rows="3"></textarea>
            </div>

            <button type="submit" class="btn btn-primary">Submit</button>
        </form>
    </div>
    <!-- Include Bootstrap JS and jQuery here -->
    <script src="https://code.jquery.com/jquery-3.5.1.slim.min.js"></script>
    <script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.5.3/dist/umd/popper.min.js"></script>
    <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
</body>
</html>
