package menu.commands.tasks.generics.andrew.creatures;

import menu.commands.tasks.generics.andrew.generator.MinionUtils;

import java.util.Map;

public abstract class Minion {
    //FIXME выставил всем публичный доступ, так как нет возможности изменить поля у объекта
    public String side;
    public String name;
    public String objectName;
    public int age;
    public int power;
    public int hp;

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
