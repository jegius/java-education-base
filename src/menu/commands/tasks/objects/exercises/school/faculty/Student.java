package menu.commands.tasks.objects.exercises.school.faculty;

public class Student extends Human {

    private String grade;

    public Student(String firstName,
                   String lastName,
                   String grade,
                   int age) {
        super(firstName, lastName, age);
        this.grade = grade;
    }


    @Override
    void doWork() {
        this.introduceYourself();
        System.out.println("Students learn subject");
    }

    @Override
    public String toString() {
        return "Student: " + super.getFirstName() + " " + super.getLastName();
    }

    public String getGrade() {
        return grade;
    }

    public void setGrade(String grade) {
        this.grade = grade;
    }

    @Override
    public boolean equals(Object obj) {
        if (!this.getClass().getName().equals(obj.getClass().getName())) {
            return false;
        }
        Student student = (Student) obj;
        return this.getFirstName().equals(student.getFirstName()) &&
                this.getLastName().equals(student.getLastName()) &&
                this.getAge() == student.getAge() &&
                this.getGrade().equals(student.getGrade());
    }
}
