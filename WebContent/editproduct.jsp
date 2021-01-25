<%@page import="dao.ProductDAO"%>
<%@page import="java.util.ArrayList"%>
<%@page import="org.apache.jasper.tagplugins.jstl.core.ForEach"%>
<%@page import="model.Category"%>
<%@page import="model.Product"%>
<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no">
<meta name="description" content="">
<meta name="author" content="">
<title>Admin</title>
<!-- Custom fonts for this template-->
<link href="admin/vendor/fontawesome-free/css/all.min.css"
	rel="stylesheet" type="text/css">
<link
	href="https://fonts.googleapis.com/css?family=Nunito:200,200i,300,300i,400,400i,600,600i,700,700i,800,800i,900,900i"
	rel="stylesheet">
<!-- Custom styles for this template-->
<link href="admin/css/sb-admin-2.min.css" rel="stylesheet">
<style type="text/css">
.pagination li {
	border: 0.1px solid black;
	padding: 5px;
	border-left: 0px;
}
</style>
<script type="text/javascript" src="ckeditor/ckeditor.js"></script>
</head>
<body id="page-top">
	<!-- Page Wrapper -->
	<div id="wrapper">
		<!-- Sidebar -->
		<ul
			class="navbar-nav bg-gradient-primary sidebar sidebar-dark accordion"
			id="accordionSidebar">
			<!-- Sidebar - Brand -->
			<a
				class="sidebar-brand d-flex align-items-center justify-content-center"
				href="AdminProductController">
				<div class="sidebar-brand-icon rotate-n-15">
					<i class="fas fa-laugh-wink"></i>
				</div>
				<div class="sidebar-brand-text mx-3">Admin</div>
			</a>
			<!-- Divider -->
			<hr class="sidebar-divider my-0">
			<!-- Nav Item - Dashboard -->
			<li class="nav-item active"><a class="nav-link"
				href="index.html"> <i class="fas fa-fw fa-tachometer-alt"></i> <span>Dashboard</span></a>
			</li>
			<!-- Divider -->
			<hr class="sidebar-divider">
			<!-- Heading -->
			<div class="sidebar-heading">Interface</div>
			<!-- Nav Item - Pages Collapse Menu -->
			<li class="nav-item"><a class="nav-link collapsed" href="#"
				data-toggle="collapse" data-target="#collapseTwo"
				aria-expanded="true" aria-controls="collapseTwo"> <i
					class="fas fa-fw fa-cog"></i> <span>Manager</span>
			</a>
				<div id="collapseTwo" class="collapse show"
					aria-labelledby="headingTwo" data-parent="#accordionSidebar">
					<div class="bg-white py-2 collapse-inner rounded">

						<a class="collapse-item " href="account.html">Account</a> <a
							class="collapse-item active" href="product.html">Product</a> <a
							class="collapse-item" href="order.html">Order</a>
					</div>
				</div></li>

			<hr class="sidebar-divider d-none d-md-block">
			<!-- Sidebar Toggler (Sidebar) -->
			<div class="text-center d-none d-md-inline">
				<button class="rounded-circle border-0" id="sidebarToggle"></button>
			</div>
		</ul>
		<!-- End of Sidebar -->
				<!-- main -->
				<div class="container-fluid">
					<div class="container">
						<div class="row">

				<%Product p = (Product)request.getAttribute("product"); %>
							<div class="col-md-6">

								<div class="modal-dialog">
									<div class="modal-content">
										<div class="modal-header">
											<button type="button" class="close" data-dismiss="modal"
												aria-hidden="true">
												<span class="glyphicon glyphicon-remove" aria-hidden="true"></span>
											</button>
											<h4 class="modal-title" id="Heading"
												style="margin-right: 32%;">Thay đổi thông tin</h4>
											<h6 style="color: red">${error}</h6>
										</div>
										<form action="UpdateProduct" method="post" id="myform" enctype="multipart/form-data">
										<div class="modal-body">
											<div class="form-group">
												<input class="form-control " type="text"
													value="<%= p.getId() %>" name="id" readonly="readonly">
											</div>
											<div class="form-group">
												<input class="form-control " type="text"
													value="<%= p.getName() %>" name="name">
											</div>
											<div class="form-group">
												<input class="form-control " name="file" type="file"
													placeholder="Tải hình ảnh">
											</div>
											<div class="form-group">

												<input class="form-control " type="text"
													value="<%= p.getPrice() %>" name="price">
											</div>
											<div class="form-group">

												<input class="form-control " type="text"
													value="<%= p.getSales() %>" name="sale" placeholder="Khuyến mãi">
											</div>
											<div class="form-group">

												<input class="form-control " type="text"
													value="<%= p.getStatus() %>" name="status">
											</div>
											
											<div class="form-group">
												<textarea class="form-control " id="content" name="des" value=""><%= p.getDes() %></textarea>
											</div>
											
											<% ArrayList<Category> listCategory = ProductDAO.getListCategory(); %>
											<div class="form-group">
												<select class="form-control" name="category">
												
												<%for (Category item : listCategory){ %>
												<%if(p.getCategory_id()==item.getId()){ %>
												<option value="<%= p.getCategory_id() %>" selected><%= item.getName() %></option>
												<%}else{ %>
													<option  value="<%= item.getId() %>"><%= item.getName() %></option>
													<% }} %>

												</select>
											</div>
											
										</div>
										<div class="modal-footer ">
											<button onclick="document.getElementById('myform').submit()" type="button" class="btn btn-warning btn-lg"
												style="width: 100%;">
												<span class="glyphicon glyphicon-ok-sign"></span> Cập nhật
											</button>
										</div>
										</form>
									</div>
									<!-- /.modal-content -->
									
								</div>


							</div>
						</div>
					</div>
					<!-- add -->

					<!-- endadd -->
					<div class="modal" id="edit" tabindex="-1" role="dialog"
						aria-labelledby="edit" aria-hidden="true">
						<div class="modal-dialog">
							<div class="modal-content">
								<div class="modal-header">
									<button type="button" class="close" data-dismiss="modal"
										aria-hidden="true">
										<span class="glyphicon glyphicon-remove" aria-hidden="true"></span>
									</button>
									<h4 class="modal-title" id="Heading" style="margin-right: 32%;">Thay
										đổi thông tin</h4>
								</div>
								<div class="modal-body">

									<div class="form-group">
										<input class="form-control " type="text" placeholder="Netflit">
									</div>
									<div class="form-group">
										<button style="margin-left: 10px">Tải hình ảnh</button>
										<!-- <input class="form-control " type="text" placeholder="img"> -->
									</div>
									<div class="form-group">

										<input class="form-control " type="text" placeholder="190,000">
									</div>
									<div class="form-group">
										<input class="form-control " type="text" placeholder="30">
									</div>
									<div class="form-group">
										<select name="" id="" class="form-control">
											<option value="">Steam</option>
											<option value="" selected>Software</option>
											<option value="">Televisiton</option>

										</select>
									</div>
								</div>
								<div class="modal-footer ">
									<button type="button" class="btn btn-warning btn-lg"
										style="width: 100%;">
										<span class="glyphicon glyphicon-ok-sign"></span> Cập nhật
									</button>
								</div>
							</div>
							<!-- /.modal-content -->
						</div>
						<!-- /.modal-dialog -->
					</div>



					<div class="modal fade" id="delete" tabindex="-1" role="dialog"
						aria-labelledby="edit" aria-hidden="true">
						<div class="modal-dialog">
							<div class="modal-content">
								<div class="modal-header">
									<button type="button" class="close" data-dismiss="modal"
										aria-hidden="true">
										<span class="glyphicon glyphicon-remove" aria-hidden="true"></span>
									</button>
									<h4 class="modal-title custom_align" id="Heading"
										style="margin-right: 32%;">Xóa sản phẩm này</h4>
								</div>
								<div class="modal-body">

									<div class="alert alert-danger">
										<span class="glyphicon glyphicon-warning-sign"></span> Bạn có
										chắc chắn muốn xóa
									</div>

								</div>
								<div class="modal-footer ">
									<button type="button" class="btn btn-success">
										<span class="glyphicon glyphicon-ok-sign"></span> Có
									</button>
									<button type="button" class="btn btn-default"
										data-dismiss="modal">
										<span class="glyphicon glyphicon-remove"></span> Không
									</button>
								</div>
							</div>
							<!-- /.modal-content -->
						</div>
						<!-- /.modal-dialog -->
					</div>
				</div>
				<!-- endmain -->
			</div>
			<!-- End of Main Content -->
			<!-- Footer -->
			<footer class="sticky-footer bg-white">
				<div class="container my-auto">
					<div class="copyright text-center my-auto">
						<span>Copyright &copy; Your Website 2020</span>
					</div>
				</div>
			</footer>
			<!-- End of Footer -->
		</div>
		<!-- End of Content Wrapper -->
	</div>
	<!-- End of Page Wrapper -->
	<!-- Scroll to Top Button-->
	<a class="scroll-to-top rounded" href="#page-top"> <i
		class="fas fa-angle-up"></i>
	</a>
	<!-- Logout Modal-->
	<div class="modal fade" id="logoutModal" tabindex="-1" role="dialog"
		aria-labelledby="exampleModalLabel" aria-hidden="true">
		<div class="modal-dialog" role="document">
			<div class="modal-content">
				<div class="modal-header">
					<h5 class="modal-title" id="exampleModalLabel">Ready to Leave?</h5>
					<button class="close" type="button" data-dismiss="modal"
						aria-label="Close">
						<span aria-hidden="true">×</span>
					</button>
				</div>
				<div class="modal-body">Select "Logout" below if you are ready
					to end your current session.</div>
				<div class="modal-footer">
					<button class="btn btn-secondary" type="button"
						data-dismiss="modal">Cancel</button>
					<a class="btn btn-primary" href="login.html">Logout</a>
				</div>
			</div>
		</div>
	</div>
	<!-- Bootstrap core JavaScript-->
	<script src="admin/vendor/jquery/jquery.min.js"></script>
	<script src="admin/vendor/bootstrap/js/bootstrap.bundle.min.js"></script>

	<!-- Core plugin JavaScript-->
	<script src="admin/vendor/jquery-easing/jquery.easing.min.js"></script>

	<!-- Custom scripts for all pages-->
	<script src="admin/js/sb-admin-2.min.js"></script>

	<!-- Page level plugins -->
	<script src="admin/vendor/chart.js/Chart.min.js"></script>

	<!-- Page level custom scripts -->
	<script src="admin/js/demo/chart-area-demo.js"></script>
	<script src="admin/js/demo/chart-pie-demo.js"></script>
	<script type="text/javascript">
	var editor = '';
	$(document).ready(function(){
		  editor = CKEDITOR.replace('content');
		});
	</script>
</body>
</html>