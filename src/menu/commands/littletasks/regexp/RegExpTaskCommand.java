package menu.commands.littletasks.regexp;

import menu.Command;
import menu.commands.littletasks.LittleTaskCommand;
import menu.commands.littletasks.regexp.regexp.macher.RegExpMatcherRunner;
import menu.commands.littletasks.regexp.regexp.validator.ValidatorRunner;
import menu.utils.MenuUtils;

import java.util.Scanner;

public class RegExpTaskCommand implements Command {
    private static Command instance;

    public static Command getInstance() {
        if (instance == null) {
            instance = new RegExpTaskCommand();
        }
        return instance;
    }

    private RegExpTaskCommand() {
    }

    @Override
    public Command execute() {

        MenuUtils.printSeparator();
        MenuUtils.printOption("1", "Run regExp validator.");
        MenuUtils.printOption("2", "Run regExp matcher.");
        MenuUtils.printOption("0", "Back");
        MenuUtils.printSeparator();
        MenuUtils.printPrompt();

        Scanner scanner = new Scanner(System.in);
        int choice = scanner.nextInt();

        switch (choice) {
            case 0:
                return LittleTaskCommand.getInstance();
            case 1:
                return ValidatorRunner.getInstance();
            case 2:
                return RegExpMatcherRunner.getInstance();
            default:
                System.out.println("Unexpected command!");
                return this;
        }
    }
}
