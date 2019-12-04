package menu.commands.tasks.generics.objects.humans;

abstract class Human {

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
}

