import org.mindrot.jbcrypt.BCrypt;

public class PasswordHandler {

    // Methode zum Hashen eines Passworts
    public static String hashPassword(String plainTextPassword){
        return BCrypt.hashpw(plainTextPassword, BCrypt.gensalt());
    }

    // Methode zum Überprüfen eines Passworts
    public static boolean checkPassword(String plainTextPassword, String hashedPassword) {
        return BCrypt.checkpw(plainTextPassword, hashedPassword);
    }
}
