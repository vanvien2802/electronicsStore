package controller;

import java.io.IOException;
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

@WebServlet("/card")
public class CardController extends HttpServlet {

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

		if (u != null)
		{
				System.out.println("1");
				String idUser = u.getIdUser();

			CardBO cardBO = new CardBO();

			request.getSession().setAttribute("boughtProduct", cardBO.GetAllProductBought(idUser));
			request.getSession().setAttribute("productInCard", cardBO.GetAllProductInCard(idUser));
			request.getSession().setAttribute("error_buy_all_product" , "true");
			System.out.println(cardBO.GetAllProductInCard(idUser).size());
			response.sendRedirect("page/cart.jsp");
			
		}
		else 
		{
			response.sendRedirect("page/login.jsp");
		}
		

	}
}