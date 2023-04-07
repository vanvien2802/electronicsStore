package controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.stream.Collectors;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.BO.getAllProductsBO;
import model.Bean.products;

/**
 * Servlet implementation class SearchProduct
 */
@WebServlet("/SearchProduct")
public class SearchProduct extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SearchProduct() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String txtSearch = request.getParameter("txtSearch");
		String typeSearch = request.getParameter("typeSearch");
		
		System.out.println(txtSearch + typeSearch);
		getAllProductsBO getPro = new getAllProductsBO();
		List<products> pros = getPro.getAllProducts();
		List<products> proSearch = new ArrayList<products>();
		if(typeSearch.equals("Camera")) {
			pros = pros.stream().filter(p->p.getType().equals("camera")).collect(Collectors.toList());
		}
		else if(typeSearch.equals("Mobile")) {
			pros = pros.stream().filter(p->p.getType().equals("phone")).collect(Collectors.toList());
		}
		else if(typeSearch.equals("Laptop")) {
			pros = pros.stream().filter(p->p.getType().equals("laptop")).collect(Collectors.toList());
		}
		for(products pro : pros) {
			if(pro.getTitle().toLowerCase().contains(txtSearch.toLowerCase()) ||pro.getNameProduct().toLowerCase().contains(txtSearch.toLowerCase()) ) {
				proSearch.add(pro);
			}
		}
		for(products pro : proSearch) {
			System.out.println(pro.getNameProduct());
		}
		request.getSession().setAttribute("products", proSearch);
		
		response.sendRedirect("page/index.jsp");
	}

}
