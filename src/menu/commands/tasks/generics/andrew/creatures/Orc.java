package menu.commands.tasks.generics.andrew.creatures;

import menu.commands.tasks.generics.andrew.generator.MinionStringEnum;

import java.util.Map;

public class Orc extends Minion {

    protected String side;

    public Orc(String name, int age, int power, int hp) {
        super(name, age, power, hp);
        this.side = MinionStringEnum.DARK_SIDE.getLine();
        this.objectName = this.getClass().getSimpleName();
    }

    public Orc(Map<String, String> minionMap) {
        super(minionMap);
        this.objectName = this.getClass().getSimpleName();
    }
}
