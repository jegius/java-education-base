package menu.commands.tasks.calculatormode.max;

import menu.Command;
import menu.commands.tasks.TaskMenuCommand;
import menu.commands.tasks.calculatormode.CalculatorModeCommand;
import menu.utils.MenuUtils;

import javax.swing.*;
import java.util.Scanner;

public class MaxCalculatorCommand implements Command {

        private static MaxCalculatorCommand instance;
        private static Calculator calculator;

        private MaxCalculatorCommand() {
        }

        public static synchronized MaxCalculatorCommand getInstance() {
            if (instance == null) {
                instance = new MaxCalculatorCommand();
                calculator = new Calculator(instance);
            }
            return instance;
        }

        @Override
        public Command execute() {
            MenuUtils.printSeparator();
            MenuUtils.printOption("1", "Вычислить корень");
            MenuUtils.printOption("2", "Вычислить сумму");
            MenuUtils.printOption("0", "Назад");
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
                    return calculator.sum();

                default:
                    System.out.println("Unexpected Task!");
                    return this;
            }
        }
}