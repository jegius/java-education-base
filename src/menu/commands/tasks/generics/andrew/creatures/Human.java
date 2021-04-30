package menu.commands.tasks.generics.andrew.creatures;

public class Human extends Minion {

    public Human(String side, String name, int age, int power, int hp) {
        super(side, name, age, power, hp);
    }

    @Override
    public String info() {
        return "Human " + this.name + "(" + this.hp + ")" + ", " + this.age + " years old, prepare to attack on " + this.power;
    }
}
