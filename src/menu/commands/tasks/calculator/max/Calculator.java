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
        long number = 1;
        for (long index = 1; index <= secondOperand; index++) {
            number *= firstOperand;
        }
        return number;
    }

    long sqrt(long number) {
        long index = 0;
        while (index*index < number) {
            index++;
        }
        return index;
    }

    long triangle(long number) {
        long triangular = 0;
        for (long index = 1; index <= number; index++) {
            triangular += index;
        }
        return triangular;
    }

    long factorial(long number) {
        long fac = 1;
        for (long index = 1; index <= number; index++) {
            fac *= index;
        }
        return fac;
    }
}
