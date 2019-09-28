package menu.utils;

import menu.commands.littletasks.regexp.regexp.Executor;

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

    public static void printExecutors(Enum[] enums) {
        int counter = 0;
        for(Enum enumValue : enums) {
            printOption(counter++, enumValue.toString());
        }
    }
}