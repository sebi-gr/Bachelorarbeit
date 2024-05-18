import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.security.spec.KeySpec;
import java.util.Arrays;
import java.util.Base64;
import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.PBEKeySpec;

public class User {
    private String username;
    private byte[] salt;
    private byte[] hashedPassword;

    public User(String username, String password) throws NoSuchAlgorithmException {
        this.username = username;
        this.salt = createSalt();
        this.hashedPassword = hashPassword(password, this.salt);
    }

    private byte[] createSalt() {
        SecureRandom random = new SecureRandom();
        byte[] salt = new byte[16];
        random.nextBytes(salt);
        return salt;
    }

    private byte[] hashPassword(String password, byte[] salt) {
        KeySpec spec = new PBEKeySpec(password.toCharArray(), salt, 65536, 128);
        SecretKeyFactory factory = null;
        byte[] hash = null;
        try {
            factory = SecretKeyFactory.getInstance("PBKDF2WithHmacSHA1");
            hash = factory.generateSecret(spec).getEncoded();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return hash;
    }

    public boolean checkPassword(String password) {
        byte[] hash = hashPassword(password, this.salt);
        return Arrays.equals(this.hashedPassword, hash);
    }
}