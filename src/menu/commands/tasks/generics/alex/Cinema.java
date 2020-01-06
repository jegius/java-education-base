package menu.commands.tasks.generics.alex;

import menu.commands.tasks.generics.alex.objects.ObjectGenerator;
import menu.commands.tasks.generics.alex.objects.Human;
import menu.commands.tasks.generics.alex.objects.Pupil;
import menu.commands.tasks.generics.alex.objects.Worker;

public class Cinema {

    private static Cinema instance;

    private AlexGenArrayList<Human> cinema;

    public static synchronized Cinema getInstance() {
        if (instance == null) {
            instance = new Cinema();
        }
        return instance;
    }

    public Cinema() {
        cinema = ObjectGenerator
                .<Human>newArrayBuilder()
                .generateObjects(2, Worker.class)
                .generateObjects(2, Pupil.class)
                .build();
    }

    public void showCinema() {
        cinema.printElements();
    }

    public AlexGenArrayList getCinema() {
        return cinema;
    }
}
