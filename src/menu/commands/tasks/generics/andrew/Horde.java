package menu.commands.tasks.generics.andrew;

import menu.commands.tasks.generics.andrew.generator.MinionIntEnum;
import menu.commands.tasks.generics.andrew.generator.MinionStringEnum;

public class Horde extends BattleSide {

    private static Horde instance;

    public Horde() {
        this.side = MinionStringEnum.DARK_SIDE;
        this.amount = MinionIntEnum.MINION_AMOUNT.getValue();
    }

    public static synchronized Horde getInstance() {
        if (instance == null) {
            instance = new Horde();
        }
        return instance;
    }
}
