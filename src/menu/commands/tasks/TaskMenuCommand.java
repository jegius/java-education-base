package menu.commands.tasks;

import menu.Command;
import menu.MainMenuCommand;
import menu.commands.tasks.calculator.CalculatorTaskCommand;
import menu.commands.tasks.calculatormode.CalculatorModeCommand;
import menu.commands.tasks.objects.ObjectsTaskCommand;
import menu.utils.MenuUtils;

import java.util.Scanner;

public class TaskMenuCommand implements Command {

    private static TaskMenuCommand instance;

    private TaskMenuCommand() {}

    public static synchronized TaskMenuCommand getInstance() {
        if (instance == null) {
            instance = new TaskMenuCommand();
        }
        return instance;
    }

    @Override
    public Command execute() {
        MenuUtils.printSeparator();
        MenuUtils.printOption("1", "Show object theme task");
        MenuUtils.printOption("2", "Show simple calculator");
        MenuUtils.printOption("3", "Show calculator mode");
        MenuUtils.printOption("0", "Back");
        MenuUtils.printSeparator();
        MenuUtils.printPrompt();

        Scanner scanner = new Scanner(System.in);
        int choice = scanner.nextInt();

        switch (choice) {
            case 0:
                return MainMenuCommand.getInstance();
            case 1:
                return ObjectsTaskCommand.getInstance();
            case 2:
                return CalculatorTaskCommand.getInstance();
            case 3:
                return CalculatorModeCommand.getInstance();
            default:
                System.out.println("Unexpected command!");
                return this;
        }
    }
}
