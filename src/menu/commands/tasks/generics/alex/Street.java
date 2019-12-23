package menu.commands.tasks.generics.alex;

import menu.commands.tasks.generics.alex.objects.ObjectGenerator;
import menu.commands.tasks.generics.alex.objects.dogs.PetDog;
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
        street = new AlexGenArrayList();
        objectGenerator = new ObjectGenerator();
        objectGenerator.generateObjects(street,2, PetDog.class).generateObjects(street,4, Worker.class);
    }

    public void showStreet() {
        street.printElements();
    }

}
