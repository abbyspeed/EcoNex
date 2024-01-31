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
						<li class="active">Housing Information</li>
						<li>Carbon Consumption</li>
						<li>Done!</li>
					</ol>
					
					<button class="btn-cancel">Leave</button>
				</div>
				
				<div class="center">
					<div class="form">
						<h3 style="margin-bottom: 20px">Housing Information</h3>
						<form>
							<table>
								<tr>
									<td>
										<label for="idNo">Select Area</label>
									</td>
									<td class="inputDivider"></td>
									<td>
										<label for="phoneNo">Select Category</label>
									</td>
								</tr>
								<tr>
									<td>
										<select id="housingArea" name="housingArea">
											<option value="default" selected="selected">Choose your area</option>
											<option value="skudai">Skudai</option>
											<option value="lima kedai">Lima Kedai</option>
											<option value="gelang patah">Gelang Patah</option>
											<option value="kangkar pulai">Kangkar Pulai</option>
											<option value="iskandar puteri">Iskandar Puteri</option>
											<option value="ulu choh">Ulu Choh</option>
										</select>
									</td>
									<td class="inputDivider"></td>
									<td>
										<select id="housingCategory" name="housingCategory">
											<option value="default" selected="selected">Choose your category</option>
											<option value="b1">B1</option>
											<option value="b2">B2</option>
											<option value="b1">M1</option>
											<option value="b2">M2</option>
										</select>
									</td>
								</tr>
								
								<tr>
									<td>
										<label for="idNo">Name of Housing/Institution/School/Office</label>
									</td>
									<td class="inputDivider"></td>
									<td>
										<label for="phoneNo">Number of Households</label>
									</td>
								</tr>
								<tr>
									<td>
										<input type="text" id="housingName" name="housingName" 
										placeholder="e.g Taman Sri Skudai">
									</td>
									<td class="inputDivider"></td>
									<td>
										<input type="text" id="housingHouseholds" name="housingHouseholds" 
										placeholder="e.g 240">
									</td>
								</tr>
								
								<tr>
									<td>
										<label for="housingAddress">Full Address</label>
									</td>
								</tr>
								<tr>
									<td colspan="3">
										<input type="text" id="housingAddress1" name="housingAddress1" 
										placeholder="Address Line 1">
									</td>
								</tr>
								<tr>
									<td colspan="3" style="margin-top: 5px;">
										<input type="text" id="housingAddress2" name="housingAddress2" 
										placeholder="Address Line 2">
									</td>
								</tr>
								
								<tr>
									<td>
										<label for="housingPostcode">Postcode</label>
										<input type="text" id="housingPostcode" name="housingPostcode" 
										placeholder="e.g 46000">
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
