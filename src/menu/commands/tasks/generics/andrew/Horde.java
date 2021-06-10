package menu.commands.tasks.generics.andrew;

import menu.commands.tasks.generics.andrew.generator.MinionIntConstant;
import menu.commands.tasks.generics.andrew.generator.MinionStringConstant;

public class Horde extends BattleSide {

    private static Horde instance;

    public Horde() {
        this.side = MinionStringConstant.DARK_SIDE;
        this.amount = MinionIntConstant.MINION_AMOUNT.getValue();
    }

    public static synchronized Horde getInstance() {
        if (instance == null) {
            instance = new Horde();
        }
        return instance;
    }
}
