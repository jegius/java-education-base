package menu.commands.tasks.generics.alex.objects.humans;

import menu.commands.tasks.generics.alex.objects.Creature;

public abstract class Human extends Creature {

    private String name;

    public Human(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return this.name + " ";
    }
}

