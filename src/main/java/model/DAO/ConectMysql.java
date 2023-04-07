package model.DAO;

import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.sql.Blob;
import java.sql.Connection;
import java.util.Date;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;


import java.sql.DriverManager;
import java.sql.Connection;

import model.Bean.products;
import model.Bean.user;

public class ConectMysql<PreparedStatement> {
	//Khai báo báo driver để làm việc với mysql
    private final static String JDBC_DRIVER = "com.mysql.jdbc.Driver";
    //Khai báo tên db cần làm việc
//    private final static String DATABASE_LINK = "jdbc:mysql://103.197.184.46:1811/ElectronicsStrore";
    private final static String DATABASE_LINK = "jdbc:mysql://localhost/electronicsstore";
    public void executeUpdate(String query) {
    	try {
    		Class.forName("com.mysql.jdbc.Driver");
//        	Connection con=DriverManager.getConnection(DATABASE_LINK,"tpham1467","18112002");
    		Connection con=DriverManager.getConnection(DATABASE_LINK,"root","");
    		Statement stmt=con.createStatement();  
    		stmt.executeUpdate(query);
    		con.close();
    	}
    	catch(Exception e) {
    	}
    }
    public ResultSet ExecuteQuery(String query) {
		try {
			// Buoc 1: Tai lop Driver
			Class.forName("com.mysql.jdbc.Driver");

			// Buoc 2: Tao doi tuong Connection

//			Connection con = DriverManager.getConnection(DATABASE_LINK, "tpham1467", "18112002");
			Connection con=DriverManager.getConnection(DATABASE_LINK,"root","");

			// <b>sihvien</b> la ten co so du lieu, root la username va mat khau la 123456

			// Buoc 3: Tao doi tuong Statement
			Statement stmt = con.createStatement();

			// Buoc 4: Thuc thi truy van
			ResultSet rs = stmt.executeQuery(query);
			return rs;
		} catch (Exception e) {
			// TODO: handle exception
			return null;
		}
	}
    public void executeUpdatePro(String idProduct,String nameProString, String descrip, String type, String price, String idUser,
			String storage, InputStream inputStream,String query) {
    	
    	try {
    		
    	Class.forName("com.mysql.jdbc.Driver");
//    	Connection con=DriverManager.getConnection(DATABASE_LINK,"tpham1467","18112002");
    	Connection con=DriverManager.getConnection(DATABASE_LINK,"root","");
    	boolean state = false;
    	
    	 PreparedStatement statement = (PreparedStatement) con.prepareStatement(query);
         ((java.sql.PreparedStatement) statement).setString(1, idProduct);
         ((java.sql.PreparedStatement) statement).setString(2, nameProString);
         ((java.sql.PreparedStatement) statement).setString(3, descrip);
         ((java.sql.PreparedStatement) statement).setString(4, type);
         ((java.sql.PreparedStatement) statement).setString(5, price);
         if (inputStream != null) {
             ((java.sql.PreparedStatement) statement).setBlob(6, inputStream);
         }
         ((java.sql.PreparedStatement) statement).setString(7, idUser);
         ((java.sql.PreparedStatement) statement).setBoolean(8,state);
         ((java.sql.PreparedStatement) statement).setInt(9, Integer.parseInt(storage));
         int row = ((java.sql.PreparedStatement) statement).executeUpdate();
         if (row > 0) {
             System.out.print("File uploaded and saved into database");
         }
    	} catch (Exception ex) {
            ex.printStackTrace();
        }
	}
    
    
	public List<user> getListUser(String query) {
		List<user> listUser = new ArrayList<user>();
		try{  
			
			// Buoc 1: Tai lop Driver 
				Class.forName("com.mysql.jdbc.Driver");

			// Buoc 2: Tao doi tuong Connection   
				
//			Connection con=DriverManager.getConnection(DATABASE_LINK,"tpham1467","18112002");  
				Connection con=DriverManager.getConnection(DATABASE_LINK,"root","");
			

			// <b>sihvien</b> la ten co so du lieu, root la username va mat khau la 123456 

			// Buoc 3: Tao doi tuong Statement    
			Statement stmt=con.createStatement();  
			
			// Buoc 4: Thuc thi truy van    
			ResultSet rs=stmt.executeQuery(query);  

			while(rs.next())  
			{
				user user = new user();
				user.setIdUser(rs.getString(1));
				user.setName(rs.getString(2));
				user.setEmail(rs.getString(3));
				user.setAddress(rs.getString(4));
				user.setPhoneNumber(rs.getString(5));
				user.setGender(rs.getBoolean(6));
				user.setUserName(rs.getString(7));
				user.setPassword(rs.getString(8));
				listUser.add(user);
			}
			con.close();
			return listUser;
			}catch(Exception e){ System.out.println(e);}
			return listUser;
			}
	
	public List<products> getListProducts(String query) {
		List<products> products = new ArrayList<products>();
		try{  
			
			// Buoc 1: Tai lop Driver 
				Class.forName("com.mysql.jdbc.Driver");

			// Buoc 2: Tao doi tuong Connection   
				
//			Connection con=DriverManager.getConnection(DATABASE_LINK,"tpham1467","18112002"); 
				Connection con=DriverManager.getConnection(DATABASE_LINK,"root","");
			

			// <b>sihvien</b> la ten co so du lieu, root la username va mat khau la 123456 

			// Buoc 3: Tao doi tuong Statement    
			Statement stmt=con.createStatement();  
			
			// Buoc 4: Thuc thi truy van    
			ResultSet rs=stmt.executeQuery(query);  
			
			Blob image = null;
			byte[ ] imgData = null ;
			while(rs.next())  
			{
				products product = new products();
				product.setIdProduct(rs.getString(1));
				product.setNameProduct(rs.getString(2));
				product.setTitle(rs.getString(3));
				product.setType(rs.getString(4));
				product.setPrice(rs.getInt(5));
				product.setImage(rs.getBlob(6));
				product.setIdUser(rs.getString(7));
				product.setState(rs.getBoolean(8));
				product.setStorage(rs.getInt(9));
				
				products.add(product);
			}
			
			con.close();
			return products;
			
			 

			}catch(Exception e){ System.out.println(e);}
			return products;
			}
	
	
	
	}
