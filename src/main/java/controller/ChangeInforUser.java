package controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.BO.ChangeInforUserBO;
import model.BO.CheckLoginBO;
import model.Bean.user;

/**
 * Servlet implementation class ChangeInforUser
 */
@WebServlet("/ChangeInforUser")
public class ChangeInforUser extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ChangeInforUser() {
        super();
        // TODO Auto-generated constructor stub
    }
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request,response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		String idUser = (String)request.getParameter("idUser");
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
		user user=null;
		if(!password.equals(rePassword)) {
			response.sendRedirect("page/inforAccount.jsp");
		}
		else {
			ChangeInforUserBO ChangeInfor = new ChangeInforUserBO();
			user=ChangeInfor.ChangeInforUserBO(idUser,name,userName,email,phoneNumber,address,isgender,password);
		}
		
		if(user != null) {
			request.getSession().setAttribute("user", user);
			response.sendRedirect("page/index.jsp");
		}
		else {
			response.sendRedirect("page/index.jsp");
		}
	}

}
