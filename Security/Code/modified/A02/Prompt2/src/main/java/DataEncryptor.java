import javax.crypto.Cipher;
import javax.crypto.KeyGenerator;
import javax.crypto.SecretKey;
import javax.crypto.spec.GCMParameterSpec;
import java.security.SecureRandom;
import java.util.Base64;

public class DataEncryptor {

    private static final int GCM_IV_LENGTH = 12; // 12 Bytes sind empfohlen
    private static final int GCM_TAG_LENGTH = 128; // 128 Bits sind Standard

    public static SecretKey generateSecretKey() throws Exception {
        KeyGenerator keyGenerator = KeyGenerator.getInstance("AES");
        keyGenerator.init(256); // Verwenden Sie eine Schlüssellänge von 256 Bits.
        return keyGenerator.generateKey();
    }

    public static byte[] generateIv() {
        byte[] iv = new byte[GCM_IV_LENGTH];
        new SecureRandom().nextBytes(iv);
        return iv;
    }

    public static String encrypt(String input, SecretKey key, byte[] iv) throws Exception {
        GCMParameterSpec gcmParameterSpec = new GCMParameterSpec(GCM_TAG_LENGTH, iv);
        Cipher cipher = Cipher.getInstance("AES/GCM/NoPadding");
        cipher.init(Cipher.ENCRYPT_MODE, key, gcmParameterSpec);
        byte[] cipherText = cipher.doFinal(input.getBytes());
        return Base64.getEncoder().encodeToString(cipherText);
    }

    // Beispielverwendung
    public static void main(String[] args) throws Exception {
        String originalInput = "Sensitive Data";
        SecretKey key = generateSecretKey();
        byte[] iv = generateIv();

        String encryptedData = encrypt(originalInput, key, iv);
        System.out.println("Encrypted Data: " + encryptedData);

        // Speichern Sie 'encryptedData', 'key' und 'iv' sicher in Ihrer Datenbank.
    }
}
