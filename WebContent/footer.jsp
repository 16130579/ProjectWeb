<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
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
        <link href="https://fonts.googleapis.com/css2?family=Roboto+Condensed:wght@300&display=swap" rel="stylesheet">
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
<footer>
            <div class="top-footer">
                <div class="container">
                    <div class="row">
                        <div class="col-md-3">
                            <div class="img">
                                <img src="https://hgeqic7azi.vcdn.com.vn/image/catalog/Footer/service1.png" style="max-width:50px;" alt="GIAO HÀNG SIÊU TỐC">
                            </div>
                            <div style="margin-left: 20px;">
                                <span style="font-size:13px;font-weight:bold;text-transform:uppercase;">GIAO HÀNG SIÊU TỐC</span>
                                <p style="font-size:13px;">Hệ thống giao hàng tự động chỉ trong 3 phút</p>
                            </div>
                        </div>
                        <div class="col-md-3">
                            <div class="img">
                                <img src="https://hgeqic7azi.vcdn.com.vn/image/catalog/Footer/service2.png" style="max-width:50px;" alt="BẢO HÀNH NHANH CHÓNG">
                            </div>
                            <div style="margin-left: 20px;">
                                <span style="font-size:13px;font-weight:bold;text-transform:uppercase;">BẢO HÀNH NHANH CHÓNG</span>
                                <p style="font-size:13px;">Mọi yêu cầu hỗ trợ sẽ được đội ngũ tư vấn giải quyết trực tiếp.</p>
                            </div>
                        </div>
                        <div class="col-md-3">
                            <div class="img">
                                <img src="https://hgeqic7azi.vcdn.com.vn/image/catalog/Footer/service3.png" style="max-width:50px;" alt="UY TÍN 5 SAO">
                            </div>
                            <div style="margin-left: 20px;">
                                <span style="font-size:13px;font-weight:bold;text-transform:uppercase;">UY TÍN 5 SAO</span>
                                <p style="font-size:13px;">Được cộng đồng bình chọn là shop game uy tín nhất VN</p>
                            </div>
                        </div>
                        <div class="col-md-3">
                            <div class="img">
                                <img src="https://hgeqic7azi.vcdn.com.vn/image/catalog/Footer/service4.png" style="max-width:50px;" alt="HỖ TRỢ TẬN TÌNH">
                            </div>
                            <div style="margin-left: 20px;">
                                <span style="font-size:13px;font-weight:bold;text-transform:uppercase;">HỖ TRỢ TẬN TÌNH</span>
                                <p style="font-size:13px;">Hệ thống hỗ trợ online liên tục từ 8h - 24h</p>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
            <div class="body-footer container">
                <div class="row">
                    <div class="col-md-4">
                        <h3>FUNNY SHOP</h3>
                        <ul>
                            <li><a href="" target="_blank">Game bản quyền là gì?</a></li>
                            <li><a href="" target="_blank">Giới thiệu Funny Shop</a></li>
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
                            <li>Hotline: <a href="">1900 633 305</a> - <a href="tel:0964567247">096 4567 247</a> (7:00 - 24:00)</li>
                            <li>Email: hotro@funnyshop.vn</li>
                            <li><a href="">Fanpage</a></li>
                        </ul>
                    </div>
                </div>
            </div>
        </footer>
</body>
</html>