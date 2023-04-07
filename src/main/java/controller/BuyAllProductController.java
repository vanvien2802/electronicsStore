package controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.BO.CardBO;
import model.Bean.user;
@WebServlet("/buy-all-product")
public class BuyAllProductController extends HttpServlet{
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
			
			
			String idUser = u.getIdUser();

			CardBO cardBO = new CardBO();

			try {
				String status =  cardBO.BuyAll(idUser);
				
				if(status == "error")
				{
					System.out.println("Co LOi");
					request.getSession().setAttribute("error_buy_all_product" , "error");	   
				}
				else 
				{
					request.getSession().setAttribute("error_buy_all_product" , "true");
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			request.getSession().setAttribute("boughtProduct", cardBO.GetAllProductBought(idUser));
			request.getSession().setAttribute("productInCard", cardBO.GetAllProductInCard(idUser));

			response.sendRedirect("page/cart.jsp");

		} else {
			response.sendRedirect("page/login.jsp");
		}

	}
}