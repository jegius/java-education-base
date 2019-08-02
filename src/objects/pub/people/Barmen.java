package objects.pub.people;

public class Barmen extends Employee {

    private Waiter[] waiters;

    public Barmen(String name,
                  int age,
                  int experience,
                  Waiter[] waiters,
                  int salary) {
        super(name, age, experience, salary);
        this.waiters = waiters;
    }

    public void doWork() {
        this.introduceYourself();

        System.out.println("Бармен налил пива и отдал официанту");

        for (Waiter waiter : waiters) {
            waiter.doWork();
        }
    }
}
