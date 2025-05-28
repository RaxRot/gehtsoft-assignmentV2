package com.raxrot.ceaser;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class CaesarCipherTest {
    @Test
    void testEncryptDecryptEnglish() {
        String original = "AbC";
        int shift = 5;

        String encrypted = CaesarCipher.encrypt(original, shift);
        String decrypted = CaesarCipher.decrypt(encrypted, shift);

        assertEquals(original, decrypted);
    }

    @Test
    void testEncryptDecryptRussian() {
        String original = "АбВ";
        int shift = 7;

        String encrypted = CaesarCipher.encrypt(original, shift);
        String decrypted = CaesarCipher.decrypt(encrypted, shift);

        assertEquals(original, decrypted);
    }
}