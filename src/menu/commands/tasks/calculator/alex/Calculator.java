package menu.commands.tasks.calculator.alex;

class Calculator {
    long sum(long operandOne, long operandTwo) {
        return operandOne + operandTwo;
    }

    long subtraction(long operandOne, long operandTwo) {
        return operandOne - operandTwo;
    }

    long multiply(long operandOne, long operandTwo) {
        return operandOne * operandTwo;
    }

    long division(long operandOne, long operandTwo) {
        return operandOne / operandTwo;
    }

    long pow(long number, long degree) {
        long initial = number;
        for (int index = 1; index < degree; index++) {
            number = number * initial;
        }
        return number;
    }

    long sqrt(long number) {
        long index;
        for (index = 1; index < number; index++) {
            long result = number / index;
            if (result == index) {
                break;
            }
        }
        return index;
    }

    long triangle(long number) {
        long result = 0;
        for (int index = 0; index < number; index++) {
            result += (number - index);
        }
        return result;
    }

    long factorial(long number) {
        long result = 1;
        for (long index = 1; index <= number; index++) {
            result = result * index;
        }
        return result;
    }
}
