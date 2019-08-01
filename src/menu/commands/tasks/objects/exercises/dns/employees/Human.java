package menu.commands.tasks.objects.exercises.dns.employees;

abstract class Human {
    private String firstName;
    private String lastName;
    private int age;

    Human(String firstName, String lastName, int age) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.age = age;
    }

    abstract void doWork();

    void introduceYourself() {
        System.out.println("Я " + this.firstName + " " + this.lastName + ". Мне " + this.age + " лет.");
    }
}
