package DataBase;

import database.DatabaseConnection;
import model.Phone;
import java.io.*;
import java.net.Socket;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import model.Laptop;

public class PhoneManager {

    private static final String SERVER_ADDRESS = "192.168.1.8";
    private static final int SERVER_PORT = 1234;

     public static List<Phone> getPhone() {
        List<Phone> phoneList = new ArrayList<>();
        try (Socket socket = new Socket(SERVER_ADDRESS, SERVER_PORT);
             ObjectOutputStream output = new ObjectOutputStream(socket.getOutputStream());
             ObjectInputStream input = new ObjectInputStream(socket.getInputStream())) {

            output.writeObject("GET_PHONES");
            output.flush();

            phoneList = (List<Phone>) input.readObject();

        } catch (IOException | ClassNotFoundException ex) {
            ex.printStackTrace();
        }
        return phoneList;
    }

    public static void addPhone(String name, String price, String des, String img) {
        try (Socket socket = new Socket(SERVER_ADDRESS, SERVER_PORT);
             ObjectOutputStream output = new ObjectOutputStream(socket.getOutputStream());
             ObjectInputStream input = new ObjectInputStream(socket.getInputStream())) {

            output.writeObject("ADD_PHONE");
            output.writeObject(new String[]{name, price, des, img});
            output.flush();

            boolean success = input.readBoolean();
            if (success) {
                System.out.println("A new phone was inserted successfully!");
            } else {
                System.out.println("Failed to insert a new phone.");
            }

        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }

    public static void delete(Phone phone) {
        try (Socket socket = new Socket(SERVER_ADDRESS, SERVER_PORT);
             ObjectOutputStream output = new ObjectOutputStream(socket.getOutputStream());
             ObjectInputStream input = new ObjectInputStream(socket.getInputStream())) {

            output.writeObject("DELETE_PHONE");
            output.writeObject(phone.getId());
            output.flush();

            boolean success = input.readBoolean();
            if (success) {
                System.out.println("Phone deleted successfully!");
            } else {
                System.out.println("Failed to delete phone.");
            }

        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }

    public static void updatePhone(Phone phone) {
        try (Socket socket = new Socket(SERVER_ADDRESS, SERVER_PORT);
             ObjectOutputStream output = new ObjectOutputStream(socket.getOutputStream());
             ObjectInputStream input = new ObjectInputStream(socket.getInputStream())) {

            output.writeObject("UPDATE_PHONE");
            output.writeObject(phone);
            output.flush();

            boolean success = input.readBoolean();
            if (success) {
System.out.println("Phone updated successfully!");
           } else {
                System.out.println("Failed to update phone.");
            }

        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }

    public static Phone getPhoneById(int id) {
        Phone phone = null;
        try (Socket socket = new Socket(SERVER_ADDRESS, SERVER_PORT);
             ObjectOutputStream output = new ObjectOutputStream(socket.getOutputStream());
             ObjectInputStream input = new ObjectInputStream(socket.getInputStream())) {

            output.writeObject("GET_PHONE_BY_ID");
            output.writeObject(id);
            output.flush();

            phone = (Phone) input.readObject();

        } catch (IOException | ClassNotFoundException ex) {
            ex.printStackTrace();
        }
        return phone;
    }
     public static List<Phone> getPhoneByName(String name) {
    List<Phone> phones = new ArrayList<>();
    String sql = "SELECT * FROM phone WHERE name LIKE ?";
    
    try (Connection con = DatabaseConnection.getConnection();
         PreparedStatement pstmt = con.prepareStatement(sql)) {
        
        pstmt.setString(1, "%" + name + "%");
        ResultSet rs = pstmt.executeQuery();
        
        while (rs.next()) {
            int id = rs.getInt("id");
            String phoneName = rs.getString("name");
            String price = rs.getString("price");
            int quantity = rs.getInt("quantity");
            String image = rs.getString("image");
            String description = rs.getString("description");

            Phone phone = new Phone(id, phoneName, price, quantity, image, description);
            phones.add(phone);
        }
    } catch (Exception e) {
        e.printStackTrace();
    }
    return phones;

     }
}