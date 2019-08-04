package menu.commands.tasks.calculator.alex;

import menu.commands.tasks.calculator.Workplace;

public class AlexWorkPlace implements Workplace {
    @Override
    public void start() {

        Calculator cal = new Calculator();
        System.out.println(cal.sum(20, 30));
        System.out.println(cal.subtraction(20, 30));
        System.out.println(cal.multiply(20, 30));
        System.out.println(cal.division(20, 2));
        System.out.println(cal.pow(2, 3));
        System.out.println(cal.sqrt(16));
        System.out.println(cal.triangle(3));
        System.out.println(cal.factorial(4));
    }
}
