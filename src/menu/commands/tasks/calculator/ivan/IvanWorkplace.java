package menu.commands.tasks.calculator.ivan;

import menu.commands.tasks.calculator.Workplace;

public class IvanWorkplace implements Workplace {

    @Override
    public void start() {
        /*
         * Здесь необходимо создать экземлпяр калькулятора и вывести в консоль
         * все операции согласно readme.md в папке menu.commands.tasks.calculator
         * */

        Calculator calculator = new Calculator();

        System.out.println(calculator.sum(233, 33));
    }
}
