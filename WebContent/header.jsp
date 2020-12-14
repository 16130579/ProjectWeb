<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@page import="model.User"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Funny</title>
<link rel="stylesheet" href="bootstrap/css/bootstrap.css">
<link rel="stylesheet" href="fontawesome-free-5.15.1-web/css/all.css">
<link rel="stylesheet" href="css/styles.css">
<link rel="stylesheet" href="css/css_dangNhap.css">
<link rel="stylesheet" href="css/css_dangky.css">
<link
	href="https://fonts.googleapis.com/css2?family=Roboto+Condensed:wght@300&display=swap"
	rel="stylesheet">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
<style type="text/css">
.dropbtn {
	background-color: #4267B2;
	color: white;
	padding: 3px;
	font-size: 16px;
	border: none;
	cursor: pointer;
}

.dropdown {
	display: inline-block;
}

.dropdown-content {
	display: none;
	position: absolute;
	background-color: #f9f9f9;
	min-width: 150px;
	box-shadow: 0px 8px 16px 0px rgba(0, 0, 0, 0.2);
	z-index: 1;
}

.dropdown-content a {
	color: black;
	padding: 12px 16px;
	text-decoration: none;
	display: block;
}

.dropdown-content a:hover {
	background-color: #f1f1f1;
}

.dropdown:hover .dropdown-content {
	display: block;
	color: black;
}

.dropdown:hover .dropbtn {
	background-color: #4267B2;
}

/* The Modal (background) */
.modal {
	display: none; /* Hidden by default */
	position: fixed; /* Stay in place */
	z-index: 1; /* Sit on top */
	padding-top: 1%; /* Location of the box */
	left: 0;
	top: 0;
	width: 100%; /* Full width */
	height: 100%; /* Full height */
	overflow: auto; /* Enable scroll if needed */
	background-color: rgb(0, 0, 0); /* Fallback color */
	background-color: rgba(0, 0, 0, 0.4); /* Black w/ opacity */
}
/* Modal Content */
.modal-content {
	position: relative;
	background-color: #fefefe;
	margin: auto;
	padding: 0;
	border: 1px solid #888;
	width: 80%;
	box-shadow: 0 4px 8px 0 rgba(0, 0, 0, 0.2), 0 6px 20px 0
		rgba(0, 0, 0, 0.19);
	-webkit-animation-name: animatetop;
	-webkit-animation-duration: 0.4s;
	animation-name: animatetop;
	animation-duration: 0.4s
}
/* Add Animation */
@
-webkit-keyframes animatetop {
	from {top: -300px;
	opacity: 0
}

to {
	top: 0;
	opacity: 1
}

}
@
keyframes animatetop {
	from {top: -300px;
	opacity: 0
}

to {
	top: 0;
	opacity: 1
}

}
/* The Close Button */
.close1 {
	color: black;
	float: right;
	font-size: 28px;
	font-weight: bold;
	position: absolute;
	top: 3px;
	right: 20px;
}

.close1:hover, .close1:focus {
	color: red;
	text-decoration: none;
	cursor: pointer;
}

.modal-body {
	padding: 2px 16px;
}

.close2 {
	color: black;
	float: right;
	font-size: 28px;
	font-weight: bold;
	position: absolute;
	top: 3px;
	right: 20px;
}

.close2:hover, .close2:focus {
	color: red;
	text-decoration: none;
	cursor: pointer;
}

.close3 {
	color: black;
	float: right;
	font-size: 28px;
	font-weight: bold;
	position: absolute;
	top: 3px;
	right: 20px;
}

.close3:hover, .close3:focus {
	color: red;
	text-decoration: none;
	cursor: pointer;
}
</style>
<style type="text/css">
.dropbtnS {
	background-color: #F4511E;
	color: white;
	padding: 5px;
	font-size: 18px;
	border: none;
	cursor: pointer;
}

.dropdown {
	display: inline-block;
}

.dropdown-contentS {
	display: none;
	position: absolute;
	background-color: #f9f9f9;
	min-width: 180px;
	box-shadow: 0px 8px 16px 0px rgba(0, 0, 0, 0.2);
	z-index: 1;
}

.dropdown-contentS a {
	color: black;
	padding: 12px 16px;
	text-decoration: none;
	display: block;
}

.dropdown-contentS p {
	padding-left: 10px;
	padding-top: 20px;
	font-weight: bold;
	color: red;
	display: block;
}

.dropdown-contentS a:hover {
	background-color: #f1f1f1
}

.dropdown:hover .dropdown-contentS {
	color: black;
	display: block;
}

.dropdown:hover .dropbtnS {
	background-color: #F4511E;
}

.divS {
	display: inline-block;
	margin-left: 10%;
	margin-right: 2.7%;
}

.divS svg {
	color: white;
}

.item-btn:hover {
	color: white;
	background: #21beff;
}

main {
	margin-top: 120px;
	margin-bottom: 20px;
}

