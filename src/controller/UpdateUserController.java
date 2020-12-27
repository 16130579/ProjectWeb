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


@WebServlet("/UpdateUserController")
public class UpdateUserController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.setCharacterEncoding("UTF-8");
		String email = request.getParameter("email");
		String firstName = request.getParameter("first_name");
		String lastName = request.getParameter("last_name");
		String phone = request.getParameter("phone");
		String cmnd = request.getParameter("cmnd");
		HttpSession session = request.getSession();
		User user = (User) session.getAttribute("USER");
		User user2 = UserDAO.getThongTinUser(user.getId());
		int balance = user2.getBalance();
		user.setEmail(email);
		user.setFirstName(firstName);
		user.setLastName(lastName);
		user.setBalance(balance);
		user.setPhone(Integer.parseInt(phone));
		user.setCmnd(Integer.parseInt(cmnd));
		boolean check = UserDAO.updateUser(user.getId(), user);
		if (check) {
			request.setAttribute("error", "Cập nhật thành công");
			request.getRequestDispatcher("profile.jsp").forward(request, response);
		}else {
			request.setAttribute("error", "Cập nhật thất bại");
			request.getRequestDispatcher("profile.jsp").forward(request, response);
		}
	}

}
