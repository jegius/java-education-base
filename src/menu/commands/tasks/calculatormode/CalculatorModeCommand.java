package menu.commands.tasks.calculatormode;

import menu.Command;
import menu.commands.tasks.TaskMenuCommand;
import menu.commands.tasks.calculatormode.alex.AlexCalculatorCommand;
import menu.commands.tasks.calculatormode.ivan.IvanCalculatorCommand;
import menu.commands.tasks.calculatormode.max.MaxCalculatorCommand;
import menu.utils.MenuUtils;

import java.util.Scanner;

public class CalculatorModeCommand implements Command {

    private static CalculatorModeCommand instance;

    private CalculatorModeCommand() {
    }

    public static synchronized CalculatorModeCommand getInstance() {
        if (instance == null) {
            instance = new CalculatorModeCommand();
        }
        return instance;
    }

    @Override
    public Command execute() {
        MenuUtils.printSeparator();
        MenuUtils.printOption("1", "Run example calculator mode");
        MenuUtils.printOption("2", "Run example Max calculator mode");
        MenuUtils.printOption("3", "Run Alex calculator mode");
        MenuUtils.printOption("0", "Back");
        MenuUtils.printSeparator();
        MenuUtils.printPrompt();

        Scanner scanner = new Scanner(System.in);
        int choice = scanner.nextInt();

        switch (choice) {
            case 0:
                return TaskMenuCommand.getInstance();
            case 1:
                return IvanCalculatorCommand.getInstance();
            case 2:
                return MaxCalculatorCommand.getInstance();
            case 3:
                return AlexCalculatorCommand.getInstance();

            default:
                System.out.println("Unexpected Task!");
                return this;
        }
    }
}
