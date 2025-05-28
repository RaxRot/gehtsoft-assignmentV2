package com.raxrot.ceaser;
/**
 * Utility class for Caesar Cipher encryption and decryption.
 * <p>
 * Supports both English and Russian alphabets, uppercase and lowercase letters.
 * Non-letter characters (spaces, digits, punctuation) remain unchanged.
 * Handles both positive and negative shifts with proper wrap-around logic.
 */
public class CaesarCipher {

    private static final String ENG_LOWER = "abcdefghijklmnopqrstuvwxyz";
    private static final String ENG_UPPER = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
    private static final String RUS_LOWER = "абвгдеёжзийклмнопрстуфхцчшщъыьэюя";
    private static final String RUS_UPPER = "АБВГДЕЁЖЗИЙКЛМНОПРСТУФХЦЧШЩЪЫЬЭЮЯ";

    /**
     * Encrypts the input text using Caesar Cipher.
     *
     * @param text  the plaintext to encrypt
     * @param shift the number of positions to shift
     * @return the encrypted ciphertext
     */
    public static String encrypt(String text, int shift) {
        return shiftText(text, shift);
    }

    /**
     * Decrypts the input text using Caesar Cipher.
     *
     * @param text  the encrypted text to decrypt
     * @param shift the original shift used during encryption
     * @return the decrypted plaintext
     */
    public static String decrypt(String text, int shift) {
        return shiftText(text, -shift);
    }

    /**
     * Shifts each character in the text by the given shift value.
     *
     * @param text  the input text to shift
     * @param shift the number of positions to shift
     * @return the shifted text
     */
    private static String shiftText(String text, int shift) {
        StringBuilder result = new StringBuilder();

        for (char c : text.toCharArray()) {
            result.append(shiftChar(c, shift));
        }

        return result.toString();
    }

    /**
     * Shifts a single character within its alphabet, preserving case.
     *
     * @param c     the character to shift
     * @param shift the number of positions to shift
     * @return the shifted character
     */
    private static char shiftChar(char c, int shift) {
        if (ENG_LOWER.indexOf(c) != -1) {
            return shiftWithinAlphabet(c, ENG_LOWER, shift);
        } else if (ENG_UPPER.indexOf(c) != -1) {
            return shiftWithinAlphabet(c, ENG_UPPER, shift);
        } else if (RUS_LOWER.indexOf(c) != -1) {
            return shiftWithinAlphabet(c, RUS_LOWER, shift);
        } else if (RUS_UPPER.indexOf(c) != -1) {
            return shiftWithinAlphabet(c, RUS_UPPER, shift);
        } else {
            return c; // Non-letter character remains unchanged
        }
    }

    /**
     * Performs the shift calculation and returns the new character.
     *
     * @param c        the original character
     * @param alphabet the alphabet in which to perform the shift
     * @param shift    the number of positions to shift
     * @return the shifted character
     */
    private static char shiftWithinAlphabet(char c, String alphabet, int shift) {
        int len = alphabet.length();
        int oldIndex = alphabet.indexOf(c);
        int newIndex = (oldIndex + shift + len) % len;
        return alphabet.charAt(newIndex);
    }
}