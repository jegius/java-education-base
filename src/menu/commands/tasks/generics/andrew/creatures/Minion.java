package menu.commands.tasks.generics.andrew.creatures;

import menu.commands.tasks.generics.andrew.generator.MinionStringEnum;

import java.util.Map;

public abstract class Minion {
    String side;
    String name;
    int age;
    int power;
    int hp;

    public Minion(String name, int age, int power, int hp) {
        this.name = name;
        this.age = age;
        this.power = power;
        this.hp = hp;
    }

    public Minion(Map<String, String> minionMap) {
        this.side = minionMap.get(MinionStringEnum.SIDE.getLine());
        this.name = minionMap.get(MinionStringEnum.NAME.getLine());
        this.age = Integer.parseInt(minionMap.get(MinionStringEnum.AGE.getLine()));
        this.power = Integer.parseInt(minionMap.get(MinionStringEnum.POWER.getLine()));
        this.hp = Integer.parseInt(minionMap.get(MinionStringEnum.HP.getLine()));
    }

    public abstract String info();


    public String getSide() {
        return side;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
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
