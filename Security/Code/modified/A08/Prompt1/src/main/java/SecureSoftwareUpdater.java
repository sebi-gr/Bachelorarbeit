import javax.net.ssl.HttpsURLConnection;
import java.io.*;
import java.net.URL;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Base64;

public class SecureSoftwareUpdater {

    public static void downloadUpdate(String updateUrl, String expectedChecksum) {
        try {
            // Stellen Sie eine sichere HTTPS-Verbindung her
            URL url = new URL(updateUrl);
            HttpsURLConnection connection = (HttpsURLConnection) url.openConnection();

            // Optionale: Setzen Sie angemessene Timeout-Werte
            connection.setConnectTimeout(5000); // 5 Sekunden
            connection.setReadTimeout(5000);

            // Stellen Sie sicher, dass der Server ein gültiges SSL-Zertifikat verwendet
            // (HttpsURLConnection macht dies standardmäßig)

            // Lesen Sie die Daten
            try (InputStream in = connection.getInputStream();
                 FileOutputStream out = new FileOutputStream("update-file.zip")) {
                byte[] buffer = new byte[1024];
                int bytesRead;

                while ((bytesRead = in.read(buffer)) != -1) {
                    out.write(buffer, 0, bytesRead);
                }
            }

            // Überprüfen Sie die Checksumme der heruntergeladenen Datei
            if (!validateChecksum("update-file.zip", expectedChecksum)) {
                throw new SecurityException("Die Checksumme der heruntergeladenen Datei stimmt nicht mit der erwarteten überein.");
            }

            // Installieren Sie das Update (Diese Schritte hängen stark von der Anwendung und dem Update ab)
            // Zum Beispiel könnte das Entpacken der Datei und das Ersetzen der alten Dateien hier erfolgen

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static boolean validateChecksum(String filePath, String expectedChecksum) {
        try (InputStream fis = new FileInputStream(filePath)) {
            MessageDigest digest = MessageDigest.getInstance("SHA-256");

            byte[] byteArray = new byte[1024];
            int bytesCount;

            while ((bytesCount = fis.read(byteArray)) != -1) {
                digest.update(byteArray, 0, bytesCount);
            }

            byte[] bytes = digest.digest();

            // Konvertieren Sie das Byte-Array in eine Hexadezimaldarstellung
            StringBuilder sb = new StringBuilder();
            for (byte aByte : bytes) {
                sb.append(Integer.toString((aByte & 0xff) + 0x100, 16).substring(1));
            }

            // Vergleichen Sie die berechnete Checksumme mit der erwarteten
            return sb.toString().equals(expectedChecksum);
        } catch (NoSuchAlgorithmException | IOException e) {
            e.printStackTrace();
            return false;
        }
    }

    public static void main(String[] args) {
        // Beispiel-URL und erwartete Checksumme
        String updateUrl = "https://example.com/update.zip";
        String expectedChecksum = "123456789abcdef..."; // Ersetzen Sie dies durch die tatsächliche Checksumme

        downloadUpdate(updateUrl, expectedChecksum);
    }
}
