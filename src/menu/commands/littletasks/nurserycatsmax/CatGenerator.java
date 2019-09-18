package menu.commands.littletasks.nurserycatsmax;

import java.util.ArrayList;
import java.util.List;

public class CatGenerator {
       private static String[] randomCatsName = {
               "Hector",
               "Jack",
               "Anton",
               "Lebowski",
               "Kisa",
               "Homer",
               "Simba",
               "Meshok",
               "Sherstyanoi"
       };
       private static String[] randomCatsAge = {"1 - 3", "4 - 6", "7 - 10", "11 - 15", "15 >"};
       private static int[] randomCatsWeight = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12};
       private static String[] randomCatsTemperament = {
               "Evil",
               "Stupid",
               "Smart",
               "Lazy",
               "Shy",
               "Sly",
               "Kind",
               "Greedy",
               "Revengeful"
       };

        public static List<Cat> getRandomCat() {
            int amountOfCats = (int) Math.floor(Math.random() * 5);

            List<Cat> cats = new ArrayList<>();
            for (int index = 0; index < amountOfCats; index++) {
                int indexForName = (int) Math.floor(Math.random() * randomCatsName.length);
                int indexForAge = (int) Math.floor(Math.random() * randomCatsAge.length);
                int indexForWeight = (int) Math.floor(Math.random() * randomCatsWeight.length);
                int indexForTemperament = (int) Math.floor(Math.random() * randomCatsTemperament.length);

            cats.add(new Cat(
                    randomCatsName[indexForName],
                    randomCatsAge[indexForAge],
                    randomCatsWeight[indexForWeight],
                    randomCatsTemperament[indexForTemperament]
                    ));
            }
            return cats;
    }
}
