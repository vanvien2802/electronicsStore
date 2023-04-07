package model.DAO;

import java.util.List;

import model.Bean.user;

public class ChangeInforUserDAO {
	public user ChangeInforUserDAO(String idUser,String name, String userName, String email, String phoneNumber, String address,
			int gender, String password) {
		String query= "UPDATE user "
				+ "SET name= '" +name+ "',email= '"+email+ "',Address = '"+address  + "',phoneNumber = '"+phoneNumber + "',Address = '"+address +
				"',gender = '"+ gender+"',nameUser = '"+userName +"',password = '"+password+"'"
				+ " WHERE idUser = '" + idUser +"'";
		ConectMysql connect = new ConectMysql();
		connect.executeUpdate(query);
		List<user> users = connect.getListUser("SELECT * FROM user");
		System.out.print(query);
		for(user u: users) {
			if(u.getIdUser().equals(idUser)) {
				return u;
			}
		}
		return null;
	}
}
