<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<title>NexCode - Login</title>
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
<style type="text/css">
@import
	url('https://fonts.googleapis.com/css2?family=Black+Han+Sans&display=swap')
	;
/* .bg-image-vertical {
         position: relative;
         overflow: hidden;
         background-repeat: no-repeat;
         background-position: right center;
         background-size: auto 100%;
         }
         @media ( min-width : 1025px) {
         .h-custom-2 {
         height: 100%;
         }
         } */
body {
	background-color: #EEEEEE;
}

.login {
	min-height: 100vh;
}

.bg-image {
	background-image:
		url('https://res.cloudinary.com/dprlflxcj/image/upload/f_auto,q_auto/v1/img/bg_rnpxrq');
	background-size: cover;
	background-position: center;
}

.login-heading {
	font-weight: 300;
}

.btn-login {
	font-size: 0.9rem;
	letter-spacing: 0.05rem;
	padding: 0.75rem 1rem;
	background-color: #080930;
}

.text-hero {
	text-align: center;
	font-family: Black Han Sans;
	font-size: 6.25rem;
	font-style: normal;
	font-weight: 400;
	line-height: 100%; /* 6.25rem */
	letter-spacing: 0.125rem;
	color: black;
	-webkit-text-fill-color: white;
	/* Will override color (regardless of order) */
	-webkit-text-stroke: 3px black;
	-webkit-text-fill-color: white;
}
</style>
</head>
<body>
	<div class="container-fluid ps-md-0">
		<div class="row g-0">
			<div
				class="d-none d-md-flex col-md-4 col-lg-6 bg-image d-flex flex-column align-items-center justify-content-center ">
				<div class="text-center text-uppercase text-hero overflow-hidden">
					<!-- Each word wrapped in a span for one word per row -->
					<div>ISKANDAR</div>
					<div>PUTERI</div>
					<div>RENDAH</div>
					<div>KARBON</div>
				</div>
			</div>
			<div class="col-md-8 col-lg-6">
				<div class="login d-flex align-items-center py-5">
					<div class="container">
						<div class="row">
							<div class="col-md-9 col-lg-8 mx-auto">
								<div class="text-center">
									<img
										src="https://res.cloudinary.com/dprlflxcj/image/upload/v1701198691/img/logo_big_sgydui.svg"
										style="width: 185px; margin-bottom: 15px;" alt="logo">
								</div>
								<h3 class="login-heading mb-4 text-center">Log in to your
									account</h3>
								<c:if test="${error != null}">
									<div class="alert alert-danger" role="alert">${error}</div>
								</c:if>
								<!-- Sign In Form -->
								<form action="/EcoNex/processLogin">
									<div class="form-floating mb-3">
										<input type="text" name="username" class="form-control"
											id="floatingInput" placeholder="name@example.com" required>
										<label for="floatingInput">Username</label>
									</div>
									<div class="form-floating mb-3">
										<input type="password" name="password" class="form-control"
											id="floatingPassword" placeholder="Password" required>
										<label for="floatingPassword">Password</label>
									</div>

									<div class="d-grid">
										<button
											class="btn btn-lg btn-primary btn-login text-uppercase fw-bold mb-2"
											type="submit">Log in</button>
										<div class="text-center">
											<a class="small" href="/EcoNex/signup">Don't have an
												account? <span class="">Sign up instead</span>
											</a>
										</div>
									</div>
								</form>
							</div>
						</div>
					</div>
				</div>
			</div>
		</div>
	</div>
	<!-- MDB -->
	<script type="text/javascript"
		src="https://cdnjs.cloudflare.com/ajax/libs/mdb-ui-kit/7.0.0/mdb.umd.min.js"></script>
</body>
</html>