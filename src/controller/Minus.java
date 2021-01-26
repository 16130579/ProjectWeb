package controller;

import java.io.IOException;
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

/**
 * Servlet implementation class Minus
 */
@WebServlet("/Minus")
public class Minus extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		int id = Integer.parseInt(request.getParameter("id"));
		HttpSession session= request.getSession();
		Map<Integer, Cart> cartShopping = (Map<Integer, Cart>) session.getAttribute("cartShopping");
		Cart cart = new Cart();
		Cart c2 = new Cart();
		c2 = (Cart) cartShopping.get(id);
		cart.setAmount(c2.getAmount()-1);
		cart.setName(c2.getName());
		cart.setImg(c2.getImg());
		Product p = ProductDAO.getProductById(id);
		cart.setPrice(p.getPrice());
		cart.setPrice(cart.getPrice() * cart.getAmount());
		cartShopping.put(id, cart);
		int total = 0;
		int sum = 0;
		for (Cart item : cartShopping.values()) {
			total += item.getPrice();
			sum += item.getAmount();
		}
		User user = (User) session.getAttribute("USER");
		if (user != null) {
			int balance = user.getBalance();
			int need = balance - total;
			if (need > 0) {
				need = 0;
			}
			User check = new User();
			check.setBalance(need);
			session.setAttribute("check", check);
			request.setAttribute("needed", need);
		}
		Double d = new Double(total);
		double vnd = d / 22000;
		vnd=(double) Math.round(vnd * 100) / 100;
		request.setAttribute("thanhtoan", vnd);
		User check = new User();
//		check.setBalance(need);
//		session.setAttribute("check", check);
//		request.setAttribute("needed", need);
		Order order = new Order();
		order.setPrice(total);
		session.setAttribute("order", order);
		request.setAttribute("sum", sum);
		session.setAttribute("sum", sum);
		request.setAttribute("total", total);
		request.getRequestDispatcher("LoadGioHang").forward(request, response);

	}




}
