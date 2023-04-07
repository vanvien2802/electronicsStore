package model.DAO;

import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;


import model.Bean.Card;

public class CardDAO {

	public List<Card> GetAll(String idUser) {
		try {

			String queryString = "SELECT c.idCard  , p.image , p.title , p.price , c.quantity , c.state , c.idProduct FROM ElectronicsStrore.card c\r\n"
					+ "join products p on c.idProduct = p.idProduct\r\n" + "join user u on u.idUser = c.idUser\r\n"
					+ "where c.idUser = '" + idUser + "'";

//			System.out.println(queryString);

			ConectMysql<PreparedStatement> conectMysql = new ConectMysql<PreparedStatement>();
			ResultSet result = conectMysql.ExecuteQuery(queryString);
			List<Card> cards = new ArrayList<>();
			while (result.next()) {
				Card card = new Card();
				card.setId(result.getString(1));
				card.getProducts().setImage(result.getBlob(2));
				card.getProducts().setTitle(result.getString(3));
				card.getProducts().setPrice(result.getInt(4));
				card.setQuantity(result.getInt(5));
				card.setState(result.getBoolean(6));
				card.setIdProduct(result.getString(7));
				cards.add(card);
			}

			System.out.print("GEt All Card Sucess");
			return cards;

		} catch (Exception e) {
			System.out.print("GEt All Card False");
			// TODO: handle exception
			return null;
		}
	}

	public void Remove(String idCard) {
		try {

			String queryString = "UPDATE card c\r\n" + "SET quantity = quantity - 1\r\n" + "where idCard = '" + idCard
					+ "'";

			System.out.println(queryString);

			ConectMysql<PreparedStatement> conectMysql = new ConectMysql<PreparedStatement>();
			conectMysql.executeUpdate(queryString);
		} catch (Exception e) {
			// TODO: handle exception
		}

	}

	public void Create(String idUser, String idProduct) throws SQLException {
		long millis = System.currentTimeMillis();
		java.sql.Date date = new java.sql.Date(millis);
		ConectMysql<PreparedStatement> conectMysql = new ConectMysql<PreparedStatement>();

		ResultSet rSet = conectMysql
				.ExecuteQuery("select max( CONVERT( TRIM( BOTH \"C\" from c.idCard ) , UNSIGNED ) ) from card c ");
		boolean a = rSet.next();

		String newId = "C" + Integer.toString(rSet.getInt(1) + 1);

		System.out.println(newId);

		String queryString = "insert card value\r\n" + "('" + newId + "' , " + 1 + " , 0 , '" + date + "' ,'" + idUser
				+ "' , '" + idProduct + "');";

		System.out.println(queryString);
		conectMysql.executeUpdate(queryString);
	}

	public void Add(String idCard, String idProduct, String idUser) throws SQLException {
		try {
			ConectMysql<PreparedStatement> conectMysql = new ConectMysql<PreparedStatement>();

			String queryCheckExiString = "SELECT count(*) FROM ElectronicsStrore.card c\r\n" + "where c.idProduct = '"
					+ idProduct + "' and c.state = 0 and c.idUser = '" + idUser + "'";

			System.out.println(queryCheckExiString);

			ResultSet resultSet = conectMysql.ExecuteQuery(queryCheckExiString);
			resultSet.next();
			int exist = (resultSet.getInt(1));

			String queryToGetIdCard = "SELECT c.idCard FROM ElectronicsStrore.card c\r\n" + "where c.idProduct = '"
					+ idProduct + "' and c.state = 0 and c.idUser = '" + idUser + "'";

			ResultSet resultSet1 = conectMysql.ExecuteQuery(queryToGetIdCard);

			resultSet1.next();

			idCard = resultSet1.getString(1);

			System.out.println(exist);

			if (exist == 1) {
				String queryString = "UPDATE card c\r\n" + "SET quantity = quantity + 1\r\n" + "where idCard = '"
						+ idCard + "'";
				conectMysql.executeUpdate(queryString);
				System.out.println(queryString);

			} else
				Create(idUser, idProduct);
		} catch (Exception e) {

			Create(idUser, idProduct);
			// TODO: handle exception
		}
	}

	public String BuyAll(String idUser) throws SQLException {

		ConectMysql<PreparedStatement> conectMysql = new ConectMysql<PreparedStatement>();

		String queryGetListProduct = "SELECT c.idProduct FROM ElectronicsStrore.card c\r\n"
				+ "where  c.state = 0 and c.idUser = '" + idUser + "'";

		ResultSet rSet = conectMysql.ExecuteQuery(queryGetListProduct);

		List<String> listidList = new ArrayList<String>();
		
		while (rSet.next()) {
			listidList.add(rSet.getString(1));
			String id = rSet.getString(1);
			String checkExistProduct = "SELECT p.storage FROM ElectronicsStrore.products p\r\n"
					+ "where p.idProduct = '"+id+"'";
			
			ResultSet rsResultSet = conectMysql.ExecuteQuery(checkExistProduct);
			rsResultSet.next();
			int sl = rsResultSet.getInt(1);
			
			
			
			Card card = GetOne(null,id); 
			
			System.out.println("So Luong :" + sl + "Muon mua :" + card.getQuantity());
			
			if(card.getQuantity() > sl)
				return  "error";
			

			String queryString = "UPDATE card c\r\n" + "SET state = 1\r\n" + "where idProduct = '" + id + "'";
			
			String queryString10 = "Update  products p\r\n"
					+ "set p.storage = p.storage - "+card.getQuantity()+"\r\n"
					+ "where p.idProduct = '"+id+"' \r\n"
					+ "";
			
			System.out.println(queryString10);
			
			conectMysql.executeUpdate(queryString10);

			conectMysql.executeUpdate(queryString);
		}
		
		return "";
	}

	public void Delete(String idCard) {
		String queryString = "DELETE FROM card \r\n" + "WHERE idCard = '" + idCard + "'";
		System.out.println(queryString);

		ConectMysql<PreparedStatement> conectMysql = new ConectMysql<PreparedStatement>();
		conectMysql.executeUpdate(queryString);
	}

	public Card GetOne(String idCard , String idproduct  ) throws SQLException {
		
		System.out.println("111111111");
		
		String query1 = idCard == null ? "c.idProduct" : "c.idCard";
		String query2 = idCard == null ? idproduct : idCard;
		
		System.out.println(query1);
		System.out.println(query2);
		
		String queryString = "SELECT c.idCard  , p.image , p.title , p.price , c.quantity , c.state , c.idProduct FROM ElectronicsStrore.card c\r\n"
				+ "join products p on c.idProduct = p.idProduct\r\n" + "join user u on u.idUser = c.idUser\r\n"
				+ "where "+ query1 + "= '" + query2 + "' and c.state = 0";

		System.out.println(queryString);

		ConectMysql<PreparedStatement> conectMysql = new ConectMysql<PreparedStatement>();

		ResultSet result = conectMysql.ExecuteQuery(queryString);

		Card card = new Card();
		while (result.next()) {

			card.setId(result.getString(1));
			card.getProducts().setImage(result.getBlob(2));
			card.getProducts().setTitle(result.getString(3));
			card.getProducts().setPrice(result.getInt(4));
			card.setQuantity(result.getInt(5));
			card.setState(result.getBoolean(6));
			card.setIdProduct(result.getString(7));
		}

		return card;
	}
}