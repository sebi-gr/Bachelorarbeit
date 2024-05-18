import javax.crypto.Cipher;
import javax.crypto.KeyGenerator;
import javax.crypto.SecretKey;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;
import java.util.Base64;

public class SecureCookieHandler {

    private static SecretKey secretKey;

    static {
        try {
            // Generieren eines Schlüssels für die AES-Verschlüsselung
            KeyGenerator keyGenerator = KeyGenerator.getInstance("AES");
            keyGenerator.init(256); // AES-256 für starke Verschlüsselung
            secretKey = keyGenerator.generateKey();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static String encryptUserData(String userData) throws Exception {
        Cipher cipher = Cipher.getInstance("AES");
        cipher.init(Cipher.ENCRYPT_MODE, secretKey);
        byte[] encryptedData = cipher.doFinal(userData.getBytes());
        return Base64.getEncoder().encodeToString(encryptedData);
    }

    public static void addSecureCookie(String userData, HttpServletResponse response) {
        try {
            String encryptedData = encryptUserData(userData);

            // Erstellen des Cookies mit verschlüsselten Benutzerdaten
            Cookie userCookie = new Cookie("UserData", encryptedData);

            // Setzen der Cookie-Attribute für Sicherheit
            userCookie.setHttpOnly(true); // Schutz vor Zugriff durch Client-Side Scripting
            userCookie.setSecure(true); // Senden nur über sichere Verbindungen
            userCookie.setPath("/"); // Verfügbar für die gesamte Website
            userCookie.setMaxAge(60 * 60 * 24); // 1 Tag Gültigkeit

            // Hinzufügen des Cookies zur Response
            response.addCookie(userCookie);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
