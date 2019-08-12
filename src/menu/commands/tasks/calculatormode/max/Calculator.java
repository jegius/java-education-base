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

            System.out.println("[" + result + "] корень для [" + number + "]");
        } catch (ArithmeticException exception) {
            System.out.println("Извлечь корень из отрицательного числа нельзя!");
            scanner.next();
            sqrt();
        } catch (Exception exception) {
            System.out.println("Пожалуйста, введите только цифры!");
            scanner.next();
            sqrt();
        }

        return calculatorCommand;
    }

    MaxCalculatorCommand sum() {
        System.out.println("Введите 1-ое число: ");
        System.out.print(">: ");
        long firstOperand = scanner.nextInt();
        System.out.println("Введите 2-ое число: ");
        System.out.print(">: ");
        long secondOperand = scanner.nextInt();


        try {
            double result = getSum(firstOperand, secondOperand);

            System.out.println("[" + result + "] сумма чисел [" + firstOperand + "] и [" + secondOperand + "]" );
        } catch (Exception exception) {
            System.out.println("Пожалуйста, введите только цифры!");
            scanner.next();
            sum();
        }

        return calculatorCommand;

    }

    MaxCalculatorCommand difference() {
        System.out.println("Введите 1-ое число: ");
        System.out.print(">: ");
        long firstOperand = scanner.nextInt();
        System.out.println("Введите 2-ое число: ");
        System.out.print(">: ");
        long secondOperand = scanner.nextInt();

        try {
            double result = getDifference(firstOperand, secondOperand);

            System.out.println("[" + result + "] разность чисел [" + firstOperand + "] и [" + secondOperand + "]");
        } catch (Exception exception) {
            System.out.println("Пожалуйста, введите только цифры!");
            scanner.next();
            difference();
        }

        return calculatorCommand;

    }

    MaxCalculatorCommand multiplication() {
        System.out.println("Введите 1-ое число: ");
        System.out.print(">: ");
        long firstOperand = scanner.nextInt();
        System.out.println("Введите 2-ое число: ");
        System.out.print(">: ");
        long secondOperand = scanner.nextInt();

        try {
            double result = getMultiplication(firstOperand, secondOperand);

            System.out.println("[" + result + "] результат умножения чисел [" + firstOperand + "] и [" + secondOperand + "]");
        } catch (Exception exception) {
            System.out.println("Пожалуйста, введите только цифры!");
            scanner.next();
            multiplication();
        }

        return calculatorCommand;

    }

    MaxCalculatorCommand division() {
        System.out.println("Введите делимое число: ");
        System.out.print(">: ");
        long numerator = scanner.nextInt();
        System.out.println("Введите делитель: ");
        System.out.print(">: ");
        long denominator = scanner.nextInt();

        try {
            double result = getDivision(numerator, denominator);

            System.out.println("[" + result + "] результат деления чисел [" + numerator + "] и [" + denominator + "]");
        } catch (ArithmeticException exception) {
            System.out.println("Делить на ноль нельзя");
            scanner.next();
            division();
        } catch (Exception exception) {
            System.out.println("Пожалуйста, введите только цифры!");
            scanner.next();
            division();
        }

        return calculatorCommand;

    }

    MaxCalculatorCommand pow() {
        System.out.println("Введите число: ");
        System.out.print(">: ");
        double number = scanner.nextInt();
        System.out.println("Введите степень: ");
        System.out.print(">: ");
        double degree = scanner.nextInt();

        try {
            double result = getPow(number, degree);

            System.out.println("[" + result + "] результат возведения числа [" + number + "] в степень [" + degree + "]");
        } catch (Exception exception) {
            System.out.println("Пожалуйста, введите только цифры!");
            scanner.next();
            division();
        }

        return calculatorCommand;

    }

    MaxCalculatorCommand max() {
        System.out.println("Введите 1ое число: ");
        System.out.print(">: ");
        double firstOperand = scanner.nextInt();
        System.out.println("Введите 2ое число: ");
        System.out.print(">: ");
        double secondOperand = scanner.nextInt();

        try {
            double result = getMax(firstOperand, secondOperand);

            System.out.println("[" + result + "] наибольшее значение");
        } catch (Exception exception) {
            System.out.println("Пожалуйста, введите только цифры!");
            scanner.next();
            max();
        }

        return calculatorCommand;

    }

    MaxCalculatorCommand min() {
        System.out.println("Введите 1ое число: ");
        System.out.print(">: ");
        double firstOperand = scanner.nextInt();
        System.out.println("Введите 2ое число: ");
        System.out.print(">: ");
        double secondOperand = scanner.nextInt();

        try {
            double result = getMin(firstOperand, secondOperand);

            System.out.println("[" + result + "] наименьшее значение");
        } catch (Exception exception) {
            System.out.println("Пожалуйста, введите только цифры!");
            scanner.next();
            min();
        }

        return calculatorCommand;

    }

    MaxCalculatorCommand cbrt() {
        System.out.println("Введите число для вычисления кубического корня: ");
        System.out.print(">: ");
        double number = scanner.nextInt();

        try {
            double result = getCbrt(number);

            System.out.println("[" + result + "] кубический корень для [" + number + "]");
        } catch (Exception exception) {
            System.out.println("Пожалуйста, введите только цифры!");
            scanner.next();
            cbrt();
        }

        return calculatorCommand;

    }

    private double getSqrt(long number) { return  Math.sqrt(number); }
    private double getSum(long firstOperand, long secondOperand) { return firstOperand + secondOperand; }
    private double getDifference(long firstOperand, long secondOperand) { return firstOperand - secondOperand; }
    private double getMultiplication(long firstOperand, long secondOperand) { return  firstOperand * secondOperand; }
    private double getDivision(double numerator, double denominator) { return  numerator / denominator; }
    private double getPow(double number, double degree) { return Math.pow(number, degree); }
    private double getMax(double firstOperand, double secondOperand) { return Math.max(firstOperand, secondOperand); }
    private double getMin(double firstOperand, double secondOperand) { return Math.min(firstOperand, secondOperand); }
    private double getCbrt(double number) { return Math.cbrt(number); }
}
