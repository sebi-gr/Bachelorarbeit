import java.security.NoSuchAlgorithmException;

public class Main {
    public static void main(String[] args) {
        try {
            User user = new User("sebi-gr", "sicheresPasswort");

            System.out.println(user.checkPassword("falschesPasswort")); // Gibt false aus
            System.out.println(user.checkPassword("sicheresPasswort")); // Gibt true aus
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
    }
}