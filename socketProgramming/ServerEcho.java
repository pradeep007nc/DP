package socketProgramming;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.ServerSocket;

public class ServerEcho {

    private static final String socketPath = "tmp/my_socket";
    private static final int maxClients = 20;

    public static void main(String[] args) {
        try{
            ServerSocket serverSocket = new ServerSocket(8080);
        }catch (IOException exception) {
            exception.printStackTrace();
        }
    }
}
