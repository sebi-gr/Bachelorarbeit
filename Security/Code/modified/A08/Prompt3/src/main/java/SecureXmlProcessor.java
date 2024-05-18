import jakarta.xml.bind.JAXBContext;
import jakarta.xml.bind.Unmarshaller;
import javax.xml.stream.XMLInputFactory;
import javax.xml.stream.XMLStreamReader;
import java.io.StringReader;

public class SecureXmlProcessor {

    public static User processXml(String xmlData) throws Exception {
        // Erstellen Sie eine sichere XMLInputFactory-Konfiguration
        XMLInputFactory xif = XMLInputFactory.newFactory();
        xif.setProperty(XMLInputFactory.IS_SUPPORTING_EXTERNAL_ENTITIES, false);
        xif.setProperty(XMLInputFactory.SUPPORT_DTD, false); // DTDs sind eine häufige Quelle für XXE

        // XMLStreamReader für das sichere Parsen von XML-Daten
        XMLStreamReader xsr = xif.createXMLStreamReader(new StringReader(xmlData));

        // JAXB-Kontext und Unmarshaller
        JAXBContext jaxbContext = JAXBContext.newInstance(User.class);
        Unmarshaller unmarshaller = jaxbContext.createUnmarshaller();

        // Deserialisieren Sie die XML-Daten in ein User-Objekt
        return (User) unmarshaller.unmarshal(xsr);
    }

    public static void main(String[] args) {
        try {
            String xmlData = "<user><username>john_doe</username><email>john.doe@example.com</email></user>";
            User user = processXml(xmlData);
            System.out.println("Username: " + user.getUsername() + ", Email: " + user.getEmail());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
