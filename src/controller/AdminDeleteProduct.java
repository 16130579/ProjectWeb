package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.ProductDAO;


@WebServlet("/AdminDeleteProduct")
public class AdminDeleteProduct extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int id = Integer.parseInt(request.getParameter("id"));
		boolean check = ProductDAO.deleteProduct(id);
		if (check) {
			request.setAttribute("error", "Xóa thành công");
			request.getRequestDispatcher("AdminProductController").forward(request, response);
		}else {
			request.setAttribute("error", "Xóa thất bại");
			request.getRequestDispatcher("adminproduct.jsp").forward(request, response);
		}
	}

}
