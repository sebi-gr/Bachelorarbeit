import javax.net.ssl.SSLSocket;
import javax.net.ssl.SSLSocketFactory;

public class SecureClient {
    public static void main(String[] args) {
        System.setProperty("javax.net.ssl.trustStore", "path/to/client_truststore.p12");
        System.setProperty("javax.net.ssl.trustStorePassword", "truststore-password");

        SSLSocketFactory ssf = (SSLSocketFactory) SSLSocketFactory.getDefault();
        try (SSLSocket socket = (SSLSocket) ssf.createSocket("localhost", 8443)) {
            System.out.println("Connected to server");

            // Kommunikation mit dem Server
            // Beispiel: Senden von Daten, Empfangen von Antworten usw.
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
