package menu.commands.littletasks.nurseryforcats.families;

import menu.commands.littletasks.nurseryforcats.Cat;

import java.util.ArrayList;
import java.util.List;

public class Nicksons implements Family {

    private List cats;

    public Nicksons() {
        this.cats = new ArrayList();
        this.cats.add(new Cat(12));
        this.cats.add(new Cat(1));
        this.cats.add(new Cat(2));
    }

    public List getCats() {
        return cats;
    }

    @Override
    public void giveCatsToShelter() {
        for (Object cat : cats) {
            System.out.println(cat);
        }
    }
}
