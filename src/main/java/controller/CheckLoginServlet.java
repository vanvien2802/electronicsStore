package controller;

import java.io.IOException;
import java.net.http.HttpResponse;
import java.util.List;

import javax.servlet.AsyncContext;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.BO.CheckLoginBO;
import model.BO.getAllProductsBO;
import model.Bean.products;
import model.Bean.user;



@WebServlet("/CheckLoginServlet")
public class CheckLoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public CheckLoginServlet() {
        super();
        // TODO Auto-generated constructor stub
    }
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
//		RequestDispatcher rd = request.getRequestDispatcher("page/login.jsp");
//		rd.forward(request, response);
//		doPost(request,response);
		doPost(request,response);
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String userName = (String)request.getParameter("userName");
		String password = (String)request.getParameter("password");
		CheckLoginBO checkBO = new CheckLoginBO();
		user user=	checkBO.getUser(userName, password);
		
		
		String destination = null;
		if(user != null) {
			getAllProductsBO getAllProducts = new getAllProductsBO();
			List<products> products = getAllProducts.getAllProducts();
			request.getSession().setAttribute("products", products);
			request.getSession().setAttribute("user", user);
			response.sendRedirect("page/index.jsp");
		}
		else {
			response.sendRedirect("page/login.jsp");
		}
	}
	
}
