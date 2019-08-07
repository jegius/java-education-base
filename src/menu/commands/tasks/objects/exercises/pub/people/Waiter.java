package menu.commands.tasks.objects.exercises.pub.people;

public class Waiter extends Employee {

    private Visitor[] subordinates;

    public Waiter(String name,
                  int age,
                  int experience,
                  Visitor[] subordinates,
                  int salary,
                  String seniority) {
        super(name, age, experience, salary, seniority);
        this.subordinates = subordinates;
    }

    public void doWork() {
        this.introduceYourself();

        System.out.println("Официант взял пиво и отнес посетителю");

        for(Visitor visitor : subordinates) {
            visitor.doWork();
        }
    }
}
