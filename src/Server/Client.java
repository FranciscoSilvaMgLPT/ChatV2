package Server;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

public class Client {
    private String username;
    private String password;
    private Boolean admin;
    private Socket userSocket;
    private BufferedReader reader;
    private PrintWriter writer;

    public Client(String username, String password, Socket userSocket) {
        this.username = username;
        this.password = password;
        this.admin = username.charAt(0) == '#';
        this.userSocket = userSocket;
        try {
            this.reader = new BufferedReader(new InputStreamReader(userSocket.getInputStream()));
            this.writer = new PrintWriter(userSocket.getOutputStream(), true);
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }

    public Client(String username, String password, Boolean admin) {
        this.username = username;
        this.password = password;
        this.admin = admin;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Boolean getAdmin() {
        return admin;
    }

    public void setAdmin(Boolean admin) {
        this.admin = admin;
    }

    public Socket getUserSocket() {
        return userSocket;
    }

    public void setUserSocket(Socket userSocket) {
        this.userSocket = userSocket;
    }
}