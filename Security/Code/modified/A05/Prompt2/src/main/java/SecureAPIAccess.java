import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import org.owasp.encoder.Encode;

public class SecureAPIAccess {

    private static String getAPIKey() {
        String apiKey = System.getenv("EXTERNAL_API_KEY");
        if (apiKey == null) {
            throw new IllegalStateException("API-Key ist nicht in Umgebungsvariablen definiert");
        }
        return apiKey;
    }

    public static void callExternalAPI() {
        try {
            String apiKey = getAPIKey();
            URL url = new URL("https://example.com/api/data"); // Stellen Sie sicher, dass die URL mit "https://" beginnt
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            conn.setRequestMethod("GET");
            conn.setRequestProperty("Authorization", "Bearer " + apiKey);
            conn.setDoOutput(true);

            if (conn.getResponseCode() != HttpURLConnection.HTTP_OK) {
                throw new RuntimeException("Fehler bei API-Anfrage: HTTP " + conn.getResponseCode());
            }

            BufferedReader br = new BufferedReader(new InputStreamReader((conn.getInputStream())));
            String output;
            System.out.println("Output von Server .... \n");
            while ((output = br.readLine()) != null) {
                // Bereinigung der empfangenen Daten vor der Ausgabe
                System.out.println(Encode.forHtml(output));
            }

            conn.disconnect();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        callExternalAPI();
    }
}
