package model.DAO;

import java.io.InputStream;
import java.util.List;

import model.Bean.products;
import model.Bean.user;

public class UpdateInforProductDAO {

	public List<products> UpdateProduct(String idUser,String nameProString, String descrip, String type, String price,
			String idProduct, String storage, InputStream inputStream) {
		String query = "select * from products";
		String queryCr="Update products set idProduct=?,nameProduct=?,title=?,type=?,price=?,image=?,idUser=?,state=?,storage=? where idProduct='"+idProduct+"'";
		ConectMysql connect = new ConectMysql();
		System.out.print(queryCr);
		connect.executeUpdatePro(idProduct,nameProString,descrip,type,price,idUser,storage,inputStream,queryCr);
		List<products> products = connect.getListProducts(query);
		return products;
	}

}
