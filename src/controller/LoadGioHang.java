package controller;

import java.io.IOException;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.Cart;

/**
 * Servlet implementation class LoadGioHang
 */
@WebServlet("/LoadGioHang")
public class LoadGioHang extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		HttpSession session = request.getSession();
		Map<Integer, Cart> cartShopping = (Map<Integer, Cart>) session.getAttribute("cartShopping");
		if (cartShopping != null) {
			session.setAttribute("cartShopping", cartShopping);
			request.setAttribute("cart", cartShopping);
			request.getRequestDispatcher("gioHang.jsp").forward(request, response);
		}else {
			request.getRequestDispatcher("index.jsp").forward(request, response);
		}
		
	}


}
