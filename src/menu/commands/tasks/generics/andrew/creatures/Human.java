package menu.commands.tasks.generics.andrew.creatures;

import java.util.Map;

public class Human extends Minion {

    public Human(String side, String name, int age, int power, int hp) {
        super(side, name, age, power, hp);
    }

    public Human(Map<String, String> minionMap) {
        super(minionMap);
    }

    @Override
    public String info() {
        return "Human " + this.name + "(" + this.hp + ")" + ", " + this.age + " years old, prepare to attack on " + this.power;
    }
}
