package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.UserDAO;
import model.User;


@WebServlet("/AdminUpdateUser")
public class AdminUpdateUser extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
 
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.setCharacterEncoding("utf-8");
		int id = Integer.parseInt(request.getParameter("id"));
		String first = request.getParameter("first_name");
		String last = request.getParameter("last_name");
		int cmnd = Integer.parseInt(request.getParameter("cmnd"));
		int balance = Integer.parseInt(request.getParameter("balance"));
		String email = request.getParameter("email");
		int phone = Integer.parseInt(request.getParameter("phone"));
		int role = Integer.parseInt(request.getParameter("role"));
		User u = new User();
		u.setBalance(balance);
		u.setCmnd(cmnd);
		u.setEmail(email);
		u.setFirstName(first);
		u.setLastName(last);
		u.setEmail(email);
		u.setRole(role);
		u.setPhone(phone);
		boolean check = UserDAO.updateUser(id, u);
		if (check) {
			request.getRequestDispatcher("adminUser.jsp").forward(request, response);
		}else {
			request.getRequestDispatcher("test.jsp").forward(request, response);
		}
	}

	

}
