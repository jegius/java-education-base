package menu.commands.tasks.objects.exercises.school;

import menu.commands.tasks.objects.exercises.Organization;
import menu.commands.tasks.objects.exercises.school.faculty.Headmaster;
import menu.commands.tasks.objects.exercises.school.faculty.Staff;
import menu.commands.tasks.objects.exercises.school.faculty.Teacher;
import menu.commands.tasks.objects.exercises.school.faculty.Student;

public class School extends Organization {

    public void start() {

        Student studentOne = new Student("Bruce", "Lee", "5a", 10);
        Student studentTwo = new Student("Brandon", "Lee", "5a", 10);
        Student studentThree = new Student("Jessica", "Alba", "5a", 11);
        Student studentFour = new Student("Don", "Pablo", "5a", 9);
        Student studentFive = new Student("Alexey", "Oval'niy", "5a", 10);
        Student studentSix = new Student("Freddy", "Kruger", "5a", 9);

        Student[] groupOne = {
                studentOne,
                studentTwo,
                studentFive
        };

        Student[] groupTwo = {
                studentThree,
                studentFour,
                studentSix
        };

        Staff staffOne = new Staff("Ariana", "Grande", "Janitor", 25);
        Staff staffTwo = new Staff("Bruce", "Willis", "Accountant", 45);
        Staff staffThree = new Staff("Taylor", "Swift", "Cook", 27);
        Staff staffFour = new Staff("Barac", "Abama", "Manager", 19);
        Staff staffFive = new Staff("Harry", "Potter", "Security", 32);

        Staff[] staffGroupOne = {
                staffOne,
                staffTwo,
                staffThree,
                staffFour,
                staffFive
        };

        Teacher teacherOne = new Teacher("Rick", "Sanchez", "History", 43, "teacher", groupOne);
        Teacher teacherTwo = new Teacher("Konstantin", "Kadavr", "Science", 29, "teacher", groupTwo);

        Teacher[] teachersStaff = {
                teacherOne,
                teacherTwo
        };

        Headmaster headmaster = new Headmaster("Donald", "Duck", "headmaster", teachersStaff, staffGroupOne, 23);

        headmaster.doWork();
    }
}
