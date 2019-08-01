package objects.pub.people;

abstract class Employee extends Human {
    private int experience;
    private int salary;

    Employee(int experience, int salary) {
        this.experience = experience;
        this.salary = salary;
    }

    abstract void doWork();

    @Override
    void introduceYourself() {
        System.out.println("Я работаю " + this.experience + " лет и получаю " + this.salary);
    }
}