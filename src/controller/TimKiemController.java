package controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.ProductDAO;
import model.Product;


@WebServlet("/TimKiemController")
public class TimKiemController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String name = request.getParameter("name");
		ArrayList<Product> list = ProductDAO.getListProductByName(name);
		request.setAttribute("list", list);
		RequestDispatcher dispatcher = request.getRequestDispatcher("listproduct.jsp");
		dispatcher.forward(request, response);
	}

	

}
