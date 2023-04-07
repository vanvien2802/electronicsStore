package model.BO;

import java.io.InputStream;
import java.util.List;

import model.Bean.products;
import model.DAO.UpdateInforProductDAO;

public class UpdateInforProductBO {

	public List<products> UpdateProduct(String idUser,String nameProString, String descrip, String type, String price,
			String idProduct, String storage, InputStream inputStream) {
		UpdateInforProductDAO updateInforPro = new UpdateInforProductDAO();
		return updateInforPro.UpdateProduct(idUser,nameProString,descrip,type,price,idProduct,storage,inputStream);
	}

}
