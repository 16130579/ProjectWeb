package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.UserDAO;
import model.User;


@WebServlet("/NapTienController")
public class NapTienController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int value = Integer.parseInt(request.getParameter("cash"));
		HttpSession session = request.getSession();
		User user = (User) session.getAttribute("USER");
		boolean check = UserDAO.napTien(user.getId(), value);
		if (check) {
			request.setAttribute("error", "Nạp thành công");
			request.getRequestDispatcher("cash.jsp").forward(request, response);
		}else {
			request.setAttribute("error", "Nạp thất bại");
			request.getRequestDispatcher("cash.jsp").forward(request, response);
	}

}
}
