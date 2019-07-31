package objects.pub.people;

public class Barmen extends Employee  {

     private Waiter[] waiters;

     public Barmen(String Name,
                   Waiter[] waiters,
                   int age) {
         super(Name, age);
         this.waiters = waiters;
    }

    public void doWork () {
         introduceYourself();

        System.out.println("Бармен налил пива");

        for (Waiter waiter : waiters) {
            waiter.doWork();
        }
    }
}
