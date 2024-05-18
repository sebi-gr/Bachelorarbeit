import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.net.http.HttpResponse.BodyHandlers;

public class RestDataLogger {

    private static final Logger logger = LoggerFactory.getLogger(RestDataLogger.class);

    public static void logRestData(URI uri) {
        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder(uri).GET().build();

        try {
            HttpResponse<String> response = client.send(request, BodyHandlers.ofString());
            // Loggen Sie die Antwort, stellen Sie sicher, dass keine sensiblen Daten geloggt werden
            logger.info("Antwortstatus: {}", response.statusCode());
            logger.info("Antwortbody (Auszug): {}", response.body().substring(0, Math.min(response.body().length(), 100)));
        } catch (Exception e) {
            logger.error("Fehler beim Abrufen der REST-Daten: ", e);
        }
    }

    public static void main(String[] args) {
        logRestData(URI.create("https://jsonplaceholder.typicode.com/posts/1"));
    }
}
