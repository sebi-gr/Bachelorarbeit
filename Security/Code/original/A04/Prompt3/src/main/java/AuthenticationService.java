import org.mindrot.jbcrypt.BCrypt;

public class AuthenticationService {
    public boolean authenticate(User user, String password) {
        return BCrypt.checkpw(password, user.getHashedPassword());
    }
}