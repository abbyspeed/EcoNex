<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<title>NexCode - SignUp</title>
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
										src="https://mdbcdn.b-cdn.net/img/Photos/new-templates/bootstrap-login-form/lotus.webp"
										style="width: 185px;" alt="logo">
								</div>
								<h3 class="login-heading mb-4 text-center">Create an
									account</h3>

								<!-- Sign In Form -->
								<form>
									<div class="form-floating mb-3">
										<input type="text" class="form-control" id="floatingInput"
											placeholder="John Doe"> <label for="floatingInput">Full
											Name</label>
									</div>
									<div class="form-floating mb-3">
										<input type="email" class="form-control" id="floatingInput"
											placeholder="name@example.com"> <label
											for="floatingInput">Email address</label>
									</div>
									<div class="form-floating mb-3">
										<input type="password" class="form-control"
											id="floatingPassword" placeholder="Password"> <label
											for="floatingPassword">Password</label>
									</div>
									<div class="form-floating mb-3">
										<input type="password" class="form-control"
											id="floatingPassword" placeholder="Password"> <label
											for="floatingPassword">Confirm Password</label>
									</div>

									<!-- <div class="form-check mb-3">
										<input class="form-check-input" type="checkbox" value=""
											id="rememberPasswordCheck"> <label
											class="form-check-label" for="rememberPasswordCheck">
											Remember password </label>
									</div> -->

									<div class="d-grid">
										<button
											class="btn btn-lg btn-primary btn-login text-uppercase fw-bold mb-2"
											type="submit">Sign Up</button>
										<div class="text-center">
											<a class="small" href="/EcoNex/auth/login">Got an account? <span class="">Log
													in instead</span></a>
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