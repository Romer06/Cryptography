# Cryptography

## Overview
The **Cryptographic Implementation Engine** is a Java-based security toolkit designed to demonstrate the fundamental mathematical principles of data encryption and decryption.The project implements classic symmetric algorithms, focusing on modular arithmetic, linear algebra, and character mapping to ensure data confidentiality.

## Core Algorithms

### 1. Caesar Cipher (Shift Cipher)
A symmetric-key algorithm that shifts characters in a plaintext message by a fixed numerical value, known as the key[cite: 2, 8].
* **Logic:** Uses the formula `(character - 'A' + shift) % 26` to handle character wrapping within the alphabet[cite: 31].
* **Features:** Maintains case sensitivity by processing uppercase and lowercase letters separately and leaves non-alphabetic characters unchanged[cite: 10, 11, 13, 29, 33].

### 2. Hill Cipher (Polygraphic Cipher)
An advanced encryption technique that encrypts blocks of letters simultaneously using matrix multiplication[cite: 69, 78].
* **Encryption:** Multiplies plaintext blocks (vectors) by a 2x2 key matrix modulo 26[cite: 98, 100, 141].
* **Decryption:** Calculates the **modular multiplicative inverse** of the key matrix to recover the original text[cite: 82, 107].
* **Mathematical Foundation:** Relies on Linear Algebra and modular inverses, specifically where `det * detInverse % 26 == 1`[cite: 108, 114].

### 3. Substitution Cipher (Monoalphabetic)
A mapping-based system where each letter of the alphabet is replaced by a corresponding letter from a mirrored or scrambled alphabet key[cite: 152, 157].
* **Mechanism:** Performs a position-based lookup between a standard alphabet string and a cipher alphabet string[cite: 173, 174, 175].
* **Key Strategy:** Utilizes a mirrored alphabet (Atbash style) where 'a' maps to 'z', 'b' to 'y', etc[cite: 167].

## Technical Implementation
* **Memory Management:** Implemented using `StringBuilder` to ensure efficient string manipulation and minimize memory overhead during encryption and decryption cycles[cite: 25, 93].
* **Input Processing:** Features robust character normalization using methods like `toUpperCase()` and input validation via `Character.isLetter()`[cite: 28, 91].
* **Modular Math:** Includes dedicated logic to ensure positive modulo results, particularly during Hill Cipher matrix operations and Caesar Cipher decryption[cite: 26, 124, 127].

## How to Run
1. **Ensure** you have **JDK 8 or higher** installed.
2. **Compile** the source files:
   ```bash
   javac CaesarCipher.java HillCipher.java SubstitutionCipher.java