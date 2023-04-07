package controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.BO.CheckLoginBO;
import model.BO.getAllProductsBO;
import model.Bean.products;

/**
 * Servlet implementation class UpdateProduct
 */
@WebServlet("/isExistProduct")
public class isExistProduct extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public isExistProduct() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
		doPost(request,response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
String idProduct = request.getParameter("idProduct");
		
		getAllProductsBO getAllProducts = new getAllProductsBO();
		List<products> products = new ArrayList<products>();
		products = getAllProducts.getAllProducts();
		System.out.println(idProduct);
		for(products pro : products) {
			System.out.println(pro.getIdProduct());
			if(pro.getIdProduct().equals(idProduct)) {
				request.getSession().setAttribute("product", pro);
				response.sendRedirect("page/UpdateProduct.jsp");
			}
		}
	}

}
