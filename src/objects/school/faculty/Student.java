package objects.school.faculty;

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

    public String getGrade() {
        return grade;
    }

    public void setGrade(String grade) {
        this.grade = grade;
    }
}
