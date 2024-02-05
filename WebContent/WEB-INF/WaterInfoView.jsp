<%@ page language="java" contentType="text/html; charset=UTF-8"
pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html lang="en">
  <head>
    <meta charset="UTF-8" />
    <meta name="viewport" content="width=device-width, initial-scale=1.0" />
    <title>Water Consumption Information</title>
    <link
      rel="stylesheet"
      href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css"
    />
    <!-- <style>
        <%@include file="css/sidebarNav.css"%>
        <%@include file="css/dataEntryContent.css"%>
        <%@include file="css/style.css"%>
    </style> -->
  </head>
  <body>
    <nav class="sideBar">
      <div class="sideBar-header">
        <a href="#">
          <img
            src="https://res.cloudinary.com/dprlflxcj/image/upload/v1701198691/img/logo_medium_e6ci8s.svg"
          />
        </a>
        <a class="toggle">
          <img
            src="https://res.cloudinary.com/dprlflxcj/image/upload/v1701070223/icons/Menu_Alt_05_nffut7.svg"
            class="toggle"
          />
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
      <div class="container mt-5">
        <h1 class="mb-4">Water Consumption Information</h1>
        <div class="form-group">
          <label>Total Days:</label>
          <input
            type="text"
            class="form-control"
            value="${water.totalDays}"
            readonly
          />
        </div>
        <div class="form-group">
          <label>Prorate Factor:</label>
          <input
            type="text"
            class="form-control"
            value="${water.prorateFactor}"
            readonly
          />
        </div>
        <div class="form-group">
          <label>Current Usage:</label>
          <input
            type="text"
            class="form-control"
            value="${water.currentUsage}"
            readonly
          />
        </div>
        <div class="form-group">
          <label>Current Amount:</label>
          <input
            type="text"
            class="form-control"
            value="${water.currentAmount}"
            readonly
          />
        </div>
        <div class="form-group">
          <label>Description of Rainwater Savings:</label>
          <textarea class="form-control" readonly>
${water.rainwaterSavings}</textarea
          >
        </div>
      </div>
    </section>
    <script src="https://code.jquery.com/jquery-3.5.1.slim.min.js"></script>
    <script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.5.3/dist/umd/popper.min.js"></script>
    <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
  </body>
</html>
