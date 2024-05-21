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

/**
 *
 * @author AN
 */
public class LaptopManager {
    public static List<Laptop> getLaptop(){
        List<Laptop> laptopList = new ArrayList<>();
        String sql = "SELECT * FROM laptop";
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

                Laptop laptop = new Laptop(id,name, price, image, description);
                laptopList.add(laptop);
            }

            DatabaseConnection.closeConnection(con);
        } catch (Exception e) {
        }
        return laptopList;
    }
    
     public static void addLaptop(String name, String price, String des, String img) {
        try {
            Connection conn = DatabaseConnection.getConnection();
            String sql = "INSERT INTO laptop (name, price, description, image) VALUES (?, ?, ?, ?)";
            PreparedStatement statement = conn.prepareStatement(sql);
            statement.setString(1, name);
            statement.setString(2, price);
            statement.setString(3, des);
            statement.setString(4, img);

            int rowsInserted = statement.executeUpdate();
            if (rowsInserted > 0) {
                System.out.println("A new laptop was inserted successfully!");
            }
            DatabaseConnection.closeConnection(conn);
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }
     
     public static void delete(Laptop l) {
		String sql="DELETE FROM laptop WHERE id='"+l.getId()+"'";
		try {
			Connection con= DatabaseConnection.getConnection();
			PreparedStatement ps= con.prepareStatement(sql);
			ps.executeUpdate();
			DatabaseConnection.closeConnection(con);
		} catch (Exception e) {
			// TODO: handle exception
		}
		
	}
public static void updateLaptop(Laptop l) {
    String sql = "UPDATE laptop SET name=?, price=?, image=?, description=? WHERE id=?";
    try {
        Connection con = DatabaseConnection.getConnection();
        PreparedStatement ps = con.prepareStatement(sql);
        ps.setString(1, l.getName());
        ps.setString(2, l.getPrice());
        ps.setString(3, l.getImage());
        ps.setString(4, l.getDescription());
        ps.setInt(5, l.getId());
        ps.executeUpdate();
        DatabaseConnection.closeConnection(con);
    } catch (Exception e) {
        e.printStackTrace(); // Handle exception
    }
}

public static Laptop getLaptopById(int id) {
    Laptop laptop = null;
    String sql = "SELECT * FROM laptop WHERE id = ?";
    
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

            laptop = new Laptop(id, name, price, image, description);
        }

        DatabaseConnection.closeConnection(con);
    } catch (Exception e) {
        e.printStackTrace();
    }
    return laptop;
}


}
