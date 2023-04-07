package model.DAO;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;



import model.Bean.products;
import model.Bean.user;

public class createProDAO {

	public List<products> createProduct(String nameProString, String descrip, String type, String price, String idUser,
			String storage, InputStream inputStream) throws FileNotFoundException {
		
		String testID="Pd0";
		String testID2="Pd";
		int i=1;
		String idProduct = testID+i;
		List<products> listPro = new ArrayList<products>();
		ConectMysql connect = new ConectMysql();
		String query = "select * from products";
		listPro = connect.getListProducts(query);
		boolean checkout=true;
		
			for(products pro : listPro) {
				
				while(checkout) {
				
				if(!pro.getIdProduct().equals(idProduct)) {
					break;
				}
				i++;
				if(i<10) {
					idProduct=testID+i;
				}
				if(i>=10) {
					idProduct=testID2+i;
				}
			}
			
		}
		
			String queryCr = "INSERT INTO products (idProduct, nameProduct, title,type,price,image,idUser,state,storage) values (?, ?, ?,?,?, ?, ?,?,?)";
		
		connect.executeUpdatePro(idProduct,nameProString,descrip,type,price,idUser,storage,inputStream,queryCr);
		List<products> products =  connect.getListProducts(query);
		return products;
	}

}
