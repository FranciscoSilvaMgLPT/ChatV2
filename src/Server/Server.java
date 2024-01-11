package Server;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {
    private static final int PORT = 8666;

    public void start() {
        try {
            ServerSocket serverSocket = new ServerSocket(PORT);
            System.out.println("Server open!\nServer port: " + PORT);
            while (!serverSocket.isClosed()) {

                Socket clientSocket = serverSocket.accept();
                System.out.println(clientSocket + " connected!");
                BufferedReader in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
                PrintWriter out = new PrintWriter(clientSocket.getOutputStream(), true);
                String info = in.readLine();
                if (authenticateLogin(info)) {
                    System.out.println("asdasd");
                } else {
                    System.out.println("Login info (" + info + ") by " + clientSocket + " refused!");
                    out.println("Login info refused ");
                }

                System.out.println(clientSocket + " disconnected!");
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private boolean authenticateLogin(String info) {
        String[] log = info.split("\\|");
        if(info!=null){
            return false;
        }
        return true;
    }
}
