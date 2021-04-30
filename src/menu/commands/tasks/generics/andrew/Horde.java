package menu.commands.tasks.generics.andrew;

import menu.commands.tasks.generics.andrew.creatures.Minion;
import menu.commands.tasks.generics.andrew.generator.GenerateMinions;

public class Horde implements SidesActions {

    private static Horde instance;
    private static ArrayListGeneric<Minion> grunts;

    public static synchronized Horde getInstance() {
        if (instance == null) {
            instance = new Horde();
        }
        return instance;
    }

    public void showHorde() {
        GenerateMinions darkMinions = new GenerateMinions();
        grunts = darkMinions.createMinions("Dark", 4);
        MinionUtils.minionsInfo(grunts);
    }

    @Override
    public ArrayListGeneric<Minion> inToBattleField() {
        return grunts;
    }
}
