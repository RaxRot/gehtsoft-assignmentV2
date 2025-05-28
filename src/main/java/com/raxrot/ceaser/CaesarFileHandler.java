package com.raxrot.ceaser;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

/**
 * Utility class for reading from and writing to text files.
 * <p>
 * Used in Caesar Cipher operations to load input text or save results.
 */
public class CaesarFileHandler {

    /**
     * Reads all text from a file and returns it as a single string.
     *
     * @param path the path to the input file
     * @return the full content of the file as a string
     * @throws IOException if the file cannot be read
     */
    public static String readFromFile(String path) throws IOException {
        List<String> lines = Files.readAllLines(Paths.get(path));
        return String.join("\n", lines);
    }

    /**
     * Writes the given content to the specified file path.
     *
     * @param path    the path to the output file
     * @param content the content to write into the file
     * @throws IOException if the file cannot be written
     */
    public static void writeToFile(String path, String content) throws IOException {
        Files.write(Paths.get(path), content.getBytes());
    }
}