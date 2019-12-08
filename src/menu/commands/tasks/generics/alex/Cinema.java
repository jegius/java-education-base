package menu.commands.tasks.generics.alex;

import menu.commands.tasks.generics.alex.objects.humans.Human;
import menu.commands.tasks.generics.alex.objects.humans.HumanGenerator;

public class Cinema {

    private static Cinema instance;

    private HumanGenerator humanGenerator = new HumanGenerator();

    private AlexGenArrayList<Human> cinema = new AlexGenArrayList<>();

    public static synchronized Cinema getInstance() {
        if (instance == null) {
            instance = new Cinema();
        }
        return instance;
    }

    public Cinema() {
        this.cinema = humanGenerator.generateHumans(cinema);
    }

    public void showCinema() {
        cinema.printElements();
    }
}
