package menu.commands.tasks.calculatormode.alex;

import menu.Command;
import menu.commands.tasks.calculatormode.CalculatorModeCommand;
import menu.utils.MenuUtils;

import java.util.Scanner;

public class AlexCalculatorCommand implements Command {
    public static AlexCalculatorCommand instance;
    public static Calculator calculator;

    private AlexCalculatorCommand() {
    }

    public static synchronized AlexCalculatorCommand getInstance() {
        if (instance == null) {
            instance = new AlexCalculatorCommand();
            calculator = new Calculator(instance);
        }
        return instance;
    }

    @Override
    public Command execute() {
        MenuUtils.printSeparator();
        MenuUtils.printOption("5", "Calculate multiply");
        MenuUtils.printOption("4", "Calculate subtraction");
        MenuUtils.printOption("3", "Calculate sum");
        MenuUtils.printOption("2", "Calculate division");
        MenuUtils.printOption("1", "Calculate sqrt");
        MenuUtils.printOption("0", "Back");
        MenuUtils.printSeparator();
        MenuUtils.printPrompt();

        Scanner scanner = new Scanner(System.in);
        int choice = scanner.nextInt();

        switch (choice) {
            case 0:
                return CalculatorModeCommand.getInstance();
            case 1:
                return calculator.sqrt();
            case 2:
                return calculator.division();
            case 3:
                return calculator.sum();
            case 4:
                return calculator.subtraction();
            case 5:
                return calculator.multiply();

            default:
                System.out.println("Unexpected Task!");
                return this;
        }
    }
}
