<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="ISO-8859-1">
		<title>EcoNex</title>
		<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-T3c6CoIi6uLrA9TneNEoa7RxnatzjcDSCmG1MXxSR1GAsXEV/Dwwykc2MPK8M2HN" crossorigin="anonymous">
		<script src="https://kit.fontawesome.com/4022a78895.js" crossorigin="anonymous"></script>
		<style>
			<%@include file="css/sidebarNav.css"%>
			<%@include file="css/dataEntryContent.css"%>
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
					<a class="back" href="/EcoNex/Events/DataEntry/${eventId}">
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
				<c:if test="${not empty housing}">
					<div class="left">
						<div class="form-menu">
							<a href="/EcoNex/Housing/ShowForm/${userId}/${eventId}">
								<button class="active">Housing Information</button>
							</a>
							<a href="/EcoNex/Electricity/ShowForm/${userId}/${eventId}">
								<button>Electricity Consumption</button>
							</a>
							<a href="/EcoNex/Water/ShowForm/${userId}/${eventId}">
								<button>Water Consumption</button>
							</a>
							<a href="/EcoNex/Recycling/ShowForm/${userId}/${eventId}">
								<button>Recycling Activity</button>
							</a>
						</div>
						
						<a href="1/deleted" class="btn-delete">Delete</a>
					</div>
					<div class="center">
						<div class="form">
							<h3 style="margin-bottom: 20px">Housing Information</h3>
							<form action="1/updated" method="POST">
								<table>
									<tr>
										<td>
											<label for="housingArea">Select Area</label>
										</td>
										<td class="inputDivider"></td>
										<td>
											<label for="housingCategory">Select Category</label>
										</td>
									</tr>
									<tr>
										<td>
											<select id="housingArea" name="housingArea">
												<option value="default" selected="selected">${housing.getArea()}</option>
												<option value="Skudai">Skudai</option>
												<option value="Lima Kedai">Lima Kedai</option>
												<option value="Gelang Patah">Gelang Patah</option>
												<option value="Kangkar Pulai">Kangkar Pulai</option>
												<option value="Iskandar Puteri">Iskandar Puteri</option>
												<option value="Ulu Choh">Ulu Choh</option>
											</select>
										</td>
										<td class="inputDivider"></td>
										<td>
											<select id="housingCategory" name="housingCategory">
												<option value="default" selected="selected">${housing.getCategory()}</option>
												<option value="B1">B1</option>
												<option value="B2">B2</option>
												<option value="M1">M1</option>
												<option value="M2">M2</option>
											</select>
										</td>
									</tr>
									
									<tr>
										<td>
											<label for="housingName">Name of Housing/Institution/School/Office</label>
										</td>
										<td class="inputDivider"></td>
										<td>
											<label for="housingHouseholds">Number of Households</label>
										</td>
									</tr>
									<tr>
										<td>
											<input type="text" id="housingName" name="housingName" 
											value="${housing.getName()}">
										</td>
										<td class="inputDivider"></td>
										<td>
											<input type="number" id="housingHouseholds" name="housingHouseholds" 
											value="${housing.getHouseholdNo()}">
										</td>
									</tr>
									
									<tr>
										<td>
											<label for="housingAddress">Full Address</label>
										</td>
									</tr>
									<tr>
										<td colspan="3">
											<input type="text" id="housingAddress" name="housingAddress" 
											value="${housing.getAddress()}">
										</td>
									</tr>
									
									<tr>
										<td>
											<label for="housingPostcode">Postcode</label>
											<input type="number" id="housingPostcode" name="housingPostcode" 
											value="${housing.getPostcode()}" required>
										</td>
									</tr>
								</table>
								
								<input type="submit" id="submit-form" hidden/>
							</form>
						</div>
					</div>
	
					<div class="right">
						<label class="submit-btn" for="submit-form" tabindex="0">Update</label>
					</div>
				</c:if>
				<c:if test="${empty housing}">
					<div class="left">
						<div class="form-menu">
							<a href="">
								<button class="active">Housing Information</button>
							</a>
							<a href="">
								<button disabled>Electricity Consumption</button>
							</a>
							<a href="">
								<button disabled>Water Consumption</button>
							</a>
							<a href="">
								<button disabled>Recycling Activity</button>
							</a>
						</div>
						
						<a href="1/deleted" class="btn-delete">Delete</a>
					</div>
					<div class="center">
						<div class="form">
							<h3 style="margin-bottom: 20px">Housing Information</h3>
							<form action="1/added" method="POST">
								<table>
									<tr>
										<td>
											<label for="housingArea">Select Area</label>
										</td>
										<td class="inputDivider"></td>
										<td>
											<label for="housingCategory">Select Category</label>
										</td>
									</tr>
									<tr>
										<td>
											<select id="housingArea" name="housingArea" required>
												<option value="default" selected="selected">Choose your area</option>
												<option value="Skudai">Skudai</option>
												<option value="Lima Kedai">Lima Kedai</option>
												<option value="Gelang Patah">Gelang Patah</option>
												<option value="Kangkar Pulai">Kangkar Pulai</option>
												<option value="Iskandar Puteri">Iskandar Puteri</option>
												<option value="Ulu Choh">Ulu Choh</option>
											</select>
										</td>
										<td class="inputDivider"></td>
										<td>
											<select id="housingCategory" name="housingCategory" required>
												<option value="default" selected="selected">Choose your category</option>
												<option value="B1">B1</option>
												<option value="B2">B2</option>
												<option value="M1">M1</option>
												<option value="M2">M2</option>
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
											placeholder="e.g Taman Sri Skudai" required>
										</td>
										<td class="inputDivider"></td>
										<td>
											<input type="number" id="housingHouseholds" name="housingHouseholds" 
											placeholder="e.g 240" required>
										</td>
									</tr>
									
									<tr>
										<td>
											<label for="housingAddress">Full Address</label>
										</td>
									</tr>
									<tr>
										<td colspan="3">
											<input type="text" id="housingAddress" name="housingAddress" 
											placeholder="Address Line" required>
										</td>
									</tr>
									
									<tr>
										<td>
											<label for="housingPostcode">Postcode</label>
											<input type="number" id="housingPostcode" name="housingPostcode" 
											placeholder="e.g 46000" required>
										</td>
									</tr>
								</table>
								
								<input type="submit" id="submit-form" hidden/>
							</form>
						</div>
					</div>
	
					<div class="right">
						<label class="submit-btn" for="submit-form" tabindex="0">Save</label>
					</div>
				</c:if>
			</div>
		</section>
	</body>
</html>
