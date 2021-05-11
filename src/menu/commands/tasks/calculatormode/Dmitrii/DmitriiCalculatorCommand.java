package menu.commands.tasks.calculatormode.Dmitrii;

import menu.Command;
import menu.commands.tasks.calculatormode.CalculatorModeCommand;

import menu.utils.MenuUtils;

import java.util.Scanner;


public class DmitriiCalculatorCommand implements Command {
    private static DmitriiCalculatorCommand instance;
    private static Calculator calculator;

    public static synchronized DmitriiCalculatorCommand getInstance() {
        if (instance == null) {
            instance = new DmitriiCalculatorCommand();
            calculator = new Calculator(instance);
        }
        return instance;
    }

    @Override
    public Command execute() {
        MenuUtils.printSeparator();
        MenuUtils.printOption("1", "Команда Сумма");
        MenuUtils.printOption("2", "Команда Вычитание");
        MenuUtils.printOption("3", "Команда Деление");
        MenuUtils.printOption("4", "Команда Умножение");
        MenuUtils.printOption("5", "Команда Квадратного корня");
        MenuUtils.printOption("6", "Команда Степень числа");
        MenuUtils.printOption("7", "Команда Логарифм числа");
        MenuUtils.printOption("8", "Команда Синус угла");
        MenuUtils.printOption("9", "Команда Косинус угла");
        MenuUtils.printOption("10", "Команда Тангенс угла");
        MenuUtils.printOption("0", "Назад");
        MenuUtils.printSeparator();
        MenuUtils.printPrompt();

        Scanner scanner = new Scanner(System.in);
        int in = scanner.nextInt();
        switch (in) {
            case 0:
                return CalculatorModeCommand.getInstance();
            case 1:
                return calculator.sum();
            case 2:
                return calculator.subtraction();
            case 3:
                return calculator.division();
            case 4:
                return calculator.multiplication();
            case 5:
                return calculator.sqrt();
            case 6:
                return calculator.pow();
            case 7:
                return calculator.log();
            case 8:
                return calculator.sin();
            case 9:
                return calculator.cos();
            case 10:
                return calculator.tan();

            default:
                System.out.println("Неверный ввод");
                return this;
        }

    }
}
