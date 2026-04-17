# Cryptography

Overview
The Cryptographic Implementation Engine is a Java-based security toolkit designed to demonstrate the fundamental mathematical principles of data encryption and decryption. The project implements classic symmetric algorithms, focusing on modular arithmetic, linear algebra, and character mapping to ensure data confidentiality. 

Core Algorithms
1. Caesar Cipher (Shift Cipher)
A symmetric-key algorithm that shifts characters in a plaintext message by a fixed numerical value (the key). 

Logic: Uses the formula (character - 'A' + shift) % 26 to handle character wrapping. 

Features: Maintains case sensitivity and leaves non-alphabetic characters unchanged. 

2. Hill Cipher (Polygraphic Cipher)
An advanced encryption technique that encrypts blocks of letters simultaneously using matrix multiplication. 

Encryption: Multiplies plaintext vectors by a 2×2 key matrix modulo 26. 

Decryption: Calculates the modular multiplicative inverse of the key matrix to recover the original text. 

Mathematical Foundation: Relies on Linear Algebra and modular inverses (det⋅detInverse≡1(mod26)). 

3. Substitution Cipher (Monoalphabetic)
A mapping-based system where each letter of the alphabet is replaced by a corresponding letter from a mirrored or scrambled alphabet key. 

Mechanism: Performs a position-based lookup between a standard alphabet string and a cipher alphabet string. 

Key Strategy: Utilizes a mirrored alphabet (Atbash style) where 'a' maps to 'z', 'b' to 'y', etc. 

Technical Implementation
Memory Management: Implemented using StringBuilder to ensure efficient string manipulation and minimize memory overhead during encryption/decryption cycles. 

Input Processing: Features robust character normalization and input validation to handle diverse plaintext formats. 

Modular Math: Includes dedicated logic for positive modulo results and handling of negative shift values during decryption. 

How to Run
Ensure you have JDK 8 or higher installed.

Compile the source files:

Bash
javac CaesarCipher.java HillCipher.java SubstitutionCipher.java
Run the desired algorithm:

Bash
java CaesarCipher
