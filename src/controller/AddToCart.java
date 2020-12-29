package controller;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.ProductDAO;
import model.Cart;
import model.Product;


@WebServlet("/AddToCart")
public class AddToCart extends HttpServlet {
	private static final long serialVersionUID = 1L;
       



	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		int id = Integer.parseInt(request.getParameter("id"));
		Product product = ProductDAO.getProductById(id);
		Cart cart = new Cart();
		cart.setName(product.getName());
		cart.setImg(product.getImg());
		cart.setPrice(product.getPrice());
		
		HttpSession session = request.getSession();
		

		if (session.getAttribute("cartShopping") == null) {
			
 			Map<Integer, Cart> cartShopping = new HashMap<>();
 			cart.setAmount(1);
 			cart.setPrice(cart.getPrice()*cart.getAmount());
 			cartShopping.put(product.getId(), cart);
 			
			int total = 0;
			int sum = 0;
			for (Cart item : cartShopping.values()) {
				total += item.getPrice();
				sum +=item.getAmount();
			}
			session.setAttribute("cartShopping", cartShopping);
			request.setAttribute("cart", cartShopping);
			request.setAttribute("total", total);
			request.setAttribute("sum", sum);
			request.getRequestDispatcher("gioHang.jsp").forward(request, response);
		} else {
			Map<Integer, Cart> cartShopping = (Map<Integer, Cart>) session.getAttribute("cartShopping");
			Cart c2 = new Cart();
			c2 = (Cart)cartShopping.get(id);
			
			if (cartShopping.containsKey(product.getId())) {
				cart.setAmount(c2.getAmount());
				cart.setAmount(cart.getAmount()+1);
				cart.setPrice(cart.getPrice()*cart.getAmount());
				int total = 0;
				int sum = 0;
				cartShopping.put(product.getId(), cart);
				for (Cart item : cartShopping.values()) {
					total += item.getPrice();
					sum +=item.getAmount();
				}
				request.setAttribute("sum", sum);
				request.setAttribute("total", total);
				
			}else {
				cart.setAmount(1);
				int total = 0;
				int sum = 0;
				cartShopping.put(product.getId(), cart);
				for (Cart item : cartShopping.values()) {
					total += item.getPrice();
					sum +=item.getAmount();
				}
				request.setAttribute("sum", sum);
				request.setAttribute("total", total);
				
			}
			
			session.setAttribute("cartShopping", cartShopping);
			request.setAttribute("cart", cartShopping);
			request.getRequestDispatcher("gioHang.jsp").forward(request, response);
		}
	}



}
