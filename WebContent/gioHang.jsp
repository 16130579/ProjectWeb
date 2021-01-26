<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>Giỏ Hàng</title>
<link rel="stylesheet" href="bootstrap/css/bootstrap.css">
<link rel="stylesheet" href="fontawesome-free-5.15.1-web/css/all.css">
<link rel="stylesheet" href="css/styles.css">
<link rel="stylesheet" href="css/stype1.css">
<link rel="stylesheet" href="css/stype2.css">
<link rel="stylesheet" href="css/css_dangNhap.css">
        <link rel="stylesheet" href="css/css_dangky.css">
<link href="https://fonts.googleapis.com/css2?family=Roboto+Condensed:wght@300&display=swap" rel="stylesheet">
<style type="text/css">
.container1 {
	width: 70%;
	height: 625px;
	margin: auto;
	margin-top: 150px;
	background: white;
}

.container1 .phu-ngoai {
	padding: 37px;
}

.phu-ngoai .bottomm {
	overflow: auto;
	margin-top: 23px;
}

.phu-ngoai .bottomm .mua-tiep {
	float: left;
}

.phu-ngoai .bottomm .mua-tiep>button {
	height: 30px;
	border: 1px solid;
	border-radius: 4px;
	background: white;
	cursor: pointer;
}

.phu-ngoai .bottomm .mua-tiep>button:hover {
	background: #21beff;
	color: white;
}

.phu-ngoai .bottomm .mua {
	float: right;
}

.phu-ngoai .bottomm .mua>button {
	height: 30px;
	border: 1px solid;
	border-radius: 4px;
	background: #21beff;
	cursor: pointer;
	color: white;
}

.phu-ngoai .bottomm .mua>button:hover {
	background: white;
	color: #21beff;
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
        .close3 {
        color: black;
        float: right;
        font-size: 28px;
        font-weight: bold;
        position: absolute;
        top: 3px;
        right: 20px;
        }
        .close3:hover,
        .close3:focus {
        color: red;
        text-decoration: none;
        cursor: pointer;
        }
</style>
</head>
<body>
	<%@include file="header.jsp" %>
	
	<div class="container1">
		<div class="phu-ngoai">
			<div class="goods">
				<div class="goods-them"></div>
				
				<c:forEach var="entry" items="${cart}">
				<div class="goods-co">
					<div class="goods-1">
						<img alt="" src="${entry.value.getImg()}">
						<div class="goods-2">
							<a href="#">${entry.value.getName()}</a>
							<div class="thep">
								<p class="truoc">Tình trạng:</p>
								<p class="sau">Còn hàng</p>
							</div>
							
							<a class="a_sau" href="DeleteItemCart?id=${entry.key}" style="">Xóa</a>
							
						</div>

					</div>
					<div class="goods-3">
						<div class="gia">
							<span> ${entry.value.getPrice()} VND</span>
						</div>
						<div class="quantity-block">
							<span>
								<a href="Minus?id=${entry.key}"><button class="bt-truoc">-</button></a>
							</span> <input type="tel" min="0" value="${entry.value.getAmount()}"> <span>
								<a href="Plus?id=${entry.key}"><button class="bt-sau">+</button></a>
							</span>
						</div>
					</div>
				</div>
				<br>
				</c:forEach>
			</div>
			<div class="form-tt">
				<div class="form-tt1">
					<div class="hed">
						<span>Thông tin thanh toán</span>
					</div>
					<div class="sau-hed">
						
						<div class="oo2">
							<span class="oo2-truoc">Tổng tiền</span> <span class="oo2-sau" id="total">${total} VNĐ (${thanhtoan} USD)</span>
						</div>
						<div class="oo1">
							<span class="oo1-truoc">Số dư hiện tại</span> 
							<%if(user!= null){%>
							<span
								class="oo1-sau" id="balance"><%= user.getBalance() %> VND</span>
								<%}else{ %>
								<span
								class="oo1-sau">Bạn chưa đăng nhập</span>
								<%} %>
						</div>
						<div class="oo2">
						<%if(user!= null){ %>
							<span class="oo2-truoc">Số tiền cần nạp thêm</span><span
								class="oo2-sau">${needed} VND</span>
								<%}else{ %>
								<span class="oo2-truoc">Số tiền cần nạp thêm</span><span
								class="oo2-sau">0 VND</span>
								<%} %>
						</div>
						
					</div>
					<a href="cash.jsp"><div class="nap-many">
						<button>Nạp thêm tiền</button>
					</div></a>
				</div>
			</div>
			<div class="bottomm">
				<div class="mua-tiep">
					<a href="ProductController"><button class="btn btn-danger">Tiếp tục mua hàng</button></a>
				</div>
				<div class="mua">
				<form action="https://www.sandbox.paypal.com/cgi-bin/webscr" method="post">

            <!-- Enter seller's email address -->
            <input type="hidden" name="business" value="your_email@gmail.com">

            <!-- Variable cmd shows PayPal that this is a payment button -->
            <input type="hidden" name="cmd" value="_xclick">

            <!-- Bill information -->
            <input type="hidden" name="item_name" value="bill_name">
			<!--Total cost ($)-->
            <input type="hidden" name="amount" placeholder="Total bill" value="${thanhtoan}">

			<!--Type of Currency-->
            <input type="hidden" name="currency_code" value="USD">
			<!--Redirect to this link if payment is successfully transfered-->
            <input type="hidden" name="return" value="http://localhost:8080/Web-2020/ThanhToan">
			<!--Redirect to this link if fail-->
            <input type="hidden" name="cancel_return" value="http://localhost:8080/Web-2020/ProductController">
            <!-- Custom button -->
            <% User needed = (User)session.getAttribute("check"); %>
            <% int money=needed.getBalance(); %>
            <% if (user != null && money == 0){ %>
            <button class="btn btn-info">Thanh toán trực tiếp</button>
             <a class="btn btn-success" href="ThanhToanSoDu">Thanh toán bằng số dư</a>
            
            
             <%}else if(money<0){ %>
             <h5>Bạn không đủ tiền trong tài khoản</h5>
             <%}else if(money == 0){ %>
             <button class="btn btn-info">Thanh toán</button>
             <%} %>
	</form>
					
				</div>
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