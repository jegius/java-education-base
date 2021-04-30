package menu.commands.tasks.generics.andrew;


import menu.commands.tasks.generics.andrew.creatures.Minion;
import menu.commands.tasks.generics.andrew.generator.GenerateMinions;

public class Castle implements SidesActions {
    private static Castle instance;
    private static ArrayListGeneric<Minion> troopers;

    public static synchronized Castle getInstance() {
        if (instance == null) {
            instance = new Castle();
        }
        return instance;
    }


    public void showCastle() {
        GenerateMinions lightMinions = new GenerateMinions();
        troopers = lightMinions.createMinions("Light", 4);
        MinionUtils.minionsInfo(troopers);
    }

    public ArrayListGeneric<Minion> inToBattleField() {
        return troopers;
    }
}
