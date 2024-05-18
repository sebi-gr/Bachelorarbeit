import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class Main {
    public static void main(String[] args) throws Exception {
        String userInput = "example"; // Ersetzen Sie dies durch die tatsächliche Benutzereingabe
        String urlString = "http://api.example.com/search?query=" + userInput;

        URL url = new URL(urlString);
        HttpURLConnection conn = (HttpURLConnection) url.openConnection();

        conn.setRequestMethod("GET");

        BufferedReader in = new BufferedReader(new InputStreamReader(conn.getInputStream()));
        String inputLine;
        StringBuffer content = new StringBuffer();
        while ((inputLine = in.readLine()) != null) {
            content.append(inputLine);
        }

        // Schließen Sie alle Verbindungen
        in.close();
        conn.disconnect();

        System.out.println("Response content: " + content.toString());
    }
}