package Client;

import javax.imageio.IIOException;
import java.io.IOException;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.HashMap;
import java.util.Scanner;

public class App {
    private static final int PORT = 8666;
    private static final String LOCALHOST = "localhost";
    private final String separator = "|";
    int option;
    String username;
    Scanner sc = new Scanner(System.in);
    Socket userSocket;

    public void start() {
        try {
            do {
                System.out.println("1- Login\n2- Sign up\n0- Exit");
                switch (option = sc.nextInt()) {
                    case 1:
                        userSocket = new Socket(LOCALHOST, PORT);
                        if (login()) {
                            loggedMenu();
                        }
                        break;
                    case 2:
                        userSocket = new Socket(LOCALHOST, PORT);
                        signUp();
                        break;
                    case 0:
                        System.out.println("Goodbye!");
                        break;
                    default:
                        System.out.println("What?");
                }
                userSocket.close();
            } while (option != 0);
        } catch (Exception e) {
            System.out.println(e.getMessage() + ".\nServer unavailable!");
        }
    }

    public boolean login() {
        System.out.print("\nLOGIN\n\nUsername:");
        username = sc.next();
        System.out.print("\nPassword:");
        String password = sc.next();
        try {
            PrintWriter out = new PrintWriter(userSocket.getOutputStream(), true);
            out.println("login" + separator + username + separator + password);
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
        return false;
    }

    public void signUp(){
        System.out.print("\nLOGIN\n\nUsername:");
        username = sc.next();
        System.out.print("\nPassword:");
        String password = sc.next();
        try {
            PrintWriter out = new PrintWriter(userSocket.getOutputStream(), true);
            out.println("signUp" + separator + username + separator + password);
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }


    public void loggedMenu() {
        do {
            System.out.println("Hello " + username + "!\n1- Chat\n2- Who is online?\n0- Log out");
            switch (sc.nextInt()) {
                case 1:

                    break;
                case 2:

                    break;
                case 0:
                    System.out.println("Logging out! Bye " + username);
                    username = null;
            }
        } while (username != null);
    }
}
