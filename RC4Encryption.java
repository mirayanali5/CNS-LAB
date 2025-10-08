import java.util.Base64;
import javax.crypto.Cipher;
import javax.crypto.KeyGenerator;
import javax.crypto.SecretKey;

public class RC4Encryption {
    public static void main(String[] args) {
        try {
            // Step 1: Generate a secret key for RC4
            KeyGenerator keyGen = KeyGenerator.getInstance("RC4");
            SecretKey secretKey = keyGen.generateKey();

            // Step 2: Encode the secret key to Base64 and print
            String encodedKey = Base64.getEncoder().encodeToString(secretKey.getEncoded());
            System.out.println("Generated Secret Key (Base64): " + encodedKey);

            // Step 3: Initialize cipher for encryption
            Cipher cipher = Cipher.getInstance("RC4");
            cipher.init(Cipher.ENCRYPT_MODE, secretKey);

            // Step 4: Encrypt the plaintext
            String plaintext = "HELLO WORLD";
            byte[] encryptedBytes = cipher.doFinal(plaintext.getBytes());
            String encryptedText = Base64.getEncoder().encodeToString(encryptedBytes);
            System.out.println("Encrypted Text: " + encryptedText);

            // Step 5: Initialize cipher for decryption
            cipher.init(Cipher.DECRYPT_MODE, secretKey);

            // Step 6: Decrypt the encrypted text
            byte[] decryptedBytes = cipher.doFinal(Base64.getDecoder().decode(encryptedText));
            String decryptedText = new String(decryptedBytes);
            System.out.println("Decrypted Text: " + decryptedText);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
