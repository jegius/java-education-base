package menu.commands.tasks.objects.exercises.pub.people;

abstract class Employee extends Human {
    private String name;
    private int age;
    private int experience;
    private int salary;

    Employee(String name, int age, int experience, int salary) {
        this.name = name;
        this.age = age;
        this.experience = experience;
        this.salary = salary;
    }

    abstract void doWork();

    @Override
    void introduceYourself() {
        System.out.println("Привет, меня зовут " + this.name + ", мне " + this.age + " лет. " + "Я работаю " + this.experience + " лет и получаю " + this.salary + " $");
    }
}
