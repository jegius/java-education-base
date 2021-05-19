package menu.commands.littletasks.andrew.nurseryforcats;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class GenerateCats {

    private static final String[] names = {
            "Tiger",
            "Puss",
            "Smokey",
            "Misty",
            "Tigger",
            "Kitty",
            "Oscar",
            "Missy",
            "Max",
            "Ginger",
            "Felix",
            "Minka",
            "Moritz",
            "Charly",
            "Romeo",
            "Eve",
            "Susi",
            "Lisa",
            "Blacky",
            "Musch"};

    public static List<Cat> generate() {
        int countCats = 3;
        List<Cat> cats = new ArrayList<>();
        for (int i = 0; i < countCats; i++) {
            cats.add(new Cat(getRandomName(), getRandomAge(), getRandomBreed()));
        }
        return cats;
    }

    private static String getRandomName() {
        return names[new Random().nextInt(names.length)];
    }

    private static int getRandomAge() {
        int low = 1;
        int high = 18;
        return new Random().nextInt(high - low) + low;
    }

    private static CatBreed getRandomBreed() {
        int random = new Random().nextInt((CatBreed.class).getEnumConstants().length);
        return (CatBreed.class).getEnumConstants()[random];
    }
}
