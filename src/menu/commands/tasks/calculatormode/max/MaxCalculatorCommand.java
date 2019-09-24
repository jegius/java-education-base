package menu.commands.tasks.calculatormode.max;

import menu.Command;
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
            MenuUtils.printOption("3", "Вычислить разность");
            MenuUtils.printOption("4", "Операция умножения");
            MenuUtils.printOption("5", "Операция деления");
            MenuUtils.printOption("6", "Возведение в степень");
            MenuUtils.printOption("7", "Определение наибольшего значения из двух чисел");
            MenuUtils.printOption("8", "Определение наименьшего значения из двух чисел");
            MenuUtils.printOption("9", "Вычислить кубический корень");
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
                case 3:
                    return calculator.difference();
                case 4:
                    return calculator.multiplication();
                case 5:
                    return calculator.division();
                case 6:
                    return calculator.pow();
                case 7:
                    return calculator.max();
                case 8:
                    return calculator.min();
                case 9:
                    return calculator.cbrt();
                default:
                    System.out.println("Unexpected Task!");
                    return this;
            }
        }
}