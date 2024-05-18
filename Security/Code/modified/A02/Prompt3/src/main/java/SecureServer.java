import javax.net.ssl.SSLServerSocketFactory;
import javax.net.ssl.SSLServerSocket;
import javax.net.ssl.SSLSocket;

public class SecureServer {
    public static void main(String[] args) {
        try {
            // Setzen der Systemeigenschaften für den Keystore und dessen Passwort
            System.setProperty("javax.net.ssl.keyStore", "path/to/server_keystore.p12");
            System.setProperty("javax.net.ssl.keyStorePassword", "keystore-password");

            // Erhalten der SSLServerSocketFactory
            SSLServerSocketFactory ssf = (SSLServerSocketFactory) SSLServerSocketFactory.getDefault();

            // Erstellen eines SSLServerSocket
            try (SSLServerSocket serverSocket = (SSLServerSocket) ssf.createServerSocket(8443)) {
                System.out.println("SSL Server is listening on port 8443");

                // Akzeptieren von Verbindungen
                try (SSLSocket clientSocket = (SSLSocket) serverSocket.accept()) {
                    System.out.println("Client connected");

                    // Kommunikation mit dem Client
                    // Hier können Sie Daten lesen und schreiben, wie Sie es für notwendig erachten
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
