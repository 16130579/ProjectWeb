<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta charset="UTF-8">
        <title>Funny</title>
        <style type="text/css">
        .background-payment{
            margin-top: 110px;
                padding:30px 0px;
                background-color: #ffffff;
            }
            .container{
                color: #4267B2;
                text-align: center;
            }
            .icon{
                font-size: 50px;
            }
            .btn{
                margin-top:20px;
            }
            .name-product{
                margin-top:10px;
                color:black;
            }
            .image-product{
                margin-top:20px;
            }</style>
    </head>
    <body>
    <%@include file="header.jsp" %>
<div class="container background-payment">
            <div class="icon">
                <i class="fas fa-check-circle"></i>
            </div>
            <h3>
                Thanh toán thành công
            </h3>
            <div class="image-product">
                <!-- <img style="width: 52%;-webkit-box-shadow: 1px 1px 5px 1px rgba(0,0,0,0.29); 
                box-shadow: 1px 1px 5px 1px rgba(0,0,0,0.29);" src="img/img-product/product-1.jpg" alt="Sản phẩm Among us"> -->
            </div>
            <div class="name-product">
                Mã đơn hàng: <span>1000120</span> <br>
                Tổng giá trị: <span>400.000đ</span> <br>
                
            </div>
            <div class="btn-succes-payment">
                <a href="index.html"><button type="button" class="btn btn-primary">Quay lại trang mua hàng</button></a>
            </div>
        </div>
     <%@include file="footer.jsp" %>
    </body>
</html>