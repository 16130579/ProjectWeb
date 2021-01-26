package controller;

import java.io.IOException;
import java.sql.Timestamp;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.OrderDAO;
import model.Order;

/**
 * Servlet implementation class AdminUpdateOrder
 */
@WebServlet("/AdminUpdateOrder")
public class AdminUpdateOrder extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		int price = Integer.parseInt(request.getParameter("price"));
		int status = Integer.parseInt(request.getParameter("status"));
		int id = Integer.parseInt(request.getParameter("id"));
		Order o = new Order();
		o.setPrice(price);
		o.setStatus(status);
		boolean check = OrderDAO.updateOder(id, o);
		if (check) {
			request.getRequestDispatcher("adminorder.jsp").forward(request, response);
		}
	}



}
