package objects.school.faculty;

public class Teacher extends Staff {

    private String subject;

    private Student[] schoolClasses;

    public Teacher(String firstName,
                   String lastName,
                   String subject,
                   int age,
                   String position,
                   Student[] schoolClasses) {
        super(firstName, lastName, position, age);
        this.subject = subject;
        this.schoolClasses = schoolClasses;
    }

    public void doWork() {
        this.introduceYourself();

        System.out.println("Teaches teach students");
        for (Student teacher : schoolClasses) {
            teacher.doWork();
        }

    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }
}
