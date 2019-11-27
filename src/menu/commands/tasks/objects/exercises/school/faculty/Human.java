package menu.commands.tasks.objects.exercises.school.faculty;

public abstract class Human {
    private String firstName;
    private String lastName;
    private int age;

    Human(String firstName, String lastName, int age) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.age = age;
    }

    abstract void doWork();

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public int getAge() {
        return age;
    }

    void introduceYourself() {
        System.out.println("I'm " + this.firstName + " " + this.lastName + "! I'm " + age + " years old");
    }

    @Override
    public boolean equals(Object obj) {
        return super.equals(obj);
    }
}
