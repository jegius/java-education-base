package menu.commands.littletasks.alexnurseryforcats;

import java.util.ArrayList;
import java.util.List;

public class CatGenerator {
    private static String[] catNames = new String[]{
            "Alex",
            "Barsic",
            "Ivan",
            "Max",
            "Vika"
    };
    private static String[] catColors = new String[]{
            "White",
            "Black",
            "Ginger",
            "Bold",
            "Grey"
    };

    public static String getCatName(){
        int min = 0;
        int max = 5;
        int index = min + (int) (max * Math.random());
        return catNames[index];
    }

    public static String getCatColor(){
        int min = 0;
        int max = 5;
        int index = min + (int) (max * Math.random());
        return catColors[index];
    }

    public static int getCatAge(){
        int min = 1;
        int max = 15;
        int age = min + (int) (max * Math.random());
        return age;
    }
    public static List fillCats() {
        List<Object> cats = new ArrayList<>();
        for (int index = 0; index < 3; index++) {
            cats.add(new Cat(getCatAge(), getCatColor(), getCatName()));
        }
        return cats;
    }



}
