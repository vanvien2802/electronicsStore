package model.BO;

import java.util.List;


import model.Bean.products;
import model.DAO.deleteProDAO;

public class deleteBO {

	public List<products> deleteProduct(String idPro) {
		deleteProDAO deletePro = new deleteProDAO();
		return deletePro.deletePro(idPro);
	}

}
