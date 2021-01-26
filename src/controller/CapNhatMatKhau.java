package controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.security.NoSuchAlgorithmException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.UserDAO;
import model.User;

/**
 * Servlet implementation class CapNhatMatKhau
 */
@WebServlet("/CapNhatMatKhau")
public class CapNhatMatKhau extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
 
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		HttpSession session = request.getSession();
		User user=(User)session.getAttribute("forget");
		String email = user.getEmail();
		String newPassword = request.getParameter("password");
		PrintWriter print = response.getWriter();
		try {
			boolean check = UserDAO.changePassword(email, newPassword);
			if (check) {
				session.setAttribute("forget", null);
				request.setCharacterEncoding("utf-8");
				print.println("Cập nhật mật khẩu mới thành công");
			}else {
				request.setCharacterEncoding("utf-8");
				print.println("Cập nhật mật khẩu mới thất bại");
			}
		} catch (NoSuchAlgorithmException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
