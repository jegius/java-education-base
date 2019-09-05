package menu.commands.littletasks.alexnurseryforcats;

import java.util.ArrayList;
import java.util.List;

public class CatShelter {
    public List<Cat> catInTheShelter;
    private static CatShelter instance;

    private CatShelter() {
        this.catInTheShelter = new ArrayList<>();
    }

    public static CatShelter getInstance() {
        if (instance == null) {
            instance = new CatShelter();
        }
        return instance;
    }

    public void addCatsToShelter(List<Cat> cats) {
        this.catInTheShelter.addAll(cats);
    }

    public void showAllCats() {
        for (Cat cat : catInTheShelter) {
            System.out.println(cat);
        }
    }
}
