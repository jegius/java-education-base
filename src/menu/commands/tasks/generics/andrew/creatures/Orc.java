package menu.commands.tasks.generics.andrew.creatures;

import menu.commands.tasks.generics.andrew.generator.MinionStringEnum;

import java.util.Map;

public class Orc extends Minion {

    public Orc(String name, int age, int power, int hp) {
        super(name, age, power, hp);
        this.side = MinionStringEnum.DARK_SIDE.getLine();
    }

    public Orc(Map<String, String> minionMap) {
        super(minionMap);
    }

    @Override
    public String info() {
        return "Orc " + this.name + "(" + this.hp + ")" + ", " + this.age + " years old, prepare to attack on " + this.power;
    }
}
