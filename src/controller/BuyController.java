package controller;

import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.net.Socket;
import java.util.regex.Pattern;
import javax.swing.JOptionPane;
import view.Buy;

public class BuyController {

    public static boolean buyProduct(String customerName, String citizenId, String phone, String productName, String price, String quantity) {
        try (Socket socket = new Socket("192.168.1.17", 1235);
             OutputStream output = socket.getOutputStream();
             ObjectOutputStream objectOutput = new ObjectOutputStream(output);
             InputStream input = socket.getInputStream();
             ObjectInputStream objectInput = new ObjectInputStream(input)) {

            objectOutput.writeObject(new String[]{"buy", customerName, citizenId, phone, productName, price, quantity});
            objectOutput.flush();

            boolean isSaved = objectInput.readBoolean();
            return isSaved;

        } catch (IOException ex) {
            ex.printStackTrace();
            JOptionPane.showMessageDialog(null, "Error connecting to server: " + ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
        return false;
    }

    public static boolean validateInput(String customerName, String citizenId, String phone) {
        if (phone.isEmpty()) {
            JOptionPane.showMessageDialog(null, "Phone should not be empty", "Error", JOptionPane.ERROR_MESSAGE);
            return false;
        } else if (!Pattern.matches("(84|0[3|5|7|8|9])+([0-9]{8})\\b", phone)) {
            JOptionPane.showMessageDialog(null, "Phone number is not in the correct format.", "Error", JOptionPane.ERROR_MESSAGE);
            return false;
        }

        if (citizenId.isEmpty()) {
            JOptionPane.showMessageDialog(null, "Citizen ID should not be empty", "Error", JOptionPane.ERROR_MESSAGE);
            return false;
        } else if (!Pattern.matches("(0)+([0-9]{11})\\b", citizenId)) {
            JOptionPane.showMessageDialog(null, "Citizen ID is not correct", "Error", JOptionPane.ERROR_MESSAGE);
            return false;
        }

        if (customerName.isEmpty()) {
            JOptionPane.showMessageDialog(null, "Name should not be empty", "Error", JOptionPane.ERROR_MESSAGE);
            return false;
        }

        return true;
    }
}
