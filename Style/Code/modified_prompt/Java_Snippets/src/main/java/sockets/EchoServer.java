package sockets;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * A simple echo server that listens for connections and echoes received messages.
 */
public class EchoServer {
    private static final Logger logger = Logger.getLogger(EchoServer.class.getName());
    private static final int PORT = 8080;

    /**
     * Starts the server.
     */
    public void start() {
        try (ServerSocket serverSocket = new ServerSocket(PORT)) {
            logger.info("Echo Server is listening on port " + PORT);

            while (true) {
                try (Socket clientSocket = serverSocket.accept();
                     PrintWriter out = new PrintWriter(clientSocket.getOutputStream(), true);
                     BufferedReader in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()))) {

                    String inputLine;
                    while ((inputLine = in.readLine()) != null) {
                        logger.info("Received message: " + inputLine);
                        out.println(inputLine); // Echoing received message back to client
                    }
                } catch (IOException e) {
                    logger.log(Level.SEVERE, "Error in communication with the client", e);
                }
            }
        } catch (IOException e) {
            logger.log(Level.SEVERE, "Could not start the server on port " + PORT, e);
        }
    }

    public static void main(String[] args) {
        new EchoServer().start();
    }
}
