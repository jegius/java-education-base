package menu.commands.tasks.generics.alex;

import menu.commands.tasks.exceptions.OutOfArrayLength;
import menu.commands.tasks.objects.exercises.school.faculty.*;

public class AlexShowCase {

    private static AlexShowCase instance;

    private AlexShowCase() {
    }

    public static synchronized AlexShowCase getInstance() {
        if (instance == null) {
            instance = new AlexShowCase();
        }
        return instance;
    }

    public void showCase() throws OutOfArrayLength {


        GenAlexArrayList<Human> listForShow = new GenAlexArrayList<>();
        GenAlexArrayList<Human> listForShow3 = new GenAlexArrayList<>();
        GenAlexArrayList<Human> listForShow2 = new GenAlexArrayList<>();

        listForShow.add(new Student(
                "Jackson",
                "Michael",
                "4",
                14));
        listForShow.add(new Teacher(
                "Kianu",
                "Rifffs",
                "Math",
                14,
                "Teacher",
                new Student[5]));
        listForShow.add(new Staff(
                "Vasya",
                "Katyshev",
                "Cleaner",
                14));
        listForShow.add(new Headmaster(
                "Jessica",
                "Alba",
                "Cleaner",
                new Teacher[5],
                new Staff[5],
                45));

        listForShow.printElements();

        listForShow2.add(new Student(
                "Jackson",
                "Michael",
                "4",
                14));
        listForShow2.add(new Teacher(
                "Kianu",
                "Rifffs",
                "Math",
                14,
                "Teacher",
                new Student[5]));
        listForShow2.add(new Staff(
                "Vasya",
                "Katyshev",
                "Cleaner",
                14));
        listForShow2.add(new Headmaster(
                "Jessica",
                "Alba",
                "Cleaner",
                new Teacher[5],
                new Staff[5],
                45));

        listForShow2.printElements();

        listForShow3.add(new Student(
                "Xam",
                "Rdip",
                "5",
                18
        ));
        listForShow3.add(new Staff(
                "Angel",
                "Marcello",
                "cleaner",
                23
        ));
        listForShow3.add(new Student(
                "Xam",
                "Rdip",
                "5",
                18
        ));
        listForShow3.add(new Staff(
                "Angel",
                "Marcello",
                "cleaner",
                23
        ));

        listForShow3.printElements();

        if (listForShow.compare(listForShow2)) {
            System.out.println("List 1 equals List 2");
        } else {
            System.out.println("List 1 does not equal List 2");
        }

        if (listForShow.compare(listForShow3)) {
            System.out.println("List 1 equals List 3");
        } else {
            System.out.println("List 1 does not equal List 3");
        }
    }
}
