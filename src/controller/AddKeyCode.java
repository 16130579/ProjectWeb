package controller;

import java.io.IOException;
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
@WebServlet("/AddKeyCode")
public class AddKeyCode extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
//		int id = Integer.parseInt(request.getParameter("id"));
		String keyName = request.getParameter("name");
		int status=Integer.parseInt(request.getParameter("status")); 
		HttpSession session = request.getSession();
		int id=(int)session.getAttribute("product_id");
		Key key = new Key();
		key.setProduct_id(id);
		key.setKey_code(keyName);
		key.setKey_status(status);
		boolean check = KeyDAO.addKey(key);
		if (check) {
//			request.setAttribute("error", "Thêm Key thành công");
			request.getRequestDispatcher("LoadKeyCode?id="+id).forward(request, response);
		}else {
//			request.setAttribute("error", "Thêm Key thất bại");
			request.getRequestDispatcher("LoadKeyCode?id="+id).forward(request, response);
		}
	}

}
