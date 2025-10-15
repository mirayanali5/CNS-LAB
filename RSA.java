import java.security.*;
import javax.crypto.Cipher;
import java.util.Base64;

public class RSA {

    public static void main(String[] args) throws Exception {
        KeyPairGenerator keyGen = KeyPairGenerator.getInstance("RSA");
        keyGen.initialize(2048);
        KeyPair pair = keyGen.generateKeyPair();
        PublicKey publicKey = pair.getPublic();
        PrivateKey privateKey = pair.getPrivate();

        String message = "Hello";
        System.out.println("Original Message: " + message);

        Cipher encryptCipher = Cipher.getInstance("RSA");
        encryptCipher.init(Cipher.ENCRYPT_MODE, publicKey);
        byte[] encryptedBytes = encryptCipher.doFinal(message.getBytes());
        String encryptedMessage = Base64.getEncoder().encodeToString(encryptedBytes);
        System.out.println("Encrypted Message: " + encryptedMessage);

        Cipher decryptCipher = Cipher.getInstance("RSA");
        decryptCipher.init(Cipher.DECRYPT_MODE, privateKey);
        byte[] decryptedBytes = decryptCipher.doFinal(Base64.getDecoder().decode(encryptedMessage));
        String decryptedMessage = new String(decryptedBytes);
        System.out.println("Decrypted Message: " + decryptedMessage);
  
  }
}

