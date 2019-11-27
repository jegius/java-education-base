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

    @Override
    public String toString() {
        return "Staff: " + super.getFirstName() + " " + super.getLastName();
    }

    @Override
    public boolean equals(Object obj) {
        if (!this.getClass().getName().equals(obj.getClass().getName())) {
            return false;
        }
        Staff staff = (Staff) obj;
        return this.getFirstName().equals(staff.getFirstName()) &&
                this.getLastName().equals(staff.getLastName()) &&
                this.getAge() == staff.getAge() &&
                this.getPosition().equals(staff.getPosition());
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }
}
