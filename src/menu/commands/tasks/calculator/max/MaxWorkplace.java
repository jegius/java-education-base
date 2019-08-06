package menu.commands.tasks.calculator.max;

import menu.commands.tasks.calculator.Workplace;

public class MaxWorkplace implements Workplace {

    @Override
    public void start() {

        Calculator calculator = new Calculator();
        System.out.println(calculator.sum(40, 10));
        System.out.println(calculator.dif(40, 25));
        System.out.println(calculator.div(50, 23));
        System.out.println(calculator.multi(32, 120));
        System.out.println(calculator.pow(14, 9));
        System.out.println(calculator.sqrt(169));
        System.out.println(calculator.triangle(7));
        System.out.println(calculator.factorial(10));
    }
}
