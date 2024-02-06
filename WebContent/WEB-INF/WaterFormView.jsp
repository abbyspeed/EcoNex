<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Water Consumption Form</title>
    <!-- Include Bootstrap CSS here -->
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
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
							<button class="active">Water Consumption</button>
						</a>
						<a href="/EcoNex/Recycling/ShowForm/${eventId}">
							<button>Recycling Activity</button>
						</a>
					</div>
					
					<a href="1/deleted" class="btn-delete">Delete</a>
				</div>
				
				<c:if test="${not empty water}">
					<div class="center">
						<div class="form">
							<h3 style="margin-bottom: 20px">Water Consumption</h3>
							<form action="1/processingUpdate" method="POST">
								<table>
									<tr>
										<td>
											<label for="waterDays">Total Days</label>
										</td>
										<td class="inputDivider"></td>
										<td>
											<label for="waterProrate">Prorate Factor</label>
										</td>
									</tr>
									<tr>
										<td>
											<input type="number" id="waterDays" name="waterDays" 
											value="${water.getNoOfDays()}" required>
										</td>
										<td class="inputDivider"></td>
										<td>
											<input type="number" step="any" id="waterProrate" name="waterProrate" 
											value="${water.getProrate()}" required>
										</td>
									</tr>
									
									<tr>
										<td>
											<label for="waterUsage">Current Usage</label>
										</td>
										<td class="inputDivider"></td>
										<td>
											<label for="waterAmount">Current Amount</label>
										</td>
									</tr>
									<tr>
										<td>
											<input type="number" id="waterUsage" name="waterUsage" 
											value="${water.getCurrentUsage()}" required>
										</td>
										<td class="inputDivider"></td>
										<td>
											<input type="number" step="any" id="waterAmount" name="waterAmount" 
											value="${water.getAmount()}" required>
										</td>
									</tr>
									<tr>
										<td>
											<label for="waterDesc">Describe how you saved water in detail</label>
										</td>
									</tr>
									<tr>
										<td colspan="3">
											<textarea rows="20" cols="90" name="waterDesc" 
											value="${water.getDescription()}" required></textarea>
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
				<c:if test="${empty water}">
					<div class="center">
						<div class="form">
							<h3 style="margin-bottom: 20px">Water Consumption</h3>
							<form action="1/processingAdd" method="POST">
								<table>
									<tr>
										<td>
											<label for="waterDays">Total Days</label>
										</td>
										<td class="inputDivider"></td>
										<td>
											<label for="waterProrate">Prorate Factor</label>
										</td>
									</tr>
									<tr>
										<td>
											<input type="text" id="waterDays" name="waterDays" 
											placeholder="e.g 30" required>
										</td>
										<td class="inputDivider"></td>
										<td>
											<input type="text" id="waterProrate" name="waterProrate" 
											placeholder="e.g 1.0233" required>
										</td>
									</tr>
									
									<tr>
										<td>
											<label for="waterUsage">Current Usage</label>
										</td>
										<td class="inputDivider"></td>
										<td>
											<label for="waterAmount">Current Amount</label>
										</td>
									</tr>
									<tr>
										<td>
											<input type="text" id="waterUsage" name="waterUsage" 
											placeholder="e.g 100" required>
										</td>
										<td class="inputDivider"></td>
										<td>
											<input type="text" id="waterAmount" name="waterAmount" 
											placeholder="e.g 20" required>
										</td>
									</tr>
									<tr>
										<td>
											<label for="waterDesc">Describe how you saved water in detail</label>
										</td>
									</tr>
									<tr>
										<td colspan="3">
											<textarea rows="20" cols="90" name="waterDesc" 
											placeholder="e.g I used the rainwater I collected to water my plants." required></textarea>
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
    <!-- Include Bootstrap JS and jQuery here -->
    <script src="https://code.jquery.com/jquery-3.5.1.slim.min.js"></script>
    <script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.5.3/dist/umd/popper.min.js"></script>
    <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
</body>
</html>
