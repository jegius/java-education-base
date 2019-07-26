package objects.factory.employees;

public class Master extends Employee {

    private Employee[] subordinates;

    public Master(String firstName,
           String lastName,
           String seniority,
           Employee[] subordinates,
           int age) {
        super(firstName, lastName, seniority, age);
        this.subordinates = subordinates;
    }

    public void doWork() {
        this.introduceYourself();

        System.out.println("Мастер раздал приказы подчиненным!");

        for (Employee employee : subordinates) {
            employee.doWork();
        }
    }
}
