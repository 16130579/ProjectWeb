package controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Timestamp;
import java.util.Date;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.OrderDAO;
import model.Cart;
import model.Order;
import model.User;

/**
 * Servlet implementation class ThanhToan
 */
@WebServlet("/ThanhToan")
public class ThanhToan extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.setCharacterEncoding("UTF-8");
		HttpSession session = request.getSession();
//		User user = (User) session.getAttribute("USER");
//		if (user != null) {
			Date now = new Date();
			Timestamp timestamp = new Timestamp(now.getTime());
			Order order = (Order) session.getAttribute("order");
			order.setCreateAt(timestamp);
			order.setStatus(1);
			order.setUser_id(15);
			boolean check=OrderDAO.addOrder(order);
			Map<Integer, Cart> cartShopping = (Map<Integer, Cart>) session.getAttribute("cartShopping");
			//key là id 
			if (check) {
				request.getRequestDispatcher("thanhtoanthanhcong.jsp").forward(request, response);
			}else {
				PrintWriter out = response.getWriter();
				out.print("Thất bại");
			}
			
			
			
//		}
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
