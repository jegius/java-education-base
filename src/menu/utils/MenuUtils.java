package menu.utils;

import java.util.InputMismatchException;
import java.util.Scanner;

public class MenuUtils {

    public static void printSeparator() {
        System.out.println("--------------------------");
    }

    public static void printPrompt() {
        System.out.print("> ");
    }

    public static void printOption(String command, String name) {
        System.out.println(command + " - " + name);
    }

    public static void printOption(int command, String name) {
        System.out.println(command + " - " + name);
    }

    public static int getScannerChoice() {
        try {
            Scanner scanner = new Scanner(System.in);
            int choice = scanner.nextInt();
            return choice;
        } catch (InputMismatchException e) {
            System.out.println("Only numbers");
        }
        return getScannerChoice();
    }


    public static void printExecutors(Enum[] enums) {
        int counter = 0;
        for (Enum enumValue : enums) {
            printOption(counter++, enumValue.toString());
        }
    }
}