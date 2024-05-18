package sockets;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * A simple echo client that sends messages to the server and prints the responses.
 */
public class EchoClient {
    private static final Logger logger = Logger.getLogger(EchoClient.class.getName());
    private static final String HOST = "localhost";
    private static final int PORT = 8080;

    /**
     * Starts the client.
     */
    public void start() {
        try (Socket socket = new Socket(HOST, PORT);
             PrintWriter out = new PrintWriter(socket.getOutputStream(), true);
             BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
             BufferedReader stdIn = new BufferedReader(new InputStreamReader(System.in))) {

            String userInput;
            while ((userInput = stdIn.readLine()) != null) {
                out.println(userInput);
                logger.info("Echo: " + in.readLine());
            }
        } catch (IOException e) {
            logger.log(Level.SEVERE, "Could not connect to the server", e);
        }
    }

    public static void main(String[] args) {
        new EchoClient().start();
    }
}
