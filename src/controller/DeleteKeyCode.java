package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.KeyDAO;

/**
 * Servlet implementation class DeleteKeyCode
 */
@WebServlet("/DeleteKeyCode")
public class DeleteKeyCode extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
//		response.getWriter().append("Served at: ").append(request.getContextPath());
		int id = Integer.parseInt(request.getParameter("id"));
		HttpSession session = request.getSession();
		int product_id=(int)session.getAttribute("product_id");
		KeyDAO.deleteKey(id);
		request.getRequestDispatcher("LoadKeyCode?id="+product_id).forward(request, response);
	}


}
