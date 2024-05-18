package networking;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

/**
 * This class represents a simple client that sends a message to a server and reads the server's response.
 */
public class Client {

    /**
     * Connects to the server and sends a message.
     *
     * @throws Exception if an I/O error occurs when opening the socket
     */
    public void connect() throws Exception {
        try (Socket socket = new Socket("localhost", 8080);
             PrintWriter out = new PrintWriter(socket.getOutputStream(), true);
             BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()))) {

            out.println("Hello Server");
            String response = in.readLine();
            System.out.println("Received response from server: " + response);
        }
    }
}