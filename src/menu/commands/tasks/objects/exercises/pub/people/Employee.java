package menu.commands.tasks.objects.exercises.pub.people;

abstract class Employee extends Human {
    private int experience;
    private int salary;
    private String seniority;

    Employee(String name,
             int age,
             int experience,
             int salary,
             String seniority) {
        super(name, age);
        this.experience = experience;
        this.salary = salary;
        this.seniority = seniority;
    }

    abstract void doWork();

    @Override
    void introduceYourself() {
        System.out.println("Привет, меня зовут " + this.name + ", мне " + this.age + " лет. Я " + this.seniority + ". Я работаю " + this.experience + " лет и получаю " + this.salary + " $");
    }
}
