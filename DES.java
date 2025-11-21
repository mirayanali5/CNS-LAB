import java.util.*;
import javax.crypto.*;
import javax.crypto.spec.*;

public class DES {
    public static void main(String args[]) throws Exception {

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter message to encrypt: ");
        String msg = sc.nextLine();
        byte[] message = msg.getBytes();

        System.out.print("Enter custom 8-byte key: ");
        String key = sc.nextLine();

        if (key.length() != 8) {
            System.out.println("Error: DES key must be exactly 8 characters!");
            return;
        }

        byte[] keyData = key.getBytes();
        DESKeySpec secretKey = new DESKeySpec(keyData);

        SecretKeyFactory keyFactory = SecretKeyFactory.getInstance("DES");
        SecretKey keyObj = keyFactory.generateSecret(secretKey);

        Cipher cipher = Cipher.getInstance("DES");

        cipher.init(Cipher.ENCRYPT_MODE, keyObj);
        byte[] encrypted = cipher.doFinal(message);

        cipher.init(Cipher.DECRYPT_MODE, keyObj);
        byte[] decrypted = cipher.doFinal(encrypted);
        String decryptedMsg = new String(decrypted);

        System.out.println("Message: " + msg);
        System.out.println("Encrypted: " + Arrays.toString(encrypted));
        System.out.println("Decrypted: " + decryptedMsg);

        sc.close();
    }
}
