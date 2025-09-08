import java.util.*
import javax.crypto.*;
import javax.crypto.spec.*;
 
public class DES{
public static void main(String args[]) throws Exception{
Scanner sc = new Scanner(System.in);
 
System.out.print("Enter message to encrypt:");
String msg = sc.nextLine();
byte[] message = msg.getBytes();
 
System.out.print("Enter custom key:");
String key = sc.nextLine();
byte[]keyData = key.getBytes();
DESKeySpec secretKey = new DESKeySpec(keyData);
 
SecretKeyFactory keyFactory = SecretKeyFactor.getInstance("DES");
SecretKeyFactory keyN = KeyFactor.generateSecret(secretKey);
 
Cipher cipher = Cipher.getInstance("DES");
cipher.init(Cipher.ENCRYPT_MODE, keyN);
byte[] encrypted = cipher.doFinal(message);
 
cipher.init(Cipher.DECRYPT_MODE, keyN);
byte[] decrypted = cipher.doFinal(encrypted);
String decryptedMsg = new String(decrypted)

System.out.println("Message:"+msg);
System.out.println("Encrypted:"+encypted);
System.out.println("Decrypted:"+decryptedMsg);
