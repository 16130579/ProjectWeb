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
import model.Order;
import model.Product;
import model.User;

@WebServlet("/AddToCart")
public class AddToCart extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		int id = Integer.parseInt(request.getParameter("id"));
		Product product = ProductDAO.getProductById(id);
		Cart cart = new Cart();
		cart.setName(product.getName());
		cart.setImg(product.getImg());
		cart.setPrice(product.getPrice());

		HttpSession session = request.getSession();
		User user = (User) session.getAttribute("USER");
		if (user != null) {

			if (session.getAttribute("cartShopping") == null) {

				Map<Integer, Cart> cartShopping = new HashMap<>();
				cart.setAmount(1);
				cart.setPrice(cart.getPrice() * cart.getAmount());
				cartShopping.put(product.getId(), cart);

				int total = 0;
				int sum = 0;
				for (Cart item : cartShopping.values()) {
					total += item.getPrice();
					sum += item.getAmount();
				}
				int balance = user.getBalance();
				int need = balance - total;
				if (need > 0) {
					need = 0;
				}
				Double d = new Double(total);
				double vnd = d / 22000;
				vnd=(double) Math.round(vnd * 100) / 100;
				request.setAttribute("thanhtoan", vnd);
				User check = new User();
				check.setBalance(need);
				session.setAttribute("check", check);
				request.setAttribute("needed", need);
				session.setAttribute("cartShopping", cartShopping);

				request.setAttribute("cart", cartShopping);
				Order order = new Order();
				order.setPrice(total);
				session.setAttribute("order", order);
				request.setAttribute("total", total);
				request.setAttribute("sum", sum);
				session.setAttribute("sum", sum);
				request.getRequestDispatcher("gioHang.jsp").forward(request, response);
			} else {
				Map<Integer, Cart> cartShopping = (Map<Integer, Cart>) session.getAttribute("cartShopping");
				Cart c2 = new Cart();
				c2 = (Cart) cartShopping.get(id);

				if (cartShopping.containsKey(product.getId())) {
					cart.setAmount(c2.getAmount());
					cart.setAmount(cart.getAmount() + 1);
					cart.setPrice(cart.getPrice() * cart.getAmount());
					int total = 0;
					int sum = 0;
					cartShopping.put(product.getId(), cart);
					for (Cart item : cartShopping.values()) {
						total += item.getPrice();
						sum += item.getAmount();
					}
					
					int balance = user.getBalance();
					int need = balance - total;
					if (need > 0) {
						need = 0;
					}
					Double d = new Double(total);
					double vnd = d / 22000;
					vnd=(double) Math.round(vnd * 100) / 100;
					request.setAttribute("thanhtoan", vnd);
					User check = new User();
					check.setBalance(need);
					session.setAttribute("check", check);
					request.setAttribute("needed", need);
					Order order = new Order();
					order.setPrice(total);
					session.setAttribute("order", order);
					request.setAttribute("sum", sum);
					session.setAttribute("sum", sum);
					request.setAttribute("total", total);

				} else {
					cart.setAmount(1);
					int total = 0;
					int sum = 0;
					cartShopping.put(product.getId(), cart);
					for (Cart item : cartShopping.values()) {
						total += item.getPrice();
						sum += item.getAmount();
					}
					int balance = user.getBalance();
					int need = balance - total;
					if (need > 0) {
						need = 0;
					}
					Double d = new Double(total);
					double vnd = d / 22000;
					vnd=(double) Math.round(vnd * 100) / 100;
					request.setAttribute("thanhtoan", vnd);
					User check = new User();
					check.setBalance(need);
					session.setAttribute("check", check);
					request.setAttribute("needed", need);
					Order order = new Order();
					order.setPrice(total);
					session.setAttribute("order", order);
					request.setAttribute("sum", sum);
					session.setAttribute("sum", sum);
					request.setAttribute("total", total);

				}

				session.setAttribute("cartShopping", cartShopping);
				request.setAttribute("cart", cartShopping);
				request.getRequestDispatcher("gioHang.jsp").forward(request, response);
			}
		} else {
			//user = null 
			
			if (session.getAttribute("cartShopping") == null) {

				Map<Integer, Cart> cartShopping = new HashMap<>();
				cart.setAmount(1);
				cart.setPrice(cart.getPrice() * cart.getAmount());
				cartShopping.put(product.getId(), cart);

				int total = 0;
				int sum = 0;
				for (Cart item : cartShopping.values()) {
					total += item.getPrice();
					sum += item.getAmount();
				}
//				int need = user.getBalance();
//				request.setAttribute("needed", need);
				Double d = new Double(total);
				double vnd = d / 22000;
				vnd=(double) Math.round(vnd * 100) / 100;
				request.setAttribute("thanhtoan", vnd);
				session.setAttribute("cartShopping", cartShopping);

				request.setAttribute("cart", cartShopping);
				Order order = new Order();
				order.setPrice(total);
				User check = new User();
				check.setBalance(0);
				session.setAttribute("check", check);
				session.setAttribute("order", order);
				request.setAttribute("total", total);
				
				request.setAttribute("sum", sum);
				session.setAttribute("sum", sum);
				request.getRequestDispatcher("gioHang.jsp").forward(request, response);
			} else {
				Map<Integer, Cart> cartShopping = (Map<Integer, Cart>) session.getAttribute("cartShopping");
				Cart c2 = new Cart();
				c2 = (Cart) cartShopping.get(id);

				if (cartShopping.containsKey(product.getId())) {
					cart.setAmount(c2.getAmount());
					cart.setAmount(cart.getAmount() + 1);
					cart.setPrice(cart.getPrice() * cart.getAmount());
					int total = 0;
					int sum = 0;
					cartShopping.put(product.getId(), cart);
					for (Cart item : cartShopping.values()) {
						total += item.getPrice();
						sum += item.getAmount();
					}
					Double d = new Double(total);
					double vnd = d / 22000;
					vnd=(double) Math.round(vnd * 100) / 100;
					request.setAttribute("thanhtoan", vnd);
					Order order = new Order();
					order.setPrice(total);
					User check = new User();
					check.setBalance(0);
					session.setAttribute("check", check);
					session.setAttribute("order", order);
					request.setAttribute("sum", sum);
					session.setAttribute("sum", sum);
					request.setAttribute("total", total);

				} else {
					cart.setAmount(1);
					int total = 0;
					int sum = 0;
					cartShopping.put(product.getId(), cart);
					for (Cart item : cartShopping.values()) {
						total += item.getPrice();
						sum += item.getAmount();
					}
					Double d = new Double(total);
					double vnd = d / 22000;
					vnd=(double) Math.round(vnd * 100) / 100;
					request.setAttribute("thanhtoan", vnd);
//					int need = user.getBalance();
//					request.setAttribute("needed", need);
					Order order = new Order();
					order.setPrice(total);
					User check = new User();
					check.setBalance(0);
					session.setAttribute("check", check);
					session.setAttribute("order", order);
					request.setAttribute("sum", sum);
					session.setAttribute("sum", sum);
					request.setAttribute("total", total);

				}

				session.setAttribute("cartShopping", cartShopping);
				request.setAttribute("cart", cartShopping);
				request.getRequestDispatcher("gioHang.jsp").forward(request, response);
			}

		}
	}

}
