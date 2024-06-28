
package utils;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.security.spec.InvalidKeySpecException;
import java.security.spec.KeySpec;
import java.util.Base64;
import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.PBEKeySpec;

public class HashService {

    private static final String ALGORITHM = "PBKDF2WithHmacSHA1";
    private static final int ITERATIONS = 65536;
    private static final int KEY_LENGTH = 128;
    private static final int SALT_LENGTH = 16;

    private static String hashPassword(String password, byte[] salt) {
        try {
            KeySpec spec = new PBEKeySpec(password.toCharArray(), salt, ITERATIONS, KEY_LENGTH);
            SecretKeyFactory factory = SecretKeyFactory.getInstance(ALGORITHM);
            byte[] hash = factory.generateSecret(spec).getEncoded();
            return Base64.getEncoder().encodeToString(hash);
        } catch (NoSuchAlgorithmException | InvalidKeySpecException e) {
            throw new RuntimeException(e);
        }
    }

    private static byte[] getSalt() {
        SecureRandom random = new SecureRandom();
        byte[] salt = new byte[SALT_LENGTH];
        random.nextBytes(salt);
        return salt;
    }

    public static String generateHashedPassword(String password) {
        byte[] salt = getSalt();
        String hashedPassword = hashPassword(password, salt);

        // Return the salt and hashed password as a concatenated string
        return Base64.getEncoder().encodeToString(salt) + ":" + hashedPassword;
    }

    public static boolean verifyPassword(String password, String storedPassword) {
        String[] parts = storedPassword.split(":");
        byte[] salt = Base64.getDecoder().decode(parts[0]);
        String hashedPassword = parts[1];

        return hashPassword(password, salt).equals(hashedPassword);
    }

    public static void main(String[] args) {
        HashService hashService = new HashService();

        String password = "mySecurePassword";
        String storedPassword = hashService.generateHashedPassword(password);

        // Verification
        String attemptedPassword = "mySecurePassword";
        boolean isMatch = hashService.verifyPassword(attemptedPassword, storedPassword);
        System.out.println("Password match: " + isMatch);
    }
}
