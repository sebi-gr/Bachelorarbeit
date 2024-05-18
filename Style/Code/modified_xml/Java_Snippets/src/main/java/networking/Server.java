package networking;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * This class represents a simple server that listens for client connections and messages.
 */
public class Server {

    /**
     * Starts the server.
     *
     * @throws Exception if an I/O error occurs when opening the socket
     */
    public void start() throws Exception {
        try (ServerSocket serverSocket = new ServerSocket(8080);
             Socket clientSocket = serverSocket.accept();
             PrintWriter out = new PrintWriter(clientSocket.getOutputStream(), true);
             BufferedReader in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()))) {

            String inputLine = in.readLine();
            System.out.println("Received message from client: " + inputLine);
            out.println("Message received");
        }
    }
}
