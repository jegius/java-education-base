package menu.commands.tasks.calculator.Dimitii;

import menu.commands.tasks.calculator.Workplace;

public class WorkspaceDmitrii implements Workplace {
    public void start() {
        Calc calculater = new Calc();
        System.out.println(calculater.sum(10, 20));
        System.out.println(calculater.difference(10, 20));
        System.out.println(calculater.division(10, 20));
        System.out.println(calculater.multiplication(10, 20));
        System.out.println(calculater.pow(10, 20));
        System.out.println(calculater.sqrt(10));
        System.out.println(calculater.triangle(20));
        System.out.println(calculater.factorial(12));
    }
}
