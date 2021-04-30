package menu.commands.tasks.generics.andrew;

import menu.commands.tasks.generics.andrew.creatures.Minion;

public class MinionUtils {

    public static void minionsInfo(ArrayListGeneric<Minion> minions) {
        for (int i = 0; i < minions.size(); i++) {
            Minion trooper = minions.get(i);
            System.out.println(trooper.info());
        }
    }
}
