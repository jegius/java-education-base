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
        int countCats = CatsConstant.COUNT_CATS_GENERATE.getValue();
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
        int minAge = CatsConstant.CATS_AGE_MIN.getValue();
        int maxAge = CatsConstant.CATS_AGE_MAX.getValue();
        return new Random().nextInt(maxAge - minAge) + minAge;
    }

    private static CatBreed getRandomBreed() {
        int random = new Random().nextInt((CatBreed.class).getEnumConstants().length);
        return (CatBreed.class).getEnumConstants()[random];
    }
}
