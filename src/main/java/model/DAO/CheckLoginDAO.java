package model.DAO;

import java.util.List;

import model.Bean.user;

public class CheckLoginDAO {
	public user getUser(String userName, String password) {
		String query= "SELECT * FROM user";
		ConectMysql connect = new ConectMysql();
		List<user> users = connect.getListUser(query);
		for(user u: users) {
			if(u.getUserName().equals(userName) && u.getPassword().equals(password)) {
				return u;
			}
		}
		return null;
	}
}
