package menu.commands.tasks.generics.alex.objects.dogs;

import menu.commands.tasks.generics.alex.AlexGenArrayList;

public class DogGenerator {

    private static final int amountOfDogs = 3;

    private String[] dogsNickNames = new String[]{
            "Barky",
            "Luci",
            "MAx",
            "Tyson",
            "Spark",
            "Sharky"
    };

    private String[] areas = new String[]{
            "City",
            "Forest",
            "Village",
            "Swamp",
            "Shore",
            "Near trash"
    };

    private String[] families = new String[]{
            "Jacksons",
            "Nicksons",
            "Willis",
            "Aflecks",
            "Andersons",
            "Jolies"
    };


    private int getRandomNumber() {
        int max = 5;
        return (int) (Math.random() * max);
    }

    public AlexGenArrayList dogsGenerator(AlexGenArrayList Dogs) {
        for (int index = 0; index < amountOfDogs; index++) {
            Dogs.add(singleDogGenerator(getRandomNumber()));
        }
        return Dogs;
    }

    private Dog singleDogGenerator(int type) {
        if (type % 2 == 0) {
            return new PetDog(dogsNickNames[getRandomNumber()], families[getRandomNumber()]);
        }
        return new WildDog(dogsNickNames[getRandomNumber()], areas[getRandomNumber()]);
    }
}
