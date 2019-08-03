package menu.commands.tasks.objects.exercises.school.faculty;

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
        System.out.println("I'm " + this.firstName + " " + this.lastName + "! I'm " + age + " years old");
    }


}
