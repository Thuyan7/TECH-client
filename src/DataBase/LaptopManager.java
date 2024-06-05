package DataBase;

import model.Laptop;

import java.io.*;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author AN
 */
public class LaptopManager {

    private static final String SERVER_ADDRESS = "192.168.1.8";
    private static final int SERVER_PORT = 1234;

    public static List<Laptop> getLaptop() {
        List<Laptop> laptopList = new ArrayList<>();
        try (Socket socket = new Socket(SERVER_ADDRESS, SERVER_PORT);
             ObjectOutputStream output = new ObjectOutputStream(socket.getOutputStream());
             ObjectInputStream input = new ObjectInputStream(socket.getInputStream())) {

            output.writeObject("GET_LAPTOPS");
            output.flush();

            laptopList = (List<Laptop>) input.readObject();

        } catch (IOException | ClassNotFoundException ex) {
            ex.printStackTrace();
        }
        return laptopList;
    }

    public static void addLaptop(String name, String price, String des, String img) {
        try (Socket socket = new Socket(SERVER_ADDRESS, SERVER_PORT);
             ObjectOutputStream output = new ObjectOutputStream(socket.getOutputStream());
             ObjectInputStream input = new ObjectInputStream(socket.getInputStream())) {

            output.writeObject("ADD_LAPTOP");
            output.writeObject(new String[]{name, price, des, img});
            output.flush();
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }

    public static void delete(Laptop l) {
        try (Socket socket = new Socket(SERVER_ADDRESS, SERVER_PORT);
             ObjectOutputStream output = new ObjectOutputStream(socket.getOutputStream());
             ObjectInputStream input = new ObjectInputStream(socket.getInputStream())) {

            output.writeObject("DELETE_LAPTOP");
            output.writeObject(l.getId());
            output.flush();

            boolean success = input.readBoolean();
            if (success) {
                System.out.println("Laptop deleted successfully!");
            } else {
                System.out.println("Failed to delete laptop.");
            }

        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }

    public static void updateLaptop(Laptop l) {
        try (Socket socket = new Socket(SERVER_ADDRESS, SERVER_PORT);
             ObjectOutputStream output = new ObjectOutputStream(socket.getOutputStream());
             ObjectInputStream input = new ObjectInputStream(socket.getInputStream())) {

            output.writeObject("UPDATE_LAPTOP");
            output.writeObject(l);
            output.flush();

            boolean success = input.readBoolean();
            if (success) {
                System.out.println("Laptop updated successfully!");
            } else {
                System.out.println("Failed to update laptop.");
            }

        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }

    public static Laptop getLaptopById(int id) {
        Laptop laptop = null;
        try (Socket socket = new Socket(SERVER_ADDRESS, SERVER_PORT);
             ObjectOutputStream output = new ObjectOutputStream(socket.getOutputStream());
             ObjectInputStream input = new ObjectInputStream(socket.getInputStream())) {

            output.writeObject("GET_LAPTOP_BY_ID");
            output.writeObject(id);
            output.flush();

            laptop = (Laptop) input.readObject();

        } catch (IOException | ClassNotFoundException ex) {
            ex.printStackTrace();
        }
        return laptop;
    }
}
