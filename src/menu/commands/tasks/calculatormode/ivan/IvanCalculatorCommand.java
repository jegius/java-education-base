package menu.commands.tasks.calculatormode.ivan;

import menu.Command;
import menu.commands.tasks.TaskMenuCommand;
import menu.commands.tasks.calculatormode.CalculatorModeCommand;
import menu.utils.MenuUtils;

import java.util.Scanner;

public class IvanCalculatorCommand implements Command  {

        private static IvanCalculatorCommand instance;
        private static Calculator calculator;

        private IvanCalculatorCommand() {
        }

        public static synchronized IvanCalculatorCommand getInstance() {
            if (instance == null) {
                instance = new IvanCalculatorCommand();
                calculator = new Calculator(instance);
            }
            return instance;
        }

        @Override
        public Command execute() {
            MenuUtils.printSeparator();
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

                default:
                    System.out.println("Unexpected Task!");
                    return this;
        }
    }

}
