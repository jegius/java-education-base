package objects.school.faculty;

public class Headmaster extends Staff {
    private Teacher[] teachers;
    private Staff[] staffMembers;

    public Headmaster(String firstName,
                      String lastName,
                      String position,
                      Teacher[] teachers,
                      Staff[] staffMembers,
                      int age) {
        super(firstName, lastName, position, age);
        this.teachers = teachers;
        this.staffMembers = staffMembers;

    }

    public void doWork() {
        this.introduceYourself();
        System.out.println("Headmaster announced the beginning of the year");

        for (Teacher teacher : teachers) {
            teacher.doWork();
        }
        for (Staff staff : staffMembers) {
            staff.doWork();
        }

    }
}
