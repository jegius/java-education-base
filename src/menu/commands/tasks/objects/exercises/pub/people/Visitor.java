package menu.commands.tasks.objects.exercises.pub.people;

public class Visitor extends Human {

    public Visitor(String name,
                   int age) {
        super(name, age);
    }

    @Override
    void doWork() {
        this.introduceYourself();

        System.out.println("Посетитель забирает стакан");
    }
}