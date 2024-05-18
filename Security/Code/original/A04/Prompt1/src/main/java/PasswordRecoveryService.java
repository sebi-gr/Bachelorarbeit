import javax.crypto.Cipher;
import javax.crypto.KeyGenerator;
import javax.crypto.SecretKey;
import javax.crypto.spec.SecretKeySpec;
import java.security.SecureRandom;
import java.util.Random;

public class PasswordRecoveryService {

    private static final int TEMP_PASSWORD_LENGTH = 8;
    private static final String CHARACTERS = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789";
    private static final String ALGORITHM = "AES";
    private SecretKey secretKey;

    public PasswordRecoveryService() {
        try {
            KeyGenerator keyGenerator = KeyGenerator.getInstance(ALGORITHM);
            keyGenerator.init(128, new SecureRandom());
            secretKey = keyGenerator.generateKey();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public String recoverPassword(String email) {
        String tempPassword = generateTempPassword();
        String encryptedPassword = encryptTempPassword(tempPassword);
        // In a real application, you would send an email to the user here
        return encryptedPassword;
    }

    private String generateTempPassword() {
        Random random = new Random();
        StringBuilder tempPassword = new StringBuilder(TEMP_PASSWORD_LENGTH);

        for (int i = 0; i < TEMP_PASSWORD_LENGTH; i++) {
            int index = random.nextInt(CHARACTERS.length());
            tempPassword.append(CHARACTERS.charAt(index));
        }

        return tempPassword.toString();
    }

    private String encryptTempPassword(String tempPassword) {
        try {
            Cipher cipher = Cipher.getInstance(ALGORITHM);
            cipher.init(Cipher.ENCRYPT_MODE, secretKey);
            byte[] encryptedBytes = cipher.doFinal(tempPassword.getBytes());
            return bytesToHex(encryptedBytes);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    private static String bytesToHex(byte[] bytes) {
        StringBuilder sb = new StringBuilder();
        for (byte b : bytes) {
            sb.append(String.format("%02x", b));
        }
        return sb.toString();
    }
}