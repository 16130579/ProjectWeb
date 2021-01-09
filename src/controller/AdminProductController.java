package controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.KeyDAO;
import dao.ProductDAO;
import model.Product;

/**
 * Servlet implementation class AdminProductController
 */
@WebServlet("/AdminProductController")
public class AdminProductController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setCharacterEncoding("UTF-8");
		ArrayList<Product> list = ProductDAO.getListProduct();
//		list.add(new Product(1, "Netflix", "img/img-product/netflix1.png", 190000, 165000, "Mô tả"));
//		list.add(new Product(2, "Netflix", "img/img-product/netflix1.png", 190000, 165000, "Mô tả"));
//		int count = KeyDAO.countProductById(id)
		request.setAttribute("list", list);
		
		RequestDispatcher dispatcher = request.getRequestDispatcher("adminproduct.jsp");
		dispatcher.forward(request, response);
	}

	

}
