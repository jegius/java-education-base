package menu.commands.tasks.generics.andrew.creatures;

public abstract class Minion {
    String side;
    String name;
    int age;
    int power;
    int hp;

    public Minion(String side, String name, int age, int power, int hp) {
        this.side = side;
        this.name = name;
        this.age = age;
        this.power = power;
        this.hp = hp;
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
