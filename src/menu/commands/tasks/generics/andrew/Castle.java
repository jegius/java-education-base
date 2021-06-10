package menu.commands.tasks.generics.andrew;

import menu.commands.tasks.generics.andrew.generator.MinionIntConstant;
import menu.commands.tasks.generics.andrew.generator.MinionStringConstant;

public class Castle extends BattleSide {

    private static Castle instance;

    public Castle() {
        this.side = MinionStringConstant.LIGHT_SIDE;
        this.amount = MinionIntConstant.MINION_AMOUNT.getValue();
    }

    public static synchronized Castle getInstance() {
        if (instance == null) {
            instance = new Castle();
        }
        return instance;
    }
}
