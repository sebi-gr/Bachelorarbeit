import org.apache.hc.client5.http.classic.methods.HttpGet;
import org.apache.hc.client5.http.impl.classic.CloseableHttpClient;
import org.apache.hc.client5.http.impl.classic.CloseableHttpResponse;
import org.apache.hc.client5.http.impl.classic.HttpClients;
import org.apache.hc.core5.http.io.entity.EntityUtils;

public class SecureHttpClientExample {

    public static void makeSecureGetRequest(String url) {
        // Verwendung von try-with-resources, um den HttpClient automatisch zu schließen
        try (CloseableHttpClient httpClient = HttpClients.createDefault()) {
            HttpGet request = new HttpGet(url);

            try (CloseableHttpResponse response = httpClient.execute(request)) {
                // Überprüfen des Statuscodes
                int statusCode = response.getCode();
                if (statusCode == 200) {
                    // Erfolgreiche Antwort
                    String responseBody = EntityUtils.toString(response.getEntity());
                    System.out.println("Response: " + responseBody);
                } else {
                    // Fehlerbehandlung
                    System.out.println("Anfrage fehlgeschlagen: HTTP-Statuscode " + statusCode);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        String secureUrl = "https://example.com";
        makeSecureGetRequest(secureUrl);
    }
}
