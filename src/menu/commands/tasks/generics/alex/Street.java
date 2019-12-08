package menu.commands.tasks.generics.alex;

import menu.commands.tasks.generics.alex.objects.dogs.Dog;
import menu.commands.tasks.generics.alex.objects.dogs.DogGenerator;
import menu.commands.tasks.generics.alex.objects.humans.HumanGenerator;

public class Street {
    private AlexGenArrayList street;
    private HumanGenerator humanGenerator;
    private DogGenerator dogGenerator;

    private static Street instance;

    public static synchronized Street getInstance() {
        if (instance == null) {
            instance = new Street();
        }
        return instance;
    }

    public Street() {
        street = new AlexGenArrayList();
        humanGenerator = new HumanGenerator();
        dogGenerator = new DogGenerator();
        street = humanGenerator.generateHumans(street);
        street = dogGenerator.dogsGenerator(street);
    }

    public void showStreet() {
        street.printElements();
    }

}
