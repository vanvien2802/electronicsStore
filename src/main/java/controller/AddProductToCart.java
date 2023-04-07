package controller;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.websocket.server.ServerEndpoint;

import model.BO.CardBO;
import model.Bean.Card;
import model.Bean.user;

@WebServlet("/add-product-to-card")
public class AddProductToCart extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doPost(request, response);

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		user u = (user) request.getSession().getAttribute("user");

		System.out.println("1");

		if (u != null)

		{
			String idProduct = (String)request.getParameter("idProduct");
			
			String idUser = u.getIdUser();

			CardBO cardBO = new CardBO();

			try {
				cardBO.Add("" , idProduct , idUser);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		
			response.sendRedirect("page/index.jsp");

		} else {
			response.sendRedirect("page/login.jsp");
		}

	}
}