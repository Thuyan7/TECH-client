package controller;

import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.net.Socket;

public class LoginController {
    public boolean authenticate(String username, String password) {
        try (Socket socket = new Socket("192.168.1.22", 1235);
             OutputStream output = socket.getOutputStream();
             ObjectOutputStream objectOutput = new ObjectOutputStream(output);
             InputStream input = socket.getInputStream();
             ObjectInputStream objectInput = new ObjectInputStream(input)) {

            objectOutput.writeObject(new String[]{"login", username, password});
            objectOutput.flush();

            return objectInput.readBoolean();

        } catch (IOException ex) {
            ex.printStackTrace();
        
        }
        return false;
    }
}
