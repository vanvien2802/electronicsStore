package model.BO;

import model.DAO.ChangeInforUserDAO;
import model.DAO.CreateUserDAO;

public class CreateUserBO {

	public void CreateUserBO(String name, String userName, String email, String phoneNumber,
			String address, int isgender, String password) {
		CreateUserDAO createUser = new CreateUserDAO();
		createUser.CreateUserDAO(name,userName,email,phoneNumber,address,isgender,password);
		
	}

}
