<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
	<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Chi tiết</title>
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
<%@include file="header.jsp" %>
	<main class="container">
		<div class="row">
			<div class="col-4">
				<a href="profile.jsp">
					<div class="inactive">

						<i style="float: left; padding: 10px;" class="fas fa-info fa-2x"></i>
						<div>
							<p>
								<b>Thông tin tài khoản</b><br> Quản lý thông tin cá nhân
							</p>
						</div>
					</div>
				</a> <a href="history.jsp"><div class="active">
						<div class="bar"></div>
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
					</div> </a> <a href="Changepassword.jsp"><div class="inactive">
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
					<b>Chi tiết đơn hàng</b>
				</p>
				<hr>
				<table class="table table-striped">
					<thead>
						<tr>
							<th scope="col">Mã đơn hàng</th>
							<th scope="col">Tên sản phẩm</th>
							<th scope="col">Code</th>
							<th scope="col">Giá</th>
						</tr>
					</thead>
					<tbody>
					<c:forEach items="${orderdetail}" var="p">
						<tr>
							<th scope="row">${p.getId()}</th>
							<td>${p.getProduct_name()}</td>
							<td>${p.getProduct_key()}</td>
							<td>${p.getProduct_price()} đ</td>
						</tr>
					</c:forEach>	
					</tbody>
				</table>

			</div>
	</main>
<%@include file="footer.jsp" %>
</body>
</html>