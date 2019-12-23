package menu.commands.tasks.generics.alex;

import menu.commands.tasks.generics.alex.objects.ObjectGenerator;
import menu.commands.tasks.generics.alex.objects.dogs.Dog;
import menu.commands.tasks.generics.alex.objects.dogs.PetDog;
import menu.commands.tasks.generics.alex.objects.dogs.WildDog;

public class DogShelter {

    private static DogShelter instance;

    private AlexGenArrayList<? super Dog> dogShelter = new AlexGenArrayList<>();
    private ObjectGenerator objectGenerator = new ObjectGenerator();

    public static synchronized DogShelter getInstance() {
        if (instance == null) {
            instance = new DogShelter();
        }
        return instance;
    }

    public DogShelter() {
        objectGenerator.generateObjects(dogShelter, 2, PetDog.class).generateObjects(dogShelter, 2, WildDog.class);
    }

    public void showDogShelter() {
        dogShelter.printElements();
    }
}