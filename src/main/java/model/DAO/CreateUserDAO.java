package model.DAO;

import java.util.ArrayList;
import java.util.List;

import model.Bean.user;

public class CreateUserDAO {

	public void CreateUserDAO(String name, String userName, String email, String phoneNumber,
			String address, int isgender, String password) {
		
		String testID="Us0";
		String testID2="Us";
		int i=1;
		String idUser = testID+i;
		List<user> listU = new ArrayList<user>();
		ConectMysql connect = new ConectMysql();
		listU = connect.getListUser("SELECT * FROM user");
		boolean checkout=true;
		
			for(user u : listU) {
				
				while(checkout) {
				
				if(!u.getIdUser().equals(idUser)) {
					break;
				}
				i++;
				if(i<10) {
					idUser=testID+i;
				}
				if(i>=10) {
					idUser=testID2+i;
				}
				
			}
			
		}
		
		String query = "INSERT INTO user " + 
                "VALUES ("+"'"+idUser+"',"+"'"+name+"',"+"'"+email+"',"+"'"+address+"',"+"'"+phoneNumber+"',"+isgender+",'"+userName+"',"+"'"+password+"'"+")";
		System.out.print(query);
		connect.executeUpdate(query);
	}

}
