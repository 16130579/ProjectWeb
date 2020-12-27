package controller;

import java.io.IOException;
import java.security.NoSuchAlgorithmException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.UserDAO;
import model.User;


@WebServlet("/doimatkhau")
public class ChangePasswordController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public ChangePasswordController() {
        super();
        // TODO Auto-generated constructor stub
    }

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException  {
		request.setCharacterEncoding("UTF-8");
		String oldPass = request.getParameter("oldPassword");
		String newPass = request.getParameter("newPassword");
		HttpSession session = request.getSession();
		User user = (User) session.getAttribute("USER");
		String email = user.getEmail();
		try {
			boolean check = UserDAO.checkPass(oldPass, email);
			if (check) {
				UserDAO.changePassword(email, newPass);
				request.setAttribute("error", "Đổi mật khẩu thành công");
				request.getRequestDispatcher("ChangePassword.jsp").forward(request, response);

			}else {
				request.setAttribute("error", "Đổi mật khẩu thất bại");
				request.getRequestDispatcher("ChangePassword.jsp").forward(request, response);

			}
		} catch (ClassNotFoundException | NoSuchAlgorithmException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}
