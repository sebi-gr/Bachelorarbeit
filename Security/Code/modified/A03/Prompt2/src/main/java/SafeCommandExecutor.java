import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.List;

public class SafeCommandExecutor {

    // Liste der sicheren Befehle, die ausgeführt werden dürfen
    private static final List<String> SAFE_COMMANDS = Arrays.asList("echo", "whoami");

    public static void executeCommand(String userInput) {
        // Validierung der Benutzereingabe
        if (!SAFE_COMMANDS.contains(userInput)) {
            System.out.println("Ungültiger Befehl: " + userInput);
            return;
        }

        try {
            // Ausführung des sicheren Befehls
            Process process = Runtime.getRuntime().exec(userInput);
            BufferedReader reader = new BufferedReader(new InputStreamReader(process.getInputStream()));

            String line;
            while ((line = reader.readLine()) != null) {
                System.out.println(line);
            }

            process.waitFor();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        // Beispiel: Sichere Ausführung basierend auf Benutzereingabe
        String userInput = "echo"; // Angenommen, dies ist die Benutzereingabe
        executeCommand(userInput);
    }
}
