package menu.commands.tasks.calculator.Dimitii;

public class Calc {
    long sum(long firstOperand, long secondOperand) {
        return firstOperand + secondOperand;
    }

    long difference(long firstOperand, long secondOperand) {
        return firstOperand - secondOperand;
    }

    long division(long firstOperand, long secondOperand) {
        return firstOperand / secondOperand;
    }

    long multiplication(long firstOperand, long secondOperand) {
        return firstOperand * secondOperand;
    }

    long pow(long firstOperand, long secondOperand) {
        long resultOperand = 1;
        for (long i = 1; i <= secondOperand; i++) {
            resultOperand = resultOperand * firstOperand;
        }
        return resultOperand;
    }

    long sqrt(long number) {
        long i;
        for (i = 1; i < number; i++) {
            long result = number / i;
            if (result == i) {
                break;
            }
        }
        return i;
    }

    long triangle(long number) {
        return number / 2 * (number + 1);
    }

    long factorial(long number) {
        long fact = 1;
        for (long i = 1; i <= number; i++) {
            fact = fact * i;
        }
        return fact;
    }
}
