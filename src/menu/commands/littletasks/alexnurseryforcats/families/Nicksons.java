package menu.commands.littletasks.alexnurseryforcats.families;

import menu.commands.littletasks.alexnurseryforcats.CatGenerator;
import menu.commands.littletasks.alexnurseryforcats.CatShelter;

import java.util.List;

public class Nicksons implements Family{

    private List cats;
    CatGenerator catGenerator = new CatGenerator();

    public Nicksons() {
        this.cats = catGenerator.fillCats();

    }

    public List getCats() {
        return cats;
    }

    @Override
    public void giveCatsToShelter() {
        CatShelter.getInstance().addCatsToShelter(cats);
        deleteCatsFromCats();
    }
    private void deleteCatsFromCats() {
        cats.clear();
    }

}
