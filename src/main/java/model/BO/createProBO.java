package model.BO;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.util.Date;
import java.util.List;

import model.Bean.products;
import model.DAO.createProDAO;

public class createProBO {

	public List<products> createProduct(String nameProString, String descrip, String type, String price, String idUser,
			String storage, InputStream inputStream) throws FileNotFoundException {
		createProDAO createProDAO = new createProDAO();
		return createProDAO.createProduct(nameProString,descrip,type,price,idUser,storage,inputStream);
	}

}
