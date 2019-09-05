package menu.commands.tasks.calculatormode.max;

import menu.commands.tasks.calculatormode.max.exceptions.IncorrectNumberFormatException;
import menu.commands.tasks.calculatormode.max.exceptions.ZeroException;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

public class Calculator {

    private static final String POSITIVE_NUMBER = "positiveNumber";
    private static final String NUMBER = "number";

    private static final String MINUS = "-";
    private static final String ZERO = "0.0";
    private MaxCalculatorCommand calculatorCommand;
    private static Scanner scanner;

    Calculator(MaxCalculatorCommand instance) {
        scanner = new Scanner(System.in);
        this.calculatorCommand = instance;
    }
    public static String getData(Scanner scanner, String parameter) {
        try {
            if(parameter.equals(POSITIVE_NUMBER)) {
                double input = scanner.nextDouble();
                String inputPositiveNumber = Double.toString(input);

                if (inputPositiveNumber.contains(MINUS)) {
                    throw new IncorrectNumberFormatException("Введеное число должно быть положительным!");
                }
                return Double.toString(input);
            } else if (parameter.equals(NUMBER)) {
                double inputNumber = scanner.nextDouble();
                return Double.toString(inputNumber);
            } else if (parameter.equals(ZERO)) {
                double inputNumber = scanner.nextDouble();
                String inputZero = Double.toString(inputNumber);
                if(inputZero.equals(ZERO)) {
                    throw new ZeroException("Нельзя вводить ноль!");
                }
                return inputZero;
            }

        } catch (IncorrectNumberFormatException e) {
            System.out.println(e.getMessage());
            return getData(scanner, parameter);
        } catch (InputMismatchException exception) {
            System.out.println("Пожалуйста, введите только цифры!");
            scanner.next();
            return getData(scanner, parameter);
        } catch (ZeroException e) {
            System.out.println(e.getMessage());
            return getData(scanner, parameter);
        }
        return null;
    }

    public static List getDataNumber(String [] messages, String param) {
        List<String> Numbers = new ArrayList<>(); {
            for (String i : messages) {
                System.out.println(i);
                Numbers.add(getData(scanner, param));
            }
        }
        return Numbers;
    }

    MaxCalculatorCommand sqrt() {
        String [] sqrtMessage = {"Введите число: "};
        List <String> value = getDataNumber(sqrtMessage, POSITIVE_NUMBER);
        double number = Double.parseDouble(value.get(0));
        double result = getSqrt(number);
        System.out.println("[" + result + "] результат вычисления корня числа [" + number + "]");

        return calculatorCommand;
    }

    MaxCalculatorCommand pow() {
        String [] powMessage = {"Введите число: ", "Введите степень: "};
        List <String> value = getDataNumber(powMessage, NUMBER);
        double number = Double.parseDouble(value.get(0));
        double degree = Double.parseDouble(value.get(1));
        double result = getPow(number, degree);
        System.out.println("[" + result + "] результат возведения числа [" + number + "] в степень [" + degree + "]");

        return calculatorCommand;
    }

    MaxCalculatorCommand division() {
        String [] divisionMessage = {"Введите делимое: ", "Введите делитель: "};
        List <String> value = getDataNumber(divisionMessage, ZERO);
        double firstOperand = Double.parseDouble(value.get(0));
        double secondOperand = Double.parseDouble(value.get(1));
        double result = getDivision(firstOperand, secondOperand);
        System.out.println("[" + result + "] результат деления числа [" + firstOperand + "] на [" + secondOperand + "]");

        return calculatorCommand;
    }

    MaxCalculatorCommand sum() {
        String [] sumMessage = {"Введите первое число: ", "Введите второе число: "};
        List <String> value = getDataNumber(sumMessage, NUMBER);
        double firstOperand = Double.parseDouble(value.get(0));
        double secondOperand = Double.parseDouble(value.get(1));
        double result = getSum(firstOperand, secondOperand);
        System.out.println("[" + result + "] результат суммы числа [" + firstOperand + "] и числа [" + secondOperand + "]");

        return calculatorCommand;
    }

    MaxCalculatorCommand difference() {
        String [] differenceMessage = {"Введите первое число: ", "Введите второе число: "};
        List <String> value = getDataNumber(differenceMessage, NUMBER);
        double firstOperand = Double.parseDouble(value.get(0));
        double secondOperand = Double.parseDouble(value.get(1));
        double result = getDifference(firstOperand, secondOperand);
        System.out.println("[" + result + "] результат разности числа [" + firstOperand + "] и числа [" + secondOperand + "]");

        return calculatorCommand;
    }

    MaxCalculatorCommand multiplication() {
        String [] multiplicationMessage = {"Введите первое число: ", "Введите второе число: "};
        List <String> value = getDataNumber(multiplicationMessage, NUMBER);
        double firstOperand = Double.parseDouble(value.get(0));
        double secondOperand = Double.parseDouble(value.get(1));
        double result = getMultiplication(firstOperand, secondOperand);
        System.out.println("[" + result + "] результат умножения числа [" + firstOperand + "] и числа [" + secondOperand + "]");

        return calculatorCommand;
    }

    MaxCalculatorCommand max() {
        String [] maxMessage = {"Введите первое число: ", "Введите второе число: "};
        List <String> value = getDataNumber(maxMessage, NUMBER);
        double firstOperand = Double.parseDouble(value.get(0));
        double secondOperand = Double.parseDouble(value.get(1));
        double result = getMax(firstOperand, secondOperand);
        System.out.println("[" + result + "] - максимальное число");

        return calculatorCommand;
    }

    MaxCalculatorCommand min() {
        String [] minMessage = {"Введите первое число: ", "Введите второе число: "};
        List <String> value = getDataNumber(minMessage, NUMBER);
        double firstOperand = Double.parseDouble(value.get(0));
        double secondOperand = Double.parseDouble(value.get(1));
        double result = getMin(firstOperand, secondOperand);
        System.out.println("[" + result + "] - минимальное число");

        return calculatorCommand;
    }

    MaxCalculatorCommand cbrt() {
        String [] cbrtMessage = {"Введите число: "};
        List <String> value = getDataNumber(cbrtMessage, NUMBER);
        double number = Double.parseDouble(value.get(0));
        double result = getCbrt(number);
        System.out.println("[" + result + "] результат вычисления кубического корня числа [" + number + "]");

        return calculatorCommand;
    }

    private double getSqrt(double number) { return Math.sqrt(number); }
    private double getPow(double number, double degree) { return Math.pow(number, degree); }
    private double getDivision (double firstOperand, double secondOperand) { return (firstOperand / secondOperand); }
    private double getSum(double firstOperand, double secondOperand) { return (firstOperand + secondOperand); }
    private double getDifference (double firstOperand, double secondOperand) { return (firstOperand - secondOperand);}
    private double getMultiplication (double firstOperand, double secondOperand) { return (firstOperand * secondOperand);}
    private double getMax(double firstOperand, double secondOperand) { return Math.max(firstOperand, secondOperand);}
    private double getMin(double firstOperand, double secondOperand) { return Math.min(firstOperand, secondOperand);}
    private double getCbrt(double number) { return Math.cbrt(number); }
}
