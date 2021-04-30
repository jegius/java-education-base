package menu.commands.tasks.generics.andrew.creatures;

public class Orc extends Minion {

    public Orc(String side, String name, int age, int power, int hp) {
        super(side, name, age, power, hp);
    }

    @Override
    public String info() {
        return "Orc " + this.name + "(" + this.hp + ")" + ", " + this.age + " years old, prepare to attack on " + this.power;
    }
}
