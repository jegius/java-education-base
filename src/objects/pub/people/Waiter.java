package objects.pub.people;

public class Waiter extends Employee {

    private Visitor[] subordinates;

    public Waiter(int experience,
                  Visitor[] subordinates,
                  int salary) {
        super(experience, salary);
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