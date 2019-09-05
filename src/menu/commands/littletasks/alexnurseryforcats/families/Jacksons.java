package menu.commands.littletasks.alexnurseryforcats.families;

import menu.commands.littletasks.alexnurseryforcats.CatGenerator;
import menu.commands.littletasks.alexnurseryforcats.CatShelter;

import java.util.List;

public class Jacksons implements Family{
    private List cats;
    CatGenerator catGenerator = new CatGenerator();
    public Jacksons (){
        this.cats = catGenerator.fillCats();
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
