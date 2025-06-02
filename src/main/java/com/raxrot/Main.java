package com.raxrot;

import com.raxrot.ceaser.CaesarCipher;
import com.raxrot.ceaser.CaesarFileHandler;
import com.raxrot.math.ExpressionEvaluator;

import java.io.IOException;
import java.util.Scanner;
public class Main {

    public static void main(String[] args) throws IOException {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Welcome in program Crypto calculator");

        boolean running = true;
        while (running) {
            showMenu();
            String option = scanner.nextLine();
            switch (option) {
                case "1":
                    handleCipher(true, scanner);
                    break;
                case "2":
                    handleCipher(false, scanner);
                    break;
                case "3":
                    calculateExpression(scanner);
                    break;
                case "4":
                    running = false;
                    break;
                case "5":
                    bruteForce(scanner);
                    break;
                default:
                    System.out.println("Error!");
            }
        }

        System.out.println("Bye!)");
        scanner.close();
    }

    private static void showMenu() {
        System.out.println("Main Menu: \n1.Encrypt \n2.Decrypt \n3.Calculate expression \n4.Exit \n5.Brute force");
    }

    // Handle encryption/decryption
    private static void handleCipher(boolean isEncrypt, Scanner scanner) throws IOException {

            System.out.println("input method: \n1.type \n2.read \nPlease choose");
            String inputMethod = scanner.nextLine();

            String text;
            if (inputMethod.equals("1")) {
                System.out.print("Enter text");
                text = scanner.nextLine();
            } else if (inputMethod.equals("2")) {
                System.out.print("Peek file path");
                String path = scanner.nextLine();
                text = CaesarFileHandler.readFileContent(path);
                System.out.println("File content");
                System.out.println(text);
            } else {
                System.out.println("Error");
                return;
            }

            System.out.print("Shift");
            int shift = Integer.parseInt(scanner.nextLine());

            String result= isEncrypt?CaesarCipher.encrypt(text, shift):CaesarCipher.decrypt(text, shift);
            System.out.println("result");
            System.out.println(result);

            if (inputMethod.equals("2")) {
                System.out.print("Save result to file? ([y]/[n])");
                String saveChoice = scanner.nextLine().toLowerCase();

                if (saveChoice.equals("y")) {
                    String outPath = scanner.nextLine();
                    CaesarFileHandler.saveToFile(outPath, result);
                    System.out.println("saved to file");
                }
            }
        }

    private static void calculateExpression(Scanner scanner) {
        System.out.print("Enter expression:");
        String expression = scanner.nextLine();
        double result = ExpressionEvaluator.evaluate(expression);
        System.out.println("Result is: " + result);
    }
    private static void bruteForce(Scanner scanner) throws IOException {
        System.out.println("Brute force decrypt.Chose \n1-print \n2-read \nplease choose");
        String myInput = scanner.nextLine();
        String text;
        if (myInput.equals("1")) {
            System.out.print("Enter text");
            text = scanner.nextLine();
        } else if (myInput.equals("2")) {
            System.out.print("Enter filePath");
            String pathToFile = scanner.nextLine();
            text = CaesarFileHandler.readFileContent(pathToFile);
        } else {
            System.out.println("Error");
            return;
        }
        CaesarCipher.bruteForce(text);
    }
}
