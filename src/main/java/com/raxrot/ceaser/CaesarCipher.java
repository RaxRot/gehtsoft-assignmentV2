package com.raxrot.ceaser;

public class CaesarCipher {
    private static final String ENG_LOWER = "abcdefghijklmnopqrstuvwxyz";
    private static final String ENG_UPPER = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
    private static final String RUS_LOWER = "абвгдеёжзийклмнопрстуфхцчшщъыьэюя";
    private static final String RUS_UPPER = "АБВГДЕЁЖЗИЙКЛМНОПРСТУФХЦЧШЩЪЫЬЭЮЯ";

    public static String encrypt(String text, int shift) {
        return processText(text, shift);
    }

    public static String decrypt(String text, int shift) {
        return processText(text, -shift);
    }

    private static String processText(String text, int shift) {
        StringBuilder result = new StringBuilder();

        for (int i = 0; i < text.length(); i++) {
            char currentChar = text.charAt(i);
            result.append(shiftChar(currentChar, shift));
        }

        return result.toString();
    }

    private static char shiftChar(char character, int shift) {
        String alphabet;
        if (ENG_LOWER.indexOf(character) >= 0) {
            alphabet = ENG_LOWER;
        } else if (ENG_UPPER.indexOf(character) >= 0) {
            alphabet = ENG_UPPER;
        } else if (RUS_LOWER.indexOf(character) >= 0) {
            alphabet = RUS_LOWER;
        } else if (RUS_UPPER.indexOf(character) >= 0) {
            alphabet = RUS_UPPER;
        } else {
            return character; //Not a letter-dont touch
        }

        int currentPos = alphabet.indexOf(character);
        int newPos = (currentPos + shift) % alphabet.length();
        if (newPos < 0) {
            newPos += alphabet.length();
        }
        return alphabet.charAt(newPos);
    }

    public static void bruteForce(String text) {
        System.out.println("All Results");
        int maxShift = detectAlphabetLength(text);
        for (int i = 1; i < maxShift; i++) {
            String decryptText = decrypt(text, i);
            System.out.println(decryptText);
            System.out.println("<><><><><>");
        }
    }
    private static int detectAlphabetLength(String text) {
        for (char character : text.toCharArray()) {
            if (RUS_LOWER.indexOf(character) >= 0||RUS_UPPER.indexOf(character)>= 0) {
                return RUS_LOWER.length();
            } else if (ENG_LOWER.indexOf(character) >= 0|| ENG_UPPER.indexOf(character)>= 0) {
                return ENG_LOWER.length();
            }
        }
        return RUS_LOWER.length();
    }
}