<%@page import="dao.ProductDAO"%>
<%@page import="model.Product"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta charset="UTF-8">
        <title>Funny</title>
    </head>
    <body>
    <%@include file="header.jsp" %>
    
                <div class="box-banner margin-box container">
                
            <div class="box-catagory">
            
                <div class="catagory">
                    <i class="fas fa-bars"></i> Danh mục sản phẩm
                </div>
                
                <div class="catagory-item">
                    <ul>
                        <li><a href="listproduct.jsp"><i class="fab fa-steam-symbol"></i> <span>Game trên Stream</span></a> </li>
                        <li><a href="listproduct.jsp"><i class="fas fa-trophy"></i> <span>PUGB</span></a> </li>
                        <li> <a href="listproduct.jsp"><i class="fab fa-diaspora"></i> <span>Game trên Origin</span></a> </li>
                        <li><a href="listproduct.jsp"><i class="fas fa-wallet"></i> <span>Stream Wallet</span></a> </li>
                        <li><a href="listproduct.jsp"><i class="fas fa-mobile-alt"></i> <span>Nạp game mobile</span></a></li>
                        <li><a href="listproduct.jsp"><i class="fas fa-broadcast-tower"></i><span>Gói Data Mobile</span></a></li>
                        <li><a href="listproduct.jsp"><i class="fab fa-google-play"></i><span>Google Play, iTunes</span></a></li>
                        <li><a href="listproduct.jsp"><i class="fas fa-magic"></i><span>Tiện ích</span></a></li>
                        <li><a href="listproduct.jsp"><i class="fas fa-wallet"></i><span>Nintendo Eshop Card</span></a></li>
                        <li><a href="listproduct.jsp"><i class="fab fa-xbox"></i><span>Xbox Gift Card</span></a></li>
                    </ul>   
                </div>
            </div>
            <div class="right-banner">
                <div class="quick-menu">
                    <ul>
                        <li><a href="listproduct.jsp"><i class="fab fa-hotjar"></i> <span>Mua nhiều trong 24h</span></a></li>
                        <li><a href="listproduct.jsp"><i class="fas fa-award"></i> <span>NỔI BẬT NHẤT</span></a></li>
                        <li><a href="payments.html"><i class="far fa-credit-card"></i> <span>Hình thức thanh toán</span></a></li>
                        <li><a href="huongDanMuaHang.html"><i class="far fa-credit-card"></i> <span>Hướng dẫn</span></a></li>
                    </ul>
                </div>
                <div class="box-image-banner">
                    <div class="big-image">
                        <a href="">
                            <img class="check_img_errs" src="img/ad-banner/big-img.png" alt="Gói nạp Genshin Impact">
                        </a>
                    </div>
                    <div class="small-image">
                        <div class="small-image-link">
                            <a href="">
                                <img class="check_img_errs" src="img/ad-banner/small-img-1.png" alt="Garena Bonus">
                            </a>
                        </div>
                        <div class="small-image-link">
                            <a href="">
                                <img src="img/ad-banner/small-img-2.png" class="height-banner-home check_img_errs img-banner" alt="Gói nạp Itunes">
                            </a>
                        </div>
                    </div>
                </div>
                <div class="box-image-banner">
                    <div class="small-image-link">
                        <a href="">
                            <img class="check_img_errs" src="img/ad-banner/small-img-3.png" alt="Phân phối gói nạp Steam Wallet">
                        </a>
                    </div>
                    <div class="small-image-link">
                        <a href="">
                            <img class="check_img_errs" src="img/ad-banner/small-img-4.png" alt="Tài khoản">
                        </a>
                    </div>
                    <div class="small-image-link">
                        <a href="">
                            <img class="check_img_errs" src="img/ad-banner/small-img-5.png" alt="Viettel">
                        </a>
                    </div>
                </div>
            </div>
        </div>
        <div class="box-banner border-top-banner container">
            <div class="small-image">
                <div class="small-image-link">
                    <a href="">
                        <img class="check_img_errs" src="img/cataglog/banner 614x310 dai ly.png">
                    </a>
                </div>
                <button type="button" class="btn btn-primary">Xem ngay</button>
            </div>
            <div class="small-image">
                <div class="small-image-link">
                    <a href="">
                        <img class="check_img_errs" src="img/cataglog/banner 614x310 gtbm.png">
                    </a>
                </div>
                <button type="button" class="btn btn-primary">Xem ngay</button>
            </div>
            <div class="small-image">
                <div class="small-image-link">
                    <a href="">
                        <img class="check_img_errs" src="img/cataglog/youtube 2.png">
                    </a>
                </div>
                <button type="button" class="btn btn-primary">Xem ngay</button>
            </div>
            <hr>
        </div>
        <div class="box-product border-top-banner container">
            <div class="box-title">
                <h2>Sản phẩm nổi bật</h2>
                
            </div>
            <div class="list-product">
            <% ArrayList<Product> list = ProductDAO.getListProductTop4(); %>
            <% for(Product p : list){ %>
                <div class="product">
                    <div class="imgae-product">
                        <a href="detail_product.html">
                            <img class="check_img_errs img-product-detail" src="<%=p.getImg() %>">
                        </a>
                    </div>
                    <div class="info-product">
                        <a href="detail_product.html"><%=p.getName() %></a><br>
                        <%=p.getPrice() %>đ<br>
                        <a href="AddToCart?id=<%=p.getId() %>"><i class="fas fa-shopping-cart "></i><br></a>
                        <a href="AddToCart?id=<%=p.getId() %>"><button type="button" class="btn btn-blue">Mua ngay</button></a>
                    </div>
                </div>
               <%} %> 
              </div>
            
        </div>
        <div class="box-search-price border-top-banner container">
            <h2>Sản phẩm giá tốt</h2>
            <p>Bạn có thể lựa chọn hiển thị theo giá sản phẩm phù hợp với túi tiền</p>
            <ul>
                <a href=""><li>Dưới 50.000đ</li></a>
                <a href=""><li>Dưới 100.000đ</li></a>
                <a href=""><li>Dưới 200.000đ</li></a>
                <a href=""><li>Dưới 500.000đ</li></a>
                <a href=""><li>Dưới 1.000.000đ</li></a>
            </ul>
        </div>
        <div class="banner-register">
            <h4>Bạn là người mới</h4>
            <p>Hãy đăng kí tài khoản để cập nhật những ưu đãi mới nhất từ Divine Shop</p>
            <button type="button" id="btnregister2" class="btn btn-primary">Đăng kí ngay</button>
            <p>Hoặc <a href="">đăng nhập</a> nếu bạn có tài khoản</p>
            <div id="modalRegister2" class="modal">
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
                                                    	<span class="close3">&times;</span>
                                                        <h1 class="h4 text-gray-900 mb-4">Create an Account!</h1>
                                                    </div>
                                                    <form class="user">
                                                        <div class="form-group row">
                                                            <div class="col-sm-6 mb-3 mb-sm-0">
                                                                <input type="text" class="form-control form-control-user" id="exampleFirstName" placeholder="First Name">
                                                            </div>
                                                            <div class="col-sm-6">
                                                                <input type="text" class="form-control form-control-user" id="exampleLastName" placeholder="Last Name">
                                                            </div>
                                                        </div>
                                                        <div class="form-group">
                                                            <input type="email" class="form-control form-control-user" id="exampleInputEmail" placeholder="Email Address">
                                                        </div>
                                                        <div class="form-group row">
                                                            <div class="col-sm-6 mb-3 mb-sm-0">
                                                                <input type="password" class="form-control form-control-user" id="exampleInputPassword" placeholder="Password">
                                                            </div>
                                                            <div class="col-sm-6">
                                                                <input type="password" class="form-control form-control-user" id="exampleRepeatPassword" placeholder="Repeat Password">
                                                            </div>
                                                        </div>
                                                        <a href="login.html" class="btn btn-primary btn-user btn-block">
                                                            Register Account
                                                        </a>
                                                        <hr>
                                                        <a href="index.html" class="btn btn-google btn-user btn-block">
                                                            <i class="fab fa-google fa-fw"></i> Register with Google
                                                        </a>
                                                        <a href="index.html" class="btn btn-facebook btn-user btn-block">
                                                            <i class="fab fa-facebook-f fa-fw"></i> Register with Facebook
                                                        </a>
                                                    </form>
                                                    <hr>
                                                    <div class="text-center">
                                                        <a class="small" href="forgot-password.html">Forgot Password?</a>
                                                    </div>
                                                    <div class="text-center">
                                                        <a class="small" href="login.html">Already have an account? Login!</a>
                                                    </div>
                                                </div>
                                            </div>
                                        </div>
                                    </div>
                                    
                                </div>
                            </div>
        </div>
        <%@include file="footer.jsp" %>
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