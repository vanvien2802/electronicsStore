package model.BO;

import model.Bean.user;
import model.DAO.ChangeInforUserDAO;
import model.DAO.CheckLoginDAO;

public class ChangeInforUserBO {
	public user ChangeInforUserBO(String idUser,String name, String userName, String email, String phoneNumber, String address,
			int gender, String password) {
		ChangeInforUserDAO ChangeInfor = new ChangeInforUserDAO();
		return ChangeInfor.ChangeInforUserDAO(idUser,name,userName,email,phoneNumber,address,gender,password);
	}
}
