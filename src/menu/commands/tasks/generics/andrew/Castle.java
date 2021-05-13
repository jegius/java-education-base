package menu.commands.tasks.generics.andrew;

import menu.commands.tasks.generics.andrew.generator.MinionIntEnum;
import menu.commands.tasks.generics.andrew.generator.MinionStringEnum;

public class Castle extends BattleSide {

    private static Castle instance;

    public Castle() {
        this.side = MinionStringEnum.LIGHT_SIDE.getLine();
        this.amount = MinionIntEnum.MINION_AMOUNT.getValue();
    }

    public static synchronized Castle getInstance() {
        if (instance == null) {
            instance = new Castle();
        }
        return instance;
    }
}
