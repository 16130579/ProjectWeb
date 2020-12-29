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


@WebServlet("/DeleteItemCart")
public class DeleteItemCart extends HttpServlet {
	private static final long serialVersionUID = 1L;
 
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int id = Integer.parseInt(request.getParameter("id"));
		HttpSession session = request.getSession();
		
		Map<Integer, Cart> cartShopping = (Map<Integer, Cart>) session.getAttribute("cartShopping");
		cartShopping.remove(id);
		int total = 0;
		int sum = 0;
		for (Cart item : cartShopping.values()) {
			total += item.getPrice();
			sum +=item.getAmount();
		}
		request.setAttribute("sum", sum);
		request.setAttribute("total", total);
//		session.setAttribute("cartShopping", cartShopping);
//		request.setAttribute("cart", cartShopping);
		request.getRequestDispatcher("LoadGioHang").forward(request, response);
//		response.sendRedirect("gioHang.jsp");
	}


}
