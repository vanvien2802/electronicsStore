package model.DAO;

import java.util.List;

import model.Bean.products;
import model.Bean.user;

public class getAllProductsDAO {
	public List<products> getAllProducts() {
		String query= "SELECT * FROM products";
		ConectMysql connect = new ConectMysql();
		List<products> products = connect.getListProducts(query);
		return products;
	}
}
