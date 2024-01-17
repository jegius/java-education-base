package menu.commands.tasks.calculator.kristina;

public class Calculator {

    //Сумма двух переданных в метод чисел
    public long sum(long firstOperand, long secondOperand) {
        return firstOperand + secondOperand;
    }

    //Разность двух переданных в метод чисел
    public long difference(long firstOperand, long secondOperand){
        return firstOperand - secondOperand;
    }

    //Результат деления одного переданного в метод числа на другое
    public long division(long firstOperand, long secondOperand){
        return firstOperand / secondOperand;
    }

    //Произведение одного переданного в метод числа на другое
    public long multiplication(long firstOperand, long secondOperand){
        return firstOperand * secondOperand;
    }

    //Возведение первого аргумента в степень указанную вторым аргументом
    public long pow(long firstOperand, long secondOperand){
        long numb = firstOperand;
        for (int i = 1; i < secondOperand; i++){
            firstOperand = firstOperand * numb;
        }
        return firstOperand;
    }

    //Нахождение квадратного корня числа переданного в метод
    public long sqrt(long number){
        long numb = 1;
        while (numb * numb <= number) {
            numb++;
        }
        return numb - 1;
    }

    //Нахождение треугольного числа переданного в метод
    public long triangle(long number){
        return number * (number + 1)/2;
    }

    //Нахождение факториала числа переданного в метод
    public long factorial(long number){
        for (long i = number - 1; i >= 1; i--) {
            number *= i;
        }
        return number;
    }
}
