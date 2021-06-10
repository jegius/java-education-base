package menu.commands.tasks.generics.andrew.creatures;

import menu.commands.tasks.generics.andrew.generator.MinionStringConstant;

import java.util.Map;

public class Human extends Minion {

    protected String side;

    public Human(String name, int age, int power, int hp) {
        super(name, age, power, hp);
        this.side = MinionStringConstant.LIGHT_SIDE.getLine();
        this.objectName = this.getClass().getSimpleName();
    }

    public Human(Map<String, String> minionMap) {
        super(minionMap);
        this.objectName = this.getClass().getSimpleName();
    }
}
