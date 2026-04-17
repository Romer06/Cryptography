public class HillCipher {
// Method to perform encryption
public static String encrypt(String plainText, int[][] keyMatrix) {
// Prepare text: remove non-letters, make uppercase, pad if needed
plainText = plainText.toUpperCase().replaceAll("[^A-Z]", "");
if (plainText.length() % 2 != 0)
plainText += "X"; // Simple padding
StringBuilder cipherText = new StringBuilder();
for (int i = 0; i<plainText.length(); i += 2) {
int p1 = plainText.charAt(i) - 'A';
int p2 = plainText.charAt(i + 1) - 'A';
// Matrix multiplication
int c1 = (keyMatrix[0][0] * p1 + keyMatrix[0][1] * p2) % 26;
int c2 = (keyMatrix[1][0] * p1 + keyMatrix[1][1] * p2) % 26;
cipherText.append((char) (c1 + 'A'));
cipherText.append((char) (c2 + 'A'));
}
return cipherText.toString();
}
// Method to calculate inverse of 2x2 matrix mod 26
private static int[][] getInverseMatrix(int[][] keyMatrix) {
int det = (keyMatrix[0][0] * keyMatrix[1][1] - keyMatrix[0][1] * keyMatrix[1][0]) % 26;
if (det< 0)
det += 26;
// Find modular multiplicative inverse of det
int detInverse = -1;
for (int i = 1; i< 26; i++) {
if ((det * i) % 26 == 1) {
detInverse = i;
break;
}
}
if (detInverse == -1)
throw new ArithmeticException("Key matrix is not invertible.");
int[][] invKey = new int[2][2];
invKey[0][0] = (keyMatrix[1][1] * detInverse) % 26;
invKey[0][1] = (-keyMatrix[0][1] * detInverse) % 26;
invKey[1][0] = (-keyMatrix[1][0] * detInverse) % 26;
invKey[1][1] = (keyMatrix[0][0] * detInverse) % 26;
// Ensure positive values
for (int i = 0; i< 2; i++) {
for (int j = 0; j < 2; j++) {
if (invKey[i][j] < 0)
invKey[i][j] += 26;
}
}
return invKey;
}
// Method to perform decryption
public static String decrypt(String cipherText, int[][] keyMatrix) {
int[][] invKey = getInverseMatrix(keyMatrix);
return encrypt(cipherText, invKey); // Decryption is just encryption with inverse key
}
public static void main(String[] args) {
// Example Key Matrix (must be invertible)
// | 3 3 |
// | 2 5 |
int[][] keyMatrix = {{3, 3}, {2, 5}};
String plainText = "HELP";
System.out.println("Plaintext: " + plainText);
String encrypted = encrypt(plainText, keyMatrix);
System.out.println("Encrypted: " + encrypted);
String decrypted = decrypt(encrypted, keyMatrix);
System.out.println("Decrypted: " + decrypted);
}
}