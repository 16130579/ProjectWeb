package controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.ProductDAO;
import model.Product;

/**
 * Servlet implementation class FilterSearch
 */
@WebServlet("/FilterSearch")
public class FilterSearch extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		int id = Integer.parseInt(request.getParameter("category"));
		String sort = request.getParameter("oder");
		String fil = request.getParameter("filter");
		ArrayList<Product> list=ProductDAO.getListProductByCategory(id, sort, fil);
		request.setAttribute("list", list);
		
	}



}
