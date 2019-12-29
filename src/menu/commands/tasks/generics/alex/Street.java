package menu.commands.tasks.generics.alex;

import menu.commands.tasks.generics.alex.objects.ObjectGenerator;
import menu.commands.tasks.generics.alex.objects.dogs.PetDog;
import menu.commands.tasks.generics.alex.objects.dogs.WildDog;
import menu.commands.tasks.generics.alex.objects.humans.Pupil;
import menu.commands.tasks.generics.alex.objects.humans.Worker;

public class Street {
    private AlexGenArrayList street;
    private ObjectGenerator objectGenerator;
    private static Street instance;

    public static synchronized Street getInstance() {
        if (instance == null) {
            instance = new Street();
        }
        return instance;
    }

    public Street() {
        objectGenerator = new ObjectGenerator();
        street = objectGenerator.generateObjects(4, Worker.class)
                .generateObjects(1, Pupil.class)
                .generateObjects(4, WildDog.class)
                .build();
    }

    public void showStreet() {
        street.printElements();
    }

}
