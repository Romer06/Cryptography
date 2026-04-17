import java.util.Scanner;
public class CaesarCipher {
// Function to encrypt a given text
public static String encrypt(String text, int shift) {
StringBuilder result = new StringBuilder();
shift = shift % 26; // Ensure shift is within 0-25
for (char character :text.toCharArray()) {
if (Character.isLetter(character)) {
if (Character.isUpperCase(character)) {
// Encryption for uppercase letters
char encryptedChar = (char) ('A' + (character - 'A' + shift) % 26);
result.append(encryptedChar);
} else {
// Encryption for lowercase letters
char encryptedChar = (char) ('a' + (character - 'a' + shift) % 26);
result.append(encryptedChar);
}
} else {
// Append non-alphabetic characters as they are
result.append(character);
}
}
return result.toString();
}
// Function to decrypt a given text
public static String decrypt(String text, int shift) {
// Decryption is simply encryption with a negative shift (or 26 - shift)
return encrypt(text, 26 - shift);
}
public static void main(String[] args) {
Scanner scanner = new Scanner(System.in);
System.out.println("Enter the text: ");
String text = scanner.nextLine();
System.out.println("Enter the shift value (integer): ");
int shift = scanner.nextInt();
// Encrypt the text
String encryptedText = encrypt(text, shift);
System.out.println("\nEncrypted text: " + encryptedText);
// Decrypt the text
String decryptedText = decrypt(encryptedText, shift);
System.out.println("Decrypted text: " + decryptedText);
scanner.close();
}
}