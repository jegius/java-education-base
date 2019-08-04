package menu.commands.tasks.calculatormode.ivan;

import java.util.Scanner;

class Calculator {

    private IvanCalculatorCommand calculatorCommand;
    private static Scanner scanner;

    Calculator(IvanCalculatorCommand instance) {
        scanner = new Scanner(System.in);
        this.calculatorCommand = instance;
    }

    IvanCalculatorCommand sqrt() {
        System.out.println("Enter the number for sqrt: ");
        System.out.print(">: ");

        try {
            int number = scanner.nextInt();
            double result = getSqrt(number);

            System.out.println("{" + result + "] is sqrt for [" + number + "]");
        } catch (Exception exception) {
            System.out.println("Please enter only numbers!");
            scanner.next();
            sqrt();
        }

        return calculatorCommand;
    }

    private double getSqrt(long number) {
        return Math.sqrt(number);
    }
}
