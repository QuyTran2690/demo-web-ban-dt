package controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.ListProductDAO;
import model.Account;

@WebServlet(urlPatterns = {"/login"})
public class LoginController extends HttpServlet{

	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String userMail = request.getParameter("user");
		String password = request.getParameter("pass");
		
		ListProductDAO dao = new ListProductDAO();
		Account a = dao.login(userMail, password);
		if(a==null) {
			request.setAttribute("error", "Email or password is empty");
			request.getRequestDispatcher("login.jsp").forward(request, response);
		} else if(a.getRole() == 0){
			HttpSession session = request.getSession(true);
			session.setAttribute("infoCustommer", a);
			response.sendRedirect("home");
		} else {
			HttpSession session = request.getSession(true);
			session.setAttribute("user", a.getName());
			response.sendRedirect("admin.jsp");
		}
	}
	
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}
}
