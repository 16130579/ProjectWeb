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
@WebServlet("/AddProductController")
public class AddProductController extends HttpServlet {
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
	        String name = request.getParameter("name");
	        int price = Integer.parseInt(request.getParameter("price"));
	        String des = request.getParameter("des");
	        request.getParameter("des");
	        Product product = new Product();
	        product.setName(name);
	        product.setPrice(price);
	        product.setDes(des);
	        product.setImg("img/img-product/"+fileName);
	        boolean add = ProductDAO.addProduct(product);
	        if (suc==true && add == true) {
	        	response.sendRedirect("http://localhost:8080/Web-2020/AdminProductController");
	    		
			}else {
				out.println("error");
			}
//	        if (suc) {
//				out.println(path);
//			}else {
//				out.println("error");
//			}
	}
	}

	public boolean upoloadFile(InputStream is,String path) {
		boolean test = false;
		try {
			byte[] byt =new byte[is.available()];
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
		processRequest(request, response);
	}

}
