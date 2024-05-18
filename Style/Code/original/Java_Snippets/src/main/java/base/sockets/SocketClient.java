package base.sockets;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

public class SocketClient {
    public static void main(String[] args) throws Exception {
        Socket socket = new Socket("localhost", 8080);
        System.out.println("Connected to server");

        BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
        PrintWriter out = new PrintWriter(socket.getOutputStream(), true);

        out.println("Hello from client");
        System.out.println("Sent message: Hello from client");

        String inputLine;
        while ((inputLine = in.readLine()) != null) {
            System.out.println("Received message: " + inputLine);

            if (inputLine.equals("Echo from server: bye")) {
                break;
            }
        }

        in.close();
        out.close();
        socket.close();
    }
}
