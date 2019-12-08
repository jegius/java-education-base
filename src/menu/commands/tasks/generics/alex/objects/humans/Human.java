package menu.commands.tasks.generics.alex.objects.humans;

public abstract class Human {

    private String name;
    private int age;

    public Human(String name, int age) {
        this.name = name;

        this.age = age;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    @Override
    public String toString() {
        return this.name + " " + this.age;
    }
}

