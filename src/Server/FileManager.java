
package Server;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class FileManager {
    List<Client> clientList;
    private static final String FILE_PATH = "/Users/mindera/IdeaProjects/Chat2/src/Server/Database/Clients.txt";

    public List<Client> getClientList() {
        return clientList;
    }
    public boolean readDatabase(){
        try {
            File obj = new File(FILE_PATH);
            Scanner reader = new Scanner(obj);
            while (reader.hasNextLine()) {
                String line = reader.nextLine();
                String[] splitString = line.split("\\|");
                Client client = new Client(splitString[0],splitString[1],Boolean.getBoolean(splitString[2]));
                clientList.add(client);
            }
            reader.close();
            return true;
        } catch (IOException e) {
            System.out.println("Something went wrong reading database.");
        }
        return false;
    }

    public boolean registerClient(String username, String password) {

        try {
            FileWriter fw = new FileWriter(FILE_PATH,true);
            fw.write(username + "|" + password + "|false");
            fw.close();

        } catch (IOException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
        return true;
    }

    public Client getClientLogin(String username,String password) throws FileNotFoundException {
        File obj = new File(FILE_PATH);
        Scanner reader = new Scanner(obj);
        while (reader.hasNextLine()) {
            String[] currentLineSplit = reader.toString().split("\\|");
            if(currentLineSplit[0].equals(username)){
                return  (currentLineSplit[1].equals(password)?  new Client(username,password,false):null);
            }
        }
    return null;}
}

