import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;

public class Main {
    public static void main(String[] args) throws Exception {
        CloseableHttpClient httpClient = HttpClients.createDefault();

        try {
            HttpGet request = new HttpGet("http://httpbin.org/get");

            // Senden der Anfrage; Rückgabe des Antwortobjekts.
            HttpResponse httpResponse = httpClient.execute(request);

            // Extrahieren der Antwort-Entity.
            HttpEntity entity = httpResponse.getEntity();

            if (entity != null) {
                // Konvertieren der Entity-Inhalte in einen String.
                String result = EntityUtils.toString(entity);
                System.out.println(result);
            }
        } finally {
            // Schließen des HttpClient.
            httpClient.close();
        }
    }
}