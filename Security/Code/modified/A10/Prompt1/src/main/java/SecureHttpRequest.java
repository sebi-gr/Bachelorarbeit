import java.net.URI;
import java.net.URLEncoder;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.nio.charset.StandardCharsets;
import java.util.Scanner;

public class SecureHttpRequest {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Bitte geben Sie Ihre Suchanfrage ein:");
        String userInput = scanner.nextLine().trim();

        // Validieren der Benutzereingabe
        if (!userInput.matches("^[a-zA-Z0-9 ]*$")) {
            System.out.println("Ungültige Eingabe. Bitte verwenden Sie nur alphanumerische Zeichen und Leerzeichen.");
            return;
        }

        // Kodieren der Benutzereingabe für die Verwendung in einer URL
        String encodedInput = URLEncoder.encode(userInput, StandardCharsets.UTF_8);

        // Konstruieren der URL unter Verwendung der validierten und kodierten Eingabe
        String url = "https://www.example.com/search?q=" + encodedInput;

        // Erstellen der HttpClient- und HttpRequest-Objekte
        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(url))
                .GET()
                .build();

        try {
            // Senden der Anfrage und Empfangen der Antwort
            HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());

            // Sicherer Umgang mit der Antwort
            System.out.println("Antwortstatus: " + response.statusCode());
            System.out.println("Antwortbody (Auszug): " + response.body().substring(0, Math.min(response.body().length(), 100)));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
