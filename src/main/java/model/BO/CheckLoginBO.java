package model.BO;

import model.Bean.user;
import model.DAO.CheckLoginDAO;

public class CheckLoginBO {
	public user getUser(String userName, String password) {
		CheckLoginDAO checkDAO = new CheckLoginDAO();
		return checkDAO.getUser(userName, password);
	}
}
