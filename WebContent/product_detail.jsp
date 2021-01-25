<%@page import="model.Product"%>
<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html>
<html>
    <head>
        <title>Chi tiết sản phẩm</title>
        <script type="text/javascript" src="javascript.js"></script>
        <link rel="stylesheet" href="bootstrap/css/bootstrap.css">
        <link rel="stylesheet" href="fontawesome-free-5.15.1-web/css/all.css">
        <link rel="stylesheet" href="css/styles.css">
        <link rel="stylesheet" href="css/css_dangNhap.css">
        <link rel="stylesheet" href="css/css_dangky.css">
        <link href="https://fonts.googleapis.com/css2?family=Roboto+Condensed:wght@300&display=swap" rel="stylesheet">
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
    <% Product p = (Product)request.getAttribute("product"); %>
        <%@include file="header.jsp" %>
        <div class="margin-box container">
            <div class="home-product">
                <a href="index.jsp"><i class="fas fa-home"></i></a> / <a href=""><span>Among Us</span></a> 
            </div>
            <div class="title-product">
                <h3><b><%= p.getName() %></b></h3>
            </div>
            <div class="row">
            
                <div class="col-md-6 box-gallary">
                    <div class="mySlides" style="display: block;">
                          <img src="<%= p.getImg() %>" style="width:100%">
                      </div>
                    
                      <div class="mySlides">
                          <img src="img/gallary/imgae-gallary-2.jpg" style="width:100%">
                      </div>
                    
                      <div class="mySlides">
                          <img src="img/gallary/imgae-gallary-3.jpg" style="width:100%">
                      </div>
                    
                      <div class="mySlides">
                          <img src="img/gallary/imgae-gallary-4.jpg" style="width:100%">
                      </div>
                    
                      <div class="mySlides">
                          <img src="img/gallary/imgae-gallary-5.jpg" style="width:100%">
                      </div>
                    
                      <div class="mySlides">
                          <img src="img/gallary/imgae-gallary-6.png" style="width:100%">
                      </div>
                    
                      <!-- Next and previous buttons -->
                    
                      <!-- Image text -->
                      <div class="caption-container">
                        <p id="caption"></p>
                      </div>
                    
                      <!-- Thumbnail images -->
                      <div class="row">
                        <div class="column">
                          <img class="demo cursor" src="img/gallary/imgae-gallary-1.jpg" style="width:100%" onclick="currentSlide(1)" alt="">
                        </div>
                        <div class="column">
                          <img class="demo cursor" src="img/gallary/imgae-gallary-2.jpg" style="width:100%" onclick="currentSlide(2)" alt="">
                        </div>
                        <div class="column">
                          <img class="demo cursor" src="img/gallary/imgae-gallary-3.jpg" style="width:100%" onclick="currentSlide(3)" alt="">
                        </div>
                        <div class="column">
                          <img class="demo cursor" src="img/gallary/imgae-gallary-4.jpg" style="width:100%" onclick="currentSlide(4)" alt="">
                        </div>
                        <div class="column">
                          <img class="demo cursor" src="img/gallary/imgae-gallary-5.jpg" style="width:100%" onclick="currentSlide(5)" alt="">
                        </div>
                        <div class="column">
                          <img class="demo cursor" src="img/gallary/imgae-gallary-6.png" style="width:100%" onclick="currentSlide(6)" alt="">
                        </div>
                      </div>
                </div>
                <div class="col-md-6">
                    <div class="box-order">
                        <h5>Giá sản phẩm</h5>
                        <span style="font-weight: 600;font-size: 24px;"><%= p.getPrice() %> VNĐ</span> <a href=""><span class="alarm-title"><i class="fas fa-bell"></i></span></a>
                    </div>
                    <div class="box-order">
                                <h6>Số lượng: </h6>
                                <div class="box-number">
                                    <button type="button" style="width:46px;height:26px;" class="btn btn-light">-</button>
                                    <input type="text" name="quantity" value="1" size="2" id="input-quantity" class="form-control" style="width:46px;height:26px;font-weight: bold;text-align: center;border-radius:0">
                                    <button type="button" style="width:40px;height:26px;" class="btn btn-light">+</button>
                                </div>
                    </div>
                    <div class="tags"><img src="img/icon/item-icon-1.png"><b>Tag:</b>
                        <span><a href="#">Casual</a></span>
                    </div>
                    <div class="box-btn-pay">
                        <div class="row">
                            
                                
                            
                            <div class="col-md-6">
                                <a href="AddToCart?id=<%=p.getId() %>"><button type="button" class="btn btn-warning"><i class="fa fa-shopping-cart text-left"></i> Thêm giỏ hàng</button></a>
                            </div>
                        </div>
                        
                    </div>
                </div>
            </div>
            <div class="tutorial clearfix huongdan"><p>An online and local party game of teamwork and betrayal for 4-10 players...in space!</p>
            </div>
            <div class="description-product">
                <h3>Chi tiết sản phẩm</h3>
                <p><%= p.getDes() %></p>
            <div class="box-contain-comment">
                <div class="box-title-question">
                    <h3>Gửi câu hỏi và ý kiến của bạn về sản phẩm <br>(Chúng tôi sẽ phản hồi trong 5 phút)</h3>
                </div>
                <div class="box-title-question">
                    <button type="button" class="btn btn-primary">Đăng nhập để bình luận</button>
                </div>
                <div class="box-title-question">
                    <div class="box-comment">
                        <div class="imgae-comment">
                            <img src="img/icon/icon-user.png" style="width: 40px; border-radius: 50%;" alt="Hình ảnh người dùng"> 
                        </div>
                        <div class="content-comment">
                            <h5>Minh Nhựt</h5>
                            <p>game này thật sự rất vui mình đã nạp wallet zo để muaaa</p>
                            <a href="">Trả lời</a> <span>2 ngày trước</span>
                        </div>
                    </div>
                    <div class="box-comment">
                        <div class="imgae-comment">
                            <img src="img/icon/icon-user-3.jpg" style="width: 40px;border-radius: 50%;" alt="Hình ảnh người dùng"> 
                        </div>
                        <div class="content-comment">
                            <h5>Tuấn Trung Nguyễn</h5>
                            <p>Game này giờ hack, bug nhiều wa :(</p>
                            <a href="">Trả lời</a> <span>4 ngày trước</span>
                            <div class="box-comment">
                                <div class="imgae-comment">
                                    <img src="img/icon/icon-admin.jpg" style="width: 40px;border-radius: 50%;" alt="Hình ảnh người dùng"> 
                                </div>
                                <div class="content-comment">
                                    <h5>CSKH - Huỳnh Phi</h5>
                                    <p>Dạ mình hiện không chơi game này nên không rõ, chắc là có bạn ạ</p>
                                    <a href="">Trả lời</a> <span>4 ngày trước</span>
                                </div>
                            </div>
                        </div>
                    </div>
                    <div class="box-comment">
                        <div class="imgae-comment">
                            <img src="img/icon/icon-user-2.jpg" style="width: 40px;border-radius: 50%;" alt="Hình ảnh người dùng"> 
                        </div>
                        <div class="content-comment">
                            <h5>PKế Lân</h5>
                            <p>Trang web thật sự rất tin cậy, cskh cũng vui tính (ɔ◔‿◔)ɔ ♥</p>
                            <a href="">Trả lời</a> <span>5 ngày trước</span>
                        </div>
                    </div>
                </div>
                <div class="add-comment">
                    <a href="">Xem thêm 32 bình luận</a>
                </div>
            </div>
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