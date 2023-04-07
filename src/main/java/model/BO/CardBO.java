package model.BO;

import java.sql.SQLException;
import java.util.List;

import model.Bean.Card;
import model.DAO.CardDAO;

public class CardBO {
	public List<Card> GetAllProductBought(String idUser) {
		CardDAO cardDAO = new CardDAO();
		return cardDAO.GetAll(idUser).stream().parallel().filter(x -> x.isState() == true).toList();
	}

	public List<Card> GetAllProductInCard(String idUser) {
		CardDAO cardDAO = new CardDAO();
		return cardDAO.GetAll(idUser).stream().parallel().filter(x -> x.isState() == false).toList();
	}

	public void Remove(String idCard) throws SQLException {

		CardDAO cardDAO = new CardDAO();
		Card card = cardDAO.GetOne(idCard , null);

		System.out.println("So Luong" + card.getQuantity());

		if (card.getQuantity() == 1)
			cardDAO.Delete(idCard);
		else
			cardDAO.Remove(idCard);

	}

	public void Add(String idCard, String idProduct, String idUser) throws SQLException {
		CardDAO cardDAO = new CardDAO();
		cardDAO.Add(idCard, idProduct, idUser);
	}

	public String BuyAll(String idUser) throws SQLException {
		CardDAO cardDAO = new CardDAO();
		return cardDAO.BuyAll(idUser);
	}
}