main .row {
	padding: 10px 80px 10px 80px;
}

.col-4 {
	background: #eeeeee75;
	padding: 5px;
	border: 1px solid #E3E3E3;
}

.col-4 i {
	margin-left: 40px;
	float: left;
	padding: 10px;
}

.active {
	background: white;
	padding: 10px;
	color: black;
}

.bar {
	background: blue;
	width: 3px;
	height: 50px;
	float: left;
}

.inactive:hover {
	background: #E3E3E3;
}

.inactive {
	padding: 10px;
	text-decoration: none;
	color: black;
}

.col-8 {
	border: 1px solid #E3E3E3;
}

#email {
	background: #E3E3E3;
	border: 2px solid #EEEEEE;
	outline: none;
}

.col-lg-8 input {
	margin: 7px;
}

.col-lg-4 label {
	margin: 10px;
}
</style>
</head>
<body>
	<div class="fix-position">
		<div class="top-header">
			<div class="container">
				<div class="box-phone-number">
					Hỗ trợ: <a href="#">0123456789</a> - <a href="#">0123456789</a>
				</div>
			</div>
		</div>
		<div class="header-menu">
			<div class="container">
				<a href="index.jsp" style="margin-top: 10px;">
					<div class="logo">
						<img
							style="width: 60px; height: auto; object-fit: contain; margin-right: 5px;"
							src="img/logo/logo_divine_pure_white.png" alt="Logo shop">
						<img style="width: 100px; height: auto; object-fit: contain;"
							src="img/logo/logo-1.png" alt="Logo shop">
					</div>
				</a>
				<div class="box-search">
					<div class="box-search-contain">
						<input type="text" placeholder="Nhập sản phẩm cần tìm....">
						<div class="btn-search">
							<i class="fas fa-search"></i>
						</div>
					</div>
				</div>
				<%
		User user = (User) session.getAttribute("USER");
		int idUser = 0;
		if (user != null) {
			idUser = user.getId();
		}
	%>
				<%
				if (user == null) {
			%>
				<div class="box-log-in">
					<div class="dropdown">
						<button class="dropbtn">
							<i class="fas fa-user" style="color: white"></i>&nbsp;<b>Đăng
								nhập</b>
						</button>
						<div class="dropdown-content">
							<a id="btnlogin">Đăng nhập</a> <a id="btnregister">Đăng ký</a>
						</div>
						<!-- The Modal -->
						<div id="modalLogin" class="modal">
							<!-- Modal content -->
							<div class="modal-content">


								<div class="modal-body" style="color: black;">

									<div class="row">
										<div class="col-lg-6 d-none d-lg-block bg-login-image">
											<img src="img/dangNhap.jpg">

										</div>
										<div class="col-lg-6">
											<div class="p-5">
												<div class="text-center">
													<span class="close1">&times;</span>
													<h1 class="h4 text-gray-900 mb-4">Đăng nhập</h1>


												</div>
												<form class="user" action="DangNhapController" method="post">
													<div class="form-group">
														<input type="email" class="form-control form-control-user"
															name="email" id="exampleInputEmail"
															aria-describedby="emailHelp"
															placeholder="Nhập địa chỉ Email...">
													</div>
													<div class="form-group">
														<input type="password"
															class="form-control form-control-user" name="password"
															id="exampleInputPassword" placeholder="Nhập mật khẩu">
													</div>
													<div class="form-group">
														<div class="custom-control custom-checkbox small">
															<input type="checkbox" class="custom-control-input"
																id="customCheck"> <label
																class="custom-control-label" for="customCheck">Lưu
																đăng nhập</label>
														</div>
													</div>
													<input type="submit"
														class="btn btn-primary btn-user btn-block"
														value="Đăng nhập">

													<hr>
													<a href="index.html"
														class="btn btn-google btn-user btn-block"> <i
														class="fab fa-google fa-fw"></i> Đăng nhập bằng Google
													</a> <a href="index.html"
														class="btn btn-facebook btn-user btn-block"> <i
														class="fab fa-facebook-f fa-fw"></i> Đăng nhập bằng
														Facebook
													</a>
												</form>
												<hr>
												<div class="text-center">
													<a class="small" href="forgot-password.html">Quên mật
														khẩu?</a>
												</div>
												<div class="text-center">
													<a class="small" href="register.html">Tạo tài khoản!</a>
												</div>
											</div>
										</div>
									</div>
								</div>

							</div>
						</div>
						<div id="modalRegister" class="modal">
							<!-- Modal content -->
							<div class="modal-content">

								<div class="modal-body" style="color: black;">

									<div class="row">
										<div class="col-lg-5 d-none d-lg-block bg-register-image">
											<img src="img/dangky.jpg">
										</div>
										<div class="col-lg-7">
											<div class="p-5">
												<div class="text-center">
													<span class="close2">&times;</span>
													<h1 class="h4 text-gray-900 mb-4">Đăng ký tài khoản</h1>
												</div>
												<form class="user" method="post" action="DangKyController">
													<div class="form-group row">
														<div class="col-sm-6 mb-3 mb-sm-0">
															<input type="text" class="form-control form-control-user"
																name="firstname" id="exampleFirstName"
																placeholder="First Name">
														</div>
														<div class="col-sm-6">
															<input type="text" class="form-control form-control-user"
																name="lastname" id="exampleLastName"
																placeholder="Last Name">
														</div>
													</div>
													<div class="form-group">
														<input type="email" class="form-control form-control-user"
															name="email" id="exampleInputEmail"
															placeholder="Email Address">
													</div>
													<div class="form-group row">
														<div class="col-sm-6 mb-3 mb-sm-0">
															<input type="password"
																class="form-control form-control-user" name="password"
																id="exampleInputPassword" placeholder="Password">
														</div>
														<div class="col-sm-6">
															<input type="password"
																class="form-control form-control-user"
																id="exampleRepeatPassword" placeholder="Repeat Password">
														</div>
													</div>
													<input type="submit" value="Đăng ký"
														class="btn btn-primary btn-user btn-block" />

													<hr>
													<a href="index.html"
														class="btn btn-google btn-user btn-block"> <i
														class="fab fa-google fa-fw"></i> Đăng ký với Google
													</a> <a href="index.html"
														class="btn btn-facebook btn-user btn-block"> <i
														class="fab fa-facebook-f fa-fw"></i> Đăng ký Facebook
													</a>
												</form>
												<hr>
												<div class="text-center">
													<a class="small" href="forgot-password.html">Forgot
														Password?</a>
												</div>
												<div class="text-center">
													<a class="small" href="login.html">Đã có tài khoản?</a>
												</div>
											</div>
										</div>
									</div>
								</div>

							</div>
						</div>
					</div>
				</div>
				<%
				} else {
			%>
				<div class="box-log-in">
					<div class="dropdown">
						<button class="dropbtnS">
							<b style="font-size: 15px"><%=user.getEmail() %></b>
						</button>
						<div class="dropdown-contentS">
							<p>Số dư : 108,000 đ</p>
							<a href="profile.jsp">Thông tin tài khoản</a> <a href="#">Lịch sử đơn
								hàng</a> <a href="#">Nạp thêm tiền</a> <a href="#">Đổi mật khẩu</a>
							<a href="DangXuatController">Đăng xuất</a>
						</div>
					</div>
				</div>

				<%} %>
				<a href="gioHang.html"><div class="box-item-cart">
						<div class="box-item-cart-contain">
							<i class="fas fa-shopping-cart"></i> Giỏ hàng <span
								class="numberItem">0</span>
						</div>
					</div> </a>
			</div>
		</div>
	</div>
	<script>
        // Get the modal
        var modal = document.getElementById("modalLogin");
        // Get the button that opens the modal
        var btn = document.getElementById("btnlogin");
        // Get the <span> element that closes the modal
            var span = document.getElementsByClassName("close1")[0];
            // When the user clicks the button, open the modal
            btn.onclick = function() {
            modal.style.display = "block";
            }
            // When the user clicks on <span> (x), close the modal
                span.onclick = function() {
                modal.style.display = "none";
                }
                // When the user clicks anywhere outside of the modal, close it
                window.onclick = function(event) {
                if (event.target == modal) {
                modal.style.display = "none";
                }
                }
        
                </script>
	<script type="text/javascript">
                    // Get the modal
        var modal2 = document.getElementById("modalRegister");
        // Get the button that opens the modal
        var btn2 = document.getElementById("btnregister");
        // Get the <span> element that closes the modal
            var span2 = document.getElementsByClassName("close2")[0];
            // When the user clicks the button, open the modal
            btn2.onclick = function() {
            modal2.style.display = "block";
            }
            // When the user clicks on <span> (x), close the modal
                span2.onclick = function() {
                modal2.style.display = "none";
                }
                // When the user clicks anywhere outside of the modal, close it
                window.onclick = function(event) {
                if (event.target == modal2) {
                modal2.style.display = "none";
                }
                }
                </script>
	<script type="text/javascript">
                    // Get the modal
        var modal3 = document.getElementById("modalRegister2");
        // Get the button that opens the modal
        var btn3 = document.getElementById("btnregister2");
        // Get the <span> element that closes the modal
            var span3 = document.getElementsByClassName("close3")[0];
            // When the user clicks the button, open the modal
            btn3.onclick = function() {
            modal3.style.display = "block";
            }
            // When the user clicks on <span> (x), close the modal
                span3.onclick = function() {
                modal3.style.display = "none";
                }
                // When the user clicks anywhere outside of the modal, close it
                window.onclick = function(event) {
                if (event.target == modal3) {
                modal3.style.display = "none";
                }
                }
                </script>

</body>
</html>