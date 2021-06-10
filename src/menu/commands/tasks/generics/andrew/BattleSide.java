package menu.commands.tasks.generics.andrew;

import menu.commands.tasks.generics.andrew.creatures.Minion;
import menu.commands.tasks.generics.andrew.generator.GenerateMinions;
import menu.commands.tasks.generics.andrew.generator.MinionStringConstant;
import menu.commands.tasks.generics.andrew.generator.MinionUtils;

abstract public class BattleSide {
    protected MinionStringConstant side;
    protected int amount;
    private ArrayListGeneric<Minion> minions;

    public void showBattleSide() {
        GenerateMinions lightMinions = new GenerateMinions();
        minions = lightMinions.createMinions(side, amount);
        MinionUtils.minionsInfo(minions);
    }

    public ArrayListGeneric<Minion> inToBattleField() {
        if (minions == null) {
            return new ArrayListGeneric<>();
        }
        return minions;
    }

    public void setMinions(ArrayListGeneric<Minion> minions) {
        this.minions = minions;
    }
}
