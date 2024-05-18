import jakarta.xml.bind.JAXBContext;
import jakarta.xml.bind.JAXBException;
import jakarta.xml.bind.Unmarshaller;

import javax.net.ssl.SSLServerSocket;
import javax.net.ssl.SSLServerSocketFactory;
import java.io.InputStream;
import java.net.Socket;

public class XmlSocketServer {

    public static void main(String[] args) throws Exception {
        SSLServerSocketFactory ssf = (SSLServerSocketFactory) SSLServerSocketFactory.getDefault();
        SSLServerSocket serverSocket = (SSLServerSocket) ssf.createServerSocket(55555); // SSL-Port

        System.out.println("Sicherer Server gestartet, wartet auf Verbindungen...");

        Socket clientSocket = serverSocket.accept();
        System.out.println("Sichere Verbindung akzeptiert.");

        InputStream inputFromClient = clientSocket.getInputStream();

        // JAXB-Kontext und Unmarshaller
        JAXBContext jaxbContext = JAXBContext.newInstance(User.class);
        Unmarshaller unmarshaller = jaxbContext.createUnmarshaller();

        User user = (User) unmarshaller.unmarshal(inputFromClient);
        System.out.println("Empfangene Daten: Username = " + user.getUsername() + ", Email = " + user.getEmail());

        inputFromClient.close();
        clientSocket.close();
        serverSocket.close();
    }
}
