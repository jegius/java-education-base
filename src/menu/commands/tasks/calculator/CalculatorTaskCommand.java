package menu.commands.tasks.calculator;

import menu.Command;
import menu.commands.tasks.TaskMenuCommand;
import menu.utils.MenuUtils;

import java.util.Scanner;

public class CalculatorTaskCommand implements Command {

    private static CalculatorTaskCommand instance;

    private CalculatorTaskCommand() {
    }

    public static synchronized CalculatorTaskCommand getInstance() {
        if (instance == null) {
            instance = new CalculatorTaskCommand();
        }
        return instance;
    }

    @Override
    public Command execute() {
        MenuUtils.printSeparator();
        MenuUtils.printOption("1", "Run Alex calculator");
        MenuUtils.printOption("2", "Run example calculator");
        MenuUtils.printOption("0", "Back");
        MenuUtils.printSeparator();
        MenuUtils.printPrompt();

        Scanner scanner = new Scanner(System.in);
        int choice = scanner.nextInt();

        switch (choice) {
            case 0:
                return TaskMenuCommand.getInstance();
            case 1:
                WorkplaceFactory
                        .getInstance()
                        .createWorkplace(Executor.ALEX)
                        .start();
                return this;
            case 2:
                WorkplaceFactory
                        .getInstance()
                        .createWorkplace(Executor.IVAN)
                        .start();
                return this;


            default:
                System.out.println("Unexpected Task!");
                return this;
        }
    }
}
