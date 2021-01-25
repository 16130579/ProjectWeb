package controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.KeyDAO;
import dao.OrderDAO;
import dao.OrderItemDAO;
import dao.ProductDAO;
import model.Cart;
import model.Key;
import model.Order;
import model.OrderItem;
import model.User;


@WebServlet("/ThanhToan")
public class ThanhToan extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		HttpSession session = request.getSession();
		User user = (User) session.getAttribute("USER");
		
		if (user == null) {
			Date now = new Date();
			Timestamp timestamp = new Timestamp(now.getTime());
			// Lấy tổng giá từ giỏ hàng qua session
			
			Order order = (Order) session.getAttribute("order");
			order.setCreateAt(timestamp);
			order.setStatus(1);
			order.setUser_id(15);
			int check=OrderDAO.addOrder(order);
			Map<String, String> redem = new HashMap<>();
			Map<Integer, Cart> cartShopping = (Map<Integer, Cart>) session.getAttribute("cartShopping");
			for (Map.Entry<Integer, Cart> item : cartShopping.entrySet()) {
				int id = item.getKey();
				Cart cart = item.getValue();
				OrderItem orderItem = new OrderItem();
				orderItem.setOrder_id(check);
				orderItem.setProduct_id(id);
				ArrayList<Key> Listkey= KeyDAO.getKeyByProductIdAmount(id, cart.getAmount());
				if (Listkey.size() < cart.getAmount()) {
					String hang = (ProductDAO.getProductById(id)).getName();
					request.setAttribute("hang", hang);
					request.getRequestDispatcher("hethang.jsp").forward(request, response);
					
				}else {
				for (Key key : Listkey) {
					orderItem.setProduct_key(key.getKey_code());
					orderItem.setProduct_name((ProductDAO.getProductById(id)).getName());
					orderItem.setProduct_price((ProductDAO.getProductById(id)).getPrice());
					orderItem.setAmount(1);
					boolean checkItem = OrderItemDAO.addOrderItem(orderItem);
					redem.put(key.getKey_code(),orderItem.getProduct_name());
					KeyDAO.updateKeyStatus(2, key.getId());
				}
				
//				orderItem.setAmount(cart.getAmount());
				
				
					int total = 0;
					for (Cart item2 : cartShopping.values()) {
						total += item2.getPrice();
					}
					request.setAttribute("tong", total);
					request.setAttribute("redem", redem);
					request.getRequestDispatcher("thanhtoanthanhcong.jsp").forward(request, response);
					session.setAttribute("cartShopping", null);
				}
				
			}
			//key là id 
			
			
			
			// Neu da dang nhap
		}else {
			
			Date now = new Date();
			Timestamp timestamp = new Timestamp(now.getTime());
			// Lấy tổng giá từ giỏ hàng quá session
			Order order = (Order) session.getAttribute("order");
			order.setCreateAt(timestamp);
			order.setStatus(1);
			order.setUser_id(user.getId());
			int check=OrderDAO.addOrder(order);
			Map<String, String> redem = new HashMap<>();
			Map<Integer, Cart> cartShopping = (Map<Integer, Cart>) session.getAttribute("cartShopping");
			for (Map.Entry<Integer, Cart> item : cartShopping.entrySet()) {
				int id = item.getKey();
				Cart cart = item.getValue();
				OrderItem orderItem = new OrderItem();
				orderItem.setOrder_id(check);
				orderItem.setProduct_id(id);
				ArrayList<Key> Listkey= KeyDAO.getKeyByProductIdAmount(id, cart.getAmount());
				if (Listkey.size() < cart.getAmount()) {
					String hang = (ProductDAO.getProductById(id)).getName();
					request.setAttribute("hang", hang);
					request.getRequestDispatcher("hethang.jsp").forward(request, response);
				}else {
				for (Key key : Listkey) {
					orderItem.setProduct_key(key.getKey_code());
					orderItem.setProduct_name((ProductDAO.getProductById(id)).getName());
					orderItem.setProduct_price((ProductDAO.getProductById(id)).getPrice());
					orderItem.setAmount(1);
					redem.put(key.getKey_code(),orderItem.getProduct_name());
					boolean checkItem = OrderItemDAO.addOrderItem(orderItem);
					KeyDAO.updateKeyStatus(2, key.getId());
				}
				
//				orderItem.setAmount(cart.getAmount());
				
				
					int total = 0;
					for (Cart item2 : cartShopping.values()) {
						total += item2.getPrice();
					}
					request.setAttribute("tong", total);
					request.setCharacterEncoding("UTF-8");
					session.setAttribute("cartShopping", null);
					request.getRequestDispatcher("thanhtoanthanhcong.jsp").forward(request, response);
				}
				
			}

			
			
		}
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
