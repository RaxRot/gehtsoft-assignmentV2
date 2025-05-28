package com.raxrot;

import com.raxrot.ceaser.CaesarCipher;
import com.raxrot.ceaser.CaesarFileHandler;
import com.raxrot.math.ExpressionEvaluator;

import java.io.IOException;
import java.util.Scanner;

/**
 * Main application class for the Gehtsoft technical assignment.
 * <p>
 * Provides a simple console interface to perform:
 * <ul>
 *     <li>Caesar Cipher encryption</li>
 *     <li>Caesar Cipher decryption</li>
 *     <li>Arithmetic expression evaluation</li>
 * </ul>
 */
public class Main {

    /**
     * Entry point of the console application.
     *
     * @param args command-line arguments (not used)
     */
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Welcome to Gehtsoft Technical Assessment");

        // Show main menu
        System.out.println("\nPlease choose an option:");
        System.out.println("1. Caesar Cipher Encryption");
        System.out.println("2. Caesar Cipher Decryption");
        System.out.println("3. Arithmetic Expression Evaluation");
        System.out.print("Your choice: ");
        String choice = scanner.nextLine().trim();

        switch (choice) {
            case "1":
                handleCaesar(true, scanner);
                break;
            case "2":
                handleCaesar(false, scanner);
                break;
            case "3":
                handleExpression(scanner);
                break;
            default:
                System.out.println("Invalid choice.");
        }

        System.out.println("\nThank you for using the app. Goodbye!");
    }

    /**
     * Handles Caesar Cipher encryption or decryption.
     *
     * @param isEncryption true to encrypt, false to decrypt
     * @param scanner      Scanner for user input
     */
    private static void handleCaesar(boolean isEncryption, Scanner scanner) {
        try {
            System.out.println("Choose text source:");
            System.out.println("1. Enter manually");
            System.out.println("2. Load from file");
            System.out.print("Your choice: ");
            String inputType = scanner.nextLine().trim();

            String inputText;
            if (inputType.equals("1")) {
                System.out.print("Enter text: ");
                inputText = scanner.nextLine();
            } else if (inputType.equals("2")) {
                System.out.print("Enter file path: ");
                String path = scanner.nextLine();
                inputText = CaesarFileHandler.readFromFile(path);
                System.out.println("File content:");
                System.out.println(inputText);
            } else {
                System.out.println("Invalid source.");
                return;
            }

            System.out.print("Enter shift value: ");
            int shift = Integer.parseInt(scanner.nextLine());

            String result = isEncryption
                    ? CaesarCipher.encrypt(inputText, shift)
                    : CaesarCipher.decrypt(inputText, shift);

            System.out.println("Result:");
            System.out.println(result);

            if (inputType.equals("2")) {
                System.out.print("Save result to file? (y/n): ");
                if (scanner.nextLine().trim().equalsIgnoreCase("y")) {
                    System.out.print("Enter output file path: ");
                    String outPath = scanner.nextLine();
                    CaesarFileHandler.writeToFile(outPath, result);
                    System.out.println("Saved successfully.");
                }
            }

        } catch (IOException e) {
            System.out.println("File error: " + e.getMessage());
        } catch (NumberFormatException e) {
            System.out.println("Invalid shift: must be a number.");
        }
    }

    /**
     * Handles arithmetic expression evaluation using the ExpressionEvaluator.
     *
     * @param scanner Scanner for user input
     */
    private static void handleExpression(Scanner scanner) {
        System.out.print("Enter expression: ");
        String expr = scanner.nextLine();
        try {
            double result = ExpressionEvaluator.evaluate(expr);
            System.out.println("Result: " + result);
        } catch (Exception e) {
            System.out.println("Invalid expression: " + e.getMessage());
        }
    }
}