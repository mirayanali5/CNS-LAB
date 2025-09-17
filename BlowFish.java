import java.util.*;
import java.security.GeneralSecurityException;
import javax.crypto.*;
import javax.crypto.spec.SecretKeySpec;

public class BlowFish {
    public static void main(String args[]) throws GeneralSecurityException {
        Scanner sc = new Scanner(System.in);

        //----INPUT: Message----
        System.out.print("Enter message to encrypt: ");
        String msg = sc.nextLine();
        byte[] message = msg.getBytes();

        //---INPUT: Key---
        System.out.print("Enter custom key: ");
        String key = sc.nextLine();
        byte[] keyData = key.getBytes();

        SecretKeySpec secretKey = new SecretKeySpec(keyData, "Blowfish");

        //----ENCRYPTION----
        Cipher cipher = Cipher.getInstance("Blowfish");
        cipher.init(Cipher.ENCRYPT_MODE, secretKey);
        byte[] encrypted = cipher.doFinal(message);

        //----DECRYPTION----
        cipher.init(Cipher.DECRYPT_MODE, secretKey);
        byte[] decrypted = cipher.doFinal(encrypted);
        String decryptedMsg = new String(decrypted);

        //----OUTPUT----
        System.out.println("Message: " + msg);
        System.out.println("Encrypted: " + Arrays.toString(encrypted)); // To print byte array properly
        System.out.println("Decrypted: " + decryptedMsg);
    }
}
