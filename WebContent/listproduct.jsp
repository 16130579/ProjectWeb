<%@page import="dao.ProductDAO"%>
<%@page import="java.util.ArrayList"%>
<%@page import="model.Product"%> 
<%@page import="model.Category"%> 
<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html lang="en">
	<head>
		<meta charset="UTF-8">
		<meta name="viewport" content="width=device-width, initial-scale=1.0">
		<title>Danh sách</title>
		<link rel="stylesheet" href="bootstrap/css/bootstrap.min.css"/>
		<script src="bootstrap/js/bootstrap.min.js"></script>
		<link rel="stylesheet" href="https://pro.fontawesome.com/releases/v5.10.0/css/all.css"/>
		<link rel="stylesheet" href="css/styles.css">
        <link rel="stylesheet" href="css/css_dangNhap.css">
        <link rel="stylesheet" href="css/css_dangky.css">
		
		<link href="https://fonts.googleapis.com/css2?family=Roboto+Condensed:wght@300&display=swap" rel="stylesheet">
		<script
		src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
		<style type="text/css">
			a:hover{
				text-decoration: none;
			}
			svg{
				color: #556377;
			}
			svg:hover{
				color: #FFB517;
				cursor: pointer;
			}
			
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
		box-shadow: 0px 8px 16px 0px rgba(0,0,0,0.2);
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
		
		#main{
			margin-top: 120px;
			padding: 90px;
			padding-top: 10px;
			text-align: center;
			padding-bottom: 20px;
		}
		.productS{
			border: 1px solid #D8D8D8;
			padding: 0;
			text-align: center;
			font-weight: bold;
			
		}
		.productS:hover{
		-moz-box-shadow:    3px 3px 5px 6px #ccc;
		-webkit-box-shadow: 3px 3px 5px 6px #ccc;
		box-shadow:         3px 3px 5px 6px #ccc;
		}
		.col-3{
			padding-top: 20px;
		}
		.divS{
			display: inline-block;
			margin-left: 10%;
			margin-right: 2.5%;
			
		}
		.divS svg{
			color: white;
		}
		.item-btn {
		display: flex;
		align-items: center;
		justify-content: center;
		color: #21beff;
		border: 1px solid #21beff;
		border-radius: 3px;
		padding: 3px 18px;
		width: fit-content;
		text-align: center;
		margin: 10px auto 0;
		font-size: 12px;
		font-family: 'Roboto-Condensed-Bold';
		cursor: pointer;
		}
		
		select {
		width: 100%;
		border: 1px solid #e0e0e0;
		padding: 6px;
		border-radius: 3px;
		font-family: 'Roboto-Condensed-Bold';
		color: #656262;
		}
		.filter{
			padding: 7px 30px 7px 30px;
			border: none;
			border-radius: 5px;
			cursor: pointer;
		}
		.item-btn:hover{
			color: white;
			background: #21beff;
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
        background-color: rgb(0,0,0); /* Fallback color */
        background-color: rgba(0,0,0,0.4); /* Black w/ opacity */
        }
        /* Modal Content */
        .modal-content {
        position: relative;
        background-color: #fefefe;
        margin: auto;
        padding: 0;
        border: 1px solid #888;
        width: 80%;
        box-shadow: 0 4px 8px 0 rgba(0,0,0,0.2),0 6px 20px 0 rgba(0,0,0,0.19);
        -webkit-animation-name: animatetop;
        -webkit-animation-duration: 0.4s;
        animation-name: animatetop;
        animation-duration: 0.4s
        }
		/* Add Animation */
		@-webkit-keyframes animatetop {
		from {top:-300px; opacity:0}
		to {top:0; opacity:1}
		}
		@keyframes animatetop {
		from {top:-300px; opacity:0}
		to {top:0; opacity:1}
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
        .close1:hover,
        .close1:focus {
        color: red;
        text-decoration: none;
        cursor: pointer;
        }
       
        .modal-body {padding: 2px 16px;}
        
        .close2 {
        color: black;
        float: right;
        font-size: 28px;
        font-weight: bold;
        position: absolute;
        top: 3px;
        right: 20px;
        }
        .close2:hover,
        .close2:focus {
        color: red;
        text-decoration: none;
        cursor: pointer;
        }
		</style>
		
	</head>
	<body>
		<%@include file="header.jsp" %>
		
		<div id="main" class="container">
			<div>
				
			</div>
			<div class="row">
			<% ArrayList<Product> arr = ProductDAO.getListProduct(); 
			int start = 0,end = 8;
			if(arr.size()<8){
				end = arr.size();
			}
			if(request.getParameter("start")!=null){
				start = Integer.parseInt(request.getParameter("start"));
			}
			if(request.getParameter("end")!=null){
				end = Integer.parseInt(request.getParameter("end"));
			}
			ArrayList<Product> list = ProductDAO.getListByPage(arr, start, end);
			
			%>
				<% for(Product item : list){ %>
				<div class="col-3">
					<div class="productS">
						<a href="ChiTietSanPham?id=<%=item.getId()%>"><img src="<%=item.getImg() %>" alt="" width="215" height="100"></a>
						<p><%=item.getName() %></p>
						<p><%=item.getPrice() %>đ</p>
						<a href="AddToCart?id=<%=item.getId()%>"><svg width="20px" height="20px" viewBox="0 0 16 16" class="bi bi-cart-fill" fill="currentColor" xmlns="http://www.w3.org/2000/svg">
							<path fill-rule="evenodd" d="M0 1.5A.5.5 0 0 1 .5 1H2a.5.5 0 0 1 .485.379L2.89 3H14.5a.5.5 0 0 1 .491.592l-1.5 8A.5.5 0 0 1 13 12H4a.5.5 0 0 1-.491-.408L2.01 3.607 1.61 2H.5a.5.5 0 0 1-.5-.5zM5 12a2 2 0 1 0 0 4 2 2 0 0 0 0-4zm7 0a2 2 0 1 0 0 4 2 2 0 0 0 0-4zm-7 1a1 1 0 1 0 0 2 1 1 0 0 0 0-2zm7 0a1 1 0 1 0 0 2 1 1 0 0 0 0-2z"/>
						</svg></a>
						<a href="gioHang.html"><div class="item-btn" style="margin-top: 10px;margin-bottom: 10px;">Mua ngay</div></a>
					</div>
				</div>
				<%} %>
			</div>
			<br>
			 <div class="container" style="margin-left: 80%;">
            
        
			<ul class="pagination">
			<%
			int a, b;
			int limit = arr.size() / 8;
			if(limit*8<arr.size()){
				limit += 1;
			}
			for (int i = 1 ; i <= limit; i++){
				a = (i-1)*8;
				b = i*8;
				if(b > arr.size()){
					b = arr.size();
				}
			
			
			%>
			<li class="page-item active"><a class="page-link" href="listproduct.jsp?start=<%=a%>&end=<%=b%>"><%=i %></a></li>
			<%} %>
			<li>
			</ul>
			</div>
		</div>
		 <%@include file="footer.jsp" %>
		
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
					</body>
				</html>