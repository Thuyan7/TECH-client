/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DataBase;

import database.DatabaseConnection;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import model.Laptop;
import model.Phone;



/**
 *
 * @author AN
 */
public class PhoneManager {
    public static List<Phone> getPhone(){
        List<Phone> phoneList = new ArrayList<>();
        String sql = "SELECT * FROM phone";
        try {
           Connection con= DatabaseConnection.getConnection();
            Statement stmt= con.createStatement();
            ResultSet rs= stmt.executeQuery(sql);
            
            while (rs.next()) {
                int id = rs.getInt("id");
                String name = rs.getString("name");
                String price = rs.getString("price");
                String image = rs.getString("image");
                String description = rs.getString("description"); 

                Phone phone = new Phone(id,name, price, image, description);
                phoneList.add(phone);
            }

            DatabaseConnection.closeConnection(con);
        } catch (Exception e) {
        }
        return phoneList;
    }
    
       public static void addPhone(String name, String price, String des, String img) {
        try {
            Connection conn = DatabaseConnection.getConnection();
            String sql = "INSERT INTO phone (name, price, description, image) VALUES (?, ?, ?, ?)";
            PreparedStatement statement = conn.prepareStatement(sql);
            statement.setString(1, name);
            statement.setString(2, price);
            statement.setString(3, des);
            statement.setString(4, img);

            int rowsInserted = statement.executeUpdate();
            if (rowsInserted > 0) {
                System.out.println("A new phone was inserted successfully!");
            }
            DatabaseConnection.closeConnection(conn);
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }
       
           public static void delete(Phone p) {
		String sql="DELETE FROM phone WHERE id='"+p.getId()+"'";
		try {
			Connection con= DatabaseConnection.getConnection();
			PreparedStatement ps= con.prepareStatement(sql);
			ps.executeUpdate();
			DatabaseConnection.closeConnection(con);
		} catch (Exception e) {
			// TODO: handle exception
		}
		
	}
       
  public static void updatePhone(Phone p) {
    String sql = "UPDATE phone SET name=?, price=?, image=?, description=? WHERE id=?";
    try {
        Connection con = DatabaseConnection.getConnection();
        PreparedStatement ps = con.prepareStatement(sql);
        ps.setString(1, p.getName());
        ps.setString(2, p.getPrice());
        ps.setString(3, p.getImage());
        ps.setString(4, p.getDescription());
        ps.setInt(5, p.getId());
        ps.executeUpdate();
        DatabaseConnection.closeConnection(con);
    } catch (Exception e) {
        e.printStackTrace(); // Handle exception
    }
}
  
  public static Phone getPhoneById(int id) {
    Phone phone= null;
    String sql = "SELECT * FROM phone WHERE id = ?";
    
    try {
        Connection con = DatabaseConnection.getConnection();
        PreparedStatement pstmt = con.prepareStatement(sql);
        pstmt.setInt(1, id);
        ResultSet rs = pstmt.executeQuery();
        
        if (rs.next()) {
            String name = rs.getString("name");
            String price = rs.getString("price");
            String image = rs.getString("image");
            String description = rs.getString("description");

            phone = new Phone(id, name, price, image, description);
        }

        DatabaseConnection.closeConnection(con);
    } catch (Exception e) {
        e.printStackTrace();
    }
    return phone;
}
    
}
