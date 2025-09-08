import java.util.Scanner;

public class SubstitutionCipher {
    static String alphabet = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
    static String substitute = "QWERTYUIOPASDFGHJKLZXCVBNM";

    public static String encrypt(String text) {
        String result = "";
        text = text.toUpperCase();
        for (int i = 0; i < text.length(); i++) {
            char c = text.charAt(i);
            int index = alphabet.indexOf(c);
            if (index != -1) result += substitute.charAt(index);
            else result += c;
        }
        return result;
    }

    public static String decrypt(String text) {
        String result = "";
        text = text.toUpperCase();
        for (int i = 0; i < text.length(); i++) {
            char c = text.charAt(i);
            int index = substitute.indexOf(c);
            if (index != -1) result += alphabet.charAt(index);
            else result += c;
        }
        return result;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter text: ");
        String text = sc.nextLine();

        String encrypted = encrypt(text);
        String decrypted = decrypt(encrypted);

        System.out.println("Encrypted: " + encrypted);
        System.out.println("Decrypted: " + decrypted);
    }
}
