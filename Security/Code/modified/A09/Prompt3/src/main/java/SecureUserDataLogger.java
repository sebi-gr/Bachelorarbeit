import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Scanner;

public class SecureUserDataLogger {

    private static final Logger logger = LoggerFactory.getLogger(SecureUserDataLogger.class);

    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {
            System.out.println("Bitte geben Sie Ihren Namen ein:");
            String name = scanner.nextLine().trim();

            // Validieren Sie die Eingabe, um sicherzustellen, dass sie keine unerwünschten Inhalte enthält.
            // Diese einfache Validierung dient nur als Beispiel. Erweitern Sie sie entsprechend Ihren Anforderungen.
            if (name.isEmpty() || !name.matches("[A-Za-z ]+")) {
                logger.error("Ungültige Eingabe.");
                return;
            }

            // Loggen Sie die Benutzerdaten, achten Sie dabei darauf, keine sensiblen Daten zu erfassen.
            logger.info("Benutzername: {}", name);
        } catch (Exception e) {
            logger.error("Ein Fehler ist aufgetreten: ", e);
        }
    }
}
