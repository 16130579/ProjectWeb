<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>Đổi mật khẩu</title>
<link rel="stylesheet" href="bootstrap/css/bootstrap.css">
<link rel="stylesheet" href="fontawesome-free-5.15.1-web/css/all.css">
<link rel="stylesheet" href="css/styles.css">
<link
	href="https://fonts.googleapis.com/css2?family=Roboto+Condensed:wght@300&display=swap"
	rel="stylesheet">

<style type="text/css">
.dropbtn {
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

.dropdown-content {
	display: none;
	position: absolute;
	background-color: #f9f9f9;
	min-width: 180px;
	box-shadow: 0px 8px 16px 0px rgba(0, 0, 0, 0.2);
	z-index: 1;
}

.dropdown-content a {
	color: black;
	padding: 12px 16px;
	text-decoration: none;
	display: block;
}

.dropdown-content p {
	padding-left: 10px;
	padding-top: 20px;
	font-weight: bold;
	color: red;
	display: block;
}

.dropdown-content a:hover {
	background-color: #f1f1f1
}

.dropdown:hover .dropdown-content {
	color: black;
	display: block;
}

.dropdown:hover .dropbtn {
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

	<%@include file="header.jsp"%>
	<main class="container">
		<div class="row">
			<div class="col-4">
				<a href="profile.jsp"><div class="inactive">

						<i style="float: left; padding: 10px;" class="fas fa-info fa-2x"></i>
						<div>
							<p>
								<b>Thông tin tài khoản</b><br> Quản lý thông tin cá nhân
							</p>
						</div>
					</div> </a> <a href="history.jsp"><div class="inactive">
						<i class="fas fa-shopping-cart fa-2x"
							style="color: #f4b844; margin-left: 20px;"></i>
						<div>
							<p>
								<b>Lịch sử đơn hàng</b><br> Thông tin đơn hàng
							</p>
						</div>
					</div> </a> <a href="cash.jsp"><div class="inactive">
						<i class="fas fa-dollar-sign fa-2x"
							style="color: #48a163; margin-left: 35px"></i>
						<div>
							<p>
								<b>Nạp tiền</b><br> Nạp thêm tiền vào tài khoản
							</p>
						</div>
					</div> </a> <a href="ChangePassword.jsp"><div class="active">
						<div class="bar"></div>
						<i class="fas fa-key fa-2x"
							style="color: #ad4025; margin-left: 20px"></i>
						<div>
							<p>
								<b>Đổi mật khẩu</b><br> Thay đổi mật khẩu
							</p>
						</div>
					</div> </a>


			</div>
			<div class="col-8">
				<p>
					<b>Đổi mật khẩu</b>
				</p>
				<hr>
				<h5 style="color: red">${error}</h5>
				<form action="doimatkhau" method="POST">
					<div class="row" style="padding: 0px;">
						<div class="col-lg-4">
							<label>Mật khẩu cũ :</label> <label>Mật khẩu mới :</label> <label>Nhập
								lại mật khẩu mới: </label>




						</div>
						<div class="col-lg-8">

							<input type="password" name="oldPassword"> <br> <input
								type="password" id="password1" name="newPassword"
								required="required"> <br> <input type="password"
								id="password2" required="required"> <br> <b><h6
									id="validate-status"
									style="margin-left: 10px; margin-top: 10px; color: green;"></h6></b>
							<input
								style="margin-left: 2%; border: none; padding-top: 5px; padding-bottom: 5px"
								class="btn-primary" id="Submit" value="Đổi mật khẩu"
								type="submit">

						</div>
						<script>
    $(document).ready(function() {
  $("#password2").keyup(validate);
});


function validate() {
  var password1 = $("#password1").val();
  var password2 = $("#password2").val();

    
 
    if(password1 == password2) {
       $("#validate-status").text("Xác nhận mật khẩu thành công");
       $("#Submit").css("background", "#007bff");
       $("#validate-status").css("color", "green");
    }
    else {
        $("#validate-status").text("Xác nhận mật khẩu thất bại");
        $("#validate-status").css("color", "red");
        $("#Submit").prop('disabled', true);
        $("#Submit").css("background", "red");
    }
    
}
 
    </script>
					</div>
				</form>
			</div>
		</div>

	</main>


	<footer>
		<div class="top-footer">
			<div class="container">
				<div class="row">
					<div class="col-md-3">
						<div class="img">
							<img
								src="https://hgeqic7azi.vcdn.com.vn/image/catalog/Footer/service1.png"
								style="max-width: 50px;" alt="GIAO HÀNG SIÊU TỐC">
						</div>
						<div style="margin-left: 20px;">
							<span
								style="font-size: 13px; font-weight: bold; text-transform: uppercase;">GIAO
								HÀNG SIÊU TỐC</span>
							<p style="font-size: 13px;">Hệ thống giao hàng tự động chỉ
								trong 3 phút</p>
						</div>
					</div>
					<div class="col-md-3">
						<div class="img">
							<img
								src="https://hgeqic7azi.vcdn.com.vn/image/catalog/Footer/service2.png"
								style="max-width: 50px;" alt="BẢO HÀNH NHANH CHÓNG">
						</div>
						<div style="margin-left: 20px;">
							<span
								style="font-size: 13px; font-weight: bold; text-transform: uppercase;">BẢO
								HÀNH NHANH CHÓNG</span>
							<p style="font-size: 13px;">Mọi yêu cầu hỗ trợ sẽ được đội
								ngũ tư vấn giải quyết trực tiếp.</p>
						</div>
					</div>
					<div class="col-md-3">
						<div class="img">
							<img
								src="https://hgeqic7azi.vcdn.com.vn/image/catalog/Footer/service3.png"
								style="max-width: 50px;" alt="UY TÍN 5 SAO">
						</div>
						<div style="margin-left: 20px;">
							<span
								style="font-size: 13px; font-weight: bold; text-transform: uppercase;">UY
								TÍN 5 SAO</span>
							<p style="font-size: 13px;">Được cộng đồng bình chọn là shop
								game uy tín nhất VN</p>
						</div>
					</div>
					<div class="col-md-3">
						<div class="img">
							<img
								src="https://hgeqic7azi.vcdn.com.vn/image/catalog/Footer/service4.png"
								style="max-width: 50px;" alt="HỖ TRỢ TẬN TÌNH">
						</div>
						<div style="margin-left: 20px;">
							<span
								style="font-size: 13px; font-weight: bold; text-transform: uppercase;">HỖ
								TRỢ TẬN TÌNH</span>
							<p style="font-size: 13px;">Hệ thống hỗ trợ online liên tục
								từ 8h - 24h</p>
						</div>
					</div>
				</div>
			</div>
		</div>
		<div class="body-footer container">
			<div class="row">
				<div class="col-md-4">
					<h3>DIVINE SHOP</h3>
					<ul>
						<li><a href="" target="_blank">Game bản quyền là gì?</a></li>
						<li><a href="" target="_blank">Giới thiệu Divine Shop</a></li>
						<li><a href="" target="_blank">Điều khoản dịch vụ</a></li>
						<li><a href="" target="_blank">Chính sách bảo mật</a></li>
						<li><a href="">Donate nhân viên CSKH</a></li>
					</ul>
				</div>
				<div class="col-md-4">
					<h3>TÀI KHOẢN</h3>
					<ul>
						<li><a href="">Giỏ hàng</a></li>
						<li><a href="">Đăng kí</a></li>
						<li><a href="">Đăng nhập</a></li>
						<li><a href="">Sản phẩm đã mua</a></li>
						<li><a href="">Chế độ bảo hành</a></li>
					</ul>
				</div>
				<div class="col-md-4">
					<h3>LIÊN HỆ</h3>
					<ul>
						<li><a href="">Địa chỉ giao dịch trực tiếp</a></li>
						<li>Hotline: <a href="">1900 633 305</a> - <a
							href="tel:0964567247">096 4567 247</a> (7:00 - 24:00)
						</li>
						<li>Email: hotro@divineshop.vn</li>
						<li><a href="">Fanpage</a></li>
					</ul>
				</div>
			</div>
		</div>
	</footer>
</body>
</html>