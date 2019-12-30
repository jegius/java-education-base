package menu.commands.tasks.generics.alex;

import menu.commands.tasks.generics.alex.objects.ObjectGenerator;
import menu.commands.tasks.generics.alex.objects.dogs.Dog;
import menu.commands.tasks.generics.alex.objects.dogs.PetDog;
import menu.commands.tasks.generics.alex.objects.dogs.WildDog;

public class DogShelter {

    private static DogShelter instance;

    private AlexGenArrayList<? super Dog> dogShelter;


    public static synchronized DogShelter getInstance() {
        if (instance == null) {
            instance = new DogShelter();
        }
        return instance;
    }

    public DogShelter() {
        dogShelter = ObjectGenerator
                .newArrayBuilder()
                .generateObjects(2, PetDog.class)
                .generateObjects(2, WildDog.class)
                .build();
    }

    public void showDogShelter() {
        dogShelter.printElements();
    }
    public AlexGenArrayList getDogShelter(){
        return dogShelter;
    }
}