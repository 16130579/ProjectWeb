package controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Product;


@WebServlet("/ProductController")
public class ProductController extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public ProductController() {
        super();
        // TODO Auto-generated constructor stub
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setCharacterEncoding("UTF-8");
		ArrayList<Product> list = new ArrayList<Product>();
		list.add(new Product(1, "Netflix", "img/img-product/netflix1.png", 190000, 165000, "Mô tả"));
		list.add(new Product(2, "Netflix", "img/img-product/netflix1.png", 190000, 165000, "Mô tả"));
		request.setAttribute("list", list);
		RequestDispatcher dispatcher = request.getRequestDispatcher("listproduct.jsp");
		dispatcher.forward(request, response);
	}

}
