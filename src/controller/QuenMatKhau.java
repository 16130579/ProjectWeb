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

/**
 * Servlet implementation class QuenMatKhau
 */
@WebServlet("/QuenMatKhau")
public class QuenMatKhau extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String email = request.getParameter("forget");
		boolean check = UserDAO.checkUser(email);
		if (check) {
			UserDAO.sendMail(email, "Cập nhật mật khẩu FunnyShop", "http://localhost:8080/Web-2020/forgetPassword.jsp");
			request.setAttribute("errorLogin", "Thành công mời bạn xác nhận tại Gmail");
			HttpSession session = request.getSession();
			User user = new User();
			user.setEmail(email);
			session.setAttribute("forget", user);
			request.getRequestDispatcher("test.jsp").forward(request, response);
		}else {
			request.setAttribute("errorLogin", "Email không hợp lệ");
			request.getRequestDispatcher("test.jsp").forward(request, response);
		}
		
	}

}
