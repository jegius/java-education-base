package menu.commands.littletasks.andrew.nurseryforcats.families;

import menu.commands.littletasks.andrew.nurseryforcats.Cat;
import menu.commands.littletasks.andrew.nurseryforcats.CatShelter;
import menu.commands.littletasks.andrew.nurseryforcats.GenerateCats;

import java.util.List;

abstract public class Family implements FamilyCat {

    protected List<Cat> cats;
    protected Class<?> getClassObject;

    public Family() {
        this.cats = GenerateCats.generate();
    }

    @Override
    public void sendToTheShelter(Class<?> getClassObject) {
        CatShelter.printCats(cats, getClassObject);
    }
}
