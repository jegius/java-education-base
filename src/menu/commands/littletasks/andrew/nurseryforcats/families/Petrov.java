package menu.commands.littletasks.andrew.nurseryforcats.families;

import menu.commands.littletasks.andrew.nurseryforcats.Cat;
import menu.commands.littletasks.andrew.nurseryforcats.CatShelter;
import menu.commands.littletasks.andrew.nurseryforcats.GenerateCats;

import java.util.List;

public class Petrov implements FamilyCat {

    private final List<Cat> cats;

    public Petrov() {
        cats = GenerateCats.generate();
    }

    @Override
    public void sendToTheShelter(Class<?> cClass) {
        CatShelter.printCats(cats, cClass);
    }
}
