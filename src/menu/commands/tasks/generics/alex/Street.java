package menu.commands.tasks.generics.alex;

import menu.commands.tasks.exceptions.OutOfArrayLength;
import menu.commands.tasks.generics.alex.objects.*;

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
                .<Creature>newArrayBuilder()
                .generateObjects(4, Worker.class)
                .generateObjects(1, Pupil.class)
                .generateObjects(4, WildDog.class)
                .build();
    }

    public void showStreet() {
        street.printElements();
    }

    public AlexGenArrayList getStreet() {
        return street;
    }

    public boolean compareStreet() {
        boolean result = false;
        try {
            result = street.compare(DogShelter
                            .getInstance()
                            .getDogShelter());
        } catch (OutOfArrayLength outOfArrayLength) {
            outOfArrayLength.printStackTrace();
        }
        return result;
    }
}
