package menu.commands.tasks.generics.andrew.generator;

import menu.commands.tasks.generics.andrew.ArrayListGeneric;
import menu.commands.tasks.generics.andrew.creatures.Human;
import menu.commands.tasks.generics.andrew.creatures.Minion;
import menu.commands.tasks.generics.andrew.creatures.Orc;

public class GenerateMinions {

    public ArrayListGeneric<Minion> createMinions(MinionStringConstant side, int quantity) {
        Minion minions;
        ArrayListGeneric<Minion> arrayListGeneric = new ArrayListGeneric<>();
        int healsPoint = MinionIntConstant.MINION_HP.getValue();

        switch (side) {
            case LIGHT_SIDE:
                for (int i = 0; i < quantity; i++) {
                    minions = new Human(
                            MinionUtils.generateName(side),
                            MinionUtils.generateAge(),
                            MinionUtils.generatePower(),
                            healsPoint);
                    arrayListGeneric.add(minions);
                }
                break;
            case DARK_SIDE:
                for (int i = 0; i < quantity; i++) {
                    minions = new Orc(
                            MinionUtils.generateName(side),
                            MinionUtils.generateAge(),
                            MinionUtils.generatePower(),
                            healsPoint);
                    arrayListGeneric.add(minions);
                }
                break;
        }
        return arrayListGeneric;
    }
}
