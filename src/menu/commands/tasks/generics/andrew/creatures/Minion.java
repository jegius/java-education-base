package menu.commands.tasks.generics.andrew.creatures;

import menu.commands.tasks.generics.andrew.generator.MinionUtils;

import java.util.Map;

public abstract class Minion {
    protected String objectName;
    private String name;
    private int age;
    private int power;
    private int hp;

    public Minion(String name, int age, int power, int hp) {
        this.name = name;
        this.age = age;
        this.power = power;
        this.hp = hp;
    }

    public Minion(Map<String, String> minionMap) {
        MinionUtils.juxtaposeFields(this, minionMap);
    }

    public String info() {
        return objectName + " " + this.name + "(" + this.hp + ")" + ", " + this.age + " years old, prepare to attack on " + this.power;
    }

    public String getName() {
        return name;
    }

    public int getPower() {
        return power;
    }

    public int getHp() {
        return hp;
    }

    public void setHp(int hp) {
        this.hp = hp;
    }
}
