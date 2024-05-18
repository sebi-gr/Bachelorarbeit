import java.util.Scanner;
import java.util.logging.Logger;

public class Main {
    private static final Logger logger = Logger.getLogger(Main.class.getName());

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Bitte geben Sie Ihren Namen ein:");
        String name = scanner.nextLine();

        System.out.println("Bitte geben Sie Ihr Alter ein:");
        int age = scanner.nextInt();
        scanner.nextLine(); // consume newline left-over

        System.out.println("Bitte geben Sie Ihren Benutzernamen ein:");
        String username = scanner.nextLine();

        System.out.println("Bitte geben Sie Ihr Passwort ein:");
        String password = scanner.nextLine();

        User user = new User(name, age, username, password);

        logger.info(user.toString());
    }
}