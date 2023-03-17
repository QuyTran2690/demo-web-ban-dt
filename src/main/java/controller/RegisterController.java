package controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.ListProductDAO;
import model.Account;

@WebServlet(urlPatterns = {"/register"})
public class RegisterController extends HttpServlet {

	private static final long serialVersionUID = 1L;
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html; charset=UTF-8");
		String user = request.getParameter("email");
		String name = request.getParameter("name");
		String phone = request.getParameter("phone");
		String address = request.getParameter("address");
		String password = request.getParameter("password");
		String co_password = request.getParameter("co-password");
		
		if(!password.equals(co_password)) {
			response.sendRedirect("register.jsp");
		} else {
			ListProductDAO dao = new ListProductDAO();
			Account a = dao.checkAccountExit(user);
			if(a==null) {
				// register
				dao.register(user, password, 0, name, address, phone);
				response.sendRedirect("home");
			} else {
				response.sendRedirect("login.jsp");
			}
		}
	}
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}
}
