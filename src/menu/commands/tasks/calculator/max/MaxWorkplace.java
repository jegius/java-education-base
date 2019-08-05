package menu.commands.tasks.calculator.max;

import menu.commands.tasks.calculator.Workplace;

public class MaxWorkplace implements Workplace {

    @Override
    public void start() {

        Calculator calculator = new Calculator();
        System.out.println(calculator.sum(40, 10));
    }
}
