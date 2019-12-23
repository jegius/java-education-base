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

    private AlexGenArrayList<Human> cinema = new AlexGenArrayList<Human>();

    public static synchronized Cinema getInstance() {
        if (instance == null) {
            instance = new Cinema();
        }
        return instance;
    }

    public Cinema() {
        objectGenerator = new ObjectGenerator();
        objectGenerator.generateObjects(cinema, 2, Worker.class)
                .generateObjects(cinema, 2, Pupil.class);
    }

    public void showCinema() {
        cinema.printElements();
    }
}
