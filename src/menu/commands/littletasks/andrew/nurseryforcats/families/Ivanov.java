package menu.commands.littletasks.andrew.nurseryforcats.families;

import menu.commands.littletasks.andrew.nurseryforcats.Cat;
import menu.commands.littletasks.andrew.nurseryforcats.CatShelter;
import menu.commands.littletasks.andrew.nurseryforcats.GenerateCats;

import java.util.List;

public class Ivanov implements FamilyCat{

    private final List<Cat> cats;

    public Ivanov() {
        cats = GenerateCats.generate();
    }

    @Override
    public void sendToTheShelter(Class<?> cClass) {
        CatShelter.printCats(cats, cClass);
    }
}
