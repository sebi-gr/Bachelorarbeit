import java.util.HashMap;
import java.util.Map;

// Eine einfache Klasse, die eine Benutzersitzung repräsentiert
class UserSession {
    private String sessionId;
    private boolean isLoggedIn;
    private String username;

    public UserSession(String sessionId, String username) {
        this.sessionId = sessionId;
        this.username = username;
        this.isLoggedIn = true; // Als vereinfachtes Beispiel setzen wir den Benutzer automatisch als eingeloggt
    }

    public String getSessionId() {
        return sessionId;
    }

    public boolean isLoggedIn() {
        return isLoggedIn;
    }

    public String getUsername() {
        return username;
    }
}

// Eine einfache Autorisierungsklasse, die überprüft, ob ein Benutzer Zugriff auf bestimmte Funktionen hat
class AuthorizationManager {
    private Map<String, Boolean> authorizedSessions;

    public AuthorizationManager() {
        authorizedSessions = new HashMap<>();
    }

    // Methode zum Hinzufügen einer autorisierten Sitzung
    public void addAuthorizedSession(String sessionId) {
        authorizedSessions.put(sessionId, true);
    }

    // Methode zum Überprüfen, ob eine Sitzung autorisiert ist
    public boolean isSessionAuthorized(String sessionId) {
        return authorizedSessions.containsKey(sessionId) && authorizedSessions.get(sessionId);
    }
}

// Beispielanwendung, die den Zugriff auf bestimmte Funktionen basierend auf der Sitzung steuert
public class Application {
    private AuthorizationManager authorizationManager;

    public Application() {
        authorizationManager = new AuthorizationManager();
    }

    // Methode zum Zugriff auf eine Funktion, die autorisierte Sitzungen erfordert
    public void accessFunction(String sessionId) {
        if (authorizationManager.isSessionAuthorized(sessionId)) {
            System.out.println("Funktion zugänglich für Sitzung: " + sessionId);
        } else {
            System.out.println("Unautorisierte Sitzung: " + sessionId + ". Zugriff verweigert.");
        }
    }

    public static void main(String[] args) {
        // Beispiel für die Verwendung
        Application app = new Application();
        UserSession session1 = new UserSession("session123", "user1");
        UserSession session2 = new UserSession("session456", "user2");

        // Fügen Sie autorisierte Sitzungen hinzu
        app.authorizationManager.addAuthorizedSession(session1.getSessionId());

        // Versuch auf Funktionen zuzugreifen
        app.accessFunction(session1.getSessionId()); // Zugriff erlaubt
        app.accessFunction(session2.getSessionId()); // Zugriff verweigert
    }
}
