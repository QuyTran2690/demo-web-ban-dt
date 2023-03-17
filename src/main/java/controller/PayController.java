package controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.OrderDAO;
import model.Cart;
import model.Orders;

@WebServlet(urlPatterns = {"/PayController"})
public class PayController extends HttpServlet{

	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html;charset=UTF-8");
		response.setCharacterEncoding("utf-8");
		
		try {
			HttpSession session = request.getSession(true);
			
			if(session.getAttribute("cart") == null) {
				response.sendRedirect("home");
				return;
			}
			
			OrderDAO dao = new OrderDAO();
			Cart c = (Cart) session.getAttribute("cart");
			String username = request.getParameter("name");
			String discount = request.getParameter("discount");
			String address = request.getParameter("address");
			Orders d = new Orders(username, 0, discount, address, "", null);
			dao.insertOrder(d,c);
			response.sendRedirect("home");
		} catch (Exception e) {
			response.getWriter().println(e);
			e.printStackTrace();
		}
	}
}
