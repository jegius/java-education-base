package menu.commands.tasks.calculatormode.max;

import java.util.Scanner;

public class Calculator {

    private MaxCalculatorCommand calculatorCommand;
    private static Scanner scanner;

    Calculator(MaxCalculatorCommand instance) {
        scanner = new Scanner(System.in);
        this.calculatorCommand = instance;
    }

    MaxCalculatorCommand sqrt() {
        System.out.println("Введите число для вычисления корня: ");
        System.out.print(">: ");

        try {
            int number = scanner.nextInt();
            double result = getSqrt(number);

            if (number < 0) {
                System.out.println("Извлечь корень из отрицательного числа нельзя!");
            }

            else
            System.out.println("[" + result + "] корень для [" + number + "]");

        } catch (Exception exception) {
            System.out.println("Пожалуйста, введите только цифры!");
            scanner.next();
            sqrt();
        }

        return calculatorCommand;
    }

    MaxCalculatorCommand sum() {
        System.out.println("Введите 2 числа для вычисления суммы: ");
        System.out.print(">: ");

        try {
            long firstOperand = scanner.nextInt();
            long secondOperand = scanner.nextInt();
            double result = getSum(firstOperand, secondOperand);

            System.out.println("[" + result + "] сумма чисел [" + firstOperand + "] и [" + secondOperand + "]" );
        } catch (Exception exception) {
            System.out.println("Пожалуйста, введите только цифры!");
            scanner.next();
            sum();
        }

        return calculatorCommand;

    }

    private double getSqrt(long number) { return  Math.sqrt(number); }
    private double getSum(long firstOperand, long secondOperand) { return firstOperand + secondOperand; }
}
