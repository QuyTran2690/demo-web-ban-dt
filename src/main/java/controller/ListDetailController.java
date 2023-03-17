package controller;



import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.ListProductDAO;
import model.Product;

@WebServlet(urlPatterns = {"/detail"})
public class ListDetailController  extends HttpServlet {

	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html;charset=UTF-8");
		response.setCharacterEncoding("utf-8");
		try {
			String id = request.getParameter("id");
			ListProductDAO dao = new ListProductDAO();
			Product myProduct  = dao.getProduct(id);
			request.setAttribute("product", myProduct);
			request.getRequestDispatcher("infoProduct.jsp").forward(request, response);
		} catch (Exception e) {
			response.getWriter().println();
		}

	}
}
