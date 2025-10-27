import java.security.MessageDigest;
import java.util.Scanner;
import java.util.Base64;
 
public class MD5Example {
	public static void main(String[] args){
		try{
			Scanner sc = new Scanner(System.in);
 
			System.out.print("Enter message to compute MD5 hash: ");
			String inputText = sc.nextLine();
 
			MessageDigest md = MessageDigest.getInstance("MD5");
 
			md.update(inputText.getBytes());
 
            		byte[] digestBytes = md.digest();
 
 
			StringBuilder hexHash = new StringBuilder();
			for (byte b: digestBytes) {
				hexHash.append(String.format("%02x",b));
			}
 
			System.out.println("\n---MD5 Message DIgest---");
			System.out.println("Input Text: "+inputText);
			System.out.println("Digest(hex): "+hexHash.toString());
			System.out.println("Digest(Base64):" + Base64.getEncoder().encodeToString(digestBytes));
 
			sc.close();
		}
		catch (Exception e){
			System.err.println("Error while computing MD5:" + e.getMessage());
		}
 
	}
 
}


// OUTPUT : 
// Enter message to compute MD5 hash: Hello 

// ---MD5 Message DIgest---
// Input Text: Hello 
// Digest(hex): d1a7fb5eab1c16cb4f7cf341cf188c3d
// Digest(Base64):0af7XqscFstPfPNBzxiMPQ==
