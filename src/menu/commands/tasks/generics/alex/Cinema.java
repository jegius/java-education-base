package menu.commands.tasks.generics.alex;

import menu.commands.tasks.generics.alex.objects.ObjectGenerator;
import menu.commands.tasks.generics.alex.objects.dogs.PetDog;
import menu.commands.tasks.generics.alex.objects.dogs.WildDog;
import menu.commands.tasks.generics.alex.objects.humans.Human;
import menu.commands.tasks.generics.alex.objects.humans.Pupil;
import menu.commands.tasks.generics.alex.objects.humans.Worker;

public class Cinema {

    private static Cinema instance;

    private ObjectGenerator objectGenerator;

    private AlexGenArrayList<Human> cinema;

    public static synchronized Cinema getInstance() {
        if (instance == null) {
            instance = new Cinema();
        }
        return instance;
    }

    public Cinema() {
        objectGenerator = new ObjectGenerator();
        cinema = objectGenerator.generateObjects(2, Worker.class).
                generateObjects(2, Pupil.class).build();
    }

    public void showCinema() {
        cinema.printElements();
    }
}
