package Models;

import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class SessionManager {

    private static int loggedInUserId;
    private static String loggedInUsername;

    public static void setLoggedInUsername(String username) {
        loggedInUsername = username;
    }

    public static boolean verifyPassword(String inputPassword, String storedHash) {
        return hashPassword(inputPassword).equals(storedHash);
    }

    public static String getLoggedInUsername() {
        return loggedInUsername;
    }

    public static void setLoggedInUserId(int userId) {
        loggedInUserId = userId;
    }

    public static int getLoggedInUserId() {
        return loggedInUserId;
    }

    public static String hashPassword(String password) {
        try {
            MessageDigest digest = MessageDigest.getInstance("SHA-256");
            byte[] encodedHash = digest.digest(password.getBytes(StandardCharsets.UTF_8));

            // Convert bytes to hexadecimal format
            StringBuilder hexString = new StringBuilder();
            for (byte b : encodedHash) {
                String hex = Integer.toHexString(0xff & b);
                if (hex.length() == 1) {
                    hexString.append('0');
                }
                hexString.append(hex);
            }
            return hexString.toString();
        } catch (NoSuchAlgorithmException e) {
            throw new RuntimeException("Error hashing password", e);
        }
    }
}
