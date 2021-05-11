package menu.commands.tasks.generics.andrew.generator;

import menu.commands.tasks.generics.andrew.ArrayListGeneric;
import menu.commands.tasks.generics.andrew.creatures.Human;
import menu.commands.tasks.generics.andrew.creatures.Minion;
import menu.commands.tasks.generics.andrew.creatures.Orc;

public class GenerateMinions {

    public ArrayListGeneric<Minion> createMinions(String side, int quantity) {
        Minion minions;
        ArrayListGeneric<Minion> arrayListGeneric = new ArrayListGeneric<>();
        if (side.equals(MinionStringEnum.LIGHT_SIDE.getLine())) {
            for (int i = 0; i < quantity; i++) {
                minions = new Human(side,
                        MinionUtils.generateName(side),
                        MinionUtils.generateAge(),
                        MinionUtils.generatePower(),
                        MinionIntEnum.MINION_HP.getValue());
                arrayListGeneric.add(minions);
            }
        }
        if (side.equals(MinionStringEnum.DARK_SIDE.getLine())) {
            for (int i = 0; i < quantity; i++) {
                minions = new Orc(side,
                        MinionUtils.generateName(side),
                        MinionUtils.generateAge(),
                        MinionUtils.generatePower(),
                        MinionIntEnum.MINION_HP.getValue());
                arrayListGeneric.add(minions);
            }
        }
        return arrayListGeneric;
    }


}
