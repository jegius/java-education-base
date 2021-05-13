package menu.commands.tasks.generics.andrew.creatures;

import menu.commands.tasks.generics.andrew.generator.MinionStringEnum;

import java.util.Map;

public class Human extends Minion {

    public Human(String name, int age, int power, int hp) {
        super(name, age, power, hp);
        this.side = MinionStringEnum.LIGHT_SIDE.getLine();
    }

    public Human(Map<String, String> minionMap) {
        super(minionMap);
    }

    @Override
    public String info() {
        return "Human " + this.name + "(" + this.hp + ")" + ", " + this.age + " years old, prepare to attack on " + this.power;
    }
}
