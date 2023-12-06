<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="ISO-8859-1">
		<title>EcoNex</title>
		<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-T3c6CoIi6uLrA9TneNEoa7RxnatzjcDSCmG1MXxSR1GAsXEV/Dwwykc2MPK8M2HN" crossorigin="anonymous">
		<script src="https://kit.fontawesome.com/4022a78895.js" crossorigin="anonymous"></script>
		<style>
			<%@include file="/css/sidebarNav.css"%>
			<%@include file="/css/dataEntryContent.css"%>
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
                <li class="item">
                    <a href="#">
                        <i class="fa-solid fa-house fa icon"></i>
                        <span class="text">Home</span>
                    </a>
                </li>
                <li class="item active">
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
				<div class="title" style="text-align: center;">
					<a class="back" href="#">
						<i class="fa-solid fa-chevron-left" style="color: #000000; margin-right: 15px;"></i>
						<span>Back</span>
					</a>
					<p>Events/Iskandar Puteri Low Carbon Competition</p>
					<h2>Iskandar Puteri Low Carbon Competition</h2>
					<p class="reminder">Your data is protected by our data and protection guidelines. 
					It will only be shared within the scope of the event and would not 
					be sold to third-party organizations.
					</p>
				</div>
				<div class="line"></div>
			</div>
			
			<div class="content-posts">
				<div class="left">
					<ol class="stepper">
						<li>Personal Information</li>
						<li>Housing Information</li>
						<li class="active">Carbon Consumption</li>
						<li>Done!</li>
					</ol>
					
					<button class="btn-cancel">Leave</button>
				</div>
				
				<div class="center">
					<div class="form">
						<h3 style="margin-bottom: 20px">Recycling Activity</h3>
						<form>
							<table>
								<tr>
									<td>
										<h5 class="note">Recyclable Materials (Plastic, Foils, Glass etc.)</h5>
									</td>
								</tr>
								<tr>
									<td>
										<label for="materialWeight">Total Weight</label>
									</td>
									<td class="inputDivider"></td>
									<td>
										<label for="materialAmount">Total Amount</label>
									</td>
								</tr>
								<tr>
									<td>
										<input type="text" id="materialWeight" name="materialWeight" 
										placeholder="e.g 30">
									</td>
									<td class="inputDivider"></td>
									<td>
										<input type="text" id="materialAmount" name="materialAmount" 
										placeholder="e.g 30">
									</td>
								</tr>
								
								<tr>
									<td>
										<h5 class="note">Used Cooking Oil</h5>
									</td>
								</tr>
								
								<tr>
									<td>
										<label for="oilWeight">Total Weight</label>
									</td>
									<td class="inputDivider"></td>
									<td>
										<label for="oilAmount">Total Amount</label>
									</td>
								</tr>
								<tr>
									<td>
										<input type="text" id="oilWeight" name="oilWeight" 
										placeholder="e.g 30">
									</td>
									<td class="inputDivider"></td>
									<td>
										<input type="text" id="oilAmount" name="oilAmount" 
										placeholder="e.g 30">
									</td>
								</tr>
								
								<tr>
									<td>
										<label for="activityPic">Pictures of Activity</label>
									</td>
								</tr>
								<tr>
									<td colspan="3">
										<input type="file" id="activityPic" name="activityPic" accept="image/*">
									</td>
								</tr>
								
								<tr>
									<td>
										<label for="activityDesc">Describe what did you recycle and how in detail</label>
									</td>
								</tr>
								<tr>
									<td colspan="3">
										<textarea rows="20" cols="90" name="activityDesc" 
										placeholder="e.g I kept every plastic bottle I got from joining events and send it to the recycling centre in bulk."></textarea>
									</td>
								</tr>
							</table>
						</form>
					</div>
				</div>

				<div class="right">
					<input type="button" value="Save">
				</div>
			</div>
			
		</section>
	</body>
</html>