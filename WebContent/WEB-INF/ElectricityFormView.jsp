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
				<div class="left">
					<div class="form-menu">
						<a href="/EcoNex/Housing/ShowForm/${eventId}">
							<button>Housing Information</button>
						</a>
						<a href="/EcoNex/Electricity/ShowForm/${eventId}">
							<button class="active">Electricity Consumption</button>
						</a>
						<a href="/EcoNex/Water/ShowForm/${eventId}">
							<button>Water Consumption</button>
						</a>
						<a href="/EcoNex/Recycling/ShowForm/${eventId}">
							<button>Recycling Activity</button>
						</a>
					</div>
					
					<a href="1/deleted" class="btn-delete">Delete</a>
				</div>
				
				<c:if test="${not empty electricity}">
					<div class="center">
						<div class="form">
							<h3 style="margin-bottom: 20px">Electricity Consumption</h3>
							<form action="1/processingUpdate" method="POST">
								<table>
									<tr>
										<td>
											<label for="electricityDays">Total Days</label>
										</td>
										<td class="inputDivider"></td>
										<td>
											<label for="electricityProrate">Prorate Factor</label>
										</td>
									</tr>
									<tr>
										<td>
											<input type="number" id="electricityDays" name="electricityDays" 
											value="${electricity.getNoOfDays()}" required>
										</td>
										<td class="inputDivider"></td>
										<td>
											<input type="number" step="any" id="electricityProrate" name="electricityProrate" 
											value="${electricity.getProrate()}" required>
										</td>
									</tr>
									
									<tr>
										<td>
											<label for="electricityUsage">Current Usage</label>
										</td>
										<td class="inputDivider"></td>
										<td>
											<label for="electricityAmount">Current Amount</label>
										</td>
									</tr>
									<tr>
										<td>
											<input type="number" id="electricityUsage" name="electricityUsage" 
											value="${electricity.getCurrentUsage()}" required>
										</td>
										<td class="inputDivider"></td>
										<td>
											<input type="number" step="any" id="electricityAmount" name="electricityAmount" 
											value="${electricity.getAmount()}" required>
										</td>
									</tr>
									<tr>
										<td>
											<label for="electricityDesc">Describe how you saved electricity in detail</label>
										</td>
									</tr>
									<tr>
										<td colspan="3">
											<textarea rows="20" cols="90" name="electricityDesc" 
											value="${electricity.getDescription()}" required></textarea>
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
				<c:if test="${empty electricity}">
					<div class="center">
						<div class="form">
							<h3 style="margin-bottom: 20px">Electricity Consumption</h3>
							<form action="1/processingAdd" method="POST">
								<table>
									<tr>
										<td>
											<label for="electricityDays">Total Days</label>
										</td>
										<td class="inputDivider"></td>
										<td>
											<label for="electricityProrate">Prorate Factor</label>
										</td>
									</tr>
									<tr>
										<td>
											<input type="text" id="electricityDays" name="electricityDays" 
											placeholder="e.g 30" required>
										</td>
										<td class="inputDivider"></td>
										<td>
											<input type="text" id="electricityProrate" name="electricityProrate" 
											placeholder="e.g 1.0233" required>
										</td>
									</tr>
									
									<tr>
										<td>
											<label for="electricityUsage">Current Usage</label>
										</td>
										<td class="inputDivider"></td>
										<td>
											<label for="electricityAmount">Current Amount</label>
										</td>
									</tr>
									<tr>
										<td>
											<input type="text" id="electricityUsage" name="electricityUsage" 
											placeholder="e.g 100" required>
										</td>
										<td class="inputDivider"></td>
										<td>
											<input type="text" id="electricityAmount" name="electricityAmount" 
											placeholder="e.g 20" required>
										</td>
									</tr>
		
									<tr>
										<td>
											<label for="electricityDesc">Describe how you saved electricity in detail</label>
										</td>
									</tr>
									<tr>
										<td colspan="3">
											<textarea rows="20" cols="90" name="electricityDesc" 
											placeholder="e.g I set a timer as to how long I can turn the lights on at night." required></textarea>
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