package menu.commands.tasks.generics.alex;

import menu.commands.tasks.generics.alex.objects.dogs.Dog;
import menu.commands.tasks.generics.alex.objects.dogs.DogGenerator;

public class DogShelter {

    private static DogShelter instance;

    private AlexGenArrayList<? super Dog> dogShelter = new AlexGenArrayList<>();

    private DogGenerator dogGenerator = new DogGenerator();

    public static synchronized DogShelter getInstance() {
        if (instance == null) {
            instance = new DogShelter();
        }
        return instance;
    }

    public DogShelter() {
        this.dogShelter = dogGenerator.dogsGenerator(dogShelter);
    }

    public void showDogShelter() {
        dogShelter.printElements();
    }
}