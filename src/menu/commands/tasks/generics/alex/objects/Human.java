package menu.commands.tasks.generics.alex.objects;

public abstract class Human extends Creature {

    String name;

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return this.name + " ";
    }
}

