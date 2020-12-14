<%@page import="model.User"%>
<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html>
<html lang="en">
	<head>
		<meta charset="UTF-8">
		<meta name="viewport" content="width=device-width, initial-scale=1.0">
		<title>Hồ sơ</title>
		<link rel="stylesheet" href="bootstrap/css/bootstrap.css">
        <link rel="stylesheet" href="fontawesome-free-5.15.1-web/css/all.css">
        <link rel="stylesheet" href="css/styles.css">
        <link href="https://fonts.googleapis.com/css2?family=Roboto+Condensed:wght@300&display=swap" rel="stylesheet">
			</head>
	<body>
<%@include file="header.jsp" %>
		<main class="container">
			<div class="row" >
				<div class="col-4">
					<a href="profile.html"><div class="active">
					<div class="bar"></div>
					<i style="float: left;padding: 10px;" class="fas fa-info fa-2x"></i>
					<div>
					<p><b>Thông tin tài khoản</b><br>
					Quản lý thông tin cá nhân</p>
					</div>
					</div>
					</a>
					<a href="history.html"><div class="inactive">
					<i class="fas fa-shopping-cart fa-2x" style="color: #f4b844;margin-left: 20px;"></i>
					<div>
					<p><b>Lịch sử đơn hàng</b><br>
					Thông tin đơn hàng</p>
					</div>
					</div>
					</a>
					<a href="cash.html"><div class="inactive">
					<i class="fas fa-dollar-sign fa-2x" style="color: #48a163;margin-left: 35px"></i>
					<div>
					<p><b>Nạp tiền</b><br>
					Nạp thêm tiền vào tài khoản</p>
					</div>
					</div>
					</a>
					<a href="changepassword.html"><div class="inactive">
					<i class="fas fa-key fa-2x" style="color: #ad4025;margin-left: 20px"></i>
					<div>
					<p><b>Đổi mật khẩu</b><br>
					Thay đổi mật khẩu</p>
					</div>
					</div>
					</a>
					
					
				</div>
				<div class="col-8">
					<p><b>Thông tin cá nhân</b></p>
					<hr>
					<p style="color: red;"><b>Số dư : 100,000 đ</b></p>
					<form>
						<div class="row" style="padding: 0px;">
							<div class="col-lg-4" >
						<label>Email đăng nhập :</label>
						
						
						<label>Họ vào tên :</label>
						
					
						<label>Số điện thoại :</label>
						
						
						<label>Số CMND :</label>
						<br>
						
						
						
							</div>
							<div class="col-lg-8" style="margin-bottom: 20px;"> 
								<input type="text" name="" readonly value="<%=user.getEmail() %>" id="email">
								<br>
								<input type="text" name="" value="<%=user.getFirstName() + user.getLastName() %>">
								<br>
								<input type="text" name="" value="<%=user.getPhone() %>">
								<br>
								<input type="text" name="" value="<%=user.getCmnd() %>">
								<br>
								
								<br>
								<button class="btn-primary" style="margin-left: 10px;">Cập nhật</button>

							</div>
						</div>
					</form>
				</div>
			</div>
			
		</main>


		<%@include file="footer.jsp" %>
	</body>
</html>