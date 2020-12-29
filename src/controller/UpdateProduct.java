package controller;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

import dao.ProductDAO;
import model.Product;

@MultipartConfig
@WebServlet("/UpdateProduct")
public class UpdateProduct extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	
	protected void processRequest(HttpServletRequest request,
	        HttpServletResponse response)
	        throws ServletException, IOException {
	    response.setContentType("text/html;charset=UTF-8");
	    request.setCharacterEncoding("UTF-8");
	    try (PrintWriter out = response.getWriter()){
	        Part part = request.getPart("file");
	        String fileName = part.getSubmittedFileName();
	        String path = "D:\\WorkSpace\\Web-2020\\WebContent\\img\\img-product\\"+fileName;

	        InputStream is = part.getInputStream();
	        boolean suc =upoloadFile(is, path);
	        Product p = ProductDAO.getProductById(Integer.parseInt(request.getParameter("id")));
			String name = request.getParameter("name");
			int price = Integer.parseInt(request.getParameter("price"));
			int sale = Integer.parseInt(request.getParameter("sale"));
			int category = Integer.parseInt(request.getParameter("category"));
			String des = request.getParameter("des");
			p.setCategory_id(category);
			p.setName(name);
			p.setPrice(price);
			p.setSales(sale);
			p.setDes(des);
			if (fileName != "") {
				p.setImg("img/img-product/"+fileName);
			}
	        boolean check = ProductDAO.updateProduct(p, p.getId());
	        if ( check == true) {
	        	response.sendRedirect("http://localhost:8080/Web-2020/AdminProductController");
//	        	request.setAttribute("error", "Cập nhật thành công");
//				request.getRequestDispatcher("AdminProductController").forward(request, response);
			}else {
				out.println("error");
			}

	}
	}
	public boolean upoloadFile(InputStream is,String path) {
		boolean test = false;
		try {
			
			FileOutputStream fops = new FileOutputStream(path);
			int b;
			 while((b=is.read())!=-1) {//Continuously read each byte
				 fops.write(b);//write each byte out
			}
			fops.flush();
			fops.close();
			test =true;
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return test;
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
//		Product p = ProductDAO.getProductById(Integer.parseInt(request.getParameter("id")));
//		String name = request.getParameter("name");
//		int price = Integer.parseInt(request.getParameter("price"));
//		int sale = Integer.parseInt(request.getParameter("sale"));
//		int category = Integer.parseInt(request.getParameter("category"));
//		String des = request.getParameter("des");
//		p.setCategory_id(category);
//		p.setName(name);
//		p.setPrice(price);
//		p.setSales(sale);
//		p.setDes(des);
//		boolean check = ProductDAO.updateProduct(p, p.getId());
//		if(check) {
//			request.setAttribute("error", "Cập nhật thành công");
//			request.getRequestDispatcher("AdminProductController").forward(request, response);
//		}else {
//			request.setAttribute("error", "Cập nhật thất bại");
//			request.getRequestDispatcher("AdminProductController").forward(request, response);
//		}
		processRequest(request, response);
	}
	

}
