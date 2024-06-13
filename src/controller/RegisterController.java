package controller;

import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.net.Socket;
import java.util.regex.Pattern;

public class RegisterController {
    public boolean register(String username, String password, String fullName, String citizenID, String date) {
        try (Socket socket = new Socket("192.168.1.22", 1235);
             OutputStream output = socket.getOutputStream();
             ObjectOutputStream objectOutput = new ObjectOutputStream(output);
             InputStream input = socket.getInputStream();
             ObjectInputStream objectInput = new ObjectInputStream(input)) {

            objectOutput.writeObject(new String[]{"register", username, password, fullName, citizenID, date});
            objectOutput.flush();

            boolean isRegistered = objectInput.readBoolean();
            return isRegistered;

        } catch (IOException ex) {
            ex.printStackTrace();
        }
        return false;
    }
    
     public boolean validateInput(String username, String password, String fullName, String citizenID, String date) {
        if (username.isEmpty()) {
            System.out.println("Username cannot be empty.");
            return false;
        }
        
        if (fullName.isEmpty()) {
            System.out.println("Full Name cannot be empty.");
            return false;
        }
        
        if (citizenID.isEmpty()) {
            System.out.println("Citizen ID cannot be empty.");
            return false;
        } else if (!Pattern.matches("(0)+([0-9]{11})\\b", citizenID)) {
            System.out.println("Invalid Citizen ID format.");
            return false;
        }
        
        if (date.isEmpty()) {
            System.out.println("Date cannot be empty.");
            return false;
        }
        return true; 
    }
}
