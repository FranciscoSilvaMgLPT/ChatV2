/*
package Server;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class FileManager {
    final String FILE_PATH = "src/Server/Database/Clients.txt";

    protected void signUpClient(Client client) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(FILE_PATH, true))) {
            writer.write(client.toString());
            writer.newLine();
            writer.close();
            System.out.println(client.getUsername() + " LOG CREATED AND SAVED TO THE FILE SUCCESSFULLY!");
        } catch (IOException e) {
            System.err.println("ERROR READING FROM THE FILE: " + e.getMessage());
        }
    }

    public boolean isUsernameTaken(String username) {
        List<Client> clientList = readDatabase();
        if (clientList != null) {
            for (Client client : clientList) {
                if (client.getUsername().equals(username)) {
                    return true;
                }
            }
        }
        return false;
    }

    public List<Client> readDatabase() {
        try {
            List<Client> userList = new ArrayList<>();
            File obj = new File(FILE_PATH);
            Scanner reader = new Scanner(obj);
            while (reader.hasNext()) {
                String currLine = reader.next();
                String[] currLineSerialized = currLine.split("\\|");
                Client user = new Client(currLineSerialized[0], currLineSerialized[1], currLineSerialized[2], Integer.parseInt(currLineSerialized[3]));
                userList.add(user);
            }
            reader.close();
            return userList;
        } catch (Exception e) {
            System.out.println("An error occurred reading the DB.");
        }
        return null;
    }

    public Client findUser(String username, String password) {
        List<Client> userList = readDatabase();
        if (userList != null) {
            for (Client user : userList) {
                if (user.getPlayerName().equals(username) && user.getPlayerPassword().equals(password)) {
                    return user;
                }
            }
        }
        return null;
    }

    public void writeDatabase(List<User> userList,User user){
        for (int i = 0; i < userList.size(); i++) {
            if(userList.get(i).getPlayerName().equals(user.getPlayerName())){
                userList.set(i,user);
            }
        }
        try {
            FileWriter fw = new FileWriter(FILE_PATH,false);
            for (int i = 0; i < userList.size(); i++) {
                String toWrite = userList.get(i).toString();
                fw.write(toWrite + "\n");
            }
            fw.close();

        } catch (IOException e) {
            System.out.println("An error occurred writting to the DB.");
            e.printStackTrace();
        }
    }

    public void writeDatabase(List<User> userList){
        try {
            FileWriter fw = new FileWriter(FILE_PATH,false);
            for (int i = 0; i < userList.size(); i++) {
                String toWrite = userList.get(i).toString();
                fw.write(toWrite + "\n");
            }
            fw.close();

        } catch (IOException e) {
            System.out.println("An error occurred writting to the DB.");
            e.printStackTrace();
        }
    }
}
*/
