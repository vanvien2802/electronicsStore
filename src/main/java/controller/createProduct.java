package controller;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

import model.BO.createProBO;
import model.Bean.products;

/**
 * Servlet implementation class createProduct
 */
@WebServlet("/createProduct")
@MultipartConfig(fileSizeThreshold=1024*1024*10, 	// 10 MB 
maxFileSize=1024*1024*50,      	// 50 MB
maxRequestSize=1024*1024*100)   	// 100 MB
public class createProduct extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public createProduct() {
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
		
		String nameProString = request.getParameter("namePro");
		String descrip = request.getParameter("descrip");
		String type = request.getParameter("type");
		String price = request.getParameter("price");
		String idUser = request.getParameter("idUser");
		String storage = request.getParameter("storage");
		Part filePart = request.getPart("chooseFile");
		InputStream inputStream = null;
		//System.out.print(filePart);
		if (filePart != null) {
            inputStream = filePart.getInputStream();
        }
		else {
			response.sendRedirect("page/myProducts.jsp");
		}
		
//		DateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
//    	Date date=null;
//		try {
//			date = (Date)formatter.parse(saleDate);
//		} catch (ParseException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		} 
//		
		//System.out.print(nameProString+ descrip+ type +price+idUser+saleDate+storage +" " + chooseFile);
		
		createProBO createProBO = new createProBO();
		List<products> products = createProBO.createProduct(nameProString,descrip,type,price,idUser,storage,inputStream);
		request.getSession().setAttribute("products", products);
		response.sendRedirect("page/myProducts.jsp");
	}

}
