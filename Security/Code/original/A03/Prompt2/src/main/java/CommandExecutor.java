import java.util.Scanner;
import java.io.*;

public class CommandExecutor {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Bitte geben Sie den auszuführenden Befehl ein:");

        String command = scanner.nextLine();

        try {
            Process process = Runtime.getRuntime().exec(command);

            BufferedReader reader = new BufferedReader(new InputStreamReader(process.getInputStream()));
            String line;
            while ((line = reader.readLine()) != null) {
                System.out.println(line);
            }

            int exitVal = process.waitFor();
            if (exitVal == 0) {
                System.out.println("Befehl erfolgreich ausgeführt");
            } else {
                System.out.println("Befehl fehlgeschlagen");
            }

        } catch (IOException | InterruptedException e) {
            e.printStackTrace();
        }
    }
}