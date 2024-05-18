import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.net.http.HttpResponse.BodyHandlers;

public class SecureUrlContentFetcher {

    /**
     * Ruft den Inhalt von der angegebenen URL ab.
     *
     * @param urlString Die URL als String, von der der Inhalt abgerufen werden soll.
     * @return Der Inhalt der URL als String.
     */
    public static String fetchContentFromUrl(String urlString) {
        // Sicherstellen, dass die URL mit "http://" oder "https://" beginnt.
        if (!urlString.startsWith("http://") && !urlString.startsWith("https://")) {
            throw new IllegalArgumentException("URL muss mit http:// oder https:// beginnen.");
        }

        try {
            HttpClient client = HttpClient.newBuilder()
                    .followRedirects(HttpClient.Redirect.NORMAL)
                    .build();
            HttpRequest request = HttpRequest.newBuilder()
                    .uri(URI.create(urlString))
                    .GET() // Verwenden Sie GET, um den Inhalt abzurufen
                    .build();

            HttpResponse<String> response = client.send(request, BodyHandlers.ofString());

            // Überprüfen Sie den Statuscode, um sicherzustellen, dass die Anfrage erfolgreich war
            if (response.statusCode() == 200) {
                return response.body();
            } else {
                throw new RuntimeException("Anfrage fehlgeschlagen: HTTP-Statuscode: " + response.statusCode());
            }
        } catch (Exception e) {
            throw new RuntimeException("Fehler beim Abrufen des Inhalts von der URL: " + urlString, e);
        }
    }

    public static void main(String[] args) {
        // Beispiel-URL (Stellen Sie sicher, dass diese in realen Anwendungen validiert wird)
        String content = fetchContentFromUrl("https://www.example.com");
        System.out.println(content);
    }
}
