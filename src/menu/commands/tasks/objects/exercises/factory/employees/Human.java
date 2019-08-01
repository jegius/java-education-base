package menu.commands.tasks.objects.exercises.factory.employees;

abstract class Human {
    private String firstName;
    private String lastName;
    private int age;

    Human(String firstName, String lastName, int age) {
        this.age = age;
        this.firstName = firstName;
        this.lastName = lastName;
    }

    abstract void doWork();

    void introduceYourself() {
        System.out.println("Я " + this.firstName + " " + this.lastName + "! Мне " + this.age + " Лет.");
    }
}
