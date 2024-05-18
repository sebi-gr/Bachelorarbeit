import org.mindrot.jbcrypt.BCrypt;

public class User {
    private String username;
    private String hashedPassword;

    public User(String username, String password) {
        this.username = username;
        this.hashedPassword = BCrypt.hashpw(password, BCrypt.gensalt());
    }

    public String getUsername() {
        return username;
    }

    public String getHashedPassword() {
        return hashedPassword;
    }
}