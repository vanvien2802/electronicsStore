package model.BO;

import java.util.List;

import model.Bean.products;
import model.DAO.getAllProductsDAO;

public class getAllProductsBO {
	public List<products> getAllProducts() {
		getAllProductsDAO getAllProduct = new getAllProductsDAO();
		return getAllProduct.getAllProducts();
	}
}
