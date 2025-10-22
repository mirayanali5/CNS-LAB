import java.security.MessageDigest;
import java.util.Scanner;
import java.util.Base64;
 
public class SHA1Example {
	public static void main(String[] args){
		try{
			Scanner sc = new Scanner(System.in);
 
			System.out.print("Enter message to compute SHA1 hash: ");
			String inputText = sc.nextLine();
 
			MessageDigest md = MessageDigest.getInstance("SHA-1");
 
			md.update(inputText.getBytes());
 
            byte[] digestBytes = md.digest();
 
 
			StringBuilder hexHash = new StringBuilder();
			for (byte b: digestBytes) {
				hexHash.append(String.format("%02x",b));
			}
 
			System.out.println("\n---SHA1 Message DIgest---");
			System.out.println("Input Text: "+inputText);
			System.out.println("Digest(hex): "+hexHash.toString());
			System.out.println("Digest(Base64):" + Base64.getEncoder().encodeToString(digestBytes));
 
			sc.close();
		}
		catch (Exception e){
			System.err.println("Error while computing SHA-1:" + e.getMessage());
		}
 
	}
 
}

// Output : 
// Enter message to compute SHA1 hash: Hello

// ---SHA1 Message DIgest---
// Input Text: Hello
// Digest(hex): f7ff9e8b7bb2e09b70935a5d785e0cc5d9d0abf0
// Digest(Base64):9/+ei3uy4Jtwk1pdeF4MxdnQq/A=
