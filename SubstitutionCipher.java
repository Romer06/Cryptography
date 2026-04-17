import java.io.*;
public class SubstitutionCipher {
static BufferedReader br = new BufferedReader(new
InputStreamReader(System.in));
// Encryption method
public static String encrypt(String text) {
String a = "abcdefghijklmnopqrstuvwxyz";
String b = "zyxwvutsrqponmlkjihgfedcba";
String result = "";
char c;
for (int i = 0; i < text.length(); i++) {
c = text.charAt(i);
if (a.indexOf(c) != -1) {
int j = a.indexOf(c);
result = result + b.charAt(j);
} else {
result = result + c; // unchanged
}
}
return result;
}
// Decryption method
public static String decrypt(String text) {
String a = "abcdefghijklmnopqrstuvwxyz";
String b = "zyxwvutsrqponmlkjihgfedcba";
String result = "";
char c;
for (int i = 0; i < text.length(); i++) {
c = text.charAt(i);
if (b.indexOf(c) != -1) {
int j = b.indexOf(c);
result = result + a.charAt(j);
} else {
result = result + c;
}
}
return result;
}
public static void main(String[] args) throws IOException {
System.out.println("Enter any string:");
String input = br.readLine().toLowerCase();
String encrypted = encrypt(input);
System.out.println("Encrypted Text: " + encrypted);
String decrypted = decrypt(encrypted);
System.out.println("Decrypted Text: " + decrypted);
}
}