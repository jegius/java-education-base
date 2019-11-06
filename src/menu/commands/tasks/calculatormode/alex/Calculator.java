package menu.commands.tasks.calculatormode.alex;

import menu.commands.tasks.calculatormode.CalculatorModeCommand;

import java.util.ArrayList;
import java.util.Scanner;
import java.util.List;

class Calculator {
    private AlexCalculatorCommand calculatorCommand;
    private static Scanner scanner;
    private static final String NUMBER = "number";
    private static final String POSITIVE_NUMBER = "positiveNumber";
    private static final String MINUS = "-";
    private static final String NO_ZERO = "0.0";

    Calculator(AlexCalculatorCommand instance) {
        scanner = new Scanner(System.in);
        this.calculatorCommand = instance;
    }

    public static List getDataNumber(
            String[] messages,
            String parameter,
            int numberOfOptionalElement,
            String optionalParameter
    ) {

        List<String> Numbers = new ArrayList<>();
        for (int index = 0; index < messages.length; index++) {
            System.out.println(messages[index]);
            if (index == (numberOfOptionalElement - 1) && numberOfOptionalElement != 0) {
                Numbers.add(getString(scanner, optionalParameter));
            } else {
                Numbers.add(getString(scanner, parameter));
            }
        }
        return Numbers;
    }

    public static String getString(Scanner scanner, String parameter) {
        try {
            if (parameter.equals(POSITIVE_NUMBER)) {
                double value = scanner.nextDouble();
                String positiveNumber = Double.toString(value);
                if (positiveNumber.contains(MINUS)) {
                    throw new IncorrectNumberFormatException("insert positive number");
                }
                return positiveNumber;
            } else if (parameter.equals(NUMBER)) {
                double value = scanner.nextDouble();
                String Number = Double.toString(value);
                return Number;
            } else if (parameter.equals(NO_ZERO)) {
                double value = scanner.nextDouble();
                String noZeroNumber = Double.toString(value);
                if (noZeroNumber.equals(NO_ZERO)) {
                    throw new ZeroNumberFormatException("Can't divide on Zero");
                }
                return noZeroNumber;
            }

        } catch (IncorrectNumberFormatException exception) {
            System.out.println(exception.getMessage());
            return getString(scanner, parameter);
        } catch (ZeroNumberFormatException exception) {
            System.out.println(exception.getMessage());
            return getString(scanner, parameter);

        } catch (Exception exception) {
            System.out.println("Insert only NUMBER");
            scanner.next();
            return getString(scanner, parameter);
        }
        return null;
    }

    AlexCalculatorCommand sqrt() {
        String[] sqrtMessage = {"insert number for sqrt"};
        List<String> num = getDataNumber(sqrtMessage, POSITIVE_NUMBER, 0, null);
        double numOne = Double.parseDouble(num.get(0));
        System.out.println("sqrt is " + getSqrt(numOne));
        return calculatorCommand;
    }

    private double getSqrt(double number) {
        return Math.sqrt(number);
    }

    AlexCalculatorCommand division() {
        String[] sqrtMessage = {"insert Dividend", "insert Divider"};
        List<String> num = getDataNumber(sqrtMessage, NUMBER, 2, NO_ZERO);
        double dividend = Double.parseDouble(num.get(0));
        double divider = Double.parseDouble(num.get(1));
        System.out.println("division is " + getDivision(dividend, divider));
        return calculatorCommand;
    }

    private double getDivision(double dividend, double divider) {
        return dividend / divider;
    }

    AlexCalculatorCommand sum() {
        String[] sqrtMessage = {"insert first number", "insert second number"};
        List<String> num = getDataNumber(sqrtMessage, NUMBER, 0, null);
        double firstOperand = Double.parseDouble(num.get(0));
        double secondOperand = Double.parseDouble(num.get(1));
        System.out.println("Sum is " + getSum(firstOperand, secondOperand));
        return calculatorCommand;
    }

    private double getSum(double firstOperand, double secondOperand) {
        return firstOperand + secondOperand;
    }

    AlexCalculatorCommand subtraction() {
        String[] sqrtMessage = {"insert first number", "insert second number"};
        List<String> num = getDataNumber(sqrtMessage, NUMBER, 0, null);
        double firstOperand = Double.parseDouble(num.get(0));
        double secondOperand = Double.parseDouble(num.get(1));
        System.out.println("Subtraction is " + getSubtraction(firstOperand, secondOperand));
        return calculatorCommand;
    }

    private double getSubtraction(double firstOperand, double secondOperand) {
        return firstOperand - secondOperand;
    }

    AlexCalculatorCommand multiply() {
        String[] sqrtMessage = {"insert first number", "insert second number"};
        List<String> num = getDataNumber(sqrtMessage, NUMBER, 0, null);
        double firstOperand = Double.parseDouble(num.get(0));
        double secondOperand = Double.parseDouble(num.get(1));
        System.out.println("Multiplication is " + getMultiply(firstOperand, secondOperand));
        return calculatorCommand;
    }

    private double getMultiply(double firstOperand, double secondOperand) {
        return firstOperand * secondOperand;
    }
}
