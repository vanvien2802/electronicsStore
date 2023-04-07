package model.DAO;

import java.util.List;


import model.Bean.products;

public class deleteProDAO {

	public List<products> deletePro(String idPro) {
		ConectMysql connect = new ConectMysql();
		String query = "Delete from products where idProduct='"+idPro+"'";
		connect.executeUpdate(query);
		query = "select * from products";
		return connect.getListProducts(query);
	}

}
