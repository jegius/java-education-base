package menu.commands.tasks.generics.alex;

import menu.commands.tasks.generics.alex.objects.ObjectGenerator;
import menu.commands.tasks.generics.alex.objects.dogs.WildDog;
import menu.commands.tasks.generics.alex.objects.humans.Pupil;
import menu.commands.tasks.generics.alex.objects.humans.Worker;

public class Street {
    private AlexGenArrayList street;
    private static Street instance;

    public static synchronized Street getInstance() {
        if (instance == null) {
            instance = new Street();
        }
        return instance;
    }

    public Street() {

        street = ObjectGenerator
                .newArrayBuilder()
                .generateObjects(4, Worker.class)
                .generateObjects(1, Pupil.class)
                .generateObjects(4, WildDog.class)
                .build();
    }

    public void showStreet() {
        street.printElements();
    }
    public AlexGenArrayList getStreet(){
        return street;
    }

}
