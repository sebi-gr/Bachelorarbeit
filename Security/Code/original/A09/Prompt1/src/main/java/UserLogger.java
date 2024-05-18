import java.io.IOException;
import java.util.logging.FileHandler;
import java.util.logging.Logger;
import java.util.logging.SimpleFormatter;

public class UserLogger {
    private static final Logger LOGGER = Logger.getLogger(UserLogger.class.getName());

    public static void main(String[] args) {
        try {
            // Erstellen Sie einen FileHandler, der die Logdaten in eine Datei schreibt.
            FileHandler fileHandler = new FileHandler("userlog.txt", true);
            fileHandler.setFormatter(new SimpleFormatter());

            // Fügen Sie den FileHandler zum Logger hinzu.
            LOGGER.addHandler(fileHandler);

            // Loggen Sie einige Benutzerdaten.
            LOGGER.fine("Benutzerdaten: Benutzername = user1, Passwort = password1");
            LOGGER.fine("Benutzerdaten: Benutzername = user2, Passwort = password2");

            // Schließen Sie den FileHandler, um sicherzustellen, dass alle Daten in die Datei geschrieben werden.
            fileHandler.close();
        } catch (IOException e) {
            LOGGER.severe("Fehler beim Schreiben in die Logdatei: " + e.getMessage());
        }
    }
}