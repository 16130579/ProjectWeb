package controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.KeyDAO;
import model.Key;

/**
 * Servlet implementation class AdminUpdateKey
 */
@WebServlet("/AdminUpdateKey")
public class AdminUpdateKey extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
 
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String key = request.getParameter("keycode");
		int status = Integer.parseInt(request.getParameter("status"));
		int id = Integer.parseInt(request.getParameter("id"));
		String url = request.getRequestURL().toString(); 
		Key k = new Key();
		k.setKey_code(key);
		k.setKey_status(status);
		KeyDAO.updateKey(k, id);
		RequestDispatcher dispatcher = request.getRequestDispatcher("AdminProductController");
		dispatcher.forward(request, response);
	}

	
}
