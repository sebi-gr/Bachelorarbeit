import javax.mail.*;
import javax.mail.internet.*;
import java.util.Properties;

public class PasswordResetService {

    private static final String SMTP_HOST_NAME = "smtp.example.com"; // Setzen Sie hier Ihren SMTP Host ein
    private static final String SMTP_AUTH_USER = "your-email@example.com"; // Ihre E-Mail-Adresse
    private static final String SMTP_AUTH_PWD = "your-email-password"; // Ihr E-Mail-Passwort

    // Methode zum Senden des Passwort-Reset-Links
    public static void sendResetLink(String userEmail) {
        try {
            Properties properties = new Properties();
            properties.put("mail.smtp.host", SMTP_HOST_NAME);
            properties.put("mail.smtp.auth", "true");
            properties.put("mail.smtp.starttls.enable", "true");

            Session session = Session.getDefaultInstance(properties, new javax.mail.Authenticator() {
                protected PasswordAuthentication getPasswordAuthentication() {
                    return new PasswordAuthentication(SMTP_AUTH_USER, SMTP_AUTH_PWD);
                }
            });

            // Erstellt eine sichere und einzigartige Reset-URL
            String token = generateSecureToken(); // Implementieren Sie diese Methode, um einen sicheren Token zu generieren
            String resetUrl = "https://example.com/reset-password?token=" + token;

            storeToken(userEmail, token); // Speichern Sie den Token und die E-Mail in Ihrer Datenbank zur späteren Überprüfung

            Message message = new MimeMessage(session);
            message.setFrom(new InternetAddress(SMTP_AUTH_USER));
            message.setRecipients(Message.RecipientType.TO, InternetAddress.parse(userEmail));
            message.setSubject("Passwort zurücksetzen");
            message.setText("Um Ihr Passwort zurückzusetzen, klicken Sie bitte auf den folgenden Link: " + resetUrl);

            Transport.send(message);

            System.out.println("Reset-Link wurde erfolgreich gesendet.");
        } catch (MessagingException e) {
            throw new RuntimeException(e);
        }
    }

    // Methode zur Generierung eines sicheren Tokens
    private static String generateSecureToken() {
        // Implementierung einer sicheren Token-Generierung (z.B. mit java.security.SecureRandom)
        return "secureRandomToken"; // Dies ist nur ein Platzhalter
    }

    // Methode zum Speichern des Tokens in der Datenbank
    private static void storeToken(String userEmail, String token) {
        // Implementierung zum Speichern des Tokens zusammen mit der Benutzer-E-Mail
        // Stellen Sie sicher, dass der Token eine begrenzte Gültigkeitsdauer hat
    }

    // Hauptmethode zum Testen der Funktionalität
    public static void main(String[] args) {
        sendResetLink("user@example.com"); // Ersetzen Sie dies durch die E-Mail-Adresse des Benutzers
    }
}
