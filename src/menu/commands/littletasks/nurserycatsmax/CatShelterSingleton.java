package menu.commands.littletasks.nurserycatsmax;

import java.util.ArrayList;
import java.util.List;

public class CatShelterSingleton {
    private static CatShelterSingleton instance;

    private List<Cat> houseOfCats;

    public static CatShelterSingleton getInstance() {
        if (instance == null) {
            instance = new CatShelterSingleton();
        }
        return instance;
    }

    private CatShelterSingleton() {
        this.houseOfCats = new ArrayList<>();
    }

    public void fillCatsToTheHouse(List<Cat> cats) {
        this.houseOfCats.addAll(cats);
    }

    public void showAllCats() {
        for (Cat cat : houseOfCats) {
            System.out.println(cat);
        }
    }
}

