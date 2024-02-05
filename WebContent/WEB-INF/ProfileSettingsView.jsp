<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
   <head>
      <meta charset="ISO-8859-1" name="viewport" content="width=device-width">
      <title>Welcome back!</title>
      <!-- <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-T3c6CoIi6uLrA9TneNEoa7RxnatzjcDSCmG1MXxSR1GAsXEV/Dwwykc2MPK8M2HN" crossorigin="anonymous">
         <script src="https://kit.fontawesome.com/4022a78895.js" crossorigin="anonymous"></script> -->
      <!-- Font Awesome -->
      <link
         href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.0.0/css/all.min.css"
         rel="stylesheet" />
      <!-- Google Fonts -->
      <link
         href="https://fonts.googleapis.com/css?family=Roboto:300,400,500,700&display=swap"
         rel="stylesheet" />
      <!-- MDB -->
      <link
         href="https://cdnjs.cloudflare.com/ajax/libs/mdb-ui-kit/7.0.0/mdb.min.css"
         rel="stylesheet" />
      <style>
         <%@include file="css/sidebarNav.css"%>
		 <%@include file="css/dashboardContent.css"%>
		 <%@include file="css/style.css"%>
         .btn-login {
         font-size: 0.9rem;
         letter-spacing: 0.05rem;
         padding: 12px;
         background-color: #080930;
         max-height: 48px;
         }
         .section-padding {
         padding: 20px 20px 0px 20px;
         }
         .folded {
         display: none;
         }
         @media (min-width: 768px) {
         form {
         max-width: 343px;
         }
         .space-input-y {
         margin-top: 12px;
         margin-bottom: 12px;
         }
         .mobile-nav {
         display: none;
         }
         }
         @media (max-width: 768px) {
         .sideBar {
         display: none;
         }
         .content{
         width: 100%;
         position: relative;
         left: 0px;
         }
         .mobile-nav {
         display: block;
         }
         }
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
            <li class="item">
               <a href="#">
               <i class="fa-regular fa-calendar icon"></i>
               <span class="text">Events</span>
               </a>
            </li>
            <li class="divider"></li>
            <li class="item active">
               <a href="/EcoNex/profile/settings">
               <i class="fa-solid fa-gear icon"></i>
               <span class="text">Settings</span>
               </a>
            </li>
         </ul>
      </nav>
      <!-- Folded Sidebar -->
      <nav class="sideBar folded" style="width:100px">
         <div class="sideBar-header">
            <!-- <a href="#">
               <img src="https://res.cloudinary.com/dprlflxcj/image/upload/v1701198691/img/logo_medium_e6ci8s.svg"/>
               </a> -->
            <a class="toggle">
            <img src="https://res.cloudinary.com/dprlflxcj/image/upload/v1701070223/icons/Menu_Alt_05_nffut7.svg" class="toggle">
            </a>
         </div>
         <ul class="items">
            <li class="item">
               <a href="#">
               <i class="fa-solid fa-house fa icon"></i>
               </a>
            </li>
            <li class="item">
               <a href="#">
               <i class="fa-regular fa-calendar icon"></i>
               </a>
            </li>
            <li class="divider"></li>
            <li class="item active">
               <a href="#">
               <i class="fa-solid fa-gear icon"></i>
               </a>
            </li>
         </ul>
      </nav>
      <!-- Navbar -->
      <nav class="navbar navbar-expand-lg navbar-light bg-body-tertiary mobile-nav">
         <!-- Container wrapper -->
         <div class="container-fluid">
            <!-- Toggle button -->
            <button
               data-mdb-collapse-init
               class="navbar-toggler"
               type="button"
               data-mdb-target="#navbarSupportedContent"
               aria-controls="navbarSupportedContent"
               aria-expanded="false"
               aria-label="Toggle navigation"
               >
            <i class="fas fa-bars"></i>
            </button>
            <!-- Collapsible wrapper -->
            <div class="collapse navbar-collapse" id="navbarSupportedContent">
               <!-- Navbar brand -->
               <a class="navbar-brand mt-2 mt-lg-0" href="#">
               <img
                  src="https://res.cloudinary.com/dprlflxcj/image/upload/v1701198691/img/logo_medium_e6ci8s.svg"
                  height="15"
                  alt="Econex Logo"
                  loading="lazy"
                  />
               </a>
               <!-- Left links -->
               <ul class="navbar-nav me-auto mb-2 mb-lg-0">
                  <li class="nav-item">
                     <a class="nav-link" href="#">Home</a>
                  </li>
                  <li class="nav-item">
                     <a class="nav-link" href="#">Events</a>
                  </li>
                  <li class="nav-item">
                     <a class="nav-link" href="#">Settings</a>
                  </li>
               </ul>
               <!-- Left links -->
            </div>
            <!-- Collapsible wrapper -->
            <!-- Right elements -->
            <div class="d-flex align-items-center">
               <!-- Avatar -->
               <div class="dropdown">
                  <a
                     data-mdb-dropdown-init
                     class="dropdown-toggle d-flex align-items-center hidden-arrow"
                     href="#"
                     id="navbarDropdownMenuAvatar"
                     role="button"
                     aria-expanded="false"
                     >
                  <img
                     src="https://mdbcdn.b-cdn.net/img/new/avatars/2.webp"
                     class="rounded-circle"
                     height="25"
                     alt="Black and White Portrait of a Man"
                     loading="lazy"
                     />
                  </a>
                  <ul
                     class="dropdown-menu dropdown-menu-end"
                     aria-labelledby="navbarDropdownMenuAvatar"
                     >
                     <li>
                        <a class="dropdown-item" href="#">My profile</a>
                     </li>
                     <li>
                        <a class="dropdown-item" href="#">Settings</a>
                     </li>
                     <li>
                        <a class="dropdown-item" href="#">Logout</a>
                     </li>
                  </ul>
               </div>
            </div>
            <!-- Right elements -->
         </div>
         <!-- Container wrapper -->
      </nav>
      <!-- Navbar -->
      <section class="content section-padding">
         <div style="display: flex; flex-direction: column; width: 100%;">
            <div style="display: flex; width: 100%; justify-content: space-between; align-items: center;">
               <div class="d-flex justify-content-center mb-4">
                  <img id="selectedAvatar" src="https://mdbootstrap.com/img/Photos/Others/placeholder-avatar.jpg"
                     class="rounded-circle" style="width: 128px; height: 128px; object-fit: cover;" alt="example placeholder" />
               </div>
               <div style="color: red;" onClick="alertAccountDeleteConfirmation()">Delete my account</div>
            </div>
            <div style="display: flex; flex-direction: row;">
               <div style="padding-right: 9.38rem;">
                  <div style="font-size: 1.5rem; font-weight: bold;">Profile picture</div>
                  <div style="font-size: 1rem;">PNG and JPEG format accepted only</div>
               </div>
               <div class="btn btn-lg btn-primary btn-login text-uppercase fw-bold mb-2">
                     <label class="form-label text-white m-1" for="customFile2">Upload</label>
                     <input type="file" class="form-control d-none" id="customFile2" onchange="displaySelectedImage(event, 'selectedAvatar')" />
                  </div>
            </div>
         </div>
         <form onSubmit="alertSuccess()">
            <div class="form-floating mb-3 space-input-y">
               <input type="text" class="form-control" id="floatingInput"
                  placeholder="Full Name"> <label
                  for="floatingInput">Full Name</label>
            </div>
            <div class="form-floating mb-3 space-input-y">
               <input type="email" class="form-control" id="floatingInput"
                  placeholder="Email"> <label
                  for="floatingInput">Email</label>
            </div>
            <div class="form-floating mb-3 space-input-y">
               <input type="password" class="form-control"
                  id="floatingPassword" placeholder="Password"> <label
                  for="floatingPassword">Password</label>
            </div>
            <div class="d-flex justify-content-between">
               <button
                  class="btn btn-lg btn-primary btn-login text-uppercase fw-bold mb-2"
                  type="submit">Update Profile</button>
               <button
                  class="btn btn-lg btn-primary btn-login text-uppercase fw-bold mb-2"
                  type="button" onClick="logout()">Log Out</button>
            </div>
         </form>
      </section>
      <script type="text/javascript" defer><%@include file="js/sidebarNav.js" %></script>
      <script type="text/javascript">
      function displaySelectedImage(event, elementId) {
    	    const selectedImage = document.getElementById(elementId);
    	    const fileInput = event.target;

    	    if (fileInput.files && fileInput.files[0]) {
    	        const reader = new FileReader();

    	        reader.onload = function(e) {
    	            selectedImage.src = e.target.result;
    	        };

    	        reader.readAsDataURL(fileInput.files[0]);
    	    }
    	}

    	function alertSuccess() {
			window.alert("Profile Updated");
        }

        function alertAccountDeleteConfirmation() {
			const response = confirm("Are you sure?");
			if(response) {
					alert("Account Deleted");
					logout();
				}
            }

        function logout() {
				window.location.href = "http://localhost:8086/EcoNex/auth/signup";
            }
      </script>
      <!-- MDB -->
      <script type="text/javascript"
         src="https://cdnjs.cloudflare.com/ajax/libs/mdb-ui-kit/7.0.0/mdb.umd.min.js"></script>
   </body>
</html>