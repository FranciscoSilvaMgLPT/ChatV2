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
                String[] info = in.readLine().split("\\|");

                switch (info[0]) {
                    case "login":
                        if (authenticateLogin(info[1], info[2])) {
                            System.out.println(info[1] + " logged.");

                        } else {
                            System.out.println("Login info (" + info + ") by " + clientSocket + " refused!");
                            out.println("Login info refused ");
                        }
                        break;
                    case "signUp":

                        break;
                }


                System.out.println(clientSocket + " disconnected!");
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private boolean authenticateLogin(String username, String password) {
        if (info != null) {
            return false;
        }
        return true;
    }
}
