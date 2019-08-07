package menu.commands.tasks.calculator.max;

class Calculator {

    long sum(long firstOperand, long secondOperand) {
        return  firstOperand + secondOperand;
    }

    long dif(long firstOperand, long secondOperand) {
        return  firstOperand - secondOperand;
    }

    long div(long firstOperand, long secondOperand) {
        return  firstOperand / secondOperand;
    }

    long multi(long firstOperand, long secondOperand) {
        return  firstOperand * secondOperand;
    }

    long pow(long firstOperand, long secondOperand) {
        long degree = 1;
        for (long index = 1; index <= secondOperand; index++) {
            degree *= firstOperand;
        }
        return degree;
    }

    long sqrt(long number) {
        long multiply = 0;
        while (multiply*multiply < number) {
            multiply++;
        }
        return multiply;
    }

    long triangle(long number) {
        long triangular = 0;
        for (long index = 1; index <= number; index++) {
            triangular += index;
        }
        return triangular;
    }

    long factorial(long number) {
        long factorial = 1;
        for (long index = 1; index <= number; index++) {
            factorial *= index;
        }
        return factorial;
    }
}
