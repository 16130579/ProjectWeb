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
 * Servlet implementation class DangNhapController
 */
@WebServlet("/DangNhapController")
public class DangNhapController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DangNhapController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String email = request.getParameter("email");
		String pass = request.getParameter("password");
		int idUser;
		idUser = UserDAO.checkLogin(email, pass);
		if (idUser != 0) {
			User user = UserDAO.getThongTinUser(idUser);
			HttpSession session = request.getSession();
			session.setAttribute("USER", user);
//			request.setAttribute("errorLogin", "Đăng nhập thành công : " + email);
//			request.getRequestDispatcher("profile.jsp").forward(request, response);
			response.sendRedirect("profile.jsp");

		}else {
			request.setAttribute("errorLogin", "Sai Email hoặc mật khẩu");
			request.getRequestDispatcher("test.jsp").forward(request, response);
		}
	}

}
