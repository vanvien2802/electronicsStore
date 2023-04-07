package controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.BO.ChangeInforUserBO;
import model.BO.CreateUserBO;
import model.Bean.user;

/**
 * Servlet implementation class CreateUser
 */
@WebServlet("/CreateUser")
public class CreateUser extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CreateUser() {
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
		
		String name = (String)request.getParameter("name");
		String userName = (String)request.getParameter("userName");
		String email = (String)request.getParameter("email");
		String phoneNumber = (String)request.getParameter("phoneNumber");
		String address = (String)request.getParameter("address");
		String gender = (String)request.getParameter("gender");
		int isgender= 0;
		if(gender.equals("Male")) {
			isgender=1;
		}
		String password = (String)request.getParameter("password");
		String rePassword = (String)request.getParameter("rePassword");
		if(!password.equals(rePassword)) {
			response.sendRedirect("page/register.jsp");
		}
		else {
			CreateUserBO createUser = new CreateUserBO();
			createUser.CreateUserBO(name,userName,email,phoneNumber,address,isgender,password);
		}
		response.sendRedirect("page/login.jsp");
	}

}
