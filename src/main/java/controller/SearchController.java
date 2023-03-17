package controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.ListProductDAO;
import model.Product;

@WebServlet(urlPatterns = {"/search"})
public class SearchController extends HttpServlet{

	private static final long serialVersionUID = 1L;
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html;charset=UTF-8");	
		
		String txtSearch = request.getParameter("txt");
		
		ListProductDAO dao = new ListProductDAO();
		List<Product> list = dao.search(txtSearch);
		
		request.setAttribute("listP", list);
		request.setAttribute("txtS", txtSearch);
		request.getRequestDispatcher("home.jsp").forward(request, response);
	}
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}
}
