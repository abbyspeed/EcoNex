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
			
			<c:if test="${not empty recycling}">
				<div class="content-posts">
					<div class="left">
						<div class="form-menu">
							<a href="/EcoNex/Housing/ShowForm/${eventId}">
								<button>Housing Information</button>
							</a>
							<a href="/EcoNex/Electricity/ShowForm/${eventId}">
								<button>Electricity Consumption</button>
							</a>
							<a href="/EcoNex/Water/ShowForm/${eventId}">
								<button>Water Consumption</button>
							</a>
							<a href="/EcoNex/Recycling/ShowForm/${eventId}">
								<button  class="active">Recycling Activity</button>
							</a>
						</div>
						
						<a href="${recycling.getRecId()}/deleted" class="btn-delete">Delete</a>
					</div>
					<div class="center">
						<div class="form">
							<h3 style="margin-bottom: 20px">Recycling Activity</h3>
							<form action="${eventId}/processingUpdate" method="POST">
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
											value="${recycling.getWasteWeight()}" required>
										</td>
										<td class="inputDivider"></td>
										<td>
											<input type="text" id="materialAmount" name="materialAmount" 
											value="${recycling.getWasteAmount()}" required>
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
											value="${recycling.getOilWeight()}" required>
										</td>
										<td class="inputDivider"></td>
										<td>
											<input type="text" id="oilAmount" name="oilAmount" 
											value="${recycling.getOilAmount()}" required>
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
											required>${recycling.getDescription()}</textarea>
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
				</div>
			</c:if>
			<c:if test="${empty recycling}">
				<div class="content-posts">
					<div class="left">
						<div class="form-menu">
							<a href="/EcoNex/Housing/ShowForm/${eventId}">
								<button>Housing Information</button>
							</a>
							<a href="/EcoNex/Electricity/ShowForm/${eventId}">
								<button>Electricity Consumption</button>
							</a>
							<a href="/EcoNex/Water/ShowForm/${eventId}">
								<button>Water Consumption</button>
							</a>
							<a href="/EcoNex/Recycling/ShowForm/${eventId}">
								<button  class="active">Recycling Activity</button>
							</a>
						</div>
					</div>
					<div class="center">
						<div class="form">
							<h3 style="margin-bottom: 20px">Recycling Activity</h3>
							<form action="${eventId}/processingAdd" method="POST">
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
											placeholder="e.g 30" required>
										</td>
										<td class="inputDivider"></td>
										<td>
											<input type="text" id="materialAmount" name="materialAmount" 
											placeholder="e.g 30" required>
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
											placeholder="e.g 30" required>
										</td>
										<td class="inputDivider"></td>
										<td>
											<input type="text" id="oilAmount" name="oilAmount" 
											placeholder="e.g 30" required>
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
											placeholder="e.g I kept every plastic bottle I got from joining events and send it to the recycling centre in bulk." required></textarea>
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
				</div>
			</c:if>
		</section>
	</body>
</html>