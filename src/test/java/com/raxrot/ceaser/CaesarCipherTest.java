package com.raxrot.ceaser;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
class CaesarCipherTest {
    @Test
    void testEncryption() {
        String input = "AbC";
        String expected = "BcD";
        assertEquals(expected, CaesarCipher.encrypt(input, 1));
    }

    @Test
    void testDecryption() {
        String input = "AbC";
        String expected = "ZaB";
        assertEquals(expected, CaesarCipher.decrypt(input, 1));
    }
}