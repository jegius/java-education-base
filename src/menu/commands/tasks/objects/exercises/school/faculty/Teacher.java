package menu.commands.tasks.objects.exercises.school.faculty;

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

    @Override
    public String toString() {
        return "Teacher: " + super.getFirstName() + " " + super.getLastName();
    }

    public Student[] getSchoolClasses() {
        return schoolClasses;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    @Override
    public boolean equals(Object obj) {
        if (!this.getClass().getName().equals(obj.getClass().getName())) {
            return false;
        }
        Teacher teacher = (Teacher) obj;
        return this.getFirstName().equals(teacher.getFirstName()) &&
                this.getLastName().equals(teacher.getLastName()) &&
                this.getAge() == teacher.getAge() &&
                this.getSubject().equals(teacher.getSubject()) &&
                this.getSchoolClasses().length == teacher.getSchoolClasses().length;
    }
}
