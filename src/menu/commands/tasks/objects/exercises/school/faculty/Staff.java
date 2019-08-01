package menu.commands.tasks.objects.exercises.school.faculty;


public class Staff extends Human {
    private String position;

    public Staff(String firstName, String lastName, String position, int age) {
        super(firstName, lastName, age);
        this.position = position;
    }

    @Override
    void doWork() {
        this.introduceYourself();

        System.out.println("We are working in school");
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }
}
