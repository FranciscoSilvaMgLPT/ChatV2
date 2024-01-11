package Server;

import java.io.*;
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
                FileManager fm = new FileManager();
                System.out.println(clientSocket + " connected!");
                BufferedReader in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
                PrintWriter out = new PrintWriter(clientSocket.getOutputStream(), true);
                String info = in.readLine();
                String[] infoSplit = info.split("\\|");
                switch (infoSplit[0]) {
                    case "login":
                        if ((fm.getClientLogin(infoSplit[1], infoSplit[2]) != null)) {
                            System.out.println("asdasd");
                        } else {
                            System.out.println("Login info (" + info + ") by " + clientSocket + " refused!");
                            out.println("Login info refused ");
                        }
                        break;

                    case "signup":
                        fm.registerClient(infoSplit[1],infoSplit[2]);
                }
                System.out.println(clientSocket + " disconnected!");
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
