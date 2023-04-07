package controller;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Blob;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import javax.imageio.ImageIO;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;


import model.BO.UpdateInforProductBO;
import model.BO.createProBO;
import model.BO.getAllProductsBO;
import model.Bean.products;

/**
 * Servlet implementation class createProduct
 */
@WebServlet("/UpdateInfPro")
@MultipartConfig(fileSizeThreshold=1024*1024*10, 	// 10 MB 
maxFileSize=1024*1024*50,      	// 50 MB
maxRequestSize=1024*1024*100)   	// 100 MB
public class UpdateInfPro extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UpdateInfPro() {
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
		String idProduct = request.getParameter("idProduct");
		String idUser = request.getParameter("idUser");
		String storage = request.getParameter("storage");
		Part filePart = request.getPart("chooseFile");
		InputStream inputStream = null;
		//System.out.print(filePart);
		if (filePart != null && filePart.getSize()>0) {
            inputStream = filePart.getInputStream();
        }
		else {
			getAllProductsBO getPro = new getAllProductsBO();
			List<products> pros = getPro.getAllProducts();
			for(products pro:pros) {
				if(pro.getIdProduct().equals(idProduct)) {
					//inputStream= new FileInputStream(pro.getImage());
					Blob blob = (Blob) pro.getImage();
					try {
						inputStream = blob.getBinaryStream();
					} catch (SQLException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
							
				}
			}
		}
		
		
		System.out.println(nameProString+descrip+type+price+idProduct+idUser + storage+filePart);
		
		UpdateInforProductBO UpdateInforPro = new UpdateInforProductBO();
		List<products> products = UpdateInforPro.UpdateProduct(idUser,nameProString,descrip,type,price,idProduct,storage,inputStream);
		for(products pro:products) {
			System.out.println(pro.getTitle());
		}
		request.getSession().setAttribute("products", products);
		response.sendRedirect("page/myProducts.jsp");
	}

}
