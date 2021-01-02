package controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.mail.Session;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.KeyDAO;
import model.Key;

/**
 * Servlet implementation class AddKeyCode
 */
@WebServlet("/LoadKeyCode")
public class LoadKeyCode extends HttpServlet {
	private static final long serialVersionUID = 1L;
       


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		int id = Integer.parseInt(request.getParameter("id"));
		HttpSession session = request.getSession();
		session.setAttribute("product_id", id); 
		ArrayList<Key> list = KeyDAO.getKeyByProductId(id);
		if (list.isEmpty()) {
		request.getRequestDispatcher("keycode.jsp").forward(request, response);	
		}else {
		request.setAttribute("list", list);
		request.getRequestDispatcher("keycode.jsp").forward(request, response);
		}
	}

}